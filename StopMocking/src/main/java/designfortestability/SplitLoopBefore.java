package designfortestability;

import designfortestability.collaborators.Builder;
import designfortestability.collaborators.ChargingEngineException;
import designfortestability.collaborators.JsonMappingException;
import designfortestability.collaborators.JsonParseException;
import designfortestability.collaborators.Msisdn;
import designfortestability.collaborators.ObjectMapper;
import designfortestability.collaborators.PurchaseDTO;
import designfortestability.collaborators.TypeReference;
import designfortestability.collaborators.UniformInterfaceException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SplitLoopBefore {


    private static final String PURCHASES_URL_EXTENSION = "/purchases";
    private static final String MSISDN_PARAM = "?msisdn.is=";
    private static final String INCLUDE_HISTORY_PARAM = "&doIncludeHistory=true";

    private final ObjectMapper mapper = new ObjectMapper();

    public List<PurchaseDTO> getPurchases(List<Msisdn> msisdns, boolean includeEvents) throws ChargingEngineException {
        List<PurchaseDTO> purchases = new ArrayList<PurchaseDTO>(20);
        for (Msisdn msisdn : msisdns) {
            try {
                Builder builder = getClient(PURCHASES_URL_EXTENSION, MSISDN_PARAM, String.valueOf(includeEvents),
                                            msisdn.format(),
                                            includeEvents ? "" : INCLUDE_HISTORY_PARAM);
                builder = addSignature(builder, PURCHASES_URL_EXTENSION, null, null);
                String jsonResponse = builder.get(String.class);
                purchases.addAll(mapper.readValue(jsonResponse, new TypeReference<List<PurchaseDTO>>()));

            } catch (JsonParseException e) {
                throw new ChargingEngineException(
                        String.format("Could not parse json response for msisdn: %s", msisdn), e);
            } catch (JsonMappingException e) {
                throw new ChargingEngineException(String.format("Could not map json response for msisdn: %s", msisdn),
                                                  e);
            } catch (IOException e) {
                throw new ChargingEngineException(String.format("Could not read json response for msisdn: %s", msisdn),
                                                  e);
            } catch (UniformInterfaceException e) {
                //...;
            }
        }
        return purchases;
    }


    private Builder getClient(String... additionalUrl) throws UniformInterfaceException {
        return null;
    }

    private Builder addSignature(Builder builder, String path, byte[] data, String contentType)
            throws ChargingEngineException {
        return null;
    }
}

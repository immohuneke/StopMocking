package designfortestability.exercises;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.TestOnly;

import designfortestability.collaborators.Builder;
import designfortestability.collaborators.ChargingEngineException;
import designfortestability.collaborators.JsonMappingException;
import designfortestability.collaborators.JsonParseException;
import designfortestability.collaborators.Msisdn;
import designfortestability.collaborators.ObjectMapper;
import designfortestability.collaborators.PurchaseDTO;
import designfortestability.collaborators.TypeReference;
import designfortestability.collaborators.UniformInterfaceException;

public class SplitLoop {


    private static final String PURCHASES_URL_EXTENSION = "/purchases";
    private static final String MSISDN_PARAM = "?msisdn.is=";
    private static final String INCLUDE_HISTORY_PARAM = "&doIncludeHistory=true";

    private final ObjectMapper mapper = new ObjectMapper();

    public List<PurchaseDTO> getPurchases(List<Msisdn> msisdns, boolean includeEvents) throws ChargingEngineException {
    	List<Builder> builders = createRequestBuilders(msisdns, includeEvents);
    	List<String> jsonResponses = callRemote(builders);
    	return parseResponses(mapper, jsonResponses);
    }

    @TestOnly
	public static List<Builder> createRequestBuilders(List<Msisdn> msisdns,
			boolean includeEvents) throws ChargingEngineException {
        List<Builder> builders = new ArrayList<Builder>();
        for (Msisdn msisdn : msisdns) {
            try {
                Builder builder = getClient(PURCHASES_URL_EXTENSION, MSISDN_PARAM, String.valueOf(includeEvents),
                                            msisdn.format(),
                                            includeEvents ? "" : INCLUDE_HISTORY_PARAM);
                builder = addSignature(builder, PURCHASES_URL_EXTENSION, null, null);
                builders.add(builder);
            } catch (UniformInterfaceException e) {
                //...;
            }
        }
		return builders;
	}

	private static List<String> callRemote(List<Builder> builders) {
		List<String> jsonResponses = new ArrayList<String>();
        for (Builder builder : builders) {
            jsonResponses.add(builder.get(String.class));
        }
        return jsonResponses;
	}

	private static List<PurchaseDTO> parseResponses(ObjectMapper mapper, List<String> jsonResponses) throws ChargingEngineException {
        List<PurchaseDTO> purchases = new ArrayList<PurchaseDTO>(20);
        for (String jsonResponse : jsonResponses) {
            try {
                purchases.addAll(mapper.readValue(jsonResponse, new TypeReference<List<PurchaseDTO>>()));
            } catch (JsonParseException e) {
                throw new ChargingEngineException(
                        String.format("Could not parse json response: %s", jsonResponse), e);
            } catch (JsonMappingException e) {
                throw new ChargingEngineException(String.format("Could not map json response: %s", jsonResponse), e);
            } catch (IOException e) {
                throw new ChargingEngineException(String.format("Could not read json response: %s", jsonResponse), e);
            }
        }
        return purchases;
    }


    private static Builder getClient(String... additionalUrl) throws UniformInterfaceException {
        return null;
    }

    private static Builder addSignature(Builder builder, String path, byte[] data, String contentType)
            throws ChargingEngineException {
        return null;
    }
}

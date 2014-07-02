package designfortestability.collaborators;

import java.io.IOException;
import java.util.List;

public class ObjectMapper {

    public List<PurchaseDTO> readValue(String jsonResponse, TypeReference<List<PurchaseDTO>> typeReference) throws JsonMappingException, JsonParseException,
                                                                                                                   IOException {
        throw new RuntimeException("Not implemented yet");
    }
}

package org.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Helper {
    ObjectMapper mapper = new ObjectMapper();
    ObjectNode responseOfToObjectNode;
    String valueOfKey;

    public ObjectNode readFileAsJson(String jsonPath, boolean isFile) {
        JsonNode responseOfAPI;
        if (isFile) {
            File file = new File(jsonPath);
            try {
                responseOfAPI = mapper.readTree(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                responseOfAPI = mapper.readTree(jsonPath);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        responseOfToObjectNode = (ObjectNode) responseOfAPI;
        return responseOfToObjectNode;
    }


    public String readResponseAsJson(Response response, String value) {
        JsonNode responseOfAPI;
        try {
            responseOfAPI = mapper.readTree(response.getBody().prettyPrint());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        responseOfToObjectNode = (ObjectNode) responseOfAPI;
        valueOfKey = responseOfToObjectNode.get(value).textValue();
        return valueOfKey;
    }

    public Map<String, String> readJsonAsMap(String jsonPath) {
        File file = new File(jsonPath);
        Map<String, String> result;
        try {
            result =
                    new ObjectMapper().readValue(file, HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Map<String, String> readJsonAsMap(String jsonPath, boolean isFile) {
        if (isFile) {
            File file = new File(jsonPath);
            Map<String, String> result;
            try {
                result =
                        new ObjectMapper().readValue(file, HashMap.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        } else {
            Map<String, String> result;
            try {
                result =
                        new ObjectMapper().readValue(jsonPath, HashMap.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        }
    }

    public int randomInt(int max) {
        return (int) (Math.random() * max);
    }

    public int convertDateToInt() {
        return (int) new Date().getTime();
    }
}

package com.panosen.plainschema;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlainParser {

    private static final Gson GSON = new Gson();

    public Plain parse(String json) {
        JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);

        return parse(jsonObject);
    }

    private Plain parse(JsonElement jsonElement) {
        if (jsonElement.isJsonNull()) {
            return null;
        }

        if (jsonElement.isJsonObject()) {
            return parseMap((JsonObject) jsonElement);
        }

        if (jsonElement.isJsonArray()) {
            return parseArray((JsonArray) jsonElement);
        }

        if (jsonElement.isJsonPrimitive()) {
            return parseValue((JsonPrimitive) jsonElement);
        }

        return null;
    }

    private PlainArray parseArray(JsonArray jsonArray) {
        PlainArray sampleArray = new PlainArray();
        sampleArray.setItems(new ArrayList<>());
        for (int index = 0, length = jsonArray.size(); index < length; index++) {
            sampleArray.getItems().add(parse(jsonArray.get(index)));
        }
        return sampleArray;
    }

    private PlainMap parseMap(JsonObject jsonObject) {
        PlainMap sampleMap = new PlainMap();
        sampleMap.setMap(new LinkedHashMap<>());
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            sampleMap.getMap().putIfAbsent(entry.getKey(), parse(entry.getValue()));
        }
        return sampleMap;
    }

    private PlainValue parseValue(JsonPrimitive jsonPrimitive) {
        PlainValue sampleValue = new PlainValue();
        sampleValue.setValue(jsonPrimitive);
        return sampleValue;
    }
}

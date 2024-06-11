package com.panosen.plainschema;

import com.google.gson.JsonPrimitive;

public class PlainValue extends Plain {
    @Override
    public String type() {
        return "value";
    }

    private JsonPrimitive value;

    public JsonPrimitive getValue() {
        return value;
    }

    public void setValue(JsonPrimitive value) {
        this.value = value;
    }
}

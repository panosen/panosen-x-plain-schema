package com.panosen.plainschema;

import java.util.Map;

public class PlainMap extends Plain {
    @Override
    public String type() {
        return "map";
    }

    private Map<String, Plain> map;

    public Map<String, Plain> getMap() {
        return map;
    }

    public void setMap(Map<String, Plain> map) {
        this.map = map;
    }
}

package com.panosen.plainschema;

import java.util.List;

public class PlainArray extends Plain {
    @Override
    public String type() {
        return "array";
    }

    private List<Plain> items;

    public List<Plain> getItems() {
        return items;
    }

    public void setItems(List<Plain> items) {
        this.items = items;
    }
}
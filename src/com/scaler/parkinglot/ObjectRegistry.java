package com.scaler.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ObjectRegistry {
    private Map<String, Object> objectsMap = new HashMap<>();

    public void register(String name, Object object) {
        objectsMap.put(name, object);
    }

    public Object get(String name) {
        return objectsMap.get(name);
    }
}

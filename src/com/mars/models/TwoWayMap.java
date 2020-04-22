package com.mars.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoWayMap<K, V> {

    private Map<K,V> referencer = new HashMap<>();
    private Map<V,K> dereferencer = new HashMap<>();

    public TwoWayMap(List<K> keys, List<V> values) {
        for(int i=0; i<keys.size(); i++){
            this.referencer.put(keys.get(i), values.get(i));
            this.dereferencer.put(values.get(i), keys.get(i));
        }
    }

    public V referenceOf(K key) {
        return this.referencer.get(key);
    }

    public K dereferenceOf(V key) {
        return this.dereferencer.get(key);
    }
}

package com.example.demo;

import java.util.HashMap;

public class Cache {

    private int key;
    private String value;

    HashMap<Integer, String> cacheInfo = new HashMap<>();


    public void set(int key, String value) {
        cacheInfo.put(key, value);
    }

    public String get(int key){
        return cacheInfo.get(key);
    }

    public boolean has(int key){
        if(cacheInfo.get(key) != null){
            return true;
        }else
            return false;
    }

    public void delete(int key){
        cacheInfo.remove(key);
    }

}

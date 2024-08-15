package com.digitalfen.jwiss.devkit.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.digitalfen.jwiss.devkit.model.JwissCommand;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissDataCache {

    private final Map<String, String> data = new ConcurrentHashMap<>();

    private static JwissDataCache instance;

    public static synchronized JwissDataCache getInstance() {
	if (instance == null) {
	    instance = new JwissDataCache();
	}
	return instance;
    }

    public void put(String key, String value) {
	data.put(key, value);
    }

    public String get(String key) {
	return data.get(key);
    }

    public Map<String, String> getMap() {
	return data;
    }

    public void remove(String key) {
	data.remove(key);
    }

    public boolean containsKey(String key) {
	return data.containsKey(key);
    }

    public void clear() {
	data.clear();
    }

}

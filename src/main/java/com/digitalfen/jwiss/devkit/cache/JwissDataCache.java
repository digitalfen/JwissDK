package com.digitalfen.jwiss.devkit.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Data Cache for JwissTool
 * 
 * {@link ConcurrentHashMap}
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissDataCache {

    private final Map<String, String> data = new ConcurrentHashMap<>();

    private static JwissDataCache instance;

    /**
     * Get instance for Data Cache
     * 
     * @return JwissDataCache
     */
    public static synchronized JwissDataCache getInstance() {
	if (instance == null) {
	    instance = new JwissDataCache();
	}
	return instance;
    }

    /**
     * Put Data in Cache
     * 
     * @param key   String
     * @param value JwissDataInterface
     * @return void
     */
    public void put(String key, String value) {
	data.put(key, value);
    }

    /**
     * Get Data from Cache
     * 
     * @param key String
     * @return JwissDataInterface
     */
    public String get(String key) {
	return data.get(key);
    }

    /**
     * Return Data map from Cache
     * 
     * @return Map<String, JwissDataInterface>
     */
    public Map<String, String> getMap() {
	return data;
    }

    /**
     * Remove Data from Cache
     * 
     * @param key String
     * @return void
     */
    public void remove(String key) {
	data.remove(key);
    }

    /**
     * Return true if Data is already on Cache
     * 
     * @param key String
     * @return boolean
     */
    public boolean containsKey(String key) {
	return data.containsKey(key);
    }

    /**
     * Remove all Data from Cache
     * 
     * @return void
     */
    public void clear() {
	data.clear();
    }

}

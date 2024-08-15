package com.digitalfen.jwiss.devkit.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.digitalfen.jwiss.devkit.interfaces.JwissAddonInterface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Addons Cache for JwissTool
 * 
 * {@link ConcurrentHashMap}
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissAddonsCache {

    private final Map<String, JwissAddonInterface> plugins = new ConcurrentHashMap<>();

    private static JwissAddonsCache instance;

    /**
     * Get instance for Addons Cache
     * 
     * @return JwissAddonsCache
     */
    public static synchronized JwissAddonsCache getInstance() {
	if (instance == null) {
	    instance = new JwissAddonsCache();
	}
	return instance;
    }

    /**
     * Put addon in Cache
     * 
     * @param key   String
     * @param value JwissAddonInterface
     * @return void
     */
    public void put(String key, JwissAddonInterface value) {
	plugins.put(key, value);
    }

    /**
     * Get Addon from Cache
     * 
     * @param key String
     * @return JwissAddonInterface
     */
    public JwissAddonInterface get(String key) {
	return plugins.get(key);
    }

    /**
     * Return Addons map from Cache
     * 
     * @return Map<String, JwissAddonInterface>
     */
    public Map<String, JwissAddonInterface> getMap() {
	return plugins;
    }

    /**
     * Remove Addon from Cache
     * 
     * @param key String
     * @return void
     */
    public void remove(String key) {
	plugins.remove(key);
    }

    /**
     * Return true if Addon is already on Cache
     * 
     * @param key String
     * @return boolean
     */
    public boolean containsKey(String key) {
	return plugins.containsKey(key);
    }

    /**
     * Remove all Addons from Cache
     * 
     * @return void
     */
    public void clear() {
	plugins.clear();
    }

}

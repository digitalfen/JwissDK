package com.digitalfen.jwiss.devkit.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.digitalfen.jwiss.devkit.interfaces.JwissPluginInterface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Plugins Cache for JwissTool
 * 
 * {@link ConcurrentHashMap}
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissPluginsCache {

    private final Map<String, JwissPluginInterface> plugins = new ConcurrentHashMap<>();

    private static JwissPluginsCache instance;

    /**
     * Get instance for Plugins Cache
     * 
     * @return JwissPluginsCache
     */
    public static synchronized JwissPluginsCache getInstance() {
	if (instance == null) {
	    instance = new JwissPluginsCache();
	}
	return instance;
    }

    /**
     * Put Plugin in Cache
     * 
     * @param key   String
     * @param value JwissPluginInterface
     * @return void
     */
    public void put(String key, JwissPluginInterface value) {
	plugins.put(key.toLowerCase(), value);
    }

    /**
     * Get Plugin from Cache
     * 
     * @param key String
     * @return JwissPluginInterface
     */
    public JwissPluginInterface get(String key) {
	return plugins.get(key.toLowerCase());
    }

    /**
     * Return Plugins map from Cache
     * 
     * @return Map<String, JwissPluginInterface>
     */
    public Map<String, JwissPluginInterface> getMap() {
	return plugins;
    }

    /**
     * Remove Plugin from Cache
     * 
     * @param key String
     * @return void
     */
    public void remove(String key) {
	plugins.remove(key.toLowerCase());
    }

    /**
     * Return true if Plugin is already on Cache
     * 
     * @param key String
     * @return boolean
     */
    public boolean containsKey(String key) {
	return plugins.containsKey(key.toLowerCase());
    }

    /**
     * Return the number of cached Plugins
     * 
     * @return integer
     */
    public int size() {
	return plugins.size();
    }

    /**
     * Remove all Plugins from Cache
     * 
     * @return void
     */
    public void clear() {
	plugins.clear();
    }

}

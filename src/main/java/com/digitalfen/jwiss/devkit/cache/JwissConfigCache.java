package com.digitalfen.jwiss.devkit.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.digitalfen.jwiss.devkit.interfaces.JwissPluginInterface;
import com.digitalfen.jwiss.devkit.model.Addon;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Configurations Cache for JwissTool
 * 
 * {@link ConcurrentHashMap}
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissConfigCache {

    private final Map<String, String> config = new ConcurrentHashMap<>();

    private static JwissConfigCache instance;

    /**
     * Get instance for Configurations Cache
     * 
     * @return JwissConfigCache
     */
    public static synchronized JwissConfigCache getInstance() {
	if (instance == null) {
	    instance = new JwissConfigCache();
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
    public void put(JwissPluginInterface plugin, String key, String value) {
	this.config.put(plugin != null ? plugin.toString() : "global" + "." + key, value);
    }

    /**
     * Get Plugin from Cache
     * 
     * @param key String
     * @return JwissPluginInterface
     */
    public String get(String key) {
	return this.config.get(key);
    }

    /**
     * Return Plugins map from Cache
     * 
     * @return Map<String, JwissPluginInterface>
     */
    public Map<String, String> getMap() {
	return this.config;
    }

}

package com.digitalfen.jwiss.devkit.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.digitalfen.jwiss.devkit.enums.JwissConfigTypeEnum;
import com.digitalfen.jwiss.devkit.interfaces.JwissAddonInterface;
import com.digitalfen.jwiss.devkit.interfaces.JwissPluginInterface;

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
     * Get Global Configurations in Cache
     * 
     * @param key   String
     * @param value JwissPluginInterface
     * @return void
     */
    public String get(String key) {
	return this.config.get(
		JwissConfigTypeEnum.GLOBAL.toString().toLowerCase()
			+ "."
			+ key);
    }

    /**
     * Get Plugin Configurations in Cache
     * 
     * @param plugin JwissPluginInterface
     * @param key    String
     * @param value  JwissPluginInterface
     * @return void
     */
    public String get(JwissPluginInterface plugin, String key) {
	return this.config.get(
		JwissConfigTypeEnum.PLUGIN.toString().toLowerCase()
			+ "."
			+ plugin.getClass().getSimpleName()
			+ "."
			+ key);
    }

    /**
     * Get Addon Configurations in Cache
     * 
     * @param addon JwissAddonInterface
     * @param key   String
     * @param value JwissPluginInterface
     * @return void
     */
    public String get(JwissAddonInterface addon, String key) {
	return this.config.get(
		JwissConfigTypeEnum.PLUGIN.toString().toLowerCase()
			+ "."
			+ addon.getClass().getSimpleName()
			+ "."
			+ key);
    }

    /**
     * Put Global Configurations in Cache
     * 
     * @param key   String
     * @param value JwissPluginInterface
     * @return void
     */
    public void put(String key, String value) {
	key = key.replace("global.", "");
	this.config.put(
		JwissConfigTypeEnum.GLOBAL.toString().toLowerCase()
			+ "."
			+ key,
		value);
    }

    /**
     * Put Plugin Configurations in Cache
     * 
     * @param plugin JwissPluginInterface
     * @param key    String
     * @param value  JwissPluginInterface
     * @return void
     */
    public void put(JwissPluginInterface plugin, String key, String value) {
	this.config.put(
		JwissConfigTypeEnum.PLUGIN.toString().toLowerCase()
			+ "."
			+ plugin.getClass().getSimpleName() + "." + key,
		value);
    }

    /**
     * Put Addon Configurations in Cache
     * 
     * @param addon JwissAddonInterface
     * @param key   String
     * @param value JwissPluginInterface
     * @return void
     */
    public void put(JwissAddonInterface addon, String key, String value) {
	this.config.put(
		JwissConfigTypeEnum.ADDON.toString().toLowerCase()
			+ "."
			+ addon.getClass().getSimpleName() + "." + key,
		value);
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

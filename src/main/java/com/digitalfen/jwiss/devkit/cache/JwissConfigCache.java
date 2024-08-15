package com.digitalfen.jwiss.devkit.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.digitalfen.jwiss.devkit.interfaces.JwissPluginInterface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissConfigCache {

    private final Map<String, String> config = new ConcurrentHashMap<>();

    private static JwissConfigCache instance;

    public static synchronized JwissConfigCache getInstance() {
	if (instance == null) {
	    instance = new JwissConfigCache();

	}
	return instance;
    }

    public void put(JwissPluginInterface plugin, String key, String value) {
	this.config.put(plugin != null ? plugin.toString() : "global" + "." + key, value);
    }

    public String get(String key) {
	return this.config.get(key);
    }

    public Map<String, String> getAll() {
	return this.config;
    }

}

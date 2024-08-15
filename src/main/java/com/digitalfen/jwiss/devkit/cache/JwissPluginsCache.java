package com.digitalfen.jwiss.devkit.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.digitalfen.jwiss.devkit.interfaces.JwissPluginInterface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissPluginsCache {

    private final Map<String, JwissPluginInterface> plugins = new ConcurrentHashMap<>();

    private static JwissPluginsCache instance;

    public static synchronized JwissPluginsCache getInstance() {
	if (instance == null) {
	    instance = new JwissPluginsCache();
	}
	return instance;
    }

    public void put(String key, JwissPluginInterface value) {
	plugins.put(key, value);
    }

    public JwissPluginInterface get(String key) {
	return plugins.get(key);
    }

    public Map<String, JwissPluginInterface> getMap() {
	return plugins;
    }

    public void remove(String key) {
	plugins.remove(key);
    }

    public boolean containsKey(String key) {
	return plugins.containsKey(key);
    }

    public int size() {
	return plugins.size();
    }

    public void clear() {
	plugins.clear();
    }

}

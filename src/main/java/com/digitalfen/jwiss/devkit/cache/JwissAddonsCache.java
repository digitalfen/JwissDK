package com.digitalfen.jwiss.devkit.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.digitalfen.jwiss.devkit.interfaces.JwissAddonInterface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissAddonsCache {

    private final Map<String, JwissAddonInterface> plugins = new ConcurrentHashMap<>();

    private static JwissAddonsCache instance;

    public static synchronized JwissAddonsCache getInstance() {
	if (instance == null) {
	    instance = new JwissAddonsCache();
	}
	return instance;
    }

    public void put(String key, JwissAddonInterface value) {
	plugins.put(key, value);
    }

    public JwissAddonInterface get(String key) {
	return plugins.get(key);
    }

    public Map<String, JwissAddonInterface> getMap() {
	return plugins;
    }

    public void remove(String key) {
	plugins.remove(key);
    }

    public boolean containsKey(String key) {
	return plugins.containsKey(key);
    }

    public void clear() {
	plugins.clear();
    }

}

package com.digitalfen.jwiss.devkit.handlers;

import com.digitalfen.jwiss.devkit.cache.JwissAddonsCache;
import com.digitalfen.jwiss.devkit.cache.JwissConfigCache;
import com.digitalfen.jwiss.devkit.cache.JwissDataCache;
import com.digitalfen.jwiss.devkit.cache.JwissPluginsCache;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissCache {

    public static final JwissDataCache data = JwissDataCache.getInstance();
    public static final JwissAddonsCache addons = JwissAddonsCache.getInstance();
    public static final JwissPluginsCache plugins = JwissPluginsCache.getInstance();
    public static final JwissConfigCache configurations = JwissConfigCache.getInstance();

}

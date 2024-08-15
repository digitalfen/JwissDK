package com.digitalfen.jwiss.devkit.handlers;

import com.digitalfen.jwiss.devkit.cache.JwissAddonsCache;
import com.digitalfen.jwiss.devkit.cache.JwissConfigCache;
import com.digitalfen.jwiss.devkit.cache.JwissDataCache;
import com.digitalfen.jwiss.devkit.cache.JwissPluginsCache;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Usable Cache Connector for JwissTool
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissCache {

    /**
     * Cache for General Data
     */
    public static final JwissDataCache data = JwissDataCache.getInstance();

    /**
     * Cache for Addons
     */
    public static final JwissAddonsCache addons = JwissAddonsCache.getInstance();

    /**
     * Cache for Plugins
     */
    public static final JwissPluginsCache plugins = JwissPluginsCache.getInstance();

    /**
     * Cache for Configurations
     */
    public static final JwissConfigCache configurations = JwissConfigCache.getInstance();

}

package com.digitalfen.jwiss.devkit.handlers;

import com.digitalfen.jwiss.devkit.utils.IOUtils;
import com.digitalfen.jwiss.devkit.utils.PluginsUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Usable Utils Connector for JwissTool
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissUtils {

    /**
     * Utils for Input and Output
     */
    public static final IOUtils io = IOUtils.getInstance();

    /**
     * Utils for Plugins
     */
    public static final PluginsUtils plugins = PluginsUtils.getInstance();

}

package com.digitalfen.jwiss.devkit.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Metadata for JwissTool Plugins
 * 
 * @example
 * 
 *          <pre>
 * {@code @JwissPluginMetadata(name = "Plugin Example", usage = "pluginexample", description = "Plugin Example", version = "1.0.0")
 * public class PluginExample implements JwissPluginInterface {
 * 	public PluginExample() {
 * 	}
 * 	&#64;JwissCommandMetadata(usage = "ex1", description = "example 1")
 * 	public void example1() {
 *		
 * 	}
 *    	@JwissCommandMetadata(usage = "ex2", description = "example 2")
 * 	public void examples() {
 *		
 * 	}
 *}
 *          </pre>
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JwissPluginMetadata {

    /**
     * Plugin name
     * 
     * @param name String
    */
    String name();
    
    /**
     * Plugin usage
     * 
     * @param usage String
    */
    String usage();

    /**
     * Plugin description
     * 
     * @param description String
    */
    String description();

    /**
     * Plugin version
     * 
     * @param version String
    */
    String version();
}
package com.digitalfen.jwiss.devkit.interfaces;

/**
 * Interface for JwissTool Plugin
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
public interface JwissPluginInterface {

}

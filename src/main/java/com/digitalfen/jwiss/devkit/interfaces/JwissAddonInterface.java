package com.digitalfen.jwiss.devkit.interfaces;


/**
 * Interface for JwissTool Addon
 * 
 * @example
 * <pre>
 * {@code @JwissAddonMetadata(name = @string, description = @string, version = @string)
 * public class JwissAddon implements JwissAddonInterface {
 *  	@Override
 *  	public void run(){
 *  
 *  	};
 * }
 * </pre>
 * 
 */
public interface JwissAddonInterface extends Runnable {

}

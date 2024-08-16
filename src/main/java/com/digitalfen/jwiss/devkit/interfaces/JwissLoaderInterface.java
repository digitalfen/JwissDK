package com.digitalfen.jwiss.devkit.interfaces;


/**
 * Interface for JwissTool Loaders
 * 
 * @example
 * <pre>
 * {@code 
 * public class JwissExampleLoader implements JwissLoaderInterface {
 *  	@Override
 *  	public void ini(){
 *  		// do something ...
 *  	};
 * }
 * </pre>
 * 
 */
public interface JwissLoaderInterface{

    void init();
}

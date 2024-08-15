package com.digitalfen.jwiss.devkit.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Metadata for JwissTool Addons
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
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JwissAddonMetadata {

    /**
     * Addon name
     * 
     * @param name String
    */
    String name();

    /**
     * Addon description
     * 
     * @param description String
    */
    String description();

    /**
     * Addon version
     * 
     * @param version String
    */
    String version();
}
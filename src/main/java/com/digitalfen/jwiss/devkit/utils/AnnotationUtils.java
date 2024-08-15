package com.digitalfen.jwiss.devkit.utils;

import com.digitalfen.jwiss.devkit.annotations.JwissPluginMetadata;
import com.digitalfen.jwiss.devkit.interfaces.JwissPluginInterface;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utils for Annotations in JwissTool
 * 
 * @value instance AnnotationUtils
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnnotationUtils {

    private static AnnotationUtils instance;

    /**
     * Get instance for Plugins
     * 
     * @return AnnotationUtils
     */
    public static synchronized AnnotationUtils getInstance() {
	if (instance == null) {
	    instance = new AnnotationUtils();
	}
	return instance;
    }

    /**
     * Get Command from Plugin
     * 
     * @param pluginInstance JwissPluginInterface
     * @return String
     */
    public String getPluginCommand(JwissPluginInterface pluginInstance) {
	Class<?> pluginClass = pluginInstance.getClass();

	// Verifica se a classe possui a anotação JwissPluginMetadata
	if (pluginClass.isAnnotationPresent(JwissPluginMetadata.class)) {
	    // Recupera a anotação
	    JwissPluginMetadata metadata = pluginClass
		    .getAnnotation(JwissPluginMetadata.class);

	    // Recupera os valores dos atributos da anotação
	    String name = metadata.name();
	    String description = metadata.description();
	    String version = metadata.version();

	    System.out.println("Name: " + name);
	    System.out.println("Description: " + description);
	    System.out.println("Version: " + version);
	} else {
	    System.out.println(
		    "A anotação JwissPluginMetadata não está presente na classe.");
	}

	return null;
    }

}

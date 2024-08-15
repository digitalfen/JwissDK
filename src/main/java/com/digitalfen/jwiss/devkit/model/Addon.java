package com.digitalfen.jwiss.devkit.model;

import com.digitalfen.jwiss.devkit.annotations.JwissAddonMetadata;
import com.digitalfen.jwiss.devkit.annotations.JwissPluginMetadata;
import com.digitalfen.jwiss.devkit.interfaces.JwissAddonInterface;

import lombok.Getter;

/**
 * JwissTool Addon model
 * 
 * @value name String
 * @value description String
 * @value version String
 * @value instance JwissAddonInterface
 */
@Getter
public class Addon {

    private String name;
    private String description;
    private String version;
    private JwissAddonInterface instance;

    /**
     * Constructor
     * 
     * @param instance JwissAddonInterface
     */
    public Addon(JwissAddonInterface instance) {
	this.instance = instance;

	Class<?> pluginClass = instance.getClass();

	// Verifica se a classe possui a anotação JwissPluginMetadata
	if (pluginClass.isAnnotationPresent(JwissAddonMetadata.class)) {
	    // Recupera a anotação
	    JwissPluginMetadata metadata = pluginClass
		    .getAnnotation(JwissPluginMetadata.class);

	    // Recupera os valores dos atributos da anotação
	    this.name = metadata.name();
	    this.description = metadata.description();
	    this.version = metadata.version();

	}

    }
}

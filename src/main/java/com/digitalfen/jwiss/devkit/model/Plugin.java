package com.digitalfen.jwiss.devkit.model;

import com.digitalfen.jwiss.devkit.annotations.JwissPluginMetadata;
import com.digitalfen.jwiss.devkit.interfaces.JwissPluginInterface;

import lombok.Getter;

/**
 * JwissTool Command Argument model
 * 
 * @value name String
 * @value description String
 * @value version String
 * @value instance JwissPluginInterface
 * 
 */
@Getter
public class Plugin {

    private String name;
    private String description;
    private String version;
    private JwissPluginInterface instance;

    /**
     * Constructor
     * 
     * @param instance JwissPluginInterface
     */
    public Plugin(JwissPluginInterface instance) {
	this.instance = instance;

	Class<?> pluginClass = instance.getClass();

	// Verifica se a classe possui a anotação JwissPluginMetadata
	if (pluginClass.isAnnotationPresent(JwissPluginMetadata.class)) {
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

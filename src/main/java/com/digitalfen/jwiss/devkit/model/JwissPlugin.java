package com.digitalfen.jwiss.devkit.model;

import com.digitalfen.jwiss.devkit.annotations.JwissPluginMetadata;
import com.digitalfen.jwiss.devkit.interfaces.JwissPluginInterface;

import lombok.Getter;

@Getter
public class JwissPlugin {

    private String name;
    private String command;
    private String version;
    private JwissPluginInterface instance;

    public JwissPlugin(JwissPluginInterface instance) {
	this.instance = instance;

	Class<?> pluginClass = instance.getClass();

	// Verifica se a classe possui a anotação JwissPluginMetadata
	if (pluginClass.isAnnotationPresent(JwissPluginMetadata.class)) {
	    // Recupera a anotação
	    JwissPluginMetadata metadata = pluginClass
		    .getAnnotation(JwissPluginMetadata.class);

	    // Recupera os valores dos atributos da anotação
	    this.name = metadata.name();
	    this.command = metadata.description();
	    this.version = metadata.version();

	}

    }

}

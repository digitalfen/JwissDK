package com.digitalfen.jwiss.devkit.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JwissPluginMetadata {

    String name();
    
    String usage();

    String description();

    String version();
}
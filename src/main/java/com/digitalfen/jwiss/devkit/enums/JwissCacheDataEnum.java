package com.digitalfen.jwiss.devkit.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum JwissCacheDataEnum {

    PUBLIC("public"),
    PRIVATE("private");

    private String type;
    
    public String get() {
	return this.type;
    }

}

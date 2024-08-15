package com.digitalfen.jwiss.devkit.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * JwissTool Command Argument model
 * 
 * @value key String
 * @value value String
 */
@Getter
@Setter
@NoArgsConstructor
public class Argument {

    private String key;
    private String value;

}

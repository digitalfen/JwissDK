package com.digitalfen.jwiss.devkit.enums;

import lombok.AllArgsConstructor;

/**
 * Verbose Level Enumeration
 * 
 * Types of verbose suported by JwissTool
 * 
 */
@AllArgsConstructor
public enum VerboseLevelEnum {

    OFF,
    INFO,
    DEBUG,
    WARNING,
    ERROR,
    FATAL,
    GLOBAL,
    NULL;

}

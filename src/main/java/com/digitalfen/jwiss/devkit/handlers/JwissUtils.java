package com.digitalfen.jwiss.devkit.handlers;

import com.digitalfen.jwiss.devkit.utils.AnnotationUtils;
import com.digitalfen.jwiss.devkit.utils.IOUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Usable Utils Connector for JwissTool
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissUtils {

    /**
     * Utils for Input and Output
     */
    public static final IOUtils io = IOUtils.getInstance();

    /**
     * Utils for Annotations
     */
    public static final AnnotationUtils annotations = AnnotationUtils.getInstance();

}

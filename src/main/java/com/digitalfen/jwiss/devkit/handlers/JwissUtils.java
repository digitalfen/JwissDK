package com.digitalfen.jwiss.devkit.handlers;

import com.digitalfen.jwiss.devkit.utils.AnnotationsUtils;
import com.digitalfen.jwiss.devkit.utils.TextUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissUtils {

    public static final TextUtils text = TextUtils.getInstance();
    public static final AnnotationsUtils annotations = AnnotationsUtils.getInstance();

}

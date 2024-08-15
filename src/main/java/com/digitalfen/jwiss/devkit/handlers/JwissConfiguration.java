package com.digitalfen.jwiss.devkit.handlers;

import com.digitalfen.jwiss.devkit.configurations.JwissConfigReader;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissConfiguration {

    public static final JwissConfigReader io = JwissConfigReader.getInstance();


}

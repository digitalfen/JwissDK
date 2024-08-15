package com.digitalfen.jwiss.devkit.handlers;

import com.digitalfen.jwiss.devkit.logger.JwissLogPrinter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissLogger {

    public static final JwissLogPrinter printer = JwissLogPrinter.getInstance();

}

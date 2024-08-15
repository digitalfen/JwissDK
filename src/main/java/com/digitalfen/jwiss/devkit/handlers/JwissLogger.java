package com.digitalfen.jwiss.devkit.handlers;

import com.digitalfen.jwiss.devkit.logger.JwissLogPrinter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Usable Logger Connector for JwissTool
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissLogger {

    /**
     * Log Printer
     */
    public static final JwissLogPrinter printer = JwissLogPrinter.getInstance();

}

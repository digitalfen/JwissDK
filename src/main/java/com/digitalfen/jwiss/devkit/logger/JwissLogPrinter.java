package com.digitalfen.jwiss.devkit.logger;

import java.util.ArrayList;
import java.util.List;

import com.digitalfen.jwiss.devkit.enums.VerboseLevelEnum;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Log Printer Actions
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissLogPrinter {

    /**
     * @value instance JwissLogPrinter
     */
    private static JwissLogPrinter instance;

    /**
     * @value utils JwissLogService
     */
    private static JwissLogService utils;

    /**
     * Get instance for Log Printer
     * 
     * @value JwissLogPrinter
     */
    public static synchronized JwissLogPrinter getInstance() {
	if (instance == null) {
	    instance = new JwissLogPrinter();
	    utils = new JwissLogService();
	}
	return instance;
    }

    /**
     * Process a string as message with info verbose level
     * 
     * @param msg String
     * @return void
     */
    public void info(String msg) {
	utils.printLogln(msg, VerboseLevelEnum.INFO);
    }

    /**
     * Process a list of strings as messages with info verbose level
     * 
     * @param msgs String[]
     * @return void
     */
    public void info(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, VerboseLevelEnum.INFO);
	}
    }

    /**
     * Process a string as message with debug verbose level
     * 
     * @param msg String
     * @return void
     */
    public void debug(String msg) {
	utils.printLogln(msg, VerboseLevelEnum.DEBUG);
    }

    /**
     * Process a list of strings as messages with debug verbose level
     * 
     * @param msgs String[]
     * @return void
     */
    public void debug(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, VerboseLevelEnum.DEBUG);
	}
    }

    /**
     * Process a string as message with warning verbose level
     * 
     * @param msg String
     * @return void
     */
    public void warning(String msg) {
	utils.printLogln(msg, VerboseLevelEnum.WARNING);
    }

    /**
     * Process a list of strings as messages with warning verbose level
     * 
     * @param msgs String[]
     * @return void
     */
    public void warning(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, VerboseLevelEnum.WARNING);
	}
    }

    /**
     * Process a string as message with error verbose level
     * 
     * @param msg String
     * @return void
     */
    public void error(String msg) {
	utils.printLogln(msg, VerboseLevelEnum.ERROR);
    }

    /**
     * Process a Exception as message with error verbose level
     * 
     * @param msg Exception
     * @return void
     */
    public void error(Exception e) {
	StackTraceElement[] stackTraceElements = e.getStackTrace();

	// Converter o array de StackTraceElement para List<String>
	List<String> stackTraceLines = new ArrayList<>();
	for (StackTraceElement element : stackTraceElements) {
	    stackTraceLines.add(element.toString());
	}

	// Imprimir cada linha do stack trace
	for (String line : stackTraceLines) {
	    utils.printLogln("> " + line, VerboseLevelEnum.ERROR);
	}
    }

    /**
     * Process a list of strings as messages with error verbose level
     * 
     * @param msgs String[]
     * @return void
     */
    public void error(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, VerboseLevelEnum.ERROR);
	}
    }

    /**
     * Process a string as message with fatal verbose level
     * 
     * @param msg String
     * @return void
     */
    public void fatal(String msg) {
	utils.printLogln(msg, VerboseLevelEnum.FATAL);
    }

    /**
     * Process a list of strings as messages with fatal verbose level
     * 
     * @param msgs String[]
     * @return void
     */
    public void fatal(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, VerboseLevelEnum.FATAL);
	}
    }

    /**
     * Process a string as message with global verbose level
     * 
     * @param msg String
     * @return void
     */
    public void global(String msg) {
	utils.printLogln(msg, VerboseLevelEnum.GLOBAL);
    }

    /**
     * Process a list of strings as messages with global verbose level
     * 
     * @param msgs String[]
     * @return void
     */
    public void global(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, VerboseLevelEnum.GLOBAL);
	}
    }

}

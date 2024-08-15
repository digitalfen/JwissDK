package com.digitalfen.jwiss.devkit.logger;

import java.util.ArrayList;
import java.util.List;

import com.digitalfen.jwiss.devkit.enums.JwissVerboseLevelEnum;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissLogPrinter {

    private static JwissLogPrinter instance;
    private static JwissLogService utils;

    public static synchronized JwissLogPrinter getInstance() {
	if (instance == null) {
	    instance = new JwissLogPrinter();
	    utils = new JwissLogService();
	}
	return instance;
    }

    public void info(String msg) {
	utils.printLogln(msg, JwissVerboseLevelEnum.INFO);
    }

    public void info(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, JwissVerboseLevelEnum.INFO);
	}
    }

    public void debug(String msg) {
	utils.printLogln(msg, JwissVerboseLevelEnum.DEBUG);
    }

    public void debug(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, JwissVerboseLevelEnum.DEBUG);
	}
    }

    public void warning(String msg) {
	utils.printLogln(msg, JwissVerboseLevelEnum.WARNING);
    }

    public void warning(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, JwissVerboseLevelEnum.WARNING);
	}
    }

    public void error(String msg) {
	utils.printLogln(msg, JwissVerboseLevelEnum.ERROR);
    }

    public void error(Exception e) {
	StackTraceElement[] stackTraceElements = e.getStackTrace();

	// Converter o array de StackTraceElement para List<String>
	List<String> stackTraceLines = new ArrayList<>();
	for (StackTraceElement element : stackTraceElements) {
	    stackTraceLines.add(element.toString());
	}

	// Imprimir cada linha do stack trace
	for (String line : stackTraceLines) {
	    utils.printLogln("> " + line, JwissVerboseLevelEnum.ERROR);
	}
    }

    public void error(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, JwissVerboseLevelEnum.ERROR);
	}
    }

    public void fatal(String msg) {
	utils.printLogln(msg, JwissVerboseLevelEnum.FATAL);
    }

    public void fatal(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, JwissVerboseLevelEnum.FATAL);
	}
    }

    public void global(String msg) {
	utils.printLogln(msg, JwissVerboseLevelEnum.GLOBAL);
    }

    public void global(String[] msgs) {
	for (String msg : msgs) {
	    utils.printLogln(msg, JwissVerboseLevelEnum.GLOBAL);
	}
    }

}

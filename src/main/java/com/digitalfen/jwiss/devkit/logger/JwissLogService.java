package com.digitalfen.jwiss.devkit.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.digitalfen.jwiss.devkit.enums.JwissVerboseLevelEnum;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Log Printer Actions
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissLogService {

    /**
     * @value instance JwissLogService
     */
    private static JwissLogService instance;

    /**
     * @value printer JwissLogPrinter
     */
    private static JwissLogPrinter printer;

    /**
     * Get instance for Log Printer
     * 
     * @value JwissLogPrinter
     */
    public static synchronized JwissLogService getInstance() {
	if (instance == null) {
	    instance = new JwissLogService();
	    printer = new JwissLogPrinter();
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
	printer.printLogln(msg, JwissVerboseLevelEnum.INFO);
    }

    /**
     * Process a list of strings as messages with info verbose level
     * 
     * @param msgs String[]
     * @return void
     */
    public void info(String[] msgs) {
	for (String msg : msgs) {
	    printer.printLogln(msg, JwissVerboseLevelEnum.INFO);
	}
    }

    /**
     * Process a string as message with debug verbose level
     * 
     * @param msg String
     * @return void
     */
    public void debug(String msg) {
	printer.printLogln(msg, JwissVerboseLevelEnum.DEBUG);
    }

    /**
     * Process a list of strings as messages with debug verbose level
     * 
     * @param msgs String[]
     * @return void
     */
    public void debug(String[] msgs) {
	for (String msg : msgs) {
	    printer.printLogln(msg, JwissVerboseLevelEnum.DEBUG);
	}
    }

    /**
     * Process a map of strings as table with debug verbose level
     * 
     * @param map Map<String, String>
     * @return void
     */
    public void debug(Map<String, String> map) {
	List<String> lines = new ArrayList<>();
	int columnWidth = 50;

	// Cabeçalho da tabela
	lines.add(String.format("%-" + columnWidth + "s %-" + columnWidth + "s",
		"----------------------------------------", "----------------------------------------"));

	// Adiciona as linhas da tabela
	for (Map.Entry<String, String> entry : map.entrySet()) {
	    String key = entry.getKey();
	    String value = entry.getValue();
	    lines.add(String.format("%-" + columnWidth + "s %-" + columnWidth + "s", key,
		    value));
	}

	lines.add(String.format("%-" + columnWidth + "s %-" + columnWidth + "s",
		"----------------------------------------", "----------------------------------------"));

	for (String line : lines) {
	    printer.printLogln(line, JwissVerboseLevelEnum.DEBUG);
	}

    }

    /**
     * Process a string as message with warning verbose level
     * 
     * @param msg String
     * @return void
     */
    public void warning(String msg) {
	printer.printLogln(msg, JwissVerboseLevelEnum.WARNING);
    }

    /**
     * Process a list of strings as messages with warning verbose level
     * 
     * @param msgs String[]
     * @return void
     */
    public void warning(String[] msgs) {
	for (String msg : msgs) {
	    printer.printLogln(msg, JwissVerboseLevelEnum.WARNING);
	}
    }

    /**
     * Process a string as message with error verbose level
     * 
     * @param msg String
     * @return void
     */
    public void error(String msg) {
	printer.printLogln(msg, JwissVerboseLevelEnum.ERROR);
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
	    printer.printLogln("> " + line, JwissVerboseLevelEnum.ERROR);
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
	    printer.printLogln(msg, JwissVerboseLevelEnum.ERROR);
	}
    }

    /**
     * Process a string as message with fatal verbose level
     * 
     * @param msg String
     * @return void
     */
    public void fatal(String msg) {
	printer.printLogln(msg, JwissVerboseLevelEnum.FATAL);
    }

    /**
     * Process a list of strings as messages with fatal verbose level
     * 
     * @param msgs String[]
     * @return void
     */
    public void fatal(String[] msgs) {
	for (String msg : msgs) {
	    printer.printLogln(msg, JwissVerboseLevelEnum.FATAL);
	}
    }

    /**
     * Process a string as message with global verbose level
     * 
     * @param msg String
     * @return void
     */
    public void global(String msg) {
	printer.printLogln(msg, JwissVerboseLevelEnum.GLOBAL);
    }

    /**
     * Process a list of strings as messages with global verbose level
     * 
     * @param msgs String[]
     * @return void
     */
    public void global(String[] msgs) {
	for (String msg : msgs) {
	    printer.printLogln(msg, JwissVerboseLevelEnum.GLOBAL);
	}
    }

}

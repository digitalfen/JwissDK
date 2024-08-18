package com.digitalfen.jwiss.devkit.logger;

import java.util.Date;

import com.digitalfen.jwiss.devkit.enums.JwissVerboseLevelEnum;
import com.digitalfen.jwiss.devkit.handlers.JwissCache;

import lombok.NoArgsConstructor;

/**
 * Jwiss Log Service
 */
@NoArgsConstructor
public class JwissLogPrinter {

    /**
     * Build a new println on JwissTool System.out with custom methods.
     * 
     * @param message         String
     * @param msgVerboseLevel JwissVerboseLevelEnum
     * 
     * @return void
     */
    protected void printLogln(String message, JwissVerboseLevelEnum msgVerboseLevel) {
	messageBuilder(message, msgVerboseLevel);

    }

    /**
     * Build labels and format values then Print message
     * 
     * @param message         String
     * @param msgVerboseLevel JwissVerboseLevelEnum
     * 
     * @return void
     */
    protected void messageBuilder(String message, JwissVerboseLevelEnum msgVerboseLevel) {
	JwissVerboseLevelEnum appVerboseLevel;

	String cacheVerboseLevel = JwissCache.configurations
		.get("verbose");

	if (cacheVerboseLevel == null) {
	    appVerboseLevel = JwissVerboseLevelEnum.OFF;

	} else if (cacheVerboseLevel.toUpperCase() == JwissVerboseLevelEnum.OFF.toString()) {
	    appVerboseLevel = JwissVerboseLevelEnum.OFF;

	} else {
	    appVerboseLevel = JwissVerboseLevelEnum
		    .valueOf(cacheVerboseLevel.toUpperCase());

	}

	StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
	StackTraceElement callerElement = stackTrace[4];
	String callerName = callerElement.getClassName();

	String[] splitedSimpleName = callerName.replace(".", "%%").split("%%");
	String fClassName = splitedSimpleName[splitedSimpleName.length - 1];

	String line = new String();
	line = line.concat(msgVerboseLevel.toString().toUpperCase());
	line = line.concat(" | ");
	line = line.concat(new Date().toString());
	line = line.concat(" | ");
	line = line.concat(fClassName);

	if (msgVerboseLevel.equals(JwissVerboseLevelEnum.GLOBAL)) {
	    line = "\033[0;35m".concat(line).concat("\033[0m");
	    line = line.concat(" - ");
	    line = line.concat(message);
	    System.out.println(line);

	} else if (msgVerboseLevel.equals(JwissVerboseLevelEnum.FATAL)) {
	    line = line.concat(" - ");
	    line = line.concat(message);
	    line = "\033[0;31m".concat(line).concat("\033[0m");
	    System.out.println(line);

	} else if (!appVerboseLevel.equals(JwissVerboseLevelEnum.OFF)) {
	    if ((msgVerboseLevel.equals(JwissVerboseLevelEnum.INFO)
		    && appVerboseLevel.equals(JwissVerboseLevelEnum.INFO)) ||
		    (msgVerboseLevel.equals(JwissVerboseLevelEnum.INFO)
			    && appVerboseLevel.equals(JwissVerboseLevelEnum.DEBUG))) {
		line = "\033[0;32m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(message);

		System.out.println(line);

	    } else if (msgVerboseLevel.equals(JwissVerboseLevelEnum.DEBUG)
		    && appVerboseLevel.equals(JwissVerboseLevelEnum.DEBUG)) {
		line = "\033[0;34m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(message);
		System.out.println(line);

	    } else if (msgVerboseLevel.equals(JwissVerboseLevelEnum.WARNING)) {
		line = "\033[0;33m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(message);
		System.out.println(line);

	    } else if (msgVerboseLevel.equals(JwissVerboseLevelEnum.ERROR)) {
		line = "\033[0;31m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(message);
		System.out.println(line);

	    }

	} else {
	    if (msgVerboseLevel.equals(JwissVerboseLevelEnum.GLOBAL)) {
		line = "\033[0;35m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(message);
		System.out.println(line);

	    }
	}
    }

}

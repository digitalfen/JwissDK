package com.digitalfen.jwiss.devkit.logger;

import java.util.Date;

import com.digitalfen.jwiss.devkit.enums.VerboseLevelEnum;
import com.digitalfen.jwiss.devkit.handlers.JwissCache;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Jwiss Log Service
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JwissLogService {

    private static JwissLogService instance;

    /**
     * Get instance for Log Service
     * 
     * @return JwissLogService
     */
    public static synchronized JwissLogService getInstance() {
	if (instance == null) {
	    instance = new JwissLogService();
	}
	return instance;
    }

    /**
     * Build a new println on JwissTool System.out with custom methods.
     * 
     * @param message         String
     * @param msgVerboseLevel VerboseLevelEnum
     * 
     * @return void
     */
    protected void printLogln(String message, VerboseLevelEnum msgVerboseLevel) {
	messageBuilder(message, msgVerboseLevel);

    }

    /**
     * Build labels and format values then Print message
     * 
     * @param message         String
     * @param msgVerboseLevel VerboseLevelEnum
     * 
     * @return void
     */
    protected void messageBuilder(String message, VerboseLevelEnum msgVerboseLevel) {
	VerboseLevelEnum appVerboseLevel;

	String cacheVerboseLevel = JwissCache.configurations.get("global.verbose");

	if (cacheVerboseLevel == null) {
	    appVerboseLevel = VerboseLevelEnum.OFF;

	} else if (cacheVerboseLevel == VerboseLevelEnum.OFF.toString()
		.toUpperCase()) {
	    appVerboseLevel = VerboseLevelEnum.OFF;

	} else {
	    appVerboseLevel = VerboseLevelEnum
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

	if (appVerboseLevel.equals(VerboseLevelEnum.GLOBAL)) {
	    line = "\033[0;35m".concat(line).concat("\033[0m");
	    line = line.concat(" - ");
	    line = line.concat(message);
	    System.out.println(line);

	} else if (appVerboseLevel.equals(VerboseLevelEnum.FATAL)) {
	    line = line.concat(" - ");
	    line = line.concat(message);
	    line = "\033[0;31m".concat(line).concat("\033[0m");
	    System.out.println(line);

	} else if (!appVerboseLevel.equals(VerboseLevelEnum.OFF)
		&& !appVerboseLevel.equals(VerboseLevelEnum.FATAL)) {
	    if ((msgVerboseLevel.equals(VerboseLevelEnum.INFO)
		    && appVerboseLevel.equals(VerboseLevelEnum.INFO)) ||
		    (msgVerboseLevel.equals(VerboseLevelEnum.INFO)
			    && appVerboseLevel.equals(VerboseLevelEnum.DEBUG))) {
		line = "\033[0;32m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(message);

		System.out.println(line);

	    } else if (msgVerboseLevel.equals(VerboseLevelEnum.DEBUG)
		    && appVerboseLevel.equals(VerboseLevelEnum.DEBUG)) {
		line = "\033[0;34m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(message);
		System.out.println(line);

	    } else if (msgVerboseLevel.equals(VerboseLevelEnum.WARNING)) {
		line = "\033[0;33m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(message);
		System.out.println(line);

	    } else if (msgVerboseLevel.equals(VerboseLevelEnum.ERROR)) {
		line = "\033[0;31m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(message);
		System.out.println(line);

	    }

	} else {
	    if (msgVerboseLevel.equals(VerboseLevelEnum.GLOBAL)) {
		line = "\033[0;35m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(message);
		System.out.println(line);

	    }
	}
    }

}

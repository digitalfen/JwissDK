package com.digitalfen.jwiss.devkit.logger;

import java.util.Date;

import com.digitalfen.jwiss.devkit.enums.JwissVerboseLevelEnum;
import com.digitalfen.jwiss.devkit.handlers.JwissCache;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JwissLogService {

    private static JwissLogService instance;

    public static synchronized JwissLogService getInstance() {
	if (instance == null) {
	    instance = new JwissLogService();
	}
	return instance;
    }

    protected void printLogln(String msg, JwissVerboseLevelEnum msgVerboseLevel) {
	msgBuilder(msg, msgVerboseLevel);

    }

    protected void printLog(String msg, JwissVerboseLevelEnum msgVerboseLevel) {
	msgBuilder(msg, msgVerboseLevel);
    }

    protected void msgBuilder(String msg, JwissVerboseLevelEnum msgVerboseLevel) {
	JwissVerboseLevelEnum appVerboseLevel;

	String cacheVerboseLevel = JwissCache.configurations.get("global.verbose");

	if (cacheVerboseLevel == null) {
	    appVerboseLevel = JwissVerboseLevelEnum.OFF;

	} else if (cacheVerboseLevel == JwissVerboseLevelEnum.OFF.toString()
		.toUpperCase()) {
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

	String toPersist = new String();
	toPersist = line.replace(JwissVerboseLevelEnum.INFO.toString().toUpperCase(),
		JwissVerboseLevelEnum.DEBUG.toString().toUpperCase());
	toPersist = toPersist.concat(callerName);
	toPersist = toPersist.concat(" : ");
	toPersist = toPersist.concat(msg);

	persistLog(toPersist);

	if (!appVerboseLevel.equals(JwissVerboseLevelEnum.OFF)
		&& !appVerboseLevel.equals(JwissVerboseLevelEnum.ERROR)) {
	    if ((msgVerboseLevel.equals(JwissVerboseLevelEnum.INFO)
		    && appVerboseLevel.equals(JwissVerboseLevelEnum.INFO)) ||
		    (msgVerboseLevel.equals(JwissVerboseLevelEnum.INFO)
			    && appVerboseLevel.equals(JwissVerboseLevelEnum.DEBUG))) {
		line = "\033[0;32m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(msg);

		System.out.println(line);

	    } else if (msgVerboseLevel.equals(JwissVerboseLevelEnum.DEBUG)
		    && appVerboseLevel.equals(JwissVerboseLevelEnum.DEBUG)) {
		line = "\033[0;34m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(msg);
		System.out.println(line);

	    } else if (msgVerboseLevel.equals(JwissVerboseLevelEnum.WARNING)) {
		line = "\033[0;33m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(msg);
		System.out.println(line);

	    } else if (msgVerboseLevel.equals(JwissVerboseLevelEnum.FATAL)) {
		line = line.concat(" - ");
		line = line.concat(msg);
		line = "\033[0;31m".concat(line).concat("\033[0m");
		System.out.println(line);

	    } else if (msgVerboseLevel.equals(JwissVerboseLevelEnum.GLOBAL)) {
		line = "\033[0;35m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(msg);
		System.out.println(line);

	    } else if (msgVerboseLevel.equals(JwissVerboseLevelEnum.ERROR)) {
		line = "\033[0;31m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(msg);
		System.out.println(line);

	    }

	} else {
	    if (msgVerboseLevel.equals(JwissVerboseLevelEnum.GLOBAL)) {
		line = "\033[0;35m".concat(line).concat("\033[0m");
		line = line.concat(" - ");
		line = line.concat(msg);
		System.out.println(line);

	    }
	}
    }

    protected void persistLog(String lines) {

    }

}

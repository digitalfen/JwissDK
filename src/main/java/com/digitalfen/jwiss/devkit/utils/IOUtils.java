package com.digitalfen.jwiss.devkit.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.digitalfen.jwiss.devkit.model.Argument;
import com.digitalfen.jwiss.devkit.model.Command;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utils for Input and Output Texts/Files in JwissTool
 * 
 * @value instance IOUtils
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IOUtils {

    private static IOUtils instance;

    /**
     * Get instance for IOUtils
     * 
     * @return IOUtils
     */
    public static synchronized IOUtils getInstance() {
	if (instance == null) {
	    instance = new IOUtils();
	}
	return instance;
    }

    /**
     * Parse an Input String into List of Commands
     * 
     * @param input String
     * @return List<Command>
     */
    public List<Command> parseInput(String input) {

	List<Command> out = new ArrayList<>();
	List<String> commands = Arrays.asList(input.split("&&"));

	for (String command : commands) {
	    List<String> splitedCommand = Arrays.asList(command.split(" "));
	    String jwissCommandKey = splitedCommand.get(1);
	    String jwissCommandParent = splitedCommand.get(0);
	    String[] arguments = command.replace(splitedCommand.get(0), "")
		    .replace(splitedCommand.get(1), "").split("-");

	    Command jwissCommand = new Command();
	    jwissCommand.setUsage(jwissCommandKey);
	    jwissCommand.setParentName(jwissCommandParent);

	    List<Argument> jwissArguments = new ArrayList<>();

	    for (String str : arguments) {
		List<String> splitedArguments = Arrays.asList(str.split(" "));

		if (splitedArguments.size() == 1) {
		    Argument arg = new Argument();
		    arg.setKey(splitedArguments.get(0));
		    arg.setValue(null);
		    jwissArguments.add(arg);
		} else if (splitedArguments.size() > 1) {
		    for (int i = 1; i < splitedArguments.size(); i++) {
			Argument arg = new Argument();
			arg.setKey(splitedArguments.get(0));
			arg.setValue(splitedArguments.get(i));
			jwissArguments.add(arg);
		    }
		}
	    }

	    jwissCommand.setArguments(jwissArguments);
	    out.add(jwissCommand);

	}

	return out;
    }

}

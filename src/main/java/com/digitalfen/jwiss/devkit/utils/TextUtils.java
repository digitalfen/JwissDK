package com.digitalfen.jwiss.devkit.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.digitalfen.jwiss.devkit.handlers.JwissLogger;
import com.digitalfen.jwiss.devkit.model.JwissArgument;
import com.digitalfen.jwiss.devkit.model.JwissCommand;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TextUtils {

    private static TextUtils instance;

    public static synchronized TextUtils getInstance() {
	if (instance == null) {
	    instance = new TextUtils();
	}
	return instance;
    }

    public String[] writeTable(Map<String, String> map) {
	List<String> lines = new ArrayList<>();
	int columnWidth = 20;

	// Cabeçalho da tabela
	lines.add(String.format("%-" + columnWidth + "s %-" + columnWidth + "s",
		"--------------------", "--------------------"));

	// Adiciona as linhas da tabela
	for (Map.Entry<String, String> entry : map.entrySet()) {
	    String key = entry.getKey();
	    String value = entry.getValue();
	    lines.add(String.format("%-" + columnWidth + "s %-" + columnWidth + "s", key,
		    value));
	}

	lines.add(String.format("%-" + columnWidth + "s %-" + columnWidth + "s",
		"--------------------", "--------------------"));

	return lines.toArray(new String[0]);
    }

    public static List<JwissCommand> parseInput(String input) {

	List<JwissCommand> out = new ArrayList<>();
	List<String> commands = Arrays.asList(input.split("&&"));

	for (String command : commands) {
	    List<String> splitedCommand = Arrays.asList(command.split(" "));
	    String jwissCommandKey = splitedCommand.get(1);
	    String jwissCommandParent = splitedCommand.get(0);
	    String[] arguments = command.replace(splitedCommand.get(0), "")
		    .replace(splitedCommand.get(1), "").split("-");

	    JwissCommand jwissCommand = new JwissCommand();
	    jwissCommand.setUsage(jwissCommandKey);
	    jwissCommand.setParentName(jwissCommandParent);

	    List<JwissArgument> jwissArguments = new ArrayList<>();

	    for (String str : arguments) {
		List<String> splitedArguments = Arrays.asList(str.split(" "));

		if (splitedArguments.size() == 1) {
		    JwissArgument arg = new JwissArgument();
		    arg.setKey(splitedArguments.get(0));
		    arg.setValue(null);
		    jwissArguments.add(arg);
		} else if (splitedArguments.size() > 1) {
		    for (int i = 1; i < splitedArguments.size(); i++) {
			JwissArgument arg = new JwissArgument();
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

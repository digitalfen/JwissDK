package com.digitalfen.jwiss.devkit.configurations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.digitalfen.jwiss.devkit.enums.JwissConfigLabelEnum;
import com.digitalfen.jwiss.devkit.handlers.JwissConfiguration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwissConfigReader {

    private static JwissConfigReader instance;

    public static synchronized JwissConfigReader getInstance() {
	if (instance == null) {
	    instance = new JwissConfigReader();
	}
	return instance;
    }

    public Map<String, String> readValues(String configName) throws Exception {
	boolean isValid = false;
	Map<String, String> definedCfg = readDefinedValues(configName);
	Map<String, String[]> defaultCfg = readDefaultValues("jwiss.properties");

	for (Entry<String, String> option : definedCfg.entrySet()) {
	    if (defaultCfg.containsKey(option.getKey())) {
		for (String defaultOption : defaultCfg.get(option.getKey())) {
		    if (option.getValue().equals(defaultOption))
			isValid = true;
		}
	    }
	}

	if (!isValid)
	    throw new Exception();

	return definedCfg;

    };

    public Map<String, String[]> readDefaultValues(String configName) {
	Map<String, String[]> propertiesMap = new HashMap<>();
	Map<String, List<String>> tempMap = new HashMap<>();
	Map<String, String> activeToOptionMap = new HashMap<>();

	try (InputStream inputStream = JwissConfiguration.class.getClassLoader()
		.getResourceAsStream(configName)) {
	    if (inputStream == null) {
		throw new IOException("File not found: " + configName);
	    }

	    Properties properties = new Properties();
	    properties.load(inputStream);

	    // Primeiro, mapear todos os valores .active para os respectivos prefixos
	    properties.stringPropertyNames().forEach(key -> {
		String[] parts = key.split("\\.");
		if (parts.length == 2 && parts[1].equals("active")) {
		    String prefix = parts[0];
		    String activeValue = properties.getProperty(key);
		    activeToOptionMap.put(prefix, activeValue);
		}
	    });

	    // Em seguida, armazenar todos os valores .option associados aos respectivos
	    // prefixos
	    properties.stringPropertyNames().forEach(key -> {
		String[] parts = key.split("\\.");
		if (parts.length == 3 && parts[1].equals("option")) {
		    String prefix = parts[0];
		    String activeValue = activeToOptionMap.get(prefix);
		    if (activeValue != null) {
			String optionKey = prefix + ".option." + activeValue;
			if (properties.getProperty(optionKey) != null) {
			    tempMap.putIfAbsent(prefix, new ArrayList<>());
			    tempMap.get(prefix).add(properties.getProperty(key));
			}
		    }
		}
	    });

	    tempMap.forEach((k, v) -> propertiesMap.put(k, v.toArray(new String[0])));

	} catch (IOException e) {
	    e.printStackTrace();
	}

	return propertiesMap;
    }

    private Map<String, String> readDefinedValues(String fileName) {
	String configDirPath = new File("").getAbsolutePath();

	String filePath = configDirPath + File.separator
		+ JwissConfigLabelEnum.CONFIG
		+ File.separator
		+ fileName
		+ JwissConfigLabelEnum.SEPARATOR
		+ JwissConfigLabelEnum.FILE_FORMAT;

	Map<String, String> propertiesMap = new HashMap<>();

	try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	    String line;
	    while ((line = br.readLine()) != null) {
		line = line.trim();
		if (line.isEmpty() || line.startsWith("#") || line.startsWith(";")) {
		    continue;
		}
		String[] parts = line.split("[=:]");
		if (parts.length >= 2) {
		    String key = parts[0].trim();
		    String value = parts[1].trim();
		    propertiesMap.put(key, value);
		}
	    }
	} catch (FileNotFoundException e) {
	    e.printStackTrace();

	} catch (IOException e) {
	    e.printStackTrace();

	}

	return propertiesMap;
    }

}

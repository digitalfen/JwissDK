package com.digitalfen.jwiss.devkit.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JwissLogFile {

    public static void persist(String logMessage) {
	// Defina o caminho para a pasta /logs
	String directoryPath = System.getProperty("user.dir") + File.separator + "logs";
	File logDirectory = new File(directoryPath);

	// Cria a pasta logs caso ela não exista
	if (!logDirectory.exists()) {
	    logDirectory.mkdir();
	}

	// Defina o caminho do arquivo de log (um arquivo chamado "log.txt" na pasta
	// logs)
	File logFile = new File(logDirectory, "log.txt");

	// Escreva a mensagem no arquivo
	try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
	    writer.write(logMessage);
	    writer.newLine(); // Adiciona uma nova linha ao final da mensagem
	    System.out.println("Log salvo com sucesso!");
	} catch (IOException e) {
	    System.out.println("Erro ao salvar o log: " + e.getMessage());
	}
    }

}

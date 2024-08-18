package com.digitalfen.jwiss.devkit.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
     * Insere uma linha em um arquivo .conf. Se o arquivo não existir, ele será
     * criado.
     * 
     * @param filePath Caminho do arquivo, relativo à raiz do projeto.
     * @param line     Linha a ser inserida no arquivo.
     * @throws IOException Se ocorrer um erro ao acessar o arquivo.
     */
    public void appendLineToFile(String filePath, String line) {
	File file = new File(filePath);

	// Verifica se o arquivo existe e cria o arquivo se não existir
	if (!file.exists()) {
	    file.getParentFile().mkdirs(); // Cria os diretórios, se necessário
	    try {
		file.createNewFile();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } // Cria o arquivo
	}

	// Usa BufferedWriter para adicionar a linha ao final do arquivo
	try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
	    writer.newLine(); // Adiciona uma nova linha antes de escrever a nova linha
	    writer.write(line); // Escreve a linha no arquivo
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Escreve uma linha em um arquivo .conf. Se o arquivo não existir, ele será
     * criado. Se o arquivo já existir, seu conteúdo será sobrescrito.
     * 
     * @param filePath Caminho do arquivo, relativo à raiz do projeto.
     * @param line     Linha a ser escrita no arquivo.
     */
    public void writeLineToFile(String filePath, String line) {
	File file = new File(filePath);

	// Verifica se o arquivo existe e cria o arquivo se não existir
	if (!file.exists()) {
	    file.getParentFile().mkdirs(); // Cria os diretórios, se necessário
	    try {
		file.createNewFile(); // Cria o arquivo
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	// Usa BufferedWriter para escrever a linha no arquivo
	try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	    writer.write(line); // Escreve a linha no arquivo
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

}

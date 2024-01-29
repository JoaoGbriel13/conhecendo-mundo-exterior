package br.com.jg.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReaderService {
    public void createFile(Path path) throws IOException {
        if (path.toFile().exists()) {
            throw new IOException("Um arquivo com esse nome já existe!");
        } else {
            Files.createFile(path);
            String text = "Homem de Ferro,Capitão América,Thor,Hulk," +
                    "Viúva Negra,Gavião Arqueiro,Pantera Negra," +
                    "Homem-Aranha,Doutor Estranho,Capitã Marvel" +
                    ",Feiticeira Escarlate,Falcão,Máquina de Combate,Wolverine,Deadpool";
            String replaceCommas = text.replace(",", "\n");
            Files.writeString(path, replaceCommas);
            System.out.println("Arquivo criado com sucesso!");
        }
    }

    public void printFile(Path path) throws IOException {
        String text = Files.readString(path);
        System.out.println(text);
        var splitted = text.split("\n");
        System.out.printf("O numero de linhas é:%d", splitted.length);
        System.out.printf("\nO numero de caracteres é:%d", Arrays.toString(splitted).
                replaceAll("\\s", "").replace(",","").length());
    }
}

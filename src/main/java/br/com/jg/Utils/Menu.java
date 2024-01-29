package br.com.jg.Utils;

import br.com.jg.Service.ReaderService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Menu {
    private static final Scanner scan = new Scanner(System.in);
    private final ReaderService readerService = new ReaderService();


    public void exibirMenu() throws IOException {
        menuLogic();
    }

    private void menuLogic() throws IOException {
        System.out.println("Bem vindo ao sistema de leitura e criação de arquivos! Selecione o que deseja fazer:" +
                "\n1 - Criar arquivo de texto" +
                "\n2 - Ler arquivo de texto");
        int escolha = scan.nextInt();
        switch (escolha){
            case 1:
                createFileLogic();
                break;
            case 2:
                readFileLogic();
                break;
            default:
                System.out.println("Opção invalida, tente novamente");
                menuLogic();
                break;
        }
    }

    private void readFileLogic() throws IOException {
        System.out.println("Insira o seu nome no mesmo formato em que criou o arquivo: ");
        String name = scan.next().replaceAll("\\s", "");
        String pathString = "C:\\Users\\joaog\\OneDrive\\Documentos\\text\\" + name +".txt";
        Path path = Path.of(pathString);
        readerService.printFile(path);
    }

    private void createFileLogic() throws IOException {
        System.out.println("Insira seu nome: ");
        String name = scan.next().replaceAll("\\s", "");
        String pathString = "C:\\Users\\joaog\\OneDrive\\Documentos\\text\\" + name +".txt";
        Path path = Path.of(pathString);
        readerService.createFile(path);
    }
}

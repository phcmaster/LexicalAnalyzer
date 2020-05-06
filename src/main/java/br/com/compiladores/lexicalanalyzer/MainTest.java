package br.com.compiladores.lexicalanalyzer;

import br.com.compiladores.lexicalanalyzer.FIleIO.FIleManager;

import java.io.IOException;

public class MainTest {

    public static void main(String[] args) throws IOException {

        String path = "src/main/resources/Program.txt";
        FIleManager fIleManager = new FIleManager();
        fIleManager.reader(path);

    }
}

package br.com.compiladores.lexicalanalyzer.FIleIO;

import br.com.compiladores.lexicalanalyzer.analyzers.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FIleManager {

    public void reader(String path) throws IOException {


        BufferedReader buffRead = new BufferedReader(new FileReader(path));

        String line = "";

        while (true) {
            if (line != null) {
                System.out.println("\n" +line + " " + printText(line));

            } else
                break;
            line = buffRead.readLine();

        }
        buffRead.close();

    }


    private String printText(String line) {

        Literal literal = new Literal();
        WholeNumber number = new WholeNumber();
        DecimalNumber decimalNumber = new DecimalNumber();
        Identifier identifier = new Identifier();
        Symbols symbol = new Symbols();

        if (literal.lexicalValidator(line)) {
            return "LITERAL";
        } else if (identifier.lexicalValidator(line)) {
            return "IDENTIFIER";
        } else if (number.lexicalValidator(line)) {
            return "NUMBER";
        } else if (decimalNumber.lexicalValidator(line)) {
            return "DECIMAL";
        } else if (symbol.lexicalValidator(line)) {
            return "    SYMBOL";
        } else {
            return "NOT FOUND";
        }


    }


}

package br.com.compiladores.lexicalanalyzer.FIleIO;

import br.com.compiladores.lexicalanalyzer.analyzers.*;

import java.io.*;
import java.util.List;

public class FIleManager {

    public void reader(String path) throws IOException {

        Literal literal = new Literal();
        WholeNumber number = new WholeNumber();
        DecimalNumber decimalNumber = new DecimalNumber();
        Identifier identifier = new Identifier();
        Symbols symbol = new Symbols();


        BufferedReader buffRead = new BufferedReader(new FileReader(path));

        String line = "";

        while (true) {
            if (line != null) {
                literal.lexicalValidator(line);
                number.lexicalValidator(line);
                decimalNumber.lexicalValidator(line);
                identifier.lexicalValidator(line);
                symbol.lexicalValidator(line);


            } else
                break;
            line = buffRead.readLine();
        }
        buffRead.close();
        printText(literal.getLiteralList(), number.getNumberList(),
                decimalNumber.getDecimalList(), identifier.getIdentifierList(), symbol.getSymbolsList());
    }


    private void printText(List<String> literais, List<String> numbers, List<String> decimal, List<String> identifier, List<String> symbol) {
        System.out.println("Literais: \n");
        literais.forEach(System.out::println);

        System.out.println("\n Valores inteiros: \n");
        numbers.forEach(System.out::println);

        System.out.println("\n Valores decimais: \n");
        decimal.forEach(System.out::println);

        System.out.println("\n Simbolos: \n");
        symbol.forEach(System.out::println);

        System.out.println("\n Identificadores: \n");
        identifier.forEach(System.out::println);


    }

}

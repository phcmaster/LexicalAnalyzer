package br.com.compiladores.lexicalanalyzer.FIleIO;

import br.com.compiladores.lexicalanalyzer.analyzers.DecimalNumber;
import br.com.compiladores.lexicalanalyzer.analyzers.Identifier;
import br.com.compiladores.lexicalanalyzer.analyzers.Literal;
import br.com.compiladores.lexicalanalyzer.analyzers.WholeNumber;

import java.io.*;
import java.util.List;

public class FIleManager {

    public void reader(String path) throws IOException {

        Literal literal = new Literal();
        WholeNumber number = new WholeNumber();
        DecimalNumber decimalNumber = new DecimalNumber();
        Identifier identifier = new Identifier();

        BufferedReader buffRead = new BufferedReader(new FileReader(path));

        String line = "";

        while (true) {
            if (line != null) {
                literal.lexicalValidator(line);
                number.lexicalValidator(line);
                decimalNumber.lexicalValidator(line);
                identifier.lexicalValidator(line);

            } else
                break;
            line = buffRead.readLine();
        }
        buffRead.close();
        printText(literal.getLiteralList(), number.getNumberList(),
                decimalNumber.getDecimalList(), identifier.getIdentifierList());
    }


    private void printText(List<String> literais, List<String> numbers, List<String> decimal, List<String> identifier) {
        System.out.println("Literais: \n");
        literais.forEach(System.out::println);

        System.out.println("\n Valor inteiro: \n");
        numbers.forEach(System.out::println);

        System.out.println("\n Valor decimal: \n");
        decimal.forEach(System.out::println);

//        System.out.println("\n Simbolos: \n");
//        decimal.forEach(System.out::println);

        System.out.println("\n Identificador: \n");
        identifier.forEach(System.out::println);


    }

}

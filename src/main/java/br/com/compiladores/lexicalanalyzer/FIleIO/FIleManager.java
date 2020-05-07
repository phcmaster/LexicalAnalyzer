package br.com.compiladores.lexicalanalyzer.FIleIO;

import br.com.compiladores.lexicalanalyzer.analyzers.DecimalNumber;
import br.com.compiladores.lexicalanalyzer.analyzers.Identifier;
import br.com.compiladores.lexicalanalyzer.analyzers.Literal;
import br.com.compiladores.lexicalanalyzer.analyzers.WholeNumber;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FIleManager {



    public void reader(String path) throws IOException {

        Literal literal = new Literal();
        WholeNumber number = new WholeNumber();
        DecimalNumber decimalNumber = new DecimalNumber();
        Identifier identifier = new Identifier();

        BufferedReader buffRead = new BufferedReader(new FileReader(path));

        String line = "";
        int n = 0;
        while (true) {
            if (line != null) {
                Pattern rxPattern = Pattern.compile("(-|\\+|)([0-9])([0-9]+)*(.|,)([0-9])([0-9]+)*");
                Matcher matcher = rxPattern.matcher(line.trim());

                Pattern literalr = Pattern.compile("[\"]\\D*?[\"]");
                Matcher lite = literalr.matcher(line.trim());

                if(lite.find()){
                    System.out.println("Literal:" + line);

                }else if (line.matches("(-|\\+|)([0-9])([0-9]+)*")){
                    System.out.println("Numero inteiro: " + line);

                }else if (line.matches("[A-Za-z]([[A-Za-z]0-9])*")){
                    System.out.println("Identificador: " + line);

                }else if (matcher.find()){
                    System.out.println("Decimal : " + line);
                }

                else {
                    System.out.println("Nao reconhecido: " + line);
                }


//                literal.lexicalValidator(line);
//                number.lexicalValidator(line);
//                decimalNumber.lexicalValidator(line);
//                identifier.lexicalValidator(line);

            } else
                break;
            line = buffRead.readLine();
        }
        buffRead.close();


//        printText(literal.getLiteralList(), number.getNumberList(),
//                decimalNumber.getDecimalList(), identifier.getIdentifierList());
    }


    private void printText(List<String> literais, List<String> numbers, List<String> decimal, List<String> identifier) {
        System.out.println("Literais: \n");
        literais.stream().forEach(x -> System.out.println("Literal: " + x));

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

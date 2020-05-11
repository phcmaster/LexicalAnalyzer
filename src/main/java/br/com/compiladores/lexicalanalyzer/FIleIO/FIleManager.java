package br.com.compiladores.lexicalanalyzer.FIleIO;

import br.com.compiladores.lexicalanalyzer.analyzers.*;

import java.io.*;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FIleManager {

    public void reader(String path) throws IOException {

        Literal literal = new Literal();
        WholeNumber number = new WholeNumber();
        DecimalNumber decimalNumber = new DecimalNumber();
        Identifier identifier = new Identifier();
        Symbols symbols = new Symbols();



        BufferedReader buffRead = new BufferedReader(new FileReader(path));

        String line = "";
        String resultado = "";


        while (true) {
            if (line != null) {

                Pattern rxPatternLiteral = Pattern.compile("[\"]\\D*?[\"]");
                Matcher matcherLiteral = rxPatternLiteral.matcher(line.trim());

                Pattern rxPatternIdentificador = Pattern.compile("[A-Za-z]([[A-Za-z]0-9])*");
                Matcher matcherIdentificador = rxPatternIdentificador.matcher(line.trim());

                Pattern rxPatternDecimal = Pattern.compile("(-|\\+|)([0-9])([0-9]+)*(.|,)([0-9])([0-9]+)*");
                Matcher matcherDecimal = rxPatternDecimal.matcher(line.trim());

                if (matcherLiteral.find()) {
                    MatchResult res = matcherLiteral.toMatchResult();
                    resultado = res.group();
                    System.out.println("Literal: " + resultado);

                }else if(matcherIdentificador.find()){
                    MatchResult res = matcherIdentificador.toMatchResult();
                    resultado = res.group();
                    System.out.println("Identificador: " + resultado);

                }else if(matcherDecimal.find()){
                    MatchResult res = matcherDecimal.toMatchResult();
                    resultado = res.group();
                    System.out.println("Decimal: " + resultado);
                }
                else {
                    System.out.println("Nao achou");
                }


//                literal.lexicalValidator(line);
//                number.lexicalValidator(line);
//                decimalNumber.lexicalValidator(line);
//                identifier.lexicalValidator(line);
//                symbols.lexicalValidator(line);


            } else
                break;
            line = buffRead.readLine();
        }
        buffRead.close();
//        printText(literal.getLiteralList(), number.getNumberList(),
//                decimalNumber.getDecimalList(), identifier.getIdentifierList(), symbols.getSymbolsList());
    }


    private void printText(List<String> literais, List<String> numbers, List<String> decimal, List<String> identifier, List<String> symbols) {
        System.out.println("Literais: \n");
        literais.forEach(System.out::println);

        System.out.println("\n Valor inteiro: \n");
        numbers.forEach(System.out::println);

        System.out.println("\n Valor decimal: \n");
        decimal.forEach(System.out::println);

        System.out.println("\n Simbolos: \n");
        symbols.forEach(System.out::println);

        System.out.println("\n Identificador: \n");
        identifier.forEach(System.out::println);


    }

}

package br.com.compiladores.lexicalanalyzer;


import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Literal {

    public static void main(String[] args) {

        String text = "programa aprovacao { \n" +
                "\treal nota;\t\n" +
                "\tinteiro frequencia; \n" +
                "\treal frequenciaPercentual; \n" +
                "\t\n" +
                "\tinteiro totalAulas = 20;\t\n" +
                "\tescreva(\"Entre com a nota: \");\n" +
                "\tleia(nota);\n" +
                "\tescreva(\"Entre com a frequencia: \");\n" +
                "\tleia(frequencia);\n" +
                "\n" +
                "\tfrequenciaPercentual = frequencia / totalAulas;\n" +
                "\n" +
                "\tse frequenciaPercentual < 0.75 entao {\n" +
                "\t\tescreva(\"Reprovado por frequencia\");\n" +
                "\t} senao {\n" +
                "\t\tse nota < 5 entao {\n" +
                "\t\t\tescreva(\"Reprovado por nota.\");\n" +
                "\t\t} senao {\n" +
                "\t\t\tescreva(\"Aprovado\");\n" +
                "\t\t}\n" +
                "\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "\t";



        Pattern rxPattern = Pattern.compile("[\"]\\D*?[\"]");
        Matcher matcher = rxPattern.matcher(text.trim());

        while(matcher.find()){
            MatchResult res = matcher.toMatchResult();
            String resultado = res.group();
            System.out.println("É um literal \t");
            System.out.println(resultado);
        }

    }

}

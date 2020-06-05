package br.com.compiladores.lexicalanalyzer.analyzers;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Symbols implements Validator {

    private List<String> symbolsList = new ArrayList<>();


    @Override
    public boolean lexicalValidator(String line) {

        boolean isSimbol = false;

        for (int i = 0; i < line.length(); i++) {

            if (line.substring(i).equals("(")
                    || line.substring(i).equals(")")
                    || line.substring(i).equals("{")
                    || line.substring(i).equals("}")
                    || line.substring(i).equals(";")
                    || line.substring(i).equals("=")
                    || line.substring(i).equals("<")
//                    || line.substring(i).equals(".")
                    || line.substring(i).equals("/")) {
                isSimbol = true;

            }
        }
        return isSimbol;
    }
}

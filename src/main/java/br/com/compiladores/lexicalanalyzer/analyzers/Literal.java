package br.com.compiladores.lexicalanalyzer.analyzers;


import lombok.Getter;
import lombok.Setter;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class Literal implements Validator {

    private boolean isLiteral = false;

    @Override
    public boolean lexicalValidator(String line) {

        Pattern rxPattern = Pattern.compile("[\"]\\D*?[\"]");
        Matcher matcher = rxPattern.matcher(line.trim());
        var resultado = "";

        while (matcher.find()) {
            MatchResult res = matcher.toMatchResult();
            resultado = res.group();
        }


        if (resultado.lines().findAny().isPresent()) {
            isLiteral = true;

        }
        return isLiteral;
    }


}

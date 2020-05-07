package br.com.compiladores.lexicalanalyzer.analyzers;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Getter
@Setter
public class WholeNumber implements Validator {

    private List<String> numberList = new ArrayList<>();

    @Override
    public List<String> lexicalValidator(String line) {

        Pattern rxPattern = Pattern.compile("(-|\\+|)([0-9])([0-9]+)*");
        Matcher matcher = rxPattern.matcher(line.trim());
        var resultado = "";

        while (matcher.find()) {
            MatchResult res = matcher.toMatchResult();
            resultado = res.group();
        }

        List<String> response = resultado.lines().collect(Collectors.toList());

        if (response.stream().findAny().isPresent()) {
            numberList.addAll(response);

        }
        return numberList;

    }

    @Override
    public boolean lexicalValidatorNew(String line) {
        return true;
    }
}

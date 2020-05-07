package br.com.compiladores.lexicalanalyzer.analyzers;

import java.util.List;

public interface Validator {

     List<String> lexicalValidator(String line);


     boolean lexicalValidatorNew(String line);
}

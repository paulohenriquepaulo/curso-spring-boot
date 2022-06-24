package br.com.vendas.exception;

import java.util.HashMap;
import java.util.Map;

public class ExceptionPersonalizada extends RuntimeException {

    private Map<String, String> errors;

    public ExceptionPersonalizada() {
        this.errors = new HashMap<>();
    }

    public ExceptionPersonalizada(String erro, String descricao) {
        this();
        add(erro, descricao);
    }


    public void add(String erro, String descricao) {
        this.errors.put(erro, descricao);
    }

    public Map<String, String> getErrors() {
        return errors;
    }

}

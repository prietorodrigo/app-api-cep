package com.example.exemploapi;

public class Local {
    private String cep;
    private String logradouro;
    private String complemento;

    public Local(String cep, String logradouro, String complemento) {
        //inicializar atributos
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}

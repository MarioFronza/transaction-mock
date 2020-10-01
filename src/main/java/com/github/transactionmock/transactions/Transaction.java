package com.github.transactionmock.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {

    private String descricao;
    private long data;
    private int valor;
    private boolean duplicated;


    public Transaction(@JsonProperty("descricao") String descricao,
                       @JsonProperty("data") long data,
                       @JsonProperty("valor") int valor,
                       @JsonProperty("duplicated") boolean duplicated) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.duplicated = duplicated;
    }

    public String getDescricao() {
        return descricao;
    }

    public long getData() {
        return data;
    }

    public int getValor() {
        return valor;
    }

    public boolean isDuplicated() {
        return duplicated;
    }

    public void setDuplicated(boolean duplicated) {
        this.duplicated = duplicated;
    }
}

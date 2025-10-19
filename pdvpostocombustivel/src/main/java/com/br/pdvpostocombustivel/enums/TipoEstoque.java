package com.br.pdvpostocombustivel.enums;

public enum TipoEstoque {
    CONSUMO("Estoque Consumo"),
    VENDAS("Estoque Vendas");

    private final String descricao;

    private TipoEstoque(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

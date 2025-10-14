package com.br.pdvpostocombustivel.api.acesso.dto;


import com.br.pdvpostocombustivel.enums.TipoAcesso;

// Para Entrada
public record AcessoRequest(
        String usuario,
        String senha,
        TipoAcesso tipoAcesso
)
{ }

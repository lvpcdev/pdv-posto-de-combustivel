package com.br.pdvpostocombustivel.api.acesso.dto;


import com.br.pdvpostocombustivel.enums.TipoAcesso;

// Para Resposta
public record AcessoResponse(
        Long id,
        String usuario,
        String senha,
        TipoAcesso tipoAcesso,
        String token
) {}
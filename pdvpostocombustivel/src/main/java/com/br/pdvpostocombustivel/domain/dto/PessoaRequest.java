package com.br.pdvpostocombustivel.domain.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

// Para Entrada
public record PessoaRequest(
        String nomeCompleto,
        String cpfCnpj,
        Long numeroCtps,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate datNascimento
)
{ }

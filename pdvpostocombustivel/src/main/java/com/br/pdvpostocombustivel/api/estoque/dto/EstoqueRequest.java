package com.br.pdvpostocombustivel.api.estoque.dto;

import com.br.pdvpostocombustivel.enums.TipoEstoque;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EstoqueRequest(
        BigDecimal quantidade,
        String localTannque,
        String localEndereco,
        String localFabricacao,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate dataValidade,
        TipoEstoque tipoEstoque

        ) {
}

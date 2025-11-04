package com.br.pdvpostocombustivel.api.custo.dto;

import java.time.LocalDate;


public record CustoResponse(
        Long id,
        double imposto,
        double custoVariavel,
        double custoFixo,
        double margemLucro,
        LocalDate dataProcessamento,
        String token
) {
}

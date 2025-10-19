package com.br.pdvpostocombustivel.api.custo.dto;

import java.time.LocalDate;


public record CustoResponse(
        double imposto,
        double custoVariavel,
        double custoFixo,
        double margemLucro,
        LocalDate dataProcessamento
) {
}

package com.br.pdvpostocombustivel.domain.repository;


import com.br.pdvpostocombustivel.domain.entity.Preco;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public interface PrecoRepository {
    Optional<Preco> findByDataAlteracao(LocalDate dataAlteracao);

    Optional<Preco> findByhoraAlteracao(LocalDate horaAlteracao);

    Optional<Preco> findByValor(BigDecimal valor);
}

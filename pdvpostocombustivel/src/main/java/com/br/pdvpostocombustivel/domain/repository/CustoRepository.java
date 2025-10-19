package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Custo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface CustoRepository extends JpaRepository<Custo, Long> {

    Optional<Custo> findByMargemLucro(double margemLucro);

    Optional<Custo> findByDataProcessamento(LocalDate dataProcessamento);

    boolean existsByMargemLucro(double margemLucro);

    boolean existsByDataProcessamento(LocalDate dataProcessamento);
}

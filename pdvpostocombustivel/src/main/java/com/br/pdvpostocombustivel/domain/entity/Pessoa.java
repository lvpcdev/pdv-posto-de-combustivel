package com.br.pdvpostocombustivel.domain.entity;
import com.br.pdvpostocombustivel.enums.TipoPessoa;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "pessoa")
public class Pessoa {



    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo", length = 200, nullable = false)
    private String nomeCompleto;

    @Column(name = "cpf_cnpj", length = 14, nullable = false)
    private String cpfCnpj;

    @Column(name = "numero_ctps", length = 12)
    private Long numeroCtps;

    @Column(name = "data_nascimento", length = 10, nullable = false)
    private LocalDate dataNascimento;

    public Pessoa( String nomeCompleto,
                   String cpfCnpj,
                   Long numeroCtps,
                   LocalDate dataNascimento,
                   TipoPessoa tipoPessoa) {

        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.numeroCtps = numeroCtps;
        this.dataNascimento = dataNascimento;
        this.tipoPessoa = tipoPessoa;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pessoa", length = 15, nullable = false)
    private TipoPessoa tipoPessoa;




    public Pessoa() {

    }



    //getters
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public Long getNumeroCtps() {
        return numeroCtps;
    }
    public Long getId() {
        return id;
    }
    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    //setters
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setNumeroCtps(Long numeroCtps) {
        this.numeroCtps = numeroCtps;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}

package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoAcesso;
import com.br.pdvpostocombustivel.enums.TipoContato;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos

    @Column(length = 14, nullable = false)
    private String telefone;

    @Column (length = 50, nullable = false)
    private String email;

    @Column (length = 100, nullable = false)
    private String endereco;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contato", nullable = false, length = 30)
    private TipoContato tipoContato;


    //construtor
    public Contato() {
    }

    public Contato(String telefone, String email, String endereco, TipoContato tipoContato) {
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.tipoContato = tipoContato;
    }

    //getters
    public Long getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    public String getEndereco() {
        return endereco;
    }
    public TipoContato getTipoContato() {
        return tipoContato;
    }

    //setters
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }
}
package com.br.domain.entity;
import java.math.BigDecimal;
import java.util.Date;

public class Estoque {

    //atributos
    private BigDecimal quantidade;
    private String localTanque;
    private String localEndereco;
    private String loteFabricacao;
    private Date dataValidade;

    //construtor
    public  Estoque(BigDecimal quantidade, String localTanque, String localEndereco, String loteFabricacao,Date dataValidade) {
        this.quantidade = quantidade;
        this.localTanque = localTanque;
        this.localEndereco = localEndereco;
        this.loteFabricacao = loteFabricacao;
        this.dataValidade = dataValidade;
    }

    //getters
    public BigDecimal getQuantidade() {
        return quantidade;
    }
    public String getLocalTanque() {
        return localTanque;
    }
    public String getLocalEndereco() {
        return localEndereco;
    }
    public String getLoteFabricacao() {
        return loteFabricacao;
    }
    public Date getDataValidade(){
        return dataValidade;
    }

    //setters
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
    public void setLocalEndereco(String localEndereco) {
        this.localEndereco = localEndereco;
    }
    public void setLocalTanque(String localTanque) {
        this.localTanque = localTanque;
    }
    public void setLoteFabricacao(String loteFabricacao) {
        this.loteFabricacao = loteFabricacao;
    }
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

}

package br.com.crescer.genesis.models;

import java.util.ArrayList;

/**
 *
 * @author mirela.adam
 */
public class TimeModel {
    private Long id;
    private String nome;
    private String descricao;
    private String descricaoresumida;
    private Character situacao;
    private ArrayList<Long> owners;
    private ArrayList<Long> membros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoresumida() {
        return descricaoresumida;
    }

    public void setDescricaoresumida(String descricaoresumida) {
        this.descricaoresumida = descricaoresumida;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public ArrayList<Long> getOwners() {
        return owners;
    }

    public void setOwners(ArrayList<Long> owners) {
        this.owners = owners;
    }

    public ArrayList<Long> getMembros() {
        return membros;
    }

    public void setMembros(ArrayList<Long> membros) {
        this.membros = membros;
    }
    
    
}

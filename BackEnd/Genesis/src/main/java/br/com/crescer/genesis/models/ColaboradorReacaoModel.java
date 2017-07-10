/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.models;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.ColaboradorTag;

/**
 *
 * @author alana'
 */
public class ColaboradorReacaoModel {

    private Long id;
    private Colaborador colaborador;
    private ColaboradorTag colaboradorTag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public ColaboradorTag getColaboradorTag() {
        return colaboradorTag;
    }

    public void setColaboradorTag(ColaboradorTag colaboradorTag) {
        this.colaboradorTag = colaboradorTag;
    }
    
}

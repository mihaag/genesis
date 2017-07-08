/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.ColaboradorFeito;
import br.com.crescer.genesis.repositorios.ColaboradorFeitoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafa
 */
@Service
public class ColaboradorFeitoService {
    
    @Autowired
    ColaboradorFeitoRepositorio repositorio;    
    
    public List<ColaboradorFeito> buscarTodos(){
        return (List<ColaboradorFeito>) repositorio.findAll();
    }
    
    public void novoColaboradorFeito(ColaboradorFeito colFeito){
        repositorio.save(colFeito);
    }
    
}

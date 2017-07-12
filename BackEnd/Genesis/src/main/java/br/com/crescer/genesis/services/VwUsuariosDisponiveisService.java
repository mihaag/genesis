/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.VwUsuariosDisponiveis;
import br.com.crescer.genesis.repositorios.VwUsuariosDisponiveisRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael.barreto
 */
@Service
public class VwUsuariosDisponiveisService {
    @Autowired
    VwUsuariosDisponiveisRepositorio vwUsuariosDisponiveis;
    
    public Object buscarTodos(){
       return vwUsuariosDisponiveis.findAll();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.ColaboradorFeito;
import br.com.crescer.genesis.entidades.Feito;
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
    @Autowired
    FeitoService feitoService;
    
    public Iterable<ColaboradorFeito> buscarTodos(Colaborador colab){
        String permissaoColaborador = colab.getIdPermissao().getDescricao().toUpperCase();
        if(permissaoColaborador.equals("ADMINISTRADOR"))
            return repositorio.findAll();
        else if (permissaoColaborador.equals("COLABORADOR")){
            List<Feito> feitos = feitoService.buscarPorPermissao(colab.getIdPermissao());
            return repositorio.findAllByIdFeito(feitos);
        }
//            return repositorio.findAllByIdPermissao(colab.getIdPermissao());
        else return null;
    }
    
    public void novoColaboradorFeito(ColaboradorFeito colFeito){
        repositorio.save(colFeito);
    }
    
}

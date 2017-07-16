/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Feito;
import br.com.crescer.genesis.entidades.Permissao;
import br.com.crescer.genesis.repositorios.FeitoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafa
 */
@Service
public class FeitoService {

    @Autowired
    FeitoRepositorio repositorio;

    public List<Feito> buscarTodosFeitos() {
        return (List<Feito>) repositorio.findAll();
    }

    public Feito buscarFeitoPorId(long id) {
        return repositorio.findOneById(id);
    }

    public List<Feito> buscarPorNome(String nome) {
        return (List<Feito>) repositorio.findByNomeIgnoreCase(nome);

    }
    
    public List<Feito> buscarPorPermissao(Permissao permissao){
        return repositorio.findAllByIdPermissao(permissao);
    }
//

    public Feito cadastrarFeito(Feito feito) {
        Feito feitoBanco = repositorio.findTop1ByNomeContainingIgnoreCase(feito.getNome());
        boolean podeSalvar = feitoBanco == null || !feitoBanco.getNome().trim().equals(feito.getNome().trim());

        if (podeSalvar)repositorio.save(feito);

        return feito;
    }

    public Feito atualizarFeito(Feito feito) {
        repositorio.save(feito);
        return feito;
    }

    public Feito removerFeito(Feito feito) {
        repositorio.delete(feito);
        return feito;
    }

}

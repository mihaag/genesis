/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Feito;
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
        return (List<Feito>) repositorio.findByNome(nome);
    }
//

    public String cadastrarFeito(Feito feito) {
        Feito feitoBanco = repositorio.findOneById(feito.getId());
        boolean podeSalvar = (feitoBanco != null) && (feitoBanco.getNome() != feito.getNome());
        final String mensagem = podeSalvar ? "feito cadastrado com sucesso" : "Feito Ja Cadastrado";

        if (podeSalvar) {
            repositorio.save(feito);
            return mensagem;
        } else {
            return (mensagem);
        }
    }

    public String atualizarFeito(Feito feito) {
        final String mensagem = "atualizado com sucesso";
        repositorio.save(feito);
        return mensagem;
    }

    public String removerFeito(Feito feito) {
        final String mensagem = "removido com sucesso";
        repositorio.delete(feito);
        return mensagem;
    }

}

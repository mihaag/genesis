/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.ColaboradorFeito;
import br.com.crescer.genesis.entidades.Feito;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafa
 */
public interface ColaboradorFeitoRepositorio extends CrudRepository<ColaboradorFeito, Long> {
    public Iterable<ColaboradorFeito> findAllByIdFeito(List<Feito> f);
}

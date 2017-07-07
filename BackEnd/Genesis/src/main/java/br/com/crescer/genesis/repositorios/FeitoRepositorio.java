/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.Feito;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafa
 */
public interface FeitoRepositorio extends CrudRepository<Feito, Long> {
    
    public Feito findOneById(long Id);
    
    public Iterable<Feito> findByNome(String nome);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.SolicitacaoTrocatime;
import br.com.crescer.genesis.entidades.Timecwi;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author alana'
 */
public interface SolicitacaoTrocaTimeRepositorio extends CrudRepository<SolicitacaoTrocatime, Long>{
    public List<SolicitacaoTrocatime> findAllByIdNovotime(Timecwi time);
    public Long countByIdNovotime(Timecwi time);
}

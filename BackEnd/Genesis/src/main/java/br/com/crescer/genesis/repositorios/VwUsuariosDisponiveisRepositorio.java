/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.repositorios;

import br.com.crescer.genesis.entidades.VwUsuariosDisponiveis;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author rafael.barreto
 */
public interface VwUsuariosDisponiveisRepositorio extends CrudRepository<VwUsuariosDisponiveis, Long>{
    
  
}

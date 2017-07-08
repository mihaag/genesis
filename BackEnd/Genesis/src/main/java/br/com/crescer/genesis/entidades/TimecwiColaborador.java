/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafael.barreto
 */
@Entity
@Table(name = "TIMECWI_COLABORADOR")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "TimecwiColaborador.findAll", query = "SELECT t FROM TimecwiColaborador t"),
//    @NamedQuery(name = "TimecwiColaborador.findById", query = "SELECT t FROM TimecwiColaborador t WHERE t.id = :id"),
//    @NamedQuery(name = "TimecwiColaborador.findByTipo", query = "SELECT t FROM TimecwiColaborador t WHERE t.tipo = :tipo")})
public class TimecwiColaborador implements Serializable {

  
    private static final long serialVersionUID = 1L;
    private static final String SQ_NAME = " SEQ_TIMECWI_COLABORADOR";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO")
    private Character tipo;
    @JoinColumn(name = "ID_COLABORADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Colaborador idColaborador;
    @JsonIgnore
    @JoinColumn(name = "ID_TIMECWI", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Timecwi idTimecwi;

    public TimecwiColaborador() {
    }

    public TimecwiColaborador(Long id) {
        this.id = id;
    }

    public TimecwiColaborador(Long id, Character tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Timecwi getIdTimecwi() {
        return idTimecwi;
    }

    public void setIdTimecwi(Timecwi idTimecwi) {
        this.idTimecwi = idTimecwi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimecwiColaborador)) {
            return false;
        }
        TimecwiColaborador other = (TimecwiColaborador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.genesis.entidade.TimecwiColaborador[ id=" + id + " ]";
    }

}

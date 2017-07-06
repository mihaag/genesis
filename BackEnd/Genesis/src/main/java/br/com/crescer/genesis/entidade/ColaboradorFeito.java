/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafael.barreto
 */
@Entity
@Table(name = "COLABORADOR_FEITO")
@XmlRootElement
public class ColaboradorFeito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAFEITO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datafeito;
    @Size(max = 200)
    @Column(name = "OBSERVACAO")
    private String observacao;
    @JoinColumn(name = "ID_COLABORADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Colaborador idColaborador;
    @JoinColumn(name = "ID_FEITO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Feito idFeito;

    public ColaboradorFeito() {
    }

    public ColaboradorFeito(Long id) {
        this.id = id;
    }

    public ColaboradorFeito(Long id, Date datafeito) {
        this.id = id;
        this.datafeito = datafeito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatafeito() {
        return datafeito;
    }

    public void setDatafeito(Date datafeito) {
        this.datafeito = datafeito;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Feito getIdFeito() {
        return idFeito;
    }

    public void setIdFeito(Feito idFeito) {
        this.idFeito = idFeito;
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
        if (!(object instanceof ColaboradorFeito)) {
            return false;
        }
        ColaboradorFeito other = (ColaboradorFeito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.genesis.entidade.ColaboradorFeito[ id=" + id + " ]";
    }
    
}

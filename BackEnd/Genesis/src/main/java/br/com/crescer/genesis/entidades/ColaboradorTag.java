/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafael.barreto
 */
@Entity
@Table(name = "COLABORADOR_TAG")
@XmlRootElement
public class ColaboradorTag implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SQ_NAME = "SEQ_COLABORADOR_TAG";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DESCRICAO")
    private String descricao;
    @JoinColumn(name = "ID_COLABORADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Colaborador idColaborador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColaboradortag")
    private Collection<ColaboradorReacaoTag> colaboradorReacaoTagCollection;

    public ColaboradorTag() {
    }

    public ColaboradorTag(Long id) {
        this.id = id;
    }

    public ColaboradorTag(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    @XmlTransient
    public Collection<ColaboradorReacaoTag> getColaboradorReacaoTagCollection() {
        return colaboradorReacaoTagCollection;
    }

    public void setColaboradorReacaoTagCollection(Collection<ColaboradorReacaoTag> colaboradorReacaoTagCollection) {
        this.colaboradorReacaoTagCollection = colaboradorReacaoTagCollection;
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
        if (!(object instanceof ColaboradorTag)) {
            return false;
        }
        ColaboradorTag other = (ColaboradorTag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.genesis.entidade.ColaboradorTag[ id=" + id + " ]";
    }

}

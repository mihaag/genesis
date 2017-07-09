/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TIMECWI")
@XmlRootElement
public class Timecwi implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SQ_NAME = "SEQ_TIMECWI";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Size(max = 100)
    @Column(name = "DESCRICAORESUMIDA")
    private String descricaoresumida;
    @Column(name = "SITUACAO")
    private Character situacao;
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColaborador")
//    private Collection<ColaboradorTag> colaboradorTagCollection;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNovotime")
    private Collection<SolicitacaoTrocatime> solicitacaoTrocatimeCollection;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTimecwi")
    private Collection<TimecwiColaborador> timecwiColaboradorCollection;

    public Timecwi() {
    }

    public Timecwi(Long id) {
        this.id = id;
    }

    public Timecwi(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoresumida() {
        return descricaoresumida;
    }

    public void setDescricaoresumida(String descricaoresumida) {
        this.descricaoresumida = descricaoresumida;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

//    @XmlTransient
//    public Collection<ColaboradorTag> getColaboradorTagCollection() {
//        return colaboradorTagCollection;
//    }
//
//    public void setColaboradorTagCollection(Collection<ColaboradorTag> colaboradorTagCollection) {
//        this.colaboradorTagCollection = colaboradorTagCollection;
//    }

    @XmlTransient
    public Collection<SolicitacaoTrocatime> getSolicitacaoTrocatimeCollection() {
        return solicitacaoTrocatimeCollection;
    }

    public void setSolicitacaoTrocatimeCollection(Collection<SolicitacaoTrocatime> solicitacaoTrocatimeCollection) {
        this.solicitacaoTrocatimeCollection = solicitacaoTrocatimeCollection;
    }

    @XmlTransient
    public Collection<TimecwiColaborador> getTimecwiColaboradorCollection() {
        return timecwiColaboradorCollection;
    }

    public void setTimecwiColaboradorCollection(Collection<TimecwiColaborador> timecwiColaboradorCollection) {
        this.timecwiColaboradorCollection = timecwiColaboradorCollection;
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
        if (!(object instanceof Timecwi)) {
            return false;
        }
        Timecwi other = (Timecwi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.genesis.entidade.Timecwi[ id=" + id + " ]";
    }

}

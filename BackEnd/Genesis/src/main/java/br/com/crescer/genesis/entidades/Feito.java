/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "FEITO")
@XmlRootElement
public class Feito implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SQ_NAME = "SEQ_FEITO";

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
    @Size(min = 1, max = 200)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Size(max = 100)
    @Column(name = "DESCRICAORESUMIDA")
    private String descricaoresumida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "IMAGEM")
    private String imagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RELEVANCIA")
    private short relevancia;
    
    //@JsonProperty(value = "colaboradorCollection")
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFeito")
    private Collection<ColaboradorFeito> colaboradorFeitoCollection;
    @JoinColumn(name = "ID_PERMISSAO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Permissao idPermissao;

    public Feito() {
    }

    public Feito(Long id) {
        this.id = id;
    }

    public Feito(Long id, String nome, String descricao, String imagem, short relevancia) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.relevancia = relevancia;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public short getRelevancia() {
        return relevancia;
    }

    public void setRelevancia(short relevancia) {
        this.relevancia = relevancia;
    }

    @XmlTransient
    public Collection<ColaboradorFeito> getColaboradorFeitoCollection() {
        return colaboradorFeitoCollection;
    }

    public void setColaboradorFeitoCollection(Collection<ColaboradorFeito> colaboradorFeitoCollection) {
        this.colaboradorFeitoCollection = colaboradorFeitoCollection;
    }

    public Permissao getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Permissao idPermissao) {
        this.idPermissao = idPermissao;
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
        if (!(object instanceof Feito)) {
            return false;
        }
        Feito other = (Feito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.genesis.entidade.Feito[ id=" + id + " ]";
    }

}

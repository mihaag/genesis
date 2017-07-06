/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafael.barreto
 */
@Entity
@Table(name = "COLABORADOR_SEGUINDO")
@XmlRootElement
public class ColaboradorSeguindo implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SQ_NAME = "SEQ_COLABORADOR_SEGUINDO";

    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @JoinColumn(name = "ID_SEGUIDOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Colaborador idSeguidor;
    @JoinColumn(name = "ID_SEGUIDO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Colaborador idSeguido;

    public ColaboradorSeguindo() {
    }

    public ColaboradorSeguindo(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colaborador getIdSeguidor() {
        return idSeguidor;
    }

    public void setIdSeguidor(Colaborador idSeguidor) {
        this.idSeguidor = idSeguidor;
    }

    public Colaborador getIdSeguido() {
        return idSeguido;
    }

    public void setIdSeguido(Colaborador idSeguido) {
        this.idSeguido = idSeguido;
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
        if (!(object instanceof ColaboradorSeguindo)) {
            return false;
        }
        ColaboradorSeguindo other = (ColaboradorSeguindo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.genesis.entidade.ColaboradorSeguindo[ id=" + id + " ]";
    }
    
}

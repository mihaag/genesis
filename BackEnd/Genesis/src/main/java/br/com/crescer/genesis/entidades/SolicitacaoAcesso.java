package br.com.crescer.genesis.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mirela.adam
 */
@Entity
@Table(name = "SOLICITACAO_ACESSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitacaoAcesso.findAll", query = "SELECT s FROM SolicitacaoAcesso s"),
    @NamedQuery(name = "SolicitacaoAcesso.findById", query = "SELECT s FROM SolicitacaoAcesso s WHERE s.id = :id"),
    @NamedQuery(name = "SolicitacaoAcesso.findByEmail", query = "SELECT s FROM SolicitacaoAcesso s WHERE s.email = :email")})
public class SolicitacaoAcesso implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SQ_NAME = "SEQ_SOLICITACAO_ACESSO";
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SQ_NAME)
    @SequenceGenerator(name = SQ_NAME, sequenceName = SQ_NAME, allocationSize = 1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;

    public SolicitacaoAcesso() {
    }

    public SolicitacaoAcesso(Long id) {
        this.id = id;
    }

    public SolicitacaoAcesso(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof SolicitacaoAcesso)) {
            return false;
        }
        SolicitacaoAcesso other = (SolicitacaoAcesso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.genesis.entidades.SolicitacaoAcesso[ id=" + id + " ]";
    }
    
}

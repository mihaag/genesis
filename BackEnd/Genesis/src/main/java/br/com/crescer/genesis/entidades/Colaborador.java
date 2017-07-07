package br.com.crescer.genesis.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafael.barreto
 */
@Entity
@Table(name = "COLABORADOR")
@XmlRootElement
public class Colaborador implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SEDE")
    private int sede;

    private static final long serialVersionUID = 1L;
    private static final String SQ_NAME = "SEQ_COLABORADOR";
    
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMECOMPLETO")
    private String nomecompleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nascimento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissao;
    @Column(name = "DEMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date demissao;
    @Size(max = 10)
    @Column(name = "RAMAL")
    private String ramal;
    @Size(max = 10)
    @Column(name = "ANDAR")
    private String andar;
    @Size(max = 10)
    @Column(name = "POSICAO")
    private String posicao;
    @Size(max = 200)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Size(max = 20)
    @Column(name = "DESCRICAORESUMIDA")
    private String descricaoresumida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SITUACAO")
    private Character situacao;
    @Size(max = 200)
    @Column(name = "SENHA")
    private String senha;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeguidor")
    private Collection<ColaboradorSeguindo> colaboradorSeguindoCollection;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeguido")
    private Collection<ColaboradorSeguindo> colaboradorSeguindoCollection1;
    //@JsonIgnore
    @JoinColumn(name = "ID_PERMISSAO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Permissao idPermissao;
   /* @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColaborador")
    private Collection<SolicitacaoAcesso> solicitacaoAcessoCollection; */
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColaborador")
    private Collection<SolicitacaoTrocatime> solicitacaoTrocatimeCollection;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColaborador")
    private Collection<ColaboradorFeito> colaboradorFeitoCollection;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColaborador")
    private Collection<ColaboradorReacaoTag> colaboradorReacaoTagCollection;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColaborador")
    private Collection<TimecwiColaborador> timecwiColaboradorCollection;

    public Colaborador() {
    }

    public Colaborador(Long id) {
        this.id = id;
    }

    public Colaborador(Long id, String email, String nomecompleto, Date nascimento, Date admissao, short sede, Character situacao) {
        this.id = id;
        this.email = email;
        this.nomecompleto = nomecompleto;
        this.nascimento = nascimento;
        this.admissao = admissao;
        this.sede = sede;
        this.situacao = situacao;
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

    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Date getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    public Date getDemissao() {
        return demissao;
    }

    public void setDemissao(Date demissao) {
        this.demissao = demissao;
    }


    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public Collection<ColaboradorSeguindo> getColaboradorSeguindoCollection() {
        return colaboradorSeguindoCollection;
    }

    public void setColaboradorSeguindoCollection(Collection<ColaboradorSeguindo> colaboradorSeguindoCollection) {
        this.colaboradorSeguindoCollection = colaboradorSeguindoCollection;
    }

    @XmlTransient
    public Collection<ColaboradorSeguindo> getColaboradorSeguindoCollection1() {
        return colaboradorSeguindoCollection1;
    }

    public void setColaboradorSeguindoCollection1(Collection<ColaboradorSeguindo> colaboradorSeguindoCollection1) {
        this.colaboradorSeguindoCollection1 = colaboradorSeguindoCollection1;
    }

    public Permissao getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(Permissao idPermissao) {
        this.idPermissao = idPermissao;
    }
/*
    @XmlTransient
    public Collection<SolicitacaoAcesso> getSolicitacaoAcessoCollection() {
        return solicitacaoAcessoCollection;
    }

    public void setSolicitacaoAcessoCollection(Collection<SolicitacaoAcesso> solicitacaoAcessoCollection) {
        this.solicitacaoAcessoCollection = solicitacaoAcessoCollection;
    }
*/
    @XmlTransient
    public Collection<SolicitacaoTrocatime> getSolicitacaoTrocatimeCollection() {
        return solicitacaoTrocatimeCollection;
    }

    public void setSolicitacaoTrocatimeCollection(Collection<SolicitacaoTrocatime> solicitacaoTrocatimeCollection) {
        this.solicitacaoTrocatimeCollection = solicitacaoTrocatimeCollection;
    }

    @XmlTransient
    public Collection<ColaboradorFeito> getColaboradorFeitoCollection() {
        return colaboradorFeitoCollection;
    }

    public void setColaboradorFeitoCollection(Collection<ColaboradorFeito> colaboradorFeitoCollection) {
        this.colaboradorFeitoCollection = colaboradorFeitoCollection;
    }

    @XmlTransient
    public Collection<ColaboradorReacaoTag> getColaboradorReacaoTagCollection() {
        return colaboradorReacaoTagCollection;
    }

    public void setColaboradorReacaoTagCollection(Collection<ColaboradorReacaoTag> colaboradorReacaoTagCollection) {
        this.colaboradorReacaoTagCollection = colaboradorReacaoTagCollection;
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
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.genesis.entidade.Colaborador[ id=" + id + " ]";
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }
    
}

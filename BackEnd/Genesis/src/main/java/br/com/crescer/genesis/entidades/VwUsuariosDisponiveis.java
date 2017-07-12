/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "VW_USUARIOS_DISPONIVEIS")
@XmlRootElement

public class VwUsuariosDisponiveis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_VIEW")
    private BigInteger idView;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigInteger id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissao;
    @Size(max = 10)
    @Column(name = "ANDAR")
    private String andar;
    @Column(name = "DEMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date demissao;
    @Size(max = 200)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Size(max = 20)
    @Column(name = "DESCRICAORESUMIDA")
    private String descricaoresumida;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nascimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMECOMPLETO")
    private String nomecompleto;
    @Size(max = 10)
    @Column(name = "POSICAO")
    private String posicao;
    @Size(max = 10)
    @Column(name = "RAMAL")
    private String ramal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEDE")
    private long sede;
    @Size(max = 200)
    @Column(name = "SENHA")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SITUACAO")
    private Character situacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERMISSAO")
    private BigInteger idPermissao;
    @Size(max = 255)
    @Column(name = "FOTO")
    private String foto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POSSUITIME")
    private Character possuitime;

    public VwUsuariosDisponiveis() {
    }

    public BigInteger getIdView() {
        return idView;
    }

    public void setIdView(BigInteger idView) {
        this.idView = idView;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Date getAdmissao() {
        return admissao;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public Date getDemissao() {
        return demissao;
    }

    public void setDemissao(Date demissao) {
        this.demissao = demissao;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public long getSede() {
        return sede;
    }

    public void setSede(long sede) {
        this.sede = sede;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public BigInteger getIdPermissao() {
        return idPermissao;
    }

    public void setIdPermissao(BigInteger idPermissao) {
        this.idPermissao = idPermissao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Character getPossuitime() {
        return possuitime;
    }

    public void setPossuitime(Character possuitime) {
        this.possuitime = possuitime;
    }
    
}

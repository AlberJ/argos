package br.edu.ifpb.argos.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_INVESTIGACAO")

public class Investigacao {
	
	@Id
	@Column(name = "ID_INVESTIGACAO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
//	@ManyToOne é muito para muitos?
//	@JoinColumn(name = "pessoa")
//	private Pessoa pessoa;
	
	@Column(name="TITULO")
	private String titulo;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA")
	private Date data;
	
	@OneToMany(mappedBy="investigacao")
	private List<Crime> crimes;
	
	@OneToMany(mappedBy="investigacao")
	private List<Fato> fato;
	
	@OneToMany(mappedBy="investigacao")
	private List<Informacao> informacao;
	
	@OneToMany(mappedBy="investigacao")
	private List<Objeto> objeto;
	
	public Investigacao(){ }
	
	public Investigacao(String titulo, String desc, Date data){ 
		this.titulo = titulo;
		this.descricao = desc;
		this.data = data;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date criacao) {
		this.data = criacao;
	}

	public List<Crime> getCrimes() {
		return crimes;
	}

	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}

	public List<Fato> getFato() {
		return fato;
	}

	public void setFato(List<Fato> fato) {
		this.fato = fato;
	}

	public List<Informacao> getInformacao() {
		return informacao;
	}

	public void setInformacao(List<Informacao> informacao) {
		this.informacao = informacao;
	}

	public List<Objeto> getObjeto() {
		return objeto;
	}

	public void setObjeto(List<Objeto> objeto) {
		this.objeto = objeto;
	}

	
	
	
	
}
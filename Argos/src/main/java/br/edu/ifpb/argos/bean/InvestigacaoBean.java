package br.edu.ifpb.argos.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;

import br.edu.ifpb.argos.entity.Investigacao;
import br.edu.ifpb.argos.facade.InvestigacaoController;


@ManagedBean(name = "investigacaoBean")
@ViewScoped
public class InvestigacaoBean extends GenericBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Investigacao investigacao;
	private String titulo;
	private String descricao;
	private Date data;
	private List<InvestigacaoBean> investigacoes;
	private Integer id = null;
	private boolean editando = false;

	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	private String argumento;

	public String salvar() {
		InvestigacaoController controller = new InvestigacaoController();
		String proxView = null;

		if (id != null) {
			investigacao = controller.buscar(id);
			investigacao.setTitulo(titulo);
			investigacao.setDescricao(descricao);
			investigacao.setData(data);
			controller.atualizar(investigacao);
			proxView = "investigacoes?faces-redirect=true";
		} else {
			try {
				investigacao = new Investigacao();
				investigacao.setTitulo(titulo);
				investigacao.setDescricao(descricao);
				investigacao.setData(data);
				
				controller.cadastrar(investigacao);
				this.addSuccessMessage("Investigação salva com sucesso");
				proxView = "investigacoes?faces-redirect=true";
				investigacao = new Investigacao();
			} catch (PersistenceException e) {
				this.addErrorMessage("Erro ao tentar salvar o investigação.");
			}
		}
		return proxView;
	}

	public String editar(Investigacao investigacao) {
		this.titulo = investigacao.getTitulo();
		this.descricao = investigacao.getDescricao();
		this.data = investigacao.getData();
		this.editando = true;
		return "cadastro?faces-redirect=true&includeViewParams=true";
	}

	public String excluir(Investigacao investigacao) {
		String proxima_pagina = null;
		
		InvestigacaoController controller = new InvestigacaoController();
		controller.excluir(investigacao);
		this.addSuccessMessage("Investigação excluída com sucesso.");
		proxima_pagina = "usuarios?faces-redirect=true";
		
		return proxima_pagina;
	}
	
	public List<Investigacao> listarInvestigacoes(){
		InvestigacaoController controller = new InvestigacaoController();
		return controller.listar();
	}

	public String goCadastro() {
		return "/usuario/cadastro?faces-redirect=true";
	}

	public String goUsuarios() {
		return "/usuario/usuarios?faces-redirect=true";
	}

	public Investigacao getInvestigacao() {
		return this.investigacao;
	}

	public void setInvestigacao(Investigacao investigacao) {
		this.investigacao = investigacao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo= titulo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data= data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isEditando() {
		return editando;
	}

	public void setEditando(boolean editando) {
		this.editando = editando;
	}

	public List<InvestigacaoBean> getInvestigacoes() {
		return investigacoes;
	}

	public void setInvestigacoes(List<InvestigacaoBean> investigacoes) {
		this.investigacoes = investigacoes;
	}

	public String getArgumento() {
		return argumento;
	}

	public void setArgumento(String argumento) {
		this.argumento = argumento;
	}

}

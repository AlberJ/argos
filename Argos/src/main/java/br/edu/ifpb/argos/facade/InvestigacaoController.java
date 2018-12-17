package br.edu.ifpb.argos.facade;

import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.edu.ifpb.argos.dao.InvestigacaoDAO;
import br.edu.ifpb.argos.dao.PersistenceUtil;
import br.edu.ifpb.argos.entity.Investigacao;

public class InvestigacaoController {

	public void cadastrar(Investigacao investigacao) {
		InvestigacaoDAO dao = new InvestigacaoDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		dao.insert(investigacao);
		dao.commit();
	}

	public boolean excluir(Investigacao investigacao) {
		boolean excluiu = false;
		InvestigacaoDAO dao = new InvestigacaoDAO();
		try {
			dao.beginTransaction();
			Investigacao i = dao.find(investigacao.getId());
			dao.delete(i);
			dao.commit();
			excluiu = true;
		} catch (PersistenceException e) {
			dao.rollback();
		}
		return excluiu;
	}

	public List<Investigacao> listar() {
		InvestigacaoDAO dao = new InvestigacaoDAO();
		List<Investigacao> investigacoes = dao.findAll();
		return investigacoes;
	}

	public Investigacao buscar(Integer investigacao_id) {
		InvestigacaoDAO dao = new InvestigacaoDAO(PersistenceUtil.getCurrentEntityManager());
		Investigacao investigacao_encontrado = dao.find(investigacao_id);
		return investigacao_encontrado;
	}

	public void atualizar(Investigacao investigacao) {
		InvestigacaoDAO dao = new InvestigacaoDAO(PersistenceUtil.getCurrentEntityManager());
		dao.beginTransaction();
		dao.update(investigacao);
		dao.commit();
	}
}

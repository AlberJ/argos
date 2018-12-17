package br.edu.ifpb.argos.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.argos.entity.Investigacao;

public class InvestigacaoDAO extends GenericDAO<Investigacao, Integer> {
	
	public InvestigacaoDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public InvestigacaoDAO(EntityManager em) {
		super(em);
	}

//	public Investigacao findById(Integer id) {
//		Query q = this.getEntityManager().createQuery("select u from Usuario u where u.matricula = :matricula");
//		q.setParameter("matricula", matricula);
//		Usuario u = null;
//		try {
//			u = (Usuario) q.getSingleResult();
//		}catch (NoResultException e) {		
//		}
//		return u; 
//	}
	
}

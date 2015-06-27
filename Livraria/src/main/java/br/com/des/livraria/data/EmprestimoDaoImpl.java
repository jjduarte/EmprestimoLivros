package br.com.des.livraria.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.des.livraria.model.Emprestimo;

@Repository
@Transactional
public class EmprestimoDaoImpl implements EmprestimoDao{
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("aLivraria-persistence-unit");
	private EntityManager em = emf.createEntityManager();

	@Override
	public Emprestimo findById(int id) {
		return em.find(Emprestimo.class, id);
	}

	@Override
	public List<Emprestimo> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Emprestimo> criteria = cb.createQuery(Emprestimo.class);
		Root<Emprestimo> livro = criteria.from(Emprestimo.class);
		criteria.select(livro);
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public void register(Emprestimo emprestimo) {
		em.persist(emprestimo);
		return;
	}

}

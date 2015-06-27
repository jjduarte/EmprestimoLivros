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

import br.com.des.livraria.model.Livro;

@Repository
@Transactional
public class LivroDaoImpl implements LivroDao{
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("aLivraria-persistence-unit");
	private EntityManager em = emf.createEntityManager();

	@Override
	public Livro findById(int id) {
		return em.find(Livro.class, id);
	}

	@Override
	public Livro findByNome(String nome) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Livro> criteria = cb.createQuery(Livro.class);
		Root<Livro> livro = criteria.from(Livro.class);

		criteria.select(livro).where(cb.equal(livro.get("nome"), nome));
		return em.createQuery(criteria).getSingleResult();
	}

	@Override
	public List<Livro> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Livro> criteria = cb.createQuery(Livro.class);
		Root<Livro> livro = criteria.from(Livro.class);
		criteria.select(livro).orderBy(cb.asc(livro.get("nome")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public void register(Livro livro) {
		em.persist(livro);
		return;
	}

}

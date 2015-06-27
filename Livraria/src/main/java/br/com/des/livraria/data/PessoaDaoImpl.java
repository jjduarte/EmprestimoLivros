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

import br.com.des.livraria.model.Pessoa;

@Repository
@Transactional
public class PessoaDaoImpl implements PessoaDao{
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("aLivraria-persistence-unit");
	private EntityManager em = emf.createEntityManager();

	@Override
	public Pessoa findById(int id) {
		return em.find(Pessoa.class, id);
	}

	@Override
	public Pessoa findByLogin(String cpf) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteria = cb.createQuery(Pessoa.class);
		Root<Pessoa> pessoa = criteria.from(Pessoa.class);

		criteria.select(pessoa).where(cb.equal(pessoa.get("cpf"), cpf));
		return em.createQuery(criteria).getSingleResult();
	}

	@Override
	public List<Pessoa> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pessoa> criteria = cb.createQuery(Pessoa.class);
		Root<Pessoa> pessoa = criteria.from(Pessoa.class);
		criteria.select(pessoa).orderBy(cb.asc(pessoa.get("nome")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public void register(Pessoa pessoa) {
		em.persist(pessoa);
		return;
	}

}

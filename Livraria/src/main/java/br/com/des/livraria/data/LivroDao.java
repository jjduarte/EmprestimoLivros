package br.com.des.livraria.data;

import java.util.List;

import br.com.des.livraria.model.Livro;

public interface LivroDao {
	Livro findById(int id);

	Livro findByNome(String nome);

	List<Livro> findAllOrderedByName();

	void register(Livro livro);
}

package br.com.des.livraria.data;

import java.util.List;

import br.com.des.livraria.model.Pessoa;

public interface PessoaDao {
	Pessoa findById(int id);

	Pessoa findByLogin(String cpf);

	List<Pessoa> findAllOrderedByName();

	void register(Pessoa pessoa);
}

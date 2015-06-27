package br.com.des.livraria.data;

import java.util.List;

import br.com.des.livraria.model.Emprestimo;

public interface EmprestimoDao {
	Emprestimo findById(int id);

	List<Emprestimo> findAll();

	void register(Emprestimo emprestimo);
}

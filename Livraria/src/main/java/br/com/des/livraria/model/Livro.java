package br.com.des.livraria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "livro", schema = "testedsl")
public class Livro implements java.io.Serializable {

	private long idlivro;
	private String nome;
	private String escritor;
	private Short anoedicao;
	private Short classificacao;
	private Set<Emprestimo> emprestimos = new HashSet<Emprestimo>(0);

	public Livro() {
	}

	public Livro(long idlivro) {
		this.idlivro = idlivro;
	}

	public Livro(long idlivro, String nome, String escritor, Short anoedicao, Short classificacao,
			Set<Emprestimo> emprestimos) {
		this.idlivro = idlivro;
		this.nome = nome;
		this.escritor = escritor;
		this.anoedicao = anoedicao;
		this.classificacao = classificacao;
		this.emprestimos = emprestimos;
	}

	@Id
	@Column(name = "idlivro", unique = true, nullable = false)
	public long getIdlivro() {
		return this.idlivro;
	}

	public void setIdlivro(long idlivro) {
		this.idlivro = idlivro;
	}

	@Column(name = "nome", length = 100)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "escritor", length = 100)
	public String getEscritor() {
		return this.escritor;
	}

	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}

	@Column(name = "anoedicao")
	public Short getAnoedicao() {
		return this.anoedicao;
	}

	public void setAnoedicao(Short anoedicao) {
		this.anoedicao = anoedicao;
	}

	@Column(name = "classificacao")
	public Short getClassificacao() {
		return this.classificacao;
	}

	public void setClassificacao(Short classificacao) {
		this.classificacao = classificacao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livro")
	public Set<Emprestimo> getEmprestimos() {
		return this.emprestimos;
	}

	public void setEmprestimos(Set<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

}

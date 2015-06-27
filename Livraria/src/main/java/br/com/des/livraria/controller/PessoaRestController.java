package br.com.des.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.des.livraria.data.PessoaDao;
import br.com.des.livraria.model.Pessoa;

@Controller
@RequestMapping("/rest/members")
public class PessoaRestController {
	@Autowired
	private PessoaDao pessoaDao;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Pessoa> listarTodasPessoas() {
		return pessoaDao.findAllOrderedByName();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Pessoa procurarPessoaPorId(@PathVariable("id") int id) {
		return pessoaDao.findById(id);
	}
}

package br.com.des.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.des.livraria.data.PessoaDao;
import br.com.des.livraria.model.Pessoa;


@Controller
@RequestMapping(value = "/")
public class PessoaController {
	@Autowired
	private PessoaDao pessoaDao;

	@RequestMapping(method = RequestMethod.GET)
	public String mostrarListaPessoas(Model model) {
		model.addAttribute("pessoas", pessoaDao.findAllOrderedByName());
		return "pessoas";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String cadastrarNovaPessoa(@Valid @ModelAttribute("newMember") Pessoa newCustomer, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			try {
				pessoaDao.register(newCustomer);
				return "redirect:/";
			} catch (UnexpectedRollbackException e) {
				model.addAttribute("pessoas", pessoaDao.findAllOrderedByName());
				return "index";
			}
		} else {
			model.addAttribute("pessoas", pessoaDao.findAllOrderedByName());
			return "index";
		}
	}
}

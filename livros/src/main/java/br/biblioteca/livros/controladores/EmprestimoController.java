package br.biblioteca.livros.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Emprestimo;
import br.biblioteca.livros.repository.EmprestimoRepository;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@GetMapping("/list")
	public ModelAndView emprestimos() {

		Iterable<Emprestimo> emprestimos = emprestimoRepository.findAll();
		return new ModelAndView("emprestimos/list", "emprestimos", emprestimos);

	}
	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Emprestimo emprestimo) {
		return "emprestimos/form";
	} 
	
	@PostMapping(params = "form")
	public ModelAndView create(@ModelAttribute("emprestimo") @Valid Emprestimo emprestimo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("emprestimos/form");
		}
		emprestimo = emprestimoRepository.save(emprestimo);
	   	 return new ModelAndView("redirect:/emprestimos/list");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		Emprestimo emprestimo = this.emprestimoRepository.findOne(id);
		return new ModelAndView("emprestimos/form", "emprestimo", emprestimo);
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Emprestimo emprestimo = this.emprestimoRepository.findOne(id);
		this.emprestimoRepository.delete(emprestimo);
		return new ModelAndView("redirect:/emprestimos/list");
	}
}

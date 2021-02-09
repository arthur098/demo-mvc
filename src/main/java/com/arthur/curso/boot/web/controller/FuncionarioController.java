package com.arthur.curso.boot.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arthur.curso.boot.domain.Cargo;
import com.arthur.curso.boot.domain.Funcionario;
import com.arthur.curso.boot.domain.UF;
import com.arthur.curso.boot.service.CargoService;
import com.arthur.curso.boot.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	@Autowired
	private CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Funcionario> fs = this.service.buscarTodos();
		model.addAttribute("funcionarios", fs);
		return "/funcionario/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors())
			return "/funcionario/cadastro";
		
		this.service.salvar(funcionario);

		attr.addFlashAttribute("success", "Funcionário salvo com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", this.service.buscarPorId(id));
		return "/funcionario/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors())
			return "/funcionario/cadastro";
		
		this.service.editar(funcionario);
		attr.addFlashAttribute("success", "Funcionário editado com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		this.service.excluir(id);
		model.addAttribute("success", "Funcionário excluído com sucesso.");
		return this.listar(model);
	}

	@GetMapping("/buscar/nome")
	public String buscarPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("funcionarios", this.service.buscarPorNome(nome));
		return "/funcionario/lista";
	}

	@GetMapping("/buscar/cargo")
	public String buscarPorCargo(@RequestParam("cargo") Long cargo, ModelMap model) {
		model.addAttribute("funcionarios", this.service.buscarPorCargo(cargo));
		return "/funcionario/lista";
	}

	@GetMapping("/buscar/data")
	public String buscarPorData(@RequestParam("entrada") @DateTimeFormat(iso = ISO.DATE) LocalDate entrada,
								@RequestParam("saida") @DateTimeFormat(iso = ISO.DATE) LocalDate saida,
								ModelMap model) {
		model.addAttribute("funcionarios", this.service.buscarPorData(entrada, saida));
		return "/funcionario/lista";
	}

	@ModelAttribute("cargos")
	public List<Cargo> listarCargos() {
		return this.cargoService.buscarTodos();
	}

	@ModelAttribute("ufs")
	public UF[] listarUfs() {
		return UF.values();
	}
}

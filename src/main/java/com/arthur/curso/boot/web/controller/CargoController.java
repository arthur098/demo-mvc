package com.arthur.curso.boot.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.arthur.curso.boot.domain.Departamento;
import com.arthur.curso.boot.service.CargoService;
import com.arthur.curso.boot.service.DepartamentoService;
import com.arthur.curso.boot.util.PaginationUtil;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService service;

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}

	@GetMapping("/listar")
	public String listar(@RequestParam("page") Optional<Integer> pagina,
						 @RequestParam("maxResults") Optional<Integer> maxResults,
						 @RequestParam("nome") Optional<String> nome,
						 ModelMap model) {
		PaginationUtil<Cargo> cargos;
		int valorPagina = 1;
		int valorMaxResults = 5;
		if(pagina.isPresent()) {
			valorPagina = pagina.get();
		}
		
		if(maxResults.isPresent()) {
			valorMaxResults = maxResults.get();
		}
		if(nome.isPresent() && !nome.get().isEmpty()) {
			cargos = this.service.buscarCargoPaginadoPorNome(valorPagina, valorMaxResults, nome.get());
		} else {
			cargos = this.service.buscarCargoPaginado(valorPagina, valorMaxResults);
		}
		
		model.addAttribute("pageCargo", cargos);
		return "/cargo/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors())
			return "/cargo/cadastro";

		this.service.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/cargos/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", this.service.buscarPorId(id));
		return "/cargo/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors())
			return "/cargo/cadastro";

		this.service.editar(cargo);
		attr.addFlashAttribute("success", "Cargo editado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (this.service.cargoTemFuncionario(id)) {
			model.addAttribute("fail", "Cargo não excluído. Tem funcionário(s) vinculado(s).");
		} else {
			this.service.excluir(id);
			model.addAttribute("success", "Cargo excluído com sucesso.");
		}

		return "redirect:/cargos/listar";
	}

	@ModelAttribute("departamentos")
	public List<Departamento> listarDepartamentos() {
		return this.departamentoService.buscarTodos();
	}
}

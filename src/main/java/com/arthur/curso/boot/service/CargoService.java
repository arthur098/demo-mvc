package com.arthur.curso.boot.service;

import java.util.List;

import com.arthur.curso.boot.domain.Cargo;
import com.arthur.curso.boot.util.PaginationUtil;

public interface CargoService {

	void salvar(Cargo cargo);

	void editar(Cargo cargo);

	void excluir(Long id);

	Cargo buscarPorId(Long id);

	List<Cargo> buscarTodos();

	boolean cargoTemFuncionario(Long id);
	
	PaginationUtil<Cargo> buscarCargoPaginado(int pagina, int tamanho);
	
	PaginationUtil<Cargo> buscarCargoPaginadoPorNome(int pagina, int tamanho, String nome);
}

package com.arthur.curso.boot.dao;

import java.time.LocalDate;
import java.util.List;

import com.arthur.curso.boot.domain.Funcionario;

public interface FuncionarioDao {

void save(Funcionario departamento);
	
	void update(Funcionario funcionario);
	
	void delete(Long id);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();

	List<Funcionario> buscarPorNome(String nome);

	List<Funcionario> buscarPorCargo(Long id);

	List<Funcionario> buscarPorDataEntradaSaida(LocalDate entrada, LocalDate saida);

	List<Funcionario> buscarPorDataEntrada(LocalDate entrada);

	List<Funcionario> buscarPorDataSaida(LocalDate saida);
}

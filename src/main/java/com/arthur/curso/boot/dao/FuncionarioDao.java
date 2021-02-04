package com.arthur.curso.boot.dao;

import java.util.List;

import com.arthur.curso.boot.domain.Funcionario;

public interface FuncionarioDao {

void save(Funcionario departamento);
	
	void update(Funcionario funcionario);
	
	void delete(Long id);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();
}

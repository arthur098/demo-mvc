package com.arthur.curso.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arthur.curso.boot.dao.FuncionarioDao;
import com.arthur.curso.boot.domain.Funcionario;
import com.arthur.curso.boot.service.FuncionarioService;

@Service
@Transactional(readOnly = true)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Funcionario funcionario) {
		this.dao.save(funcionario);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Funcionario funcionario) {
		this.dao.update(funcionario);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		this.dao.delete(id);
	}

	@Override
	public Funcionario buscarPorId(Long id) {
		return this.dao.findById(id);
	}

	@Override
	public List<Funcionario> buscarTodos() {
		return this.dao.findAll();
	}

}

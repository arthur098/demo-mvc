package com.arthur.curso.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arthur.curso.boot.dao.DepartamentoDao;
import com.arthur.curso.boot.domain.Departamento;
import com.arthur.curso.boot.service.DepartamentoService;

@Service
@Transactional(readOnly = true)
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Departamento departamento) {
		this.dao.save(departamento);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Departamento departamento) {
		this.dao.update(departamento);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		this.dao.delete(id);
	}

	@Override
	public Departamento buscarPorId(Long id) {
		return this.dao.findById(id);
	}

	@Override
	public List<Departamento> buscarTodos() {
		return this.dao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		return this.dao.findById(id).getCargos().size() > 0;
	}
}

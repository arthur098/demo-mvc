package com.arthur.curso.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arthur.curso.boot.dao.CargoDao;
import com.arthur.curso.boot.domain.Cargo;
import com.arthur.curso.boot.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void salvar(Cargo cargo) {
		this.dao.save(cargo);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Cargo cargo) {
		this.dao.update(cargo);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		this.dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Cargo buscarPorId(Long id) {
		return this.dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cargo> buscarTodos() {
		return this.dao.findAll();
	}

}

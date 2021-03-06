package com.arthur.curso.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arthur.curso.boot.dao.CargoDao;
import com.arthur.curso.boot.domain.Cargo;
import com.arthur.curso.boot.service.CargoService;
import com.arthur.curso.boot.util.PaginationUtil;

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

	@Override
	public boolean cargoTemFuncionario(Long id) {
		return this.buscarPorId(id).getFuncionarios().size() > 0;
	}

	@Override
	public PaginationUtil<Cargo> buscarCargoPaginado(int pagina, int tamanho) {
		return this.dao.buscaPaginada(pagina, tamanho);
	}

	@Override
	public PaginationUtil<Cargo> buscarCargoPaginadoPorNome(int pagina, int tamanho, String nome) {
		return this.dao.buscaPaginadaPorNome(pagina, nome, tamanho);
	}

}

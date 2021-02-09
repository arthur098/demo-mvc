package com.arthur.curso.boot.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.arthur.curso.boot.dao.AbstractDao;
import com.arthur.curso.boot.dao.FuncionarioDao;
import com.arthur.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	@Override
	public List<Funcionario> buscarPorNome(String nome) {
		String hql = "FROM Funcionario f WHERE f.nome like concat('%', ?1, '%')";
		return this.createQuery(hql, nome);
	}

	@Override
	public List<Funcionario> buscarPorCargo(Long id) {
		String hql = "FROM Funcionario f WHERE f.cargo.id = ?1";
		return this.createQuery(hql, id);
	}

	@Override
	public List<Funcionario> buscarPorDataEntradaSaida(LocalDate entrada, LocalDate saida) {
		String hql = "FROM Funcionario f WHERE f.dataEntrada >= ?1 AND f.dataSaida <= ?2";
		return createQuery(hql, entrada, saida);
	}

	@Override
	public List<Funcionario> buscarPorDataEntrada(LocalDate entrada) {
		String hql = "FROM Funcionario f WHERE f.dataEntrada >= ?1";
		return createQuery(hql, entrada);
	}

	@Override
	public List<Funcionario> buscarPorDataSaida(LocalDate saida) {
		String hql = "FROM Funcionario f WHERE f.dataSaida <= ?2";
		return createQuery(hql, saida);
	}
}

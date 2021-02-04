package com.arthur.curso.boot.dao.impl;

import org.springframework.stereotype.Repository;

import com.arthur.curso.boot.dao.AbstractDao;
import com.arthur.curso.boot.dao.DepartamentoDao;
import com.arthur.curso.boot.domain.Departamento;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao {
	
}

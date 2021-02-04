package com.arthur.curso.boot.dao.impl;

import org.springframework.stereotype.Repository;

import com.arthur.curso.boot.dao.AbstractDao;
import com.arthur.curso.boot.dao.FuncionarioDao;
import com.arthur.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}

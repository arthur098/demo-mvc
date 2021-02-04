package com.arthur.curso.boot.dao.impl;

import org.springframework.stereotype.Repository;

import com.arthur.curso.boot.dao.AbstractDao;
import com.arthur.curso.boot.dao.CargoDao;
import com.arthur.curso.boot.domain.Cargo;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

}

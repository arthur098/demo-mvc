package com.arthur.curso.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {

	@Column(name="nome", nullable = false, unique = true, length=60)
	private String name;
	
	@OneToMany(mappedBy="departamento")
	private List<Cargo> cargos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
}

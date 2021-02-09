package com.arthur.curso.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.arthur.curso.boot.domain.Departamento;
import com.arthur.curso.boot.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService departamentoService;
	
	@Override
	public Departamento convert(String source) {
		if(source.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(source);
		return this.departamentoService.buscarPorId(id);
	}

}

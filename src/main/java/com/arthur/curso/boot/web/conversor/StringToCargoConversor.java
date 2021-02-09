package com.arthur.curso.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.arthur.curso.boot.domain.Cargo;
import com.arthur.curso.boot.service.CargoService;

@Component
public class StringToCargoConversor implements Converter<String, Cargo> {

	@Autowired
	private CargoService service;
	
	@Override
	public Cargo convert(String source) {
		if(source.isEmpty())
			return null;
		
		return this.service.buscarPorId(Long.valueOf(source));
	}
}

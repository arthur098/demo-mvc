package com.arthur.curso.boot.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToIntegerConverter implements Converter<String, Integer> {

	@Override
	public Integer convert(String source) {
		
		if(source.matches("\\D")) {
			source = source.replaceAll("\\D", "");
		}
		
		return Integer.valueOf(source);
	}

}

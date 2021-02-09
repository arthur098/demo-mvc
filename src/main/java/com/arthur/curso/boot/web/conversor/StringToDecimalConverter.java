package com.arthur.curso.boot.web.conversor;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDecimalConverter implements Converter<String, BigDecimal> {

	@Override
	public BigDecimal convert(String source) {
		
		if(source.isEmpty()) {
			return null;
		}
		
		NumberFormat format = NumberFormat.getNumberInstance(new Locale("pt","BR"));
		if (format instanceof DecimalFormat) {
	        ((DecimalFormat) format).setParseBigDecimal(true);
	    }
	    try {
	    	BigDecimal b = (BigDecimal) format.parse(source.replaceAll("[^\\d.,]",""));
			return b;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

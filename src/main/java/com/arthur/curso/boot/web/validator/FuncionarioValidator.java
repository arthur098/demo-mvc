package com.arthur.curso.boot.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.arthur.curso.boot.domain.Funcionario;

public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Funcionario f = (Funcionario) target;
		
		LocalDate dataEntrada = f.getDataEntrada();
		
		if(f.getDataSaida() != null) {
			if(f.getDataSaida().isBefore(dataEntrada)) {
				errors.reject("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
			}			
		}
	}

}

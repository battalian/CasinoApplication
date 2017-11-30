package com.nagarro.CasinoAdmin.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<NameChecker, String> {

	@Override
	public void initialize(NameChecker arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		System.out.println("in validator" + arg0);
		String name = arg0.trim();
		if(name.length() ==0 || name==" " || name =="")
			return false;
		else 
			return name.matches(".*\\d+.*"); 
	}

	

}

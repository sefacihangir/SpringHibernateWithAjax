package spring.model;

import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

public class TestValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Article.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
		
	}

}

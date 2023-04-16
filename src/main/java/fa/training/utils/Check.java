package fa.training.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Check {
	public static <T> void isValid(T obj) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> violations = validator.validate(obj);
		
		if(violations.size() > 0) {
			for(ConstraintViolation<T> violation : violations) {
				System.out.println("["+violation.getInvalidValue() +"]"+ " : " + violation.getMessage());
			}
		}else {
			System.out.println("valid object");
		}
	}
}

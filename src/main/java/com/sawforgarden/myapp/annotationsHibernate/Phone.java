package com.sawforgarden.myapp.annotationsHibernate;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=CourseCodeCOnstraintValidator.class)
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Phone {

	
	//define default course code
	public String value() default "Phone";
	
	//define default message
	public String message() default "Неправильный телефон. Пример правильных номеров телефона: 1234567890. (055) 4477284";
	
	//define default groups
	public Class<?>[] groups() default{};
	
	//define default payload
	public Class<? extends Payload>[] payload() default{};
	
	
	
	
}

package com.sawforgarden.myapp.annotationsHibernate;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=PasswordCanNotContainSemicolonClass.class)
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface PasswordCanNotContainSemicolon {

	
	//define default course code
	public String value() default "";
	
	//define default message
	public String message() default "Пароль не может содержать точку с запятой";
	
	//define default groups
	public Class<?>[] groups() default{};
	
	//define default payload
	public Class<? extends Payload>[] payload() default{};
	
	
	
	
}

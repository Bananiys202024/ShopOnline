package com.sawforgarden.myapp.annotationsHibernate;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
//import static java.lang.annotation.RetentionPolicy.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Target({TYPE, ANNOTATION_TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy=ClassForAnnotationPasswordValidator.class)
@Documented
public @interface ValidPassword {
	
	//define default message
	public String message() default "Пароли не соответствуют";
	
	//define default groups
	public Class<?>[] groups() default{};
//	
	//define default payload
	public Class<? extends Payload>[] payload() default{};
		
	//define default course code
	public String value() default "confirmpassword";
	
	
	
	
	
	

//	public String[] passwords();
//	
//	
	 /**
     * @return The first field
     */
    String first();

    /**
     * @return The second field
     */
    String second();

    /**
     * Defines several <code>@FieldMatch</code> annotations on the same element
     *
     * @see FieldMatch
     */
    @Target({TYPE, ANNOTATION_TYPE, FIELD})
    @Retention(RUNTIME)
    @Documented
            @interface List
    {
    	ValidPassword[] value();
    }
	
}

package com.sawforgarden.myapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sawforgarden.myapp.model.CommentInfo;

public class EditCommentInfoValidator  implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CommentInfo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		CommentInfo commentinfo = (CommentInfo) target;
	
//		NotEmpty.editcomment.title
//		NotEmpty.editcomment.commentText
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "Заголовок не может быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "commentText", "Комментарий не может быть пустым");

		
		if(commentinfo.getTitle().length()>60) {
			errors.rejectValue("title", "emptyValue", new Object[]{"'title'"}, "Максимальная длина: 60 символов");
		}
		
		if(commentinfo.getCommentText().length()>2000) {
			errors.rejectValue("commentText", "overflowValue", new Object[]{"'title'"}, "Максимальное количество символов: 2_000");
		}
		
	}

}

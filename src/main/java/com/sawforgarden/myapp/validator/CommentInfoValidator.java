package com.sawforgarden.myapp.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sawforgarden.myapp.model.CommentInfo;

public class CommentInfoValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return CommentInfo.class.equals(paramClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CommentInfo commentinfo = (CommentInfo) target;
		
		
		if(commentinfo.getTitle()==null || commentinfo.getTitle().equals("")) {
		errors.rejectValue("title", "emptyValue", new Object[]{"'title'"}, "Заголовок не может быть пустым");
		}
		
		if(commentinfo.getTitle().length()>60) {
			errors.rejectValue("title", "emptyValue", new Object[]{"'title'"}, "Максимальная длина заголовка: 60 символов");
		}
		
		if(commentinfo.getRating()==0) {
		errors.rejectValue("rating", "emptyValue", new Object[]{"'rating'"}, "Рейтинг не может быть пустым");
		}
		
		if(commentinfo.getCommentText()==null || commentinfo.getCommentText().equals("")) {
		errors.rejectValue("commentText", "emptyValue", new Object[]{"'commentText'"}, "Поле для коментария не может быть пустым");
		}
		
		if(commentinfo.getRecommend()==null || commentinfo.getRecommend().equals("") ) {
		errors.rejectValue("Recommend", "emptyValue", new Object[]{"'Recommend'"}, "Необходимо выбрать рекомендацию");
		}
		
		
		
	}

}

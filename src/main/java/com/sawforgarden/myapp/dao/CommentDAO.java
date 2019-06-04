package com.sawforgarden.myapp.dao;

import org.springframework.stereotype.Repository;

import com.sawforgarden.myapp.entity.Comment;
import com.sawforgarden.myapp.model.CommentInfo;
import com.sawforgarden.myapp.model.PaginationResult;

@Repository
public interface CommentDAO {

	public CommentInfo queryCommentsByProduct_Id(String code);

	Comment findProduct(String code);

	void saveComment(CommentInfo commentinfo, String code);

	public CommentInfo findCommentInfo(String code);

	PaginationResult<CommentInfo> queryComments(int page, int maxResult, int maxNavigationPage, String likeName,
			String TransitedTypeOfSorting, String code);

	public void deleteComment(String code);

	Comment findComment(String id);

	public Object queryComments(String code);

	public void updateComment(CommentInfo commentinfo);
	
	
}

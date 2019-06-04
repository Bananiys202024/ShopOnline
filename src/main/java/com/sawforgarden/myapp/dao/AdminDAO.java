package com.sawforgarden.myapp.dao;

import org.springframework.stereotype.Repository;

import com.sawforgarden.myapp.entity.Admin;
import com.sawforgarden.myapp.entity.Comment;
import com.sawforgarden.myapp.model.AdminInfo;

@Repository
public interface AdminDAO  {

	public Admin queryCompanyData();

//	public String quaryCompanyEmail();

	Admin findThatOneLine(Long id);

	public void setCompanyData(AdminInfo admininfo);

}

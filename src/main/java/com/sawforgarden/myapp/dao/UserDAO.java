package com.sawforgarden.myapp.dao;

import org.springframework.stereotype.Repository;

import com.sawforgarden.myapp.entity.Product;
import com.sawforgarden.myapp.entity.USERS;
import com.sawforgarden.myapp.model.RegisterInfo;

@Repository
public interface UserDAO {

	void saveRegisteredDataUsers(RegisterInfo registerinfo);

	void saveRegisteredDataUserRoles(RegisterInfo registerinfo);

	String CheckIfemailExistsInDataBase(String passedEmail);

	USERS findEmail(String passedEmail);

	String CheckIfphoneExistsInDataBase(String phone);

	USERS findPhone(String passedPhone);

}

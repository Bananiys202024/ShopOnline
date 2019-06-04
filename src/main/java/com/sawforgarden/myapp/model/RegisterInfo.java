package com.sawforgarden.myapp.model;


import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import org.springframework.transaction.annotation.Transactional;

import com.sawforgarden.myapp.annotationsHibernate.AdminIsUniqueNameAndUnrepeatable;
import com.sawforgarden.myapp.annotationsHibernate.PasswordCanNotContainSemicolon;
import com.sawforgarden.myapp.annotationsHibernate.Phone;
import com.sawforgarden.myapp.annotationsHibernate.ValidPassword;
import com.sawforgarden.myapp.annotationsHibernate.ValidPassword.List;


@Transactional
@ValidPassword.List({	
	
	@ValidPassword(
//			propertyPath = "confirmpassword",
			first = "password",
			second = "confirmpassword",
		    message = "Пароли не совпадают" 
		    )
})
public class RegisterInfo {

	 private String codeRecieved;

	 @Size(min=4,max=30,message = "Максимальный размер 30 символов, \n "
	 		+ "минимальный размер 4 символа")
	 @NotBlank(message = "Необходимо имя")
	 @AdminIsUniqueNameAndUnrepeatable
	 private String name;
	 
	
	 
	
	 @Size(min=8,max=100,message="Максимальный размер 30 символов,"
	 		+ " минимальный размер 8 символа")
	 private String confirmpassword;
	
	 
	 @Size(min=8,max=100,message="Максимальный размер 30 символов, "
		 		+ "минимальный размер 8 символа")
		 @NotBlank(message = "Пароль необходим")
	 @PasswordCanNotContainSemicolon
		 private String password;
		 
	 
	 @Email(message = "Здесь должен быть емайл похожий на следующий: ******@gmail.com")
	 @NotBlank(message = "Емайл нужен")
	 private String email;
	 
	 @Phone
//	 @ThatPhoneExistsInDataBaseOrNot
	 private String phone;
	 	 
	 private String maxValueColumnRoleIdOfUSER_ROLESTABLE;
	 private boolean newProduct=false;
	 


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isNewProduct() {
		return newProduct;
	}


	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
	}


	public String getCodeRecieved() {
		return codeRecieved;
	}


	public void setCodeRecieved(String codeRecieved) {
		this.codeRecieved = codeRecieved;
	}


	public String getMaxValueColumnRoleIdOfUSER_ROLESTABLE() {
		return maxValueColumnRoleIdOfUSER_ROLESTABLE;
	}


	public void setMaxValueColumnRoleIdOfUSER_ROLESTABLE(String maxValueColumnRoleIdOfUSER_ROLESTABLE) {
		this.maxValueColumnRoleIdOfUSER_ROLESTABLE = maxValueColumnRoleIdOfUSER_ROLESTABLE;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	 
	 public String getConfirmpassword() {
		return confirmpassword;
	}


	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}


}

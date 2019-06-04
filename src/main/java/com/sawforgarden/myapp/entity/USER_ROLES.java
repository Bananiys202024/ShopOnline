package com.sawforgarden.myapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USER_ROLES",
uniqueConstraints = {
		@UniqueConstraint(
				columnNames = {"email", "username","user_role"}
				)
		}
)

public class USER_ROLES implements Serializable {

	    private static final long serialVersionUID = -2054386655979281969L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ROLE_ID", columnDefinition = "INT(10)", nullable = false)
	    private String role_id;
	    
	    @Column(name = "USERNAME", length = 36, nullable = false)
	    private String username;
	    
	    @Column(name = "USER_ROLE", length = 30, nullable = false)
	    private String user_role;
	    
	    @Column(name = "EMAIL", length = 36, nullable = false)
	    private String email;
	    
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole_id() {
			return String.valueOf(role_id);
		}
	    
		public void setRole_id(String role_id) {
			this.role_id = role_id;
		}
		
	    
		public String getUsername() {
			return username;
		}
	    
		public void setUsername(String username) {
			this.username = username;
		}
		
	   
		public String getUSER_ROLE() {
			return user_role;
		}
	    
		public void setUSER_ROLE(String user_role) {
			this.user_role = user_role;
		}
	     
}

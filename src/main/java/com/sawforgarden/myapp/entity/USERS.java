package com.sawforgarden.myapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class USERS implements Serializable {

	    private static final long serialVersionUID = -2054386655979281969L;
	 
	    
	    @Column(name = "USERNAME", length = 100, nullable = false)
	    private String userName;
	    
	    @Column(name = "PASSWORD", length = 36, nullable = false)
	    private String password;
	    
	    @Id
	    @Column(name = "EMAIL", length = 100, nullable = false)
	    private String email;
	    
	    @Column(name = "PHONE", length = 36, nullable = false)
	    private String phone;
	    
	    @Column(name = "ENABLED", columnDefinition = "smallint default 1", nullable = false)
	    private String enabled;    
	    
	    public String getUserName() {
	        return userName;
	    }
	 
	    public void setUserName(String userName) {
	        this.userName = userName;
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
	    
		public String getEnabled() {
			return enabled;
		}

		public void setEnabled(String enabled) {
			this.enabled = enabled;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

	
}

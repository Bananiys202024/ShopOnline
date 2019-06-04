package com.sawforgarden.myapp.impl;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sawforgarden.myapp.dao.UserDAO;
import com.sawforgarden.myapp.entity.Product;
import com.sawforgarden.myapp.entity.USERS;
import com.sawforgarden.myapp.entity.USER_ROLES;
import com.sawforgarden.myapp.model.ProductInfo;
import com.sawforgarden.myapp.model.RegisterInfo;

@Transactional
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = Logger
			.getLogger(UserDAOImpl.class);
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public void saveRegisteredDataUsers(RegisterInfo registerinfo) {

		 USERS users = new USERS();
		
		 users.setEmail(registerinfo.getEmail().trim());
		 users.setUserName(registerinfo.getName().trim());
		 users.setPassword(registerinfo.getPassword().trim());
		 users.setPhone(registerinfo.getPhone().trim());
		 users.setEnabled("1");

	     this.sessionFactory.getCurrentSession().persist(users);
	     this.sessionFactory.getCurrentSession().flush();

	}

	
	@Override
	public void saveRegisteredDataUserRoles(RegisterInfo registerinfo) {
		
		 int forRole_id = Integer.parseInt(registerinfo.getMaxValueColumnRoleIdOfUSER_ROLESTABLE())+1;
		
		 USER_ROLES user_roles = new USER_ROLES();
	
		 user_roles.setUsername(registerinfo.getName().trim());
		 user_roles.setUSER_ROLE("USER");
		 user_roles.setRole_id(String.valueOf(forRole_id).trim());
		 user_roles.setEmail(String.valueOf(registerinfo.getEmail().trim()));

	     this.sessionFactory.getCurrentSession().merge(user_roles);
	     this.sessionFactory.getCurrentSession().flush();

	}

	
	@Override
	public String CheckIfemailExistsInDataBase(String passedEmail) {
	 
		boolean result=true;
		
		USERS users = this.findEmail(passedEmail);
        if (users == null) {
            result=false;
        }
        
		return ""+result;
	}
	
	@Override
	public String CheckIfphoneExistsInDataBase(String passedPhone) {
	 
		boolean result=true;
		
		USERS users = this.findPhone(passedPhone);
        if (users == null) {
            result=false;
        }
        
		return ""+result;
	}
	
	
	  @Override
	    public USERS findEmail(String passedEmail) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(USERS.class);
	        crit.add(Restrictions.eq("email", passedEmail));
	        return (USERS) crit.uniqueResult();
	    }
	  
	  @Override
	    public USERS findPhone(String passedPhone) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(USERS.class);
	        crit.add(Restrictions.eq("phone", passedPhone));
	        return (USERS) crit.uniqueResult();
	    }



	
	
	
	
	
	
}

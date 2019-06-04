package com.sawforgarden.myapp.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sawforgarden.myapp.dao.AdminDAO;
import com.sawforgarden.myapp.entity.Admin;
import com.sawforgarden.myapp.entity.Comment;
import com.sawforgarden.myapp.model.AdminInfo;

@Transactional
public class AdminDAOImpl implements AdminDAO {

	 @Autowired
	    private SessionFactory sessionFactory;
	
	 
	 @Override
	    public Admin findThatOneLine(Long id) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(Admin.class);
	        crit.add(Restrictions.eq("id", id));
	        return (Admin) crit.uniqueResult();
	    }
	 
	@Override
	public Admin queryCompanyData() {
		return findThatOneLine(1L);
	}

	@Override
	public void setCompanyData(AdminInfo admininfo) {
		Session session = sessionFactory.getCurrentSession();
		 
		Admin admin = findThatOneLine(1L);
		admin.setPhone(admininfo.getPhoneAdmin());
		admin.setEmail(admininfo.getEmailAdmin());
		
		session.saveOrUpdate(admin); 
		
	}


}

package com.synixia.projectbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.synixia.projectbackend.dao.UserDAO;
import com.synixia.projectbackend.dto.User;

/**
 * 
 * @author saddam
 *
 */
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean register(User user) {
		
		try{
			
			sessionFactory.getCurrentSession().persist(user);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
	
	

	@Override
	public List<User> list() {
		
			return sessionFactory
					.getCurrentSession()
						.createQuery("FROM User" , User.class)
							.getResultList();
		
	}




}
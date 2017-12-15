package com.synixia.projectbackend.dao;

import java.util.List;

import com.synixia.projectbackend.dto.User;


/**
 * 
 * @author saddam
 *
 */

public interface UserDAO {

	boolean register(User user);

	// List of product
	List<User> list();

	
}

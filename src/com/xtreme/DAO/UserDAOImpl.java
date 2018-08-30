package com.xtreme.DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xtreme.user.hibernate.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findUserByUsername(String username) {
		List<User> users = new ArrayList<User>();
		users=sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username).list();
		if(users.size()>0)
			return users.get(0);
			else
		return null;
	}
	
}

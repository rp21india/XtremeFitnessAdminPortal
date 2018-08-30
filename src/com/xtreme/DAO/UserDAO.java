package com.xtreme.DAO;

import com.xtreme.user.hibernate.User;

public interface UserDAO {
	User findUserByUsername(String username);

}

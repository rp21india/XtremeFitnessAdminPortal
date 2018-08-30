package com.xtremeService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xtreme.DAO.UserDAO;
import com.xtreme.user.hibernate.UserRole;

@Service("userDetailsService")
public class xtremeUserService implements UserDetailsService{
	@Autowired
	private UserDAO userDao;

	@Transactional(readOnly = true)	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.xtreme.user.hibernate.User  user = userDao.findUserByUsername(username);
		
	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	for(UserRole userRole : user.getUserRole()){
		authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
	}
	return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true,true,true,authorities);
	}

	
	
	

}

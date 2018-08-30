package com.xtreme.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecuritConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder)throws Exception{
		System.out.println("********configGlobal************");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/admin**").access("hasRole('ROLEADMIN')")
		.antMatchers("/emp**").access("hasAnyRole('ROLE_ADMIN','ROLE_EMP')")
		.and()
		.formLogin().loginPage("/login")
		.usernameParameter("usename")
		.passwordParameter("password")
		.defaultSuccessUrl("/index.jsp")
		.failureUrl("/login?error")
		.and()
		.logout()
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/login?logout")
		.and()
		.csrf()
		.and()
		.exceptionHandling().accessDeniedPage("/invalid-access.jsp");
	}

}

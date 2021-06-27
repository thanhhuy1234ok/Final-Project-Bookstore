package com.bookstore.client.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.bookstore.client.handlers.OnAuthenticationSuccessHandler;
import com.bookstore.client.services.CustomerOAuth2Service;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomerOAuth2Service customerOAuth2Servive;
	
	@Autowired
	private OnAuthenticationSuccessHandler onAuthenticationSuccess;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/register", "/assets/**", "/css/**", "/fonts/**", "/images/**", "/js/**", "/vendor/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.usernameParameter("email")
		.passwordParameter("password")
		.loginProcessingUrl("/do_login")
		.defaultSuccessUrl("/")
		.and().oauth2Login().loginPage("/login").permitAll()
		.userInfoEndpoint().userService(customerOAuth2Servive)
		.and().successHandler(onAuthenticationSuccess)
		.and().logout().permitAll();
	}

}

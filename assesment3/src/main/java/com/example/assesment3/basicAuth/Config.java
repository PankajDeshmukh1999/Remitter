//package com.example.assesment3.basicAuth;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class Config{
//	
//	@Bean
//	public SecurityFilterChain  securityFilterChain (HttpSecurity http) throws Exception {
//		return http.csrf().disable()
//				.authorizeHttpRequests(auth->{
//				 
//			  auth.antMatchers(HttpMethod.GET,"/employee/*").hasRole("admin");
//			  auth.antMatchers("/products/*").hasRole("admin"); //
//			  auth.anyRequest().authenticated();//authentication
//			  }).httpBasic(Customizer.withDefaults()) .build();
//	}
//	
//	@Bean 
//	InMemoryUserDetailsManager users() 
//	{ 
//	return new InMemoryUserDetailsManager(
//			User
//			.withUsername("pankaj")
//			.password("{noop}pankaj")
//			.roles("admin")
//			.build(),
//			User.withUsername("kavita")
//			.password("kavita")
//			.roles("{noop}user")
//			.build());
//	  
//	  }
//	
//}

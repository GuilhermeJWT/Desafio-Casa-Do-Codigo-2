package br.com.systemsgs.casadocodigo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.systemsgs.casadocodigo.service.GenerationJwtAuthFilter;
import br.com.systemsgs.casadocodigo.service.GenerationJwtService;
import br.com.systemsgs.casadocodigo.service.ImplementacaoUserDetailsService;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ImplementacaoUserDetailsService implUserDetailsService;
	
	@Autowired
	private GenerationJwtService generationJwtService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public OncePerRequestFilter generationFilter() {
		return new GenerationJwtAuthFilter(generationJwtService, implUserDetailsService);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(implUserDetailsService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		/*
		.antMatchers("/api/autor/**").hasAnyRole("USER", "ADMIN")
		.antMatchers("/api/categoria/**").hasAnyRole("USER", "ADMIN")
		.antMatchers("/api/livro/**").hasAnyRole("USER", "ADMIN")
		.antMatchers("/api/usuario/**").permitAll()
		*/
		.antMatchers("/api/autor/**").permitAll()
		.antMatchers("/api/categoria/**").permitAll()
		.antMatchers("/api/livro/**").permitAll()
		.antMatchers("/api/usuario/**").permitAll()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(generationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

}

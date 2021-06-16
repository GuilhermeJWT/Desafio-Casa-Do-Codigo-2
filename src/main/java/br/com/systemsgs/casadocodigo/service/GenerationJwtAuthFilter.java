package br.com.systemsgs.casadocodigo.service;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class GenerationJwtAuthFilter extends OncePerRequestFilter{
	
	private GenerationJwtService generationJwtService;
	private ImplementacaoUserDetailsService implUserDetailsService;

	public GenerationJwtAuthFilter(GenerationJwtService generationJwtService, ImplementacaoUserDetailsService implUserDetailsService) {
		this.generationJwtService = generationJwtService;
		this.implUserDetailsService = implUserDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String authorization = request.getHeader("Authorization");
		
		if (authorization != null && authorization.startsWith("Bearer")) {
			String token = authorization.split(" ")[1];
			boolean validaTokenValido = generationJwtService.tokenValido(token);
			
			if(validaTokenValido) {
				String loginUsuario = generationJwtService.obterLoginUsuario(token);
				UserDetails modelUsuario =  implUserDetailsService.loadUserByUsername(loginUsuario);
				
				UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(modelUsuario, null, modelUsuario.getAuthorities());
				user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(user);
			}
		}
		
		/*Dispara uma Requisção e Resposta - Lança pra cima para podermos Testar o Projeto Casa do Código*/
		filterChain.doFilter(request, response);
	}
}

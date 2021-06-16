package br.com.systemsgs.casadocodigo.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.systemsgs.casadocodigo.model.ModelUsuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class GenerationJwtService {
	
	@Value("${security.jwt.expiracao}")
	private String expiracaoToken;
	
	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;
	
	public String geraToken(ModelUsuario modelUsuario) {
		long expiracao = Long.valueOf(expiracaoToken);
		
		LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expiracao);
		Date data = Date.from(dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant());
		
		return Jwts.builder()
				.setSubject(modelUsuario.getLogin())
				.setExpiration(data)
				.signWith(SignatureAlgorithm.HS512, chaveAssinatura)
				.compact();
	}
	
	private Claims obterClaims(String token) throws ExpiredJwtException{
		return Jwts.parser()
				.setSigningKey(chaveAssinatura)
				.parseClaimsJws(token)
				.getBody();
	}
	
	public boolean tokenValido(String token) {
		try {
			
			Claims claims =  obterClaims(token);
			Date dataExpiracao = claims.getExpiration();
			LocalDateTime verificaDataValidaExpiracao = dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			
			return !LocalDateTime.now().isAfter(verificaDataValidaExpiracao);
		}catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
	public String obterLoginUsuario(String token) throws ExpiredJwtException{
		return (String) obterClaims(token).getSubject();
	}
	
}

package br.com.systemsgs.casadocodigo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.systemsgs.casadocodigo.model.ModelUsuario;
import br.com.systemsgs.casadocodigo.repository.UsuarioRepository;

@Service
public class ImplementacaoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	private final UsuarioRepository usuarioRepository;
	
	public ImplementacaoUserDetailsService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Transactional
	public ModelUsuario salvaUsuario(ModelUsuario modelUsuario) {
		return usuarioRepository.save(modelUsuario);
	}
	/*
	public UserDetails autenticaUsuario(ModelUsuario modelUsuario) {
		UserDetails usuarioAutenticado = loadUserByUsername(modelUsuario.getLogin());
		boolean senhaVerificada =  passwordEncoder.matches(modelUsuario.getSenha(), usuarioAutenticado.getPassword());
		
		if(senhaVerificada) {
			return usuarioAutenticado;
		}
	}
	*/

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ModelUsuario modelUsuario = usuarioRepository.findByLogin(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário ou Senha Inválidos!!!"));

		String[] roles = modelUsuario.isAdmin() ? new String[] { "ADMIN", "USER" } : new String[] { "USER" };

		return User.builder().username(modelUsuario.getLogin()).password(modelUsuario.getSenha()).roles(roles).build();
	}

}

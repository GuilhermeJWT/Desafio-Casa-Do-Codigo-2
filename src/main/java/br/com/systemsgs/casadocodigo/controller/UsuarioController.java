package br.com.systemsgs.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemsgs.casadocodigo.model.ModelUsuario;
import br.com.systemsgs.casadocodigo.service.ImplementacaoUserDetailsService;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {
	
	private final ImplementacaoUserDetailsService implUserDetailsService;

	public UsuarioController(ImplementacaoUserDetailsService implUserDetailsService) {
		this.implUserDetailsService = implUserDetailsService;
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping(value = "/salvar")
	public ModelUsuario salvaUsuario(@RequestBody @Valid ModelUsuario modelUsuario) {
		String senhaUserCriptografada = passwordEncoder.encode(modelUsuario.getSenha());
		modelUsuario.setSenha(senhaUserCriptografada);
		
		ModelUsuario usuarioSalvo = implUserDetailsService.salvaUsuario(modelUsuario);

		return usuarioSalvo;
	}

}

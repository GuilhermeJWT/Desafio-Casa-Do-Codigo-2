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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Api Usuários", description = "Api que vai responsavel pela parte de Usuários")
@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {
	
	private final ImplementacaoUserDetailsService implUserDetailsService;

	public UsuarioController(ImplementacaoUserDetailsService implUserDetailsService) {
		this.implUserDetailsService = implUserDetailsService;
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@ApiOperation(value = "Endpoint para Salvar Usuário!")
	@PostMapping(value = "/salvar")
	public ModelUsuario salvaUsuario(@RequestBody @Valid ModelUsuario modelUsuario) {
		String senhaUserCriptografada = passwordEncoder.encode(modelUsuario.getSenha());
		modelUsuario.setSenha(senhaUserCriptografada);
		
		ModelUsuario usuarioSalvo = implUserDetailsService.salvaUsuario(modelUsuario);

		return usuarioSalvo;
	}
	
	/*
	@PostMapping(value = "/auth")
	public TokenDTO autenticaUsuario(@RequestBody @Valid ModelUsuarioDTO modelUsuarioDTO) {
		try {
			//implUserDetailsService.autenticaUsuario(ModelUsuario.builder().login(modelUsuarioDTO.getLogin()).senha(modelUsuarioDTO.getSenha()).build());
		}catch(UsernameNotFoundException exception) {
			exception.printStackTrace();
		}
	}
	*/

}

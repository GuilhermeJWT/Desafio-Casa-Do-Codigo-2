package br.com.systemsgs.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

public class ModelUsuarioDTO {

	@NotBlank(message = "O Login deve ser Informado!!!")
	private String login;

	@NotBlank(message = "A Senha deve ser Informada!!!")
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

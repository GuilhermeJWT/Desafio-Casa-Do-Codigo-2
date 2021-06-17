package br.com.systemsgs.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.systemsgs.casadocodigo.annotation.GenericUniqueColumn;
import br.com.systemsgs.casadocodigo.model.ModelAutor;

public class ModelAutorDTO{

	@NotBlank(message = "O Nome deve ser Informado!!!")
	private String nome;

	@GenericUniqueColumn(domainClass = ModelAutor.class, fieldName = "email", message = "E-Mail já Cadastrado, Informe Outro!!!")
	@Email(message = "E-Mail Inválido, Informe Outro!!!")
	@NotBlank(message = "O E-Mail deve ser Informado!!!")
	private String email;

	@Length(max = 400, message = "A Descrição deve ter no Máximo 400 Caracteres!!!")
	@NotBlank(message = "A Descrição deve ser Informada!")
	private String descricao;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

}

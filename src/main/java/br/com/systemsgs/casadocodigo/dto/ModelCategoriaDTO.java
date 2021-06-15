package br.com.systemsgs.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.systemsgs.casadocodigo.annotation.GenericUniqueColumn;
import br.com.systemsgs.casadocodigo.model.ModelCategoria;

public class ModelCategoriaDTO {

	@GenericUniqueColumn(domainClass = ModelCategoria.class, fieldName = "nome", message = "Nome da Categoria já Cadastrado, Informe Outro!!!")
	@NotBlank(message = "O Nome da Categoria deve ser Informado!!!")
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
}

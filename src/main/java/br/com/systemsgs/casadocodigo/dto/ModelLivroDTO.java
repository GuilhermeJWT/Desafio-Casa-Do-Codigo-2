package br.com.systemsgs.casadocodigo.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.systemsgs.casadocodigo.annotation.GenericUniqueColumn;
import br.com.systemsgs.casadocodigo.model.ModelLivro;

public class ModelLivroDTO {

	@GenericUniqueColumn(domainClass = ModelLivro.class, fieldName = "titulo", message = "O Titulo já está Cadastrado, Informe Outro!!!")
	@NotBlank(message = "O Titulo deve ser Informado!!!")
	private String titulo;

	@Length(max = 500, message = "O Resumo deve ter no Máximo 500 Caracteres!!!")
	@NotBlank(message = "O Resumo deve ser Informado!!!")
	private String resumo;

	@Column(columnDefinition = "text")
	private String sumario;

	@Min(value = 20, message = "O Preço do Livro deve ser maior que $20,00")
	@NotNull(message = "O Preço deve ser Informado!!!")
	private BigDecimal preco;

	@Min(value = 100, message = "O Número de páginas deve ser no Minimo de 100 Páginas!!!")
	@NotNull(message = "O Número de Páginas deve ser Informado!!!")
	private int numero_pagina;

	@GenericUniqueColumn(domainClass = ModelLivro.class, fieldName = "isbn", message = "O Isbn já cadastrado, Informe Outro!!!")
	@NotBlank(message = "O Isbn deve ser Informado!!!")
	private String isbn;

	@Future(message = "A Data de Publicação deve ser no Futuro!!!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPublicacao;

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumero_pagina() {
		return numero_pagina;
	}

	public String getIsbn() {
		return isbn;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

}

package br.com.systemsgs.casadocodigo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "livro")
public class ModelLivro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O Titúlo deve ser Informado!!!")
	private String titulo;

	@Length(max = 500, message = "O Resumo deve ter no Máximo 500 Caracteres!!!")
	@NotBlank(message = "O Resumo deve ser Informado!!!")
	private String resumo;

	@Column(columnDefinition = "text")
	private String sumario;

	@Length(min = 20, message = "O Preço do Livro deve ser maior que $20,00")
	@NotNull(message = "O Preço deve ser Informado!!!")
	private BigDecimal preco;

	@Length(min = 100, message = "O Número de páginas deve ser no Minimo de 100 Páginas!!!")
	@NotNull(message = "O Número de Páginas deve ser Informado!!!")
	private int numero_pagina;

	@NotBlank(message = "O Isbn deve ser Informado!!!")
	private String isbn;

	@Future(message = "A Data de Publicação deve ser no Futuro!!!")
	private Date dataPublicacao;

	@NotNull(message = "O ID da Categoria deve ser Informado!!!")
	@ManyToOne(optional = false)
	@ForeignKey(name = "categoria_id")
	private ModelCategoria categoria;

	@NotNull(message = "O ID do Autor deve ser Informado!!!")
	@ManyToOne(optional = false)
	@ForeignKey(name = "autor_id")
	private ModelAutor autor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getNumero_pagina() {
		return numero_pagina;
	}

	public void setNumero_pagina(int numero_pagina) {
		this.numero_pagina = numero_pagina;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public ModelCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(ModelCategoria categoria) {
		this.categoria = categoria;
	}

	public ModelAutor getAutor() {
		return autor;
	}

	public void setAutor(ModelAutor autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelLivro other = (ModelLivro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

package br.com.systemsgs.casadocodigo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "autor")
public class ModelAutor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O Nome deve ser Informado!!!")
	private String nome;

	@Email(message = "E-Mail Inválido, Informe Outro!!!")
	@NotBlank(message = "O E-Mail deve ser Informado!!!")
	private String email;

	@Length(max = 400, message = "A Descrição deve ter no Máximo 400 Caracteres!!!")
	@NotBlank(message = "A Descrição deve ser Informada!")
	private String descricao;

	private LocalDate instanteCadastro = LocalDate.now();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getInstanteCadastro() {
		return instanteCadastro;
	}

	public void setInstanteCadastro(LocalDate instanteCadastro) {
		this.instanteCadastro = instanteCadastro;
	}
	
	@Deprecated
	public ModelAutor() {
		
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
		ModelAutor other = (ModelAutor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

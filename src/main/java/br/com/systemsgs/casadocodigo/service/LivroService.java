package br.com.systemsgs.casadocodigo.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.casadocodigo.config.DozerConverter;
import br.com.systemsgs.casadocodigo.dto.ModelLivroDTO;
import br.com.systemsgs.casadocodigo.model.ModelLivro;
import br.com.systemsgs.casadocodigo.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	@Transactional
	public ModelLivroDTO salvaLicroService(ModelLivroDTO modelLivroDTO) {
		var modelLivro = DozerConverter.converteEntidade(modelLivroDTO, ModelLivro.class);
		var livroConvertido = DozerConverter.converteEntidade(livroRepository.save(modelLivro), ModelLivroDTO.class);
		
		return livroConvertido;
	}

}

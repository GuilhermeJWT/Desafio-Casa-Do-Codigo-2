package br.com.systemsgs.casadocodigo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.casadocodigo.config.DozerConverter;
import br.com.systemsgs.casadocodigo.dto.ModelLivroDTO;
import br.com.systemsgs.casadocodigo.exception.RecursoNaoEncontradoException;
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
	
	public List<ModelLivro> recuperaTodosLivros(){
		//return DozerConverter.converteList(livroRepository.findAll(), ModelLivroDTO.class);
		return livroRepository.findAll();
	}
	
	public ModelLivroDTO pesquisaLivroPorId(Long id) {
		var modelLivro = livroRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
		
		return DozerConverter.converteEntidade(modelLivro, ModelLivroDTO.class);
	}

}

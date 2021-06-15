package br.com.systemsgs.casadocodigo.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.casadocodigo.config.DozerConverter;
import br.com.systemsgs.casadocodigo.dto.ModelCategoriaDTO;
import br.com.systemsgs.casadocodigo.model.ModelCategoria;
import br.com.systemsgs.casadocodigo.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional
	public ModelCategoriaDTO salvaCategoriaService(ModelCategoriaDTO modelCategoriaDTO) {
		var modelCategoria = DozerConverter.converteEntidade(modelCategoriaDTO, ModelCategoria.class);
		var categoriaConvertida = DozerConverter.converteEntidade(categoriaRepository.save(modelCategoria), ModelCategoriaDTO.class);
		
		return categoriaConvertida;
	}
	

}

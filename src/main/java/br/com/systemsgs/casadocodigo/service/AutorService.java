package br.com.systemsgs.casadocodigo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.casadocodigo.config.DozerConverter;
import br.com.systemsgs.casadocodigo.dto.ModelAutorDTO;
import br.com.systemsgs.casadocodigo.model.ModelAutor;
import br.com.systemsgs.casadocodigo.model.ModelUsuario;
import br.com.systemsgs.casadocodigo.repository.AutorRepisitory;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepisitory autorRepisitory;
	
	@Transactional
	public ModelAutorDTO salvaAutor(ModelAutorDTO modelAutorDTO) {
		
		var modelAutor = DozerConverter.converteEntidade(modelAutorDTO, ModelAutor.class);
		var autorConvertido = DozerConverter.converteEntidade(autorRepisitory.save(modelAutor), ModelAutorDTO.class);
		
		return autorConvertido;
	}
	
	public List<ModelAutor> listaAutores() {
		List<ModelAutor> modelAutor = autorRepisitory.findAll();
		return modelAutor;
	}
}

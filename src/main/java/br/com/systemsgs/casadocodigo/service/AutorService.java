package br.com.systemsgs.casadocodigo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systemsgs.casadocodigo.model.ModelAutor;
import br.com.systemsgs.casadocodigo.repository.AutorRepisitory;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepisitory autorRepisitory;
	
	@Transactional
	public void salvaAutor(ModelAutor modelAutor) {
		autorRepisitory.save(modelAutor);
	}

}

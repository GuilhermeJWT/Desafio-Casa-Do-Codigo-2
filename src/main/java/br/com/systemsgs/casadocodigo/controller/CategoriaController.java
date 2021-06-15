package br.com.systemsgs.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemsgs.casadocodigo.dto.ModelCategoriaDTO;
import br.com.systemsgs.casadocodigo.service.CategoriaService;

@RestController
@RequestMapping(value = "/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping(value = "/salvar")
	public ResponseEntity<?> salvaCategoria(@RequestBody @Valid ModelCategoriaDTO modelCategoriaDTO){
		
		categoriaService.salvaCategoriaService(modelCategoriaDTO);
		
		return ResponseEntity.ok("Categoria Salva com Sucesso!!!");
	}

}

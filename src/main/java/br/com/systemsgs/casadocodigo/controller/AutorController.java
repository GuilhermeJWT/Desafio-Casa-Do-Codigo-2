package br.com.systemsgs.casadocodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemsgs.casadocodigo.dto.ModelAutorDTO;
import br.com.systemsgs.casadocodigo.model.ModelAutor;
import br.com.systemsgs.casadocodigo.service.AutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Api Autor", description = "Api que vai responsavel pela parte de Autores")
@RestController
@RequestMapping(value = "/api/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@ApiOperation(value = "Endpoint para Salvar Autores!")
	@PostMapping(value = "/salvar")
	public ResponseEntity<?> salvaAutor(@RequestBody @Valid ModelAutorDTO modelAutorDTO) {
		autorService.salvaAutor(modelAutorDTO);

		return ResponseEntity.ok("Autor Salvo com Sucesso!!!");
	}

	@ApiOperation(value = "Endpoint para Listar todos Autores!")
	@GetMapping("/listaAutores")
	public List<ModelAutor> listaAutores() {
		return autorService.listaAutores();
	}

}

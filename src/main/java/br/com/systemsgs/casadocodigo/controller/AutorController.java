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

@RestController
@RequestMapping(value = "/api/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@PostMapping(value = "/salvar")
	public ResponseEntity<?> salvaAutor(@RequestBody @Valid ModelAutorDTO modelAutorDTO) {
		autorService.salvaAutor(modelAutorDTO);

		return ResponseEntity.ok("Autor Salvo com Sucesso!!!");
	}

	@GetMapping("/listaAutores")
	public List<ModelAutor> listaAutores() {
		return autorService.listaAutores();
	}

}

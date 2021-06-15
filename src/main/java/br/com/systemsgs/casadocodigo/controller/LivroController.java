package br.com.systemsgs.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemsgs.casadocodigo.dto.ModelLivroDTO;
import br.com.systemsgs.casadocodigo.service.LivroService;

@RestController
@RequestMapping(value = "/api/livro")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping(value = "/salvar")
	public ResponseEntity<?> salvaLivro(@RequestBody @Valid ModelLivroDTO modelLivroDTO) {

		livroService.salvaLicroService(modelLivroDTO);

		return ResponseEntity.ok("Livro Cadastrado com Sucesso!!!");
	}

}

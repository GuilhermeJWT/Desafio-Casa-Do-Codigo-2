package br.com.systemsgs.casadocodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemsgs.casadocodigo.dto.ModelLivroDTO;
import br.com.systemsgs.casadocodigo.model.ModelLivro;
import br.com.systemsgs.casadocodigo.service.LivroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Api Livros", description = "Api que vai responsavel pela parte de Livros")
@RestController
@RequestMapping(value = "/api/livro")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@ApiOperation(value = "Endpoint para Salvar Livros!")
	@PostMapping(value = "/salvar")
	public ResponseEntity<?> salvaLivro(@RequestBody @Valid ModelLivroDTO modelLivroDTO) {
		livroService.salvaLicroService(modelLivroDTO);

		return ResponseEntity.ok("Livro Cadastrado com Sucesso!!!");
	}
	
	@ApiOperation(value = "Endpoint para Listar Todos os Livros!")
	@GetMapping(value = "/listaLivros")
	public List<ModelLivro> listaLivros(){
		return livroService.recuperaTodosLivros();
	}
	
	@ApiOperation(value = "Endpoint para Pesquisar Livro por Id!")
	@GetMapping(value = "/pesquisaLivro/{id}")
	public ModelLivro recuperaDetalheLivro(@PathVariable("id") Long id) {
		return livroService.pesquisaLivroPorId(id);
	}

}

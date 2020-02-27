package com.ufpb.produtos.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ufpb.produtos.model.Produto;
import com.ufpb.produtos.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtos;

	@GetMapping
	public List<Produto> listarProdutos() {
		//faz um select na tabela do bd
		return produtos.findAll();
	}
	
	// retorna 404 caso o produto não exista na busca
	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscar(@PathVariable Long id) {
		Optional<Produto> produto = produtos.findById(id);
		
		if(produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
			
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@Valid @RequestBody Produto produto) {
		return produtos.save(produto);
	}

}

package com.ufpb.produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}

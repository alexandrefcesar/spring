package com.ufpb.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufpb.produtos.model.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {

}

package com.apirestprodutos.estudos.controller;


import com.apirestprodutos.estudos.model.Produto;
import com.apirestprodutos.estudos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping(path = "/produtos")
    public List<Produto> getProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/produto/{id}")
    public ResponseEntity getProduto(@PathVariable("id") long id){
        return produtoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/produtos/insert")
    public Produto insertProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }



}

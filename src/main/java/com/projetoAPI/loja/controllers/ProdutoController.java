package com.projetoAPI.loja.controllers;

import com.projetoAPI.loja.models.Produto;
import com.projetoAPI.loja.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")


public class ProdutoController {
    @Autowired
    private  ProdutoRepository produtoRepository;
    @GetMapping
    public List<Produto> listandoProdutos() {
        return  produtoRepository.findAll();
    }
    @PostMapping
    public Produto adicionandoProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    @PutMapping("/{id}")
    public Produto atualizandoProduto(@PathVariable Long id, @RequestBody  Produto atualizandoProduto){
        Optional<Produto> produtoOpcional = produtoRepository.findById(id);
        if(produtoOpcional.isPresent()) {
            Produto produtoAtualizado = produtoOpcional.get();
            produtoAtualizado.setNome(atualizandoProduto.getNome());
            produtoAtualizado.setPreco(atualizandoProduto.getPreco());
            Produto produtoAdicionado = produtoRepository.save(produtoAtualizado);
            return produtoAdicionado;
        } else {
            System.out.println("Erro ao encontrar o produto especificado");
        }
        return  atualizandoProduto;
    }
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}

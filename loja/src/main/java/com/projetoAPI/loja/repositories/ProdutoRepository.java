package com.projetoAPI.loja.repositories;

import com.projetoAPI.loja.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

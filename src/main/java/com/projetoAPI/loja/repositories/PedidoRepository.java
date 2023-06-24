package com.projetoAPI.loja.repositories;

import com.projetoAPI.loja.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

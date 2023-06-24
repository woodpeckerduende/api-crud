package com.projetoAPI.loja.repositories;


import com.projetoAPI.loja.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

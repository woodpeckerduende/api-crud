package com.projetoAPI.loja.controllers;

import com.projetoAPI.loja.models.Cliente;
import com.projetoAPI.loja.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizarDadosCliente(@PathVariable Long id, @RequestBody Cliente atualizarCliente) {
        Optional<Cliente> clienteOpcional = clienteRepository.findById(id);
        if (clienteOpcional.isPresent()) {
            Cliente cliente = clienteOpcional.get();
            cliente.setNome(atualizarCliente.getNome());
            Cliente clienteAtualizado = clienteRepository.save(cliente);
            return clienteAtualizado;

        } else {
            System.out.println("Erro ao encontrar um cliente para atualizar");
        }

        return atualizarCliente;
    }
    @DeleteMapping("/{id}")
    public void DeletarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }

}

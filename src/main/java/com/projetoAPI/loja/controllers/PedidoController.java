package com.projetoAPI.loja.controllers;

import com.projetoAPI.loja.models.Cliente;
import com.projetoAPI.loja.models.Pedido;
import com.projetoAPI.loja.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
    @PostMapping
    public Pedido adicionandoPedidos(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    @PutMapping("/{id}")
    public Pedido atualizandoPedidos(@PathVariable Long id, @RequestBody Pedido atualizandoPedidos) {
        Optional<Pedido> pedidoOpcional = pedidoRepository.findById(id);
        if(pedidoOpcional.isPresent()) {
            Pedido pedido = pedidoOpcional.get();
            pedido.setNome(atualizandoPedidos.getNome());
            pedido.setCliente(atualizandoPedidos.getCliente());
            pedido.setProdutos(atualizandoPedidos.getProdutos());
            Pedido salvandoPedido = pedidoRepository.save(pedido);
            return salvandoPedido;
        }
        return atualizandoPedidos;
    }
    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }

}

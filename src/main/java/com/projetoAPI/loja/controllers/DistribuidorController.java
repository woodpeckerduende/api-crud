package com.projetoAPI.loja.controllers;

import com.projetoAPI.loja.models.Distribuidor;
import com.projetoAPI.loja.repositories.DistribuidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/distribuidores")
public class DistribuidorController {
    @Autowired
    private DistribuidorRepository distribuidorRepository;

    @GetMapping
    public List<Distribuidor> listarDistribuidores() {
        return distribuidorRepository.findAll();
    }

    @PostMapping
    public Distribuidor criarDistribuidor(@RequestBody Distribuidor distribuidor) {
        return distribuidorRepository.save(distribuidor);
    }

    @PutMapping("/{id}")
    public Distribuidor atualizarDadosDistribuidor(@PathVariable Long id, @RequestBody Distribuidor atualizarDistribuidor) {
        Optional<Distribuidor> distribuidorOpcional = distribuidorRepository.findById(id);
        if (distribuidorOpcional.isPresent()) {
            Distribuidor distribuidor = distribuidorOpcional.get();
            distribuidor.setNome(atualizarDistribuidor.getNome());
            distribuidor.setCategorias(atualizarDistribuidor.getCategorias());

            Distribuidor distribuidorAtualizado = distribuidorRepository.save(distribuidor);
            return distribuidorAtualizado;
        } else {
            System.out.println("Erro ao encontrar um distribuidor para atualizar");
        }

        return atualizarDistribuidor;
    }

    @DeleteMapping("/{id}")
    public void deletarDistribuidor(@PathVariable Long id) {
        distribuidorRepository.deleteById(id);
    }
}

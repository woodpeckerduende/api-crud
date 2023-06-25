package com.projetoAPI.loja.controllers;

import com.projetoAPI.loja.models.Endereco;
import com.projetoAPI.loja.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    @PostMapping
    public Endereco criarEndereco(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @PutMapping("/{id}")
    public Endereco atualizarDadosEndereco(@PathVariable Long id, @RequestBody Endereco atualizarEndereco) {
        Optional<Endereco> enderecoOpcional = enderecoRepository.findById(id);
        if (enderecoOpcional.isPresent()) {
            Endereco endereco = enderecoOpcional.get();
            endereco.setNomeRementente(atualizarEndereco.getNomeRementente());
            endereco.setRua(atualizarEndereco.getRua());
            endereco.setNumero(atualizarEndereco.getNumero());
            endereco.setComplemento(atualizarEndereco.getComplemento());
            endereco.setBairro(atualizarEndereco.getBairro());
            endereco.setCidade(atualizarEndereco.getCidade());
            endereco.setEstado(atualizarEndereco.getEstado());
            endereco.setCep(atualizarEndereco.getCep());

            Endereco enderecoAtualizado = enderecoRepository.save(endereco);
            return enderecoAtualizado;
        } else {
            System.out.println("Erro ao encontrar um endereço para atualizar");
        }

        return atualizarEndereco;
    }

    @DeleteMapping("/{id}")
    public void deletarEndereco(@PathVariable Long id) {
        enderecoRepository.deleteById(id);
    }
}

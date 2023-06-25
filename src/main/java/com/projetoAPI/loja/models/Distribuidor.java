package com.projetoAPI.loja.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "distribuidores")
public class Distribuidor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ElementCollection
    @CollectionTable(name = "distribuidor_categorias", joinColumns = @JoinColumn(name = "distribuidor_id"))
    @Column(name = "categoria")
    private List<String> categorias;
}

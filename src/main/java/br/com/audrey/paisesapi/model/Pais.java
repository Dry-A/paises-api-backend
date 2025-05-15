package br.com.audrey.paisesapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "paises")
@NoArgsConstructor
@AllArgsConstructor
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String capital;

    private String continente;

    @Column(name = "area_km2")
    private BigDecimal areaKm2;

    private Long populacao;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    // Construtor para criação
    public Pais(String nome, String capital, String continente, BigDecimal areaKm2, Long populacao) {
        this.nome = nome;
        this.capital = capital;
        this.continente = continente;
        this.areaKm2 = areaKm2;
        this.populacao = populacao;
    }

    // Construtor para atualização
    public Pais(Integer id, String nome, String capital, String continente, BigDecimal areaKm2, Long populacao,
                LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.capital = capital;
        this.continente = continente;
        this.areaKm2 = areaKm2;
        this.populacao = populacao;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = LocalDateTime.now();
    }
}

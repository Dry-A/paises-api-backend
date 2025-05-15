package br.com.audrey.paisesapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaisRequestDTO {
    private String nome;
    private String capital;
    private String continente;
    private BigDecimal areaKm2;
    private Long populacao;
}


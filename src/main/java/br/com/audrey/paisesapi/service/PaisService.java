package br.com.audrey.paisesapi.service;

import br.com.audrey.paisesapi.dto.PaisRequestDTO;
import br.com.audrey.paisesapi.dto.PaisResponseDTO;
import br.com.audrey.paisesapi.model.Pais;
import br.com.audrey.paisesapi.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PaisService {

    private final PaisRepository paisRepository;

    @Autowired
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public Page<PaisResponseDTO> buscarTodos(Pageable pageable, String nome) {
        Page<Pais> paises;

        if (nome == null || nome.isBlank()) {
            paises = paisRepository.findAll(pageable);
        } else {
            paises = paisRepository.findByNomeContainingIgnoreCase(nome, pageable);
        }

        return paises.map(this::toResponseDTO);
    }

    public PaisResponseDTO buscarPorId(Integer id) {
        Pais pais = paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País não encontrado com o ID: " + id));

        return toResponseDTO(pais);
    }

    @Transactional
    public PaisResponseDTO cadastrar(PaisRequestDTO paisDTO) {
        Pais pais = new Pais(
                paisDTO.getNome(),
                paisDTO.getCapital(),
                paisDTO.getContinente(),
                paisDTO.getAreaKm2(),
                paisDTO.getPopulacao()
        );

        return toResponseDTO(paisRepository.save(pais));
    }

    @Transactional
    public PaisResponseDTO atualizar(Integer id, PaisRequestDTO paisDTO) {
        Pais paisExistente = paisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("País não encontrado com o ID: " + id));

        Pais paisAtualizado = new Pais(
                id,
                paisDTO.getNome(),
                paisDTO.getCapital(),
                paisDTO.getContinente(),
                paisDTO.getAreaKm2(),
                paisDTO.getPopulacao(),
                paisExistente.getDataCriacao()
        );

        return toResponseDTO(paisRepository.save(paisAtualizado));
    }

    @Transactional
    public void excluir(Integer id) {
        if (!paisRepository.existsById(id)) {
            throw new RuntimeException("País não encontrado com o ID: " + id);
        }

        paisRepository.deleteById(id);
    }

    private PaisResponseDTO toResponseDTO(Pais pais) {
        return new PaisResponseDTO(
                pais.getId(),
                pais.getNome(),
                pais.getCapital(),
                pais.getContinente(),
                pais.getAreaKm2(),
                pais.getPopulacao()
        );
    }
}


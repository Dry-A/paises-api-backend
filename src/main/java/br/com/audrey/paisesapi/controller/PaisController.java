package br.com.audrey.paisesapi.controller;

import br.com.audrey.paisesapi.dto.PaisRequestDTO;
import br.com.audrey.paisesapi.dto.PaisResponseDTO;
import br.com.audrey.paisesapi.service.PaisService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/paises")
@CrossOrigin(origins = "*")
public class PaisController {

    private final PaisService paisService;

    @Autowired
    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping
    public ResponseEntity<Page<PaisResponseDTO>> listar(
            @RequestParam(required = false) String nome,
            @PageableDefault(size = 10, sort = "nome") Pageable pageable) {

        return ResponseEntity.ok(paisService.buscarTodos(pageable, nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaisResponseDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(paisService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PaisResponseDTO> cadastrar(@RequestBody @Valid PaisRequestDTO pais) {
        PaisResponseDTO paisCadastrado = paisService.cadastrar(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(paisCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaisResponseDTO> atualizar(
            @PathVariable Integer id,
            @RequestBody @Valid PaisRequestDTO pais) {

        PaisResponseDTO paisAtualizado = paisService.atualizar(id, pais);
        return ResponseEntity.ok(paisAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        paisService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}


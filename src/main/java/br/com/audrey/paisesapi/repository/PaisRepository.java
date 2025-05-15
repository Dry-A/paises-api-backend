package br.com.audrey.paisesapi.repository;

import br.com.audrey.paisesapi.model.Pais;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

    Page<Pais> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}

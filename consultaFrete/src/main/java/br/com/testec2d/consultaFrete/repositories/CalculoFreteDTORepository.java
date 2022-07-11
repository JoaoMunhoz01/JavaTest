package br.com.testec2d.consultaFrete.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testec2d.consultaFrete.entities.CalculoFreteDTO;

public interface CalculoFreteDTORepository extends JpaRepository<CalculoFreteDTO, Integer> {
	

}

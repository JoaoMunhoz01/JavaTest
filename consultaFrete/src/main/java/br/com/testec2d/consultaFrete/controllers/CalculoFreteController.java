package br.com.testec2d.consultaFrete.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testec2d.consultaFrete.entities.CalculoFreteDTO;
import br.com.testec2d.consultaFrete.repositories.CalculoFreteDTORepository;

@RestController
@RequestMapping(value = "/CalculadorFrete")
public class CalculoFreteController {
	
	@Autowired
	private CalculoFreteDTORepository calcFreteRepository;
	
	@PostMapping
	public boolean saveRecords(@RequestBody CalculoFreteDTO dto) {
		
		try {
			CalculoFreteDTO req = calcFreteRepository.save(dto);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

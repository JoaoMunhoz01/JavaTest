package br.com.testec2d.consultaFrete.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testec2d.consultaFrete.CalculadoraFrete;
import br.com.testec2d.consultaFrete.entities.CalculoFreteDTO;
import br.com.testec2d.consultaFrete.repositories.CalculoFreteDTORepository;

@RestController
@RequestMapping(value = "/CalculadorFrete")
public class CalculoFreteController {

	@Autowired
	private CalculoFreteDTORepository calcFreteRepository;

	@GetMapping
	public List<CalculoFreteDTO> findAll() {
		List<CalculoFreteDTO> req = calcFreteRepository.findAll();
		return req;
	}

	@PostMapping
	public String saveRecords(@RequestBody CalculoFreteDTO dto) {
		CalculadoraFrete calculate = new CalculadoraFrete();

		try {
			dto = calculate.calcValTotalFrete(dto.getPeso(), dto.getCepOrigem().replaceAll("-", ""),
					dto.getCepDestino().replaceAll("-", ""),
					dto.getNomeDestinatario());

			System.out.println(dto);
			CalculoFreteDTO req = calcFreteRepository.save(dto);

			return "{ status:" + "1, \nnomeDestinatario:" + dto.getNomeDestinatario() + ", \nvlrTotalFrete:"
					+ dto.getVlrTotal() + ", \ndataPrevistaEntrega:" + dto.getDiasEntrega() + ", \ndataConsulta:"
					+ dto.getDataConsulta() + ",\n}";
		} catch (Exception e) {
			return "{ status:" + "0, \nstatusMessage:" + e.toString() + ",\n} ";
		}
	}

}

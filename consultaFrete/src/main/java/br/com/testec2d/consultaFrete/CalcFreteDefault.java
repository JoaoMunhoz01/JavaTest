package br.com.testec2d.consultaFrete;

import org.json.JSONObject;

import br.com.testec2d.consultaFrete.entities.CalculoFreteDTO;

public class CalcFreteDefault implements EstragiaCalFrete {

	@Override
	public void calculaFrete(CalculoFreteDTO dto) {
		dto.setVlrTotal(dto.getPeso());
        dto.setDiasEntrega(10);
	}

	@Override
	public boolean isValid(JSONObject jsonOrigem, JSONObject jsonDestino) {
		
		return !jsonOrigem.getString("uf").equals(jsonDestino.getString("uf"));
	}

}

package br.com.testec2d.consultaFrete;

import org.json.JSONObject;

import br.com.testec2d.consultaFrete.entities.CalculoFreteDTO;

public class CalcFreteDDD implements EstragiaCalFrete {

	@Override
	public void calculaFrete(CalculoFreteDTO dto) {
		dto.setVlrTotal(dto.getPeso()/2);
        dto.setDiasEntrega(1);
		
	}

	@Override
	public boolean isValid(JSONObject jsonOrigem, JSONObject jsonDestino) {
		return jsonOrigem.getInt("ddd") == jsonDestino.getInt("ddd");
	}


}

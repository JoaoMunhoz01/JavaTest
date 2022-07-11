package br.com.testec2d.consultaFrete;

import org.json.JSONObject;

import br.com.testec2d.consultaFrete.entities.CalculoFreteDTO;

public interface EstragiaCalFrete {
	
	public void calculaFrete(CalculoFreteDTO dto);
	
	public boolean isValid(JSONObject jsonOrigem, JSONObject jsonDestino);
	
}

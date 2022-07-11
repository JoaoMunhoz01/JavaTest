package br.com.testec2d.consultaFrete;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import br.com.testec2d.consultaFrete.entities.CalculoFreteDTO;

public class CalculadoraFrete {

	public CalculadoraFrete() {

	}

	public JSONObject getJSONViaCep(String cep) {
		ViaCep vc = new ViaCep();
		try {
			URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
			JSONObject jsonViaCep = vc.readJSON(url);

			return jsonViaCep;
		} catch (Exception e) {
			JSONObject jsonErro = new JSONObject("status: 0,statusMessage: Houve um erro" + e.toString());
			return jsonErro;
		}

	}

	public CalculoFreteDTO calcValTotalFrete(double peso, String cepOrigem, String cepDestino,
			String nomeDestinatario) {

		CalculoFreteDTO dto = new CalculoFreteDTO();

		dto.setCepOrigem(cepOrigem);
		dto.setCepDestino(cepDestino);
		dto.setNomeDestinatario(nomeDestinatario);
		dto.setPeso(peso);

		JSONObject jsonOrigem = getJSONViaCep(cepOrigem);
		JSONObject jsonDestino = getJSONViaCep(cepDestino);

		List<EstragiaCalFrete> estrategiasFrete = new ArrayList<EstragiaCalFrete>();
		estrategiasFrete.add(new CalcFreteDDD());
		estrategiasFrete.add(new CalcFreteUF());
		estrategiasFrete.add(new CalcFreteDefault());

		for (EstragiaCalFrete estragia : estrategiasFrete) {
			if (estragia.isValid(jsonOrigem, jsonDestino)) {
				estragia.calculaFrete(dto);
			}
		}

		return dto;
	}


}
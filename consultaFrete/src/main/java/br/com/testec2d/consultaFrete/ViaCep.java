package br.com.testec2d.consultaFrete;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONObject;

public class ViaCep {

    private String jsonCepOrigem;
    private String jsonCepDestino;

    public ViaCep() {

    }

    // GETTERS
    public String getJsonCepOrigem() {
        return jsonCepOrigem;
    }

    public String getJsonCepDestino() {
        return jsonCepDestino;
    }

    // SETTERS
    public void setJsonCepDestino(String jsonCepDestino) {
        this.jsonCepDestino = jsonCepDestino;
    }

    public void setJsonCepOrigem(String jsonCepOrigem) {
        this.jsonCepOrigem = jsonCepOrigem;
    }

    // FUNCTIONS

    // LEITURA E FORMATAÇÃO DO JSON;

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private JSONObject readJsonFromUrl(String url) throws Exception {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public JSONObject readJSON(URL url) throws Exception {

        HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        String jsonStr = "{0:0}";
        JSONObject jsonERRO = new JSONObject(jsonStr);

        if (connect.getResponseCode() == 200) {
            JSONObject json = readJsonFromUrl(url.toString());
            return json;
        } else {
            return jsonERRO;
        }
    }

}
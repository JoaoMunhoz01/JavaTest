package br.com.testec2d.consultaFrete.entities;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CalculoFrete")
public class CalculoFreteDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeDestinatario;
    private double peso;
    private String cepOrigem;
    private String cepDestino;
    private double vlrTotal;
    private int diasEntrega;
    private String dataConsulta;

    public CalculoFreteDTO() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
        ZonedDateTime now = ZonedDateTime.now();
        this.nomeDestinatario = "";
        this.peso = 0;
        this.cepOrigem = "";
        this.cepDestino = "";
        this.vlrTotal = 0;
        this.diasEntrega = 0;
        this.dataConsulta = dtf.format(now);

    }

    // GETTERS
    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public double getPeso() {
        return peso;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public int getDiasEntrega() {
        return diasEntrega;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    // SETTERS
    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setCepOrigem(String cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public void setDiasEntrega(int diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    @Override
    public String toString() {
        return "CalculoFreteDTO [nomeDestinatario=" + nomeDestinatario + ", peso=" + peso + ", cepOrigem=" + cepOrigem
                + ", cepDestino=" + cepDestino + ", vlrTotal=" + vlrTotal + ", diasEntrega=" + diasEntrega
                + ", dataConsulta=" + dataConsulta + "]";
    }

}

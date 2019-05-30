package com.example.ccproject.Models;

public class Carros {
    private String placa;
    private String modelo;
    private String marca;
    private String cor;
    private String id;
    private String inicioEnd;
    private String destinoEnd;
    private Double kmInicio;
    private Double kmFinal;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInicioEnd() {
        return inicioEnd;
    }

    public void setInicioEnd(String inicioEnd) {
        this.inicioEnd = inicioEnd;
    }

    public String getdestinoEnd() {
        return destinoEnd;
    }

    public void setdestinoEnd(String finalEnd) {
        this.destinoEnd = finalEnd;
    }

    public Double getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(Double kmInicio) {
        this.kmInicio = kmInicio;
    }

    public Double getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Double kmFinal) {
        this.kmFinal = kmFinal;
    }

    public Carros(String placa, Double kmInicio, String marca) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.id = id;
        this.inicioEnd = inicioEnd;
        this.destinoEnd = destinoEnd;
        this.kmInicio = this.kmInicio;
        this.kmFinal = kmFinal;
    }

    public void Carros() {

    }
}
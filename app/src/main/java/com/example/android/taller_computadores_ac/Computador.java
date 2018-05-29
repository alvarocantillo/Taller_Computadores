package com.example.android.taller_computadores_ac;

/**
 * Created by android on 28/05/2018.
 */

public class Computador {
    private String marca;
    private double ram;
    private String color;
    private String tipo;
    private String sistema;
    private int foto;

    public Computador(String marca, double ram, String color, String tipo, String sistema, int foto) {
        this.marca = marca;
        this.ram = ram;
        this.color = color;
        this.tipo = tipo;
        this.sistema = sistema;
        this.foto = foto;
    }
    public Computador(){

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }



}

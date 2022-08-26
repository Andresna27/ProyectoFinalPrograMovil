package com.proyectofinal.model;

import java.util.Date;

public class Reserva {

    public String uid;
    public Integer Cedula;
    public Integer Placa;
    public String Nombre;
    public String Telefono;
    public String HoraEntrada;
    public String HoraSalida;
    public Integer NumeroLugar;

    public Reserva() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getCedula() {
        return Cedula;
    }

    public void setCedula(Integer cedula) {
        Cedula = cedula;
    }

    public Integer getPlaca() {
        return Placa;
    }

    public void setPlaca(Integer placa) {
        Placa = placa;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        HoraEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String horaSalida) {
        HoraSalida = horaSalida;
    }

    public Integer getNumeroLugar() {
        return NumeroLugar;
    }

    public void setNumeroLugar(Integer numeroLugar) {
        NumeroLugar = numeroLugar;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "Placa=" + Placa +
                ", Nombre='" + Nombre + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", HoraEntrada='" + HoraEntrada + '\'' +
                ", HoraSalida='" + HoraSalida + '\'' +
                ", NumeroLugar=" + NumeroLugar +
                '}';
    }
}

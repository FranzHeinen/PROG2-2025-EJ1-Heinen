package com.ejercicios.Dto;

import com.ejercicios.Entity.CuentaCorriente;

public class CuentaCorrienteDTO {

    private double saldo;
    private int operaciones;
    private double giroDescubierto;

    public CuentaCorrienteDTO(double saldo, int operaciones, double giroDescubierto) {
        this.saldo = saldo;
        this.operaciones = operaciones;
        this.giroDescubierto = giroDescubierto;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getOperaciones() {
        return operaciones;
    }

    public double getGiroDescubierto() {
        return giroDescubierto;
    }
}

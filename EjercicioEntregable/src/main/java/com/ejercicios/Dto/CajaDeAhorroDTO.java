package com.ejercicios.Dto;

import com.ejercicios.Entity.CajaDeAhorro;
import com.ejercicios.Entity.Cuenta;

public class CajaDeAhorroDTO {

    private double saldo;
    private int operaciones;

    public CajaDeAhorroDTO(double saldo, int operaciones) {
        this.saldo = saldo;
        this.operaciones = operaciones;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getOperaciones() {
        return operaciones;
    }
}

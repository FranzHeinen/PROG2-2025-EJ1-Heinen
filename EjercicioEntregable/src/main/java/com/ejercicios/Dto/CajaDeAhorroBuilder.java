package com.ejercicios.Dto;

import com.ejercicios.Entity.CajaDeAhorro;

public class CajaDeAhorroBuilder {
    private double saldoInicial = 0;

    public CajaDeAhorroBuilder conSaldoInicial(double saldo) {
        this.saldoInicial = saldo;
        return this;
    }

    public CajaDeAhorro build() {
        CajaDeAhorro cuenta = new CajaDeAhorro();
        cuenta.saldo = this.saldoInicial;
        return cuenta;
    }
}

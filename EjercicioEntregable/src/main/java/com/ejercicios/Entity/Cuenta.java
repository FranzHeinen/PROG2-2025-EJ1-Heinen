package com.ejercicios.Entity;

public abstract class Cuenta {

    public double saldo;
    protected int operaciones;

    public Cuenta(){
        this.saldo = 0;
        this.operaciones = 0;
    }
}

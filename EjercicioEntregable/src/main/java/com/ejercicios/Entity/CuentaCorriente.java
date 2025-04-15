package com.ejercicios.Entity;

public class CuentaCorriente extends Cuenta implements IGestionSaldo{

    private double giroDescubierto;

    public CuentaCorriente(double giroDescubierto){
        this.giroDescubierto = giroDescubierto;
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        if(monto > 0){
            saldo += monto;
            operaciones ++;
            return true;
        }
        return false;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if(monto > 0 && (saldo - monto ) >= -giroDescubierto){
            saldo -= monto;
            operaciones ++;
            return true;
        }
        return false;
    }

    @Override
    public double getSaldo() {
        operaciones++;
        return saldo;
    }

    @Override
    public int getOperaciones() {
        operaciones++;
        return operaciones;
    }
    public double getGiroDescubierto(){
        return giroDescubierto;
    }
}

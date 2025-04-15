package com.ejercicios.Entity;

public class CajaDeAhorro extends Cuenta implements IGestionSaldo{

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        if(monto > 0){
            saldo += monto;
            operaciones++;
            return true;
        }
        return false;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if(monto > 0 && saldo >= monto){
            saldo -= monto;
            operaciones++;
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
}

package com.ejercicios.Service;

import com.ejercicios.Entity.Cuenta;
import com.ejercicios.Entity.IGestionSaldo;

import java.util.ArrayList;
import java.util.List;

public class LogicaCuenta {

    private static LogicaCuenta logica;

    private static final Object objeto = new Object();

    private List<IGestionSaldo> cuentas;

    private LogicaCuenta() {
        cuentas = new ArrayList<>();
    }

    public static LogicaCuenta getInstancia() {
        if (logica == null) {
            synchronized (objeto) {
                if (logica == null) {
                    logica = new LogicaCuenta();
                }
            }
        }
        return logica;
    }

    public void agregarCuenta(IGestionSaldo cuenta) {
        cuentas.add(cuenta);
    }

    public boolean agregarSaldo(int id, double monto) {
        if (id >= 0 && id < cuentas.size()) {
            return cuentas.get(id).agregarSaldo(monto);
        }
        return false;
    }

    public boolean quitarSaldo(int id, double monto) {
        if (id >= 0 && id < cuentas.size()) {
            return cuentas.get(id).quitarSaldo(monto);
        }
        return false;
    }

    public double consultarSaldo(int id) {
        if (id >= 0 && id < cuentas.size()) {
            return cuentas.get(id).getSaldo();
        }
        return 0;}

    public int consultarOperaciones(int id) {
        if (id >= 0 && id < cuentas.size()) {
            return cuentas.get(id).getOperaciones();
        }
        return 0;
    }
}


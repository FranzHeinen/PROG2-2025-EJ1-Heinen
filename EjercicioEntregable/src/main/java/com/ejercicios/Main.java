package com.ejercicios;


import com.ejercicios.Entity.CajaDeAhorro;
import com.ejercicios.Entity.CuentaCorriente;
import com.ejercicios.Service.LogicaCuenta;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        LogicaCuenta logica = LogicaCuenta.getInstancia();
        Random random = new Random();

        for (int  i = 0; i < 10; i++){
            if(random.nextBoolean()){
                logica.agregarCuenta(new CajaDeAhorro());
            }else{
                logica.agregarCuenta(new CuentaCorriente(0));
            }
        }

        ExecutorService operacion = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++){
            operacion.execute(() -> {
                int id = random.nextInt(10);
                double monto = random.nextDouble() * 100;
                boolean bool = random.nextBoolean();

                if(bool){
                    logica.agregarSaldo(id, monto);
                }else{
                    logica.quitarSaldo(id, monto);
                }
            });
        }
        operacion.shutdown();
        while(!operacion.isTerminated()) {
        Thread.sleep(50);
        }

        for(int i = 0; i < 10; i++){
            double saldo = logica.consultarSaldo(i);
            int operaciones = logica.consultarOperaciones(i);
            System.out.println("Cuenta " + i + " Saldo: $" + saldo + " || Operaciones: " + operaciones);
        }
    }
}

package com.banco.modelo;

import com.banco.interfaz.OperacionesBancarias;
import java.util.ArrayList;

public abstract class CuentaBancaria implements OperacionesBancarias {
    protected String numeroCuenta;
    protected double saldo;
    protected ArrayList<Transaccion> historial;

    public CuentaBancaria(String numeroCuenta, double saldoInicial){
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
        this.historial = new ArrayList<>();
    }

    public String getNumeroCuenta(){
        return numeroCuenta;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    public void mostrarHistorial(){
        System.out.println("\n Historial de la cuenta: " +numeroCuenta);
        if(historial.isEmpty()){
            System.out.println("Sin transacciones registradas. ");
        }else {
            for (Transaccion t : historial){
                System.out.println("  -  " + t);
            }
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "Número='" + numeroCuenta + '\'' +
                ", Saldo=" + saldo +
                '}';
    }
}

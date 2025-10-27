package com.banco.modelo;

public class CuentaCorriente extends CuentaBancaria{
    private  double limiteSobregiro;

    public CuentaCorriente(String numeroCuenta, double saldoInicial, double limiteSobregiro){
        super(numeroCuenta, saldoInicial);
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            historial.add(new Transaccion("DEPÓSITO", monto));
        } else {
            System.out.println(" Monto inválido.");
        }
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo + limiteSobregiro) {
            saldo -= monto;
            historial.add(new Transaccion("RETIRO", monto));
        } else {
            System.out.println(" Excede el límite de sobregiro.");
        }
    }
}

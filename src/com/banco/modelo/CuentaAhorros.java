package com.banco.modelo;

public   class CuentaAhorros extends CuentaBancaria {
    private double tasaInteres;

    public CuentaAhorros(String numeroCuenta, double saldoInicial, double tasaInteres) {
        super(numeroCuenta, saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            historial.add(new Transaccion("Deposito", monto));
        } else {
            System.out.println(" Monto inválido.");
        }
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            historial.add(new Transaccion("Retiro", monto));
        } else {
            System.out.println(" Fondos insuficientes.");
        }
    }

    public void aplicarInteres() {
        double interes = saldo * tasaInteres;
        saldo += interes;
        historial.add(new Transaccion("INTERÉS", interes));
    }
}

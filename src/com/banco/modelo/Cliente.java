package com.banco.modelo;

import java.util.ArrayList;

public class Cliente {
    private String id;
    private String nombre;
    private ArrayList<CuentaBancaria> cuentas;


    public Cliente(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(CuentaBancaria cuenta){
        cuentas.add(cuenta);
    }

    public ArrayList<CuentaBancaria> getCuentas(){
        return cuentas;
    }

    public String getNombre(){
        return nombre;
    }

    public String getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ID='" + id + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Cuentas=" + cuentas.size() +
                '}';
    }

}

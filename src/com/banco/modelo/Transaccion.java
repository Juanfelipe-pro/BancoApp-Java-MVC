package com.banco.modelo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaccion {
    private String tipo;
    private double monto;
    private LocalDateTime fecha;


    public Transaccion(String tipo, double monto){
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + fecha.format(formato) + "] " + tipo + " $" + monto;
    }
}

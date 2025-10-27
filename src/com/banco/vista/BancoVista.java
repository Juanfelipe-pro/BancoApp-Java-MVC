package com.banco.vista;

import com.banco.modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BancoVista {
    private Scanner sc = new Scanner(System.in);

    public int menuPrincipal() {
        System.out.println("\n===== BANCO =====");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Crear cuenta");
        System.out.println("3. Listar clientes y cuentas");
        System.out.println("4. Operar cuenta");
        System.out.println("5. Ver historial");
        System.out.println("6. Salir");
        System.out.print("Selecciona opción: ");
        return sc.nextInt();
    }

    public String leerTexto(String mensaje) {
        System.out.println(mensaje);
        sc.nextLine();
        return sc.nextLine();
    }

    public double leerMonto(String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public void mostrarClientes(ArrayList<Cliente> clientes){
        System.out.println("\n=== CLIENTES ===");
        if (clientes.isEmpty()){
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes){
                System.out.println(c);
                for (CuentaBancaria cuenta : c.getCuentas()){
                    System.out.println("   ↳ " + cuenta);
                }
            }
        }
    }
}

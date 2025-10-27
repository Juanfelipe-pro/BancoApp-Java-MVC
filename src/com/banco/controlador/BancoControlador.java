package com.banco.controlador;

import com.banco.modelo.*;
import com.banco.vista.*;

public class BancoControlador {
    private Banco banco;
    private BancoVista vista;

    public BancoControlador(Banco banco, BancoVista vista) {
        this.banco = banco;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.menuPrincipal();

            switch (opcion) {
                case 1 -> registrarCliente();
                case 2 -> crearCuenta();
                case 3 -> vista.mostrarClientes(banco.getClientes());
                case 4 -> operarCuenta();
                case 5 -> verHistorial();
                case 6 -> {
                    vista.mostrarMensaje(" Gracias por usar " + banco.getNombre());
                    salir = true;
                }
                default -> vista.mostrarMensaje(" Opción inválida.");
            }
        }
    }

    private void registrarCliente() {
        String id = vista.leerTexto("ID del cliente: ");
        String nombre = vista.leerTexto("Nombre del cliente: ");
        if (banco.buscarCliente(id) != null) {
            vista.mostrarMensaje(" Ya existe un cliente con ese ID.");
            return;
        }
        banco.agregarCliente(new Cliente(id, nombre));
        vista.mostrarMensaje(" Cliente registrado.");
    }

    private void crearCuenta() {
        String idCliente = vista.leerTexto("ID del cliente: ");
        Cliente cliente = banco.buscarCliente(idCliente);
        if (cliente == null) {
            vista.mostrarMensaje(" Cliente no encontrado.");
            return;
        }

        vista.mostrarMensaje("1. Cuenta de Ahorros");
        vista.mostrarMensaje("2. Cuenta Corriente");
        int tipo = (int) vista.leerMonto("Tipo de cuenta: ");
        String numero = vista.leerTexto("Número de cuenta: ");
        double saldoInicial = vista.leerMonto("Saldo inicial: ");

        CuentaBancaria cuenta = switch (tipo) {
            case 1 -> new CuentaAhorros(numero, saldoInicial, 0.02);
            case 2 -> new CuentaCorriente(numero, saldoInicial, 500);
            default -> null;
        };

        if (cuenta == null) {
            vista.mostrarMensaje(" Tipo de cuenta inválido.");
            return;
        }

        cliente.agregarCuenta(cuenta);
        vista.mostrarMensaje("✅ Cuenta creada correctamente.");
    }

    private void operarCuenta() {
        String id = vista.leerTexto("ID del cliente: ");
        Cliente cliente = banco.buscarCliente(id);
        if (cliente == null) {
            vista.mostrarMensaje(" Cliente no encontrado.");
            return;
        }

        String num = vista.leerTexto("Número de cuenta: ");
        CuentaBancaria cuenta = cliente.getCuentas().stream()
                .filter(c -> c.getNumeroCuenta().equals(num))
                .findFirst().orElse(null);

        if (cuenta == null) {
            vista.mostrarMensaje(" Cuenta no encontrada.");
            return;
        }

        boolean volver = false;
        while (!volver) {
            vista.mostrarMensaje("\n=== OPERACIONES ===");
            vista.mostrarMensaje("1. Consultar saldo");
            vista.mostrarMensaje("2. Depositar");
            vista.mostrarMensaje("3. Retirar");
            vista.mostrarMensaje("4. Volver");
            int op = (int) vista.leerMonto("Opción: ");

            switch (op) {
                case 1 -> vista.mostrarMensaje(" Saldo: $" + cuenta.consultarSaldo());
                case 2 -> cuenta.depositar(vista.leerMonto("Monto a depositar: "));
                case 3 -> cuenta.retirar(vista.leerMonto("Monto a retirar: "));
                case 4 -> volver = true;
                default -> vista.mostrarMensaje(" Opción inválida.");
            }
        }
    }

    private void verHistorial() {
        String id = vista.leerTexto("ID del cliente: ");
        Cliente cliente = banco.buscarCliente(id);
        if (cliente == null) {
            vista.mostrarMensaje(" Cliente no encontrado.");
            return;
        }

        String num = vista.leerTexto("Número de cuenta: ");
        for (CuentaBancaria c : cliente.getCuentas()) {
            if (c.getNumeroCuenta().equals(num)) {
                c.mostrarHistorial();
                return;
            }
        }

        vista.mostrarMensaje(" Cuenta no encontrada.");
    }
}

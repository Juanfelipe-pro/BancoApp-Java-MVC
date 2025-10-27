package com.banco;

import com.banco.modelo.*;
import com.banco.vista.*;
import com.banco.controlador.*;

public class Main {
    public static void main(String[] args){
        Banco banco = new Banco("Banco IntelliJ");
        BancoVista vista = new BancoVista();
        BancoControlador controlador = new BancoControlador(banco, vista);
        controlador.iniciar();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea1_poo;

/**
 *
 * @author gerso
 */
public class Tarea1_POO {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        cuentaBancaria miCuenta = new cuentaBancaria("254a545454", "Gerson Fabian", 500);
        
        //miCuenta.saldo = 50000;
        //Error acceso privado ya que declaramos el estado de saldo como private, solo puede editarse
        //dentro de la clase donde fue creado
        
        System.out.println("Titular: "+miCuenta.titular);
        System.out.println("Numero de cuenta: "+miCuenta.numeroCuenta);
        System.out.println("Cuenta Ahorro");
        CuentaAhorro ahorro = new CuentaAhorro("956466646add46", "Armando Bronca", 3000,5);
        ahorro.retirarConComision(500);
        ahorro.retirarConComision(500);
        ahorro.retirarConComision(500);
        ahorro.retirarConComision(500);
        
        System.out.println("Saldo: "+ahorro.getSaldo());
        ahorro.aplicarInteresMensual();
        System.out.println("Saldo: "+ahorro.getSaldo());
        
        CuentaCorriente corriente = new CuentaCorriente("77777", "Lisa Perez", 1000,"Empresa No Fake", 5000);
        
        System.out.println("Cuenta Corriente");
        System.out.println("Saldo: "+corriente.getSaldo());
        corriente.retirarConSobregiro(3500);
        System.out.println("Saldo: "+corriente.getSaldo());
        System.out.println("Sobregiro: "+corriente.getSobregiroUtilizado());
        
        corriente.pagarSobregiro(500);
        System.out.println("Sobregiro: "+corriente.getSobregiroUtilizado());

        
        
    }
}

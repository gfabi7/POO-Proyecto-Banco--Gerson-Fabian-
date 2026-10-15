/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea1_poo;

/**
 *
 * @author gerso
 */
public class CuentaBancaria {
    public String numeroCuenta;
    public String titular;
    private double saldo;
    private int totalTransacciones =0;
    
    CuentaBancaria(String numeroCuenta, String titular, double saldoInicial){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        if(saldoInicial<0){
            saldoInicial = 0;
        }
        this.saldo = saldoInicial;
        
    }
   
    public double getSaldo(){
        return this.saldo;
    }
    
    public int getTotalTransacciones(){
    return this.totalTransacciones;
    }
    
    public void depositar(double monto){
        if(monto>0){
            this.saldo += monto;
            this.totalTransacciones +=1;
        }
        else{
            System.out.println("La cantidad del monto debe ser positiva");
        }
    }
    
    public boolean retirar(double monto){
        if(monto>0 && this.saldo>=monto){
            this.saldo -= monto;
            this.totalTransacciones +=1;
            return true;
        }
        
        
        System.out.println("Introduzca un valor válido");
           return false; 
        }
    
    public void mostrarDatos(){
        System.out.println("Titular:    "+this.titular);
        System.out.println("Número de Cuenta:    "+this.numeroCuenta);
        System.out.println("Saldo Actual:    "+this.saldo);
        System.out.println("Total de Transacciones:    "+this.totalTransacciones);
    }
    }
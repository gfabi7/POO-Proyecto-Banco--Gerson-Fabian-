/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea1_poo;

/**
 *
 * @author gerso
 */
public class CuentaCorriente extends CuentaBancaria {
     public String nombreEmpresa;
     private double limiteSobregiro;
     private double sobregiroUtilizado = 0.0;
     
     CuentaCorriente(String numeroCuenta, String titular, double saldoInicial,
             String nombreEmpresa, double limiteSobregiro){
         super(numeroCuenta, titular, saldoInicial);
         this.nombreEmpresa = nombreEmpresa;
         this.limiteSobregiro = limiteSobregiro;
     }
     
     public double getLimiteSobregiro(){
         return this.limiteSobregiro;
     }
     
     public double  getSobregiroUtilizado(){
         return this.sobregiroUtilizado;
     }
     
     public boolean retirarConSobregiro(double monto){
         if(this.getSaldo()>=monto){
             return this.retirar(monto);
             
         }
         
         double creditoDisponible = this.limiteSobregiro - this.sobregiroUtilizado;
         double dineroTotalDisponible = this.getSaldo() + creditoDisponible;
         
    if(monto>dineroTotalDisponible){
        System.out.println("Error: La operación excede el cupo de sobregiro autorizado.");
        return false;
             
         }
    double saldoTotal = this.getSaldo();
    double faltaPagarConSobregiro = monto - saldoTotal;
    
    double interesRecargo = faltaPagarConSobregiro*0.03;
    this.sobregiroUtilizado += (faltaPagarConSobregiro+interesRecargo);
    
    this.retirar(saldoTotal);
         System.out.println("Retiro Exitoso con sobregiro. Se aplico un recargo del 3%");
    
         return true;
     }
     public void pagarSobregiro(double monto){
         if(monto>this.sobregiroUtilizado){
             double sobraParaSaldo = monto - this.sobregiroUtilizado;
             this.depositar(sobraParaSaldo);
             this.sobregiroUtilizado = 0.0;
             
         }
         else{
             this.sobregiroUtilizado -= monto;
         }
     }
}

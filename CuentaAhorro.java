/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea1_poo;

/**
 *
 * @author gerso
 */
public class CuentaAhorro extends cuentaBancaria{
    public double tasaInsteresAnual;
    private int retirosRealizadosMes = 0;
    private double comisionPorExceso = 20.0;
    
    CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual){
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInsteresAnual = tasaInteresAnual;
    }
    
    public boolean retirarConComision(double monto){
        if(this.retirosRealizadosMes>=3){
            double montoTotal = monto+this.comisionPorExceso;
            
            boolean exito = super.retirar(montoTotal);
            if (exito){
                this.retirosRealizadosMes++;
                System.out.println("Se cobró un exceso de comision por exceso de: "+this.comisionPorExceso);
                return true;
            }
            return false;
        } else{
            boolean exito = super.retirar(monto);
        
        if (exito) {
            this.retirosRealizadosMes++;
            return true;
        }
        return false;
        }
    }
    
    public void aplicarInteresMensual(){
     double interesMes = (this.getSaldo()*(this.tasaInsteresAnual/100))/12;
     this.depositar(interesMes);
}
}


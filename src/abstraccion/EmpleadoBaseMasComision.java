/*
 * Demostración del uso de una clase de tipo abstracta.
 * Creado el: 24/07/2019 10:50 am.
 * Versión: 1.0.
 * Copyright (C) 2019 Ingeniero em Compuación Ricardo Presilla.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package abstraccion;

/**
 * Clase hija de la clase abstracta EmpleadoPorComision.
 * @author Ingeniero em Compuación Ricardo Presilla.
 * @version 1.0.
 */
public class EmpleadoBaseMasComision extends EmpleadoPorComision {
    /**Salario base por semana.*/
    private double salarioBase; 
    /**
     * Constructor.
     * @param primerNombre          Tipo String.
     * @param apellidoPaterno       Tipo String.      
     * @param numeroSeguroSosial    Tipo String.
     * @param ventasBrutas          Tipo double.
     * @param tarifaComision        Tipo double.
     * @param salarioBase           Tipo double.
     */
    public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno, 
            String numeroSeguroSosial, double ventasBrutas, 
            double tarifaComision, double salarioBase) {
        super(primerNombre, apellidoPaterno, numeroSeguroSosial, ventasBrutas, tarifaComision);
        if (salarioBase < 0.0) 
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");
        else
            this.salarioBase=salarioBase;
    }
    /**Establece el salario base.*/
    public void establecerSalarioBase(double salarioBase){
        if (salarioBase < 0.0) 
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");
        else
            this.salarioBase=salarioBase;
    }
    /**Obtiene el salario base.
     * @return Regresa un double con el salario base.
     */
    public double obtenerSalarioBase(){
        return this.salarioBase;
    }
    /**Sobre escribe el método de la clase padre.
     * @return Regresa un double.
     */
    @Override
    public double ingresos() {
        return obtenerSalarioBase() + super.ingresos();
    }
    /**
     * Permite generar una cadena de caracteres con la información del objeto de
     * tipo EmpleadoBaseMasComision.
     * @return Regresa una cadena de caracteres con la información del objeto de
     * tipo EmpleadoBaseMasComision.
     */
    @Override
    public String toString() {
        return String.format("%s %s; %s: $%,.2f", "con salario base", super.toString(),
            "salario base", obtenerSalarioBase());
    }
    
}

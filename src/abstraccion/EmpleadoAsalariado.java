/*
 * Demostración del uso de una clase de tipo abstracta.
 * Creado el: 24/07/2019 9:46 am.
 * Versión: 1.0.
 * 
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
 * Clase hija de la clase abstracta. La clase concreta EmpleadoAsalariado 
 * extiende a la clase abstracta Empleado.
 * @author Ingeniero em Compuación Ricardo Presilla.
 * @version 1.0.
 */
public class EmpleadoAsalariado extends Empleado {
    /**Atributos*/
    private double salarioSemanal;
    /**
     * Constructor.
     * @param primerNombre          Tipo String.
     * @param apellidoPaterno       Tipo String.      
     * @param numeroSeguroSosial    Tipo String.
     * @param salarioSemanal        Tipo double.
     */
    public EmpleadoAsalariado(String primerNombre, String apellidoPaterno, 
            String numeroSeguroSosial, double salarioSemanal) {
        super(primerNombre, apellidoPaterno, numeroSeguroSosial);
        if (salarioSemanal < 0.0)
            throw new IllegalArgumentException("El salario semanal debe ser >= 0.0");
        else
            this.salarioSemanal = salarioSemanal;
    }
    /**
     * Calcula los ingresos. Sobrescribe el método abstracto ingresos en 
     * Empleado.
     * @return 
     */
    @Override
    public double ingresos() {
        return obtenerSalarioSemanal();
    }
    /**
     * Establece el salario semanal.
     * @param salarioSemanal
     **/
    public void establecerSalarioSemanal(double salarioSemanal){
        if (salarioSemanal < 0.0)
            throw new IllegalArgumentException("El salario semanal debe ser >= 0.0");
        else
            this.salarioSemanal = salarioSemanal;
    }
    /**Devuelve el salario semanal.
     * @return .*/
    public double obtenerSalarioSemanal(){
        return this.salarioSemanal;
    }
    /** 
     * Devuelve representación String de un objeto EmpleadoAsalariado.
     * @return Cadena de caracteres con el contenido del objeto tipo 
     * EmpleadoAsalariado.
     */
    @Override
    public String toString() {
        return  String.format("Empleado asalariado: %s%n%s: $%,.2f",
                super.toString(), "salario semanal", obtenerSalarioSemanal());
    }
}

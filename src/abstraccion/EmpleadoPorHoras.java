/*
 * Demostración del uso de una clase de tipo abstracta.
 * Creado el: 24/07/2019 10:05 am.
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
 * Clase hija de la clase abstracta Empleado.
 * @author Ingeniero em Compuación Ricardo Presilla.
 * @version 1.0.
 */
public class EmpleadoPorHoras extends Empleado {
    /**Sueldo por hora*/
    private double sueldo; 
    /**Horas trabajadas por semana*/
    private double horas;
    /**
     * Constructor.
     * @param primerNombre          Tipo String.
     * @param apellidoPaterno       Tipo String.      
     * @param numeroSeguroSosial    Tipo String.
     * @param sueldo                Tipo double.
     * @param horas                 Tipo double.
     */
    public EmpleadoPorHoras(String primerNombre, String apellidoPaterno, 
            String numeroSeguroSosial, double sueldo, double horas) {
        super(primerNombre, apellidoPaterno, numeroSeguroSosial);
        if (sueldo < 0.0) // valida sueldo
            throw new IllegalArgumentException("El sueldo por horas debe ser >= 0.0");
        else
            this.sueldo = sueldo;
        if ((horas < 0.0) || (horas > 168.0)) // valida horas
            throw new IllegalArgumentException("Las horas trabajadas debe ser >= 0.0 y <= 168.0");
        else
            this.horas = horas;
    }
    /**
     * Calcula los ingresos.
     * @return Regresa un double con el calculo de los ingresos.
     */
    @Override
    public double ingresos() {
        if (obtenerHoras() <= 40) // no hay tiempo extra
            return obtenerSueldo() * obtenerHoras();
        else
            return 40 * obtenerSueldo() + (obtenerHoras() - 40) * obtenerSueldo() * 1.5;
    }
    /**Establece el sueldo.
     * @param sueldo    Tipo double.
     */
    public void establecerSueldo(double sueldo){
        if (sueldo < 0.0) // valida sueldo
            throw new IllegalArgumentException("El sueldo por horas debe ser >= 0.0");
        else
            this.sueldo = sueldo;
    }
    /**Obtiene el sueldo.
     * @return Regresa un double.
     */      
    public double obtenerSueldo(){
        return this.sueldo;
    }
    /**
     * Asigna las horas trabajadas.
     * @param horas Tipo double.
     */
    public void establecerHoras(double horas){
        if ((horas < 0.0) || (horas > 168.0)) // valida horas
            throw new IllegalArgumentException("Las horas trabajadas debe ser >= 0.0 y <= 168.0");
        else
            this.horas = horas;
    }
    /**
     * Obtiene las horas trabajadas.
     * @return Regresa un double.
     */
    public double obtenerHoras(){
        return this.horas;
    }

    @Override
    public String toString() {
        return String.format("empleado por horas: %s%n%s: $%,.2f; %s: %,.2f",
            super.toString(), "sueldo por hora", obtenerSueldo(),
            "horas trabajadas", obtenerHoras());
    }
    
}//fin de la clase EmpleadoPorHoras

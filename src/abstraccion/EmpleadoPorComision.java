/*
 * Demostración del uso de una clase de tipo abstracta.
 * Creado el: 24/07/2019 10:32 am.
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
public class EmpleadoPorComision extends Empleado {
    /**Ventas totales por semana.
     */
    private double ventasBrutas;
    /**Porcentaje de comisión.
     */
    private double tarifaComision;
    /**
     * Constructor.
     * @param primerNombre          Tipo String.
     * @param apellidoPaterno       Tipo String.      
     * @param numeroSeguroSosial    Tipo String.
     * @param ventasBrutas          Tipo double.
     * @param tarifaComision        Tipo double.
     */
    public EmpleadoPorComision(String primerNombre, String apellidoPaterno, 
            String numeroSeguroSosial, double ventasBrutas, double tarifaComision) {
        super(primerNombre, apellidoPaterno, numeroSeguroSosial);
        if (tarifaComision <= 0.0 || tarifaComision >= 1.0) // valida
            throw new IllegalArgumentException("La tarifa de comision debe ser > 0.0 y < 1.0");
        else
            this.tarifaComision=tarifaComision;
        if (ventasBrutas < 0.0)
            throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");
        else
            this.ventasBrutas=ventasBrutas;
    }
    /**Calcula los ingresos.
     * @return Regresa un double.
     */
    @Override
    public double ingresos() {
        return obtenerTarifaComision() * obtenerVentasBrutas();
    }
    /** Establece el monto de ventas brutas.
     * @param ventasBrutas Tipo double.
     */
    public void establecerVentasBrutas(double ventasBrutas){
        if (ventasBrutas < 0.0)
            throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");
        else
            this.ventasBrutas=ventasBrutas;
    }
    /**Devuelve el monto de ventas brutas.
     * @return Regresa un double con el monto de las ventas brutas.
     */
    public double obtenerVentasBrutas(){
        return this.ventasBrutas;
    }
    /**Establece la tarifa de comisión.
     * @param tarifaComision Tipo double.
     */
    public void establecerTarifaComision(double tarifaComision){
        if (tarifaComision <= 0.0 || tarifaComision >= 1.0) // valida
            throw new IllegalArgumentException("La tarifa de comision debe ser > 0.0 y < 1.0");
        else
            this.tarifaComision=tarifaComision;
    }
    /**Devuelve la tarifa de comisión.
     * @return Regresa un double.
     */
    public double obtenerTarifaComision(){
        return this.tarifaComision;
    }
    /**Devuelve representación String de un objeto EmpleadoPorComision.
     * @return Regresa una cadena de caracteres.
     */
    @Override
    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
            "empleado por comision", super.toString(),
            "ventas brutas", obtenerVentasBrutas(),
            "tarifa de comision", obtenerTarifaComision());
    }    
}// fin de la clase EmpleadoPorComision

/*
 * Demostración del uso de una clase de tipo abstracta.
 * Creado el: 24/07/2019 9:27 am.
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
 * Ejemplo de una clase de tipo abstracta.
 * @author Ingeniero em Compuación Ricardo Presilla.
 * @version 1.0.
 */
public abstract class Empleado {
    /**
     * Almacena el primer nombre.
     */
    private final String primerNombre;
    private final String apellidoPaterno;
    private final String numeroSeguroSosial;
    /**Constructor.
     * @param primerNombre          Tipo String.
     * @param apellidoPaterno       Tipo String.      
     * @param numeroSeguroSosial    Tipo String.
     */
    public Empleado(String primerNombre, String apellidoPaterno, String numeroSeguroSosial) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroSeguroSosial = numeroSeguroSosial;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getNumeroSeguroSosial() {
        return numeroSeguroSosial;
    }
    /**
     * Devuelve representación String de un objeto Empleado.
     * @return Regresa una cadena de caracteres con el contenido del objeto 
     * empleado.
     */
    @Override
    public String toString() {
        return String.format("%s %s%nnumero de seguro social: %s", 
                this.primerNombre, this.apellidoPaterno, 
                this.numeroSeguroSosial);
    }
    /** 
     * Método abstracto sobrescrito por las subclases concretas.
     * @return Regresa un valor double ó cero.
     */
    public abstract double ingresos(); // aquí no hay implementación 
}

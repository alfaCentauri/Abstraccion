/* 
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
 * Para ejecutar el programa.
 * @author Ingeniero em Compuación Ricardo Presilla.
 * @version 1.0.
 */
public class SistemaNominas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // crea objetos de las subclases
        EmpleadoAsalariado empleadoAsalariado=new EmpleadoAsalariado("John", "Smith", "111-11-1111", 800.00);
        EmpleadoPorHoras empleadoPorHoras =new EmpleadoPorHoras("Karen", "Price", "222-22-2222", 16.75, 40);
        EmpleadoPorComision empleadoPorComision =new EmpleadoPorComision("Sue", "Jones", "333-33-3333", 10000, .06);
        EmpleadoBaseMasComision empleadoBaseMasComision=new EmpleadoBaseMasComision("Bob", "Lewis", "444-44-4444", 5000, .04, 300);
        System.out.println("Empleados procesados por separado:");
        System.out.printf("%n%s%n%s: $%,.2f%n%n",
            empleadoAsalariado, "ingresos", empleadoAsalariado.ingresos());
        System.out.printf("%s%n%s: $%,.2f%n%n",
            empleadoPorHoras, "ingresos", empleadoPorHoras.ingresos());
        System.out.printf("%s%n%s: $%,.2f%n%n",
            empleadoPorComision, "ingresos", empleadoPorComision.ingresos());
        System.out.printf("%s%n%s: $%,.2f%n%n",
            empleadoBaseMasComision,
            "ingresos", empleadoBaseMasComision.ingresos());
        // crea un arreglo Empleado de cuatro elementos
        Empleado[] empleados = new Empleado[4];
        // inicializa el arreglo con objetos Empleado
        empleados[0] = empleadoAsalariado;
        empleados[1] = empleadoPorHoras;
        empleados[2] = empleadoPorComision;
        empleados[3] = empleadoBaseMasComision;
        System.out.println("Empleados procesados en forma polimorfica:\n");
        // procesa en forma genérica a cada elemento en el arreglo de empleados
        for (Empleado empleadoActual : empleados)
        {
            System.out.println(empleadoActual); // invoca a toString
            // determina si el elemento es un EmpleadoBaseMasComision
            if (empleadoActual instanceof EmpleadoBaseMasComision)
            {
                // conversión descendente de la referencia de Empleado
                // a una referencia de EmpleadoBaseMasComision
                EmpleadoBaseMasComision empleado =
                (EmpleadoBaseMasComision) empleadoActual;
                System.out.printf("el nuevo salario base con 10%% de aumento es: $%,.2f%n",
                empleado.obtenerSalarioBase());
            }//Fin if
            System.out.printf("ingresos $%,.2f%n%n", empleadoActual.ingresos());
        }//Fin for
        // obtiene el nombre del tipo de cada objeto en el arreglo de empleados
        for (int j = 0; j < empleados.length; j++)
            System.out.printf("El empleado %d es un %s%n", j,
            empleados[j].getClass().getName());
    }//Fin main
}//Fin clase SistemaNominas

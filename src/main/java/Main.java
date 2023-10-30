import dataBase.EstructuraDB;
import libs.Leer;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        String opcion;
        do {
            System.out.println("0. Salir \n" +
                    "1. CrearBD \n" +
                    "2. Crear tabla y datos inicio \n" +
                    "3. Introducir nuevo departamento \n" +
                    "4. Introducir nuevo empleado \n"
            );

            opcion = Leer.pedirCadena("Introduce una opción: ");

            switch (opcion) {
                case "0" -> {salir = true;}
                case "1" -> {
                    EstructuraDB.crearDB();}
                case "2" -> {
                    EstructuraDB.crearTablaDepartamentos(); EstructuraDB.crearTablaEmpleados();}
                /*case "3" -> {
                    PedirDatos.introducirNuevoDep();}
                case "4" -> {PedirDatos.introducirNuevoEmpleado();}*/
                default -> {System.out.println("La opcion seleccionada no existe");}
            }
        } while (!salir);
    }
}
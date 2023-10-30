package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPostgreSQL {
    //definimos como constantes los datos de la conexión a la base de datos
    private static final String URL = "jdbc:postgresql://localhost:8432"; //conector y localización
    private static final String USUARIO = "postgres";
    private static final String CLAVE = "admin";

    public static Connection conectar(String nombreBD) {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection((URL + "/" + nombreBD), USUARIO, CLAVE);
            System.out.println("Conexión OK.");
        } catch (SQLException e) {
            System.out.println("Error in the connection: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other error: " + e.getMessage());
        }
        return conexion;
    }
}



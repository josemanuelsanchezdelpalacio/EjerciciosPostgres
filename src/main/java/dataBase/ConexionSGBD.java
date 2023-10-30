package dataBase;

import java.lang.module.InvalidModuleDescriptorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSGBD {
    private static final String URL = "jdbc:postgresql://localhost:8432/";
    private static final String USUARIO = "postgres";
    private static final String CLAVE = "admin";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK.");
        }catch (SQLException e) {
            System.out.println("Error en la conexión" + e.getMessage());
        } catch (InvalidModuleDescriptorException e) {
            System.out.println("Error PAM");
        }

        return conexion;
    }
}
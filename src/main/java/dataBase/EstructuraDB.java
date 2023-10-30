package dataBase;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

import static dataBase.ConexionSGBD.conectar;

public class InsertarDatos {

    public static void crearDB(){
        try (Connection miCon = conectar()){
            //crear la base de datos
            Statement crearBD = miCon.createStatement();
            crearBD.executeUpdate("CREATE DATABASE basePostgres");
        } catch (SQLException e) {
            System.out.println("Error al conectar");
        }
    }

    public static void crearTablaDepartamentos() {
        try (Connection miCon = ConexionPostgreSQL.conectar("basepostgres")) {
            // Sentencias SQL para crear tabla departamentos
            String tablaDep = "CREATE TABLE departamentos (\n" +
                    " dept_no  SMALLINT NOT NULL PRIMARY KEY,\n" +
                    " dnombre  VARCHAR(15),\n" +
                    " loc      VARCHAR(15)\n" +
                    ")";

            // Sentencias SQL para añadir los valores de varios departamentos a la tabla
            List<String> addDeps = Arrays.asList(
                    "INSERT INTO departamentos VALUES (10,'CONTABILIDAD','SEVILLA')",
                    "INSERT INTO departamentos VALUES (20,'INVESTIGACIÓN','MADRID')",
                    "INSERT INTO departamentos VALUES (30,'VENTAS','BARCELONA')",
                    "INSERT INTO departamentos VALUES (40,'PRODUCCION','BILBAO')");

            try (Statement crearTablaDep = miCon.createStatement()) {
                // Borrado de las tablas antes de crearlas to avoid integrity violations
                crearTablaDep.executeUpdate("DROP TABLE IF EXISTS empleados");
                crearTablaDep.executeUpdate("DROP TABLE IF EXISTS departamentos");
                crearTablaDep.executeUpdate(tablaDep);

                for (String d : addDeps) {
                    crearTablaDep.executeUpdate(d);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void crearTablaEmpleados() {
        try (Connection miCon = ConexionPostgreSQL.conectar("basepostgres")) {
            // Crear tabla empleados
            String tablaEmp = "CREATE TABLE empleados (\n" +
                    " emp_no    SMALLINT NOT NULL PRIMARY KEY,\n" +
                    " apellido  VARCHAR(10),\n" +
                    " oficio    VARCHAR(10),\n" +
                    " dir       SMALLINT,\n" +
                    " fecha_alt DATE,\n" +
                    " salario   FLOAT,\n" +
                    " comision  FLOAT,\n" +
                    " dept_no   SMALLINT NOT NULL,\n" +
                    " CONSTRAINT FK_DEP FOREIGN KEY (dept_no) REFERENCES departamentos(dept_no)\n" +
                    ")";

            List<String> addEmps = Arrays.asList("INSERT INTO empleados VALUES (7369,'S NCHEZ','EMPLEADO',7902,'1990/12/17',1040,NULL,20)" ,
                    "INSERT INTO empleados VALUES (7499,'ARROYO','VENDEDOR',7698,'1990/02/20',1500,390,30)" ,
                    "INSERT INTO empleados VALUES (7521,'SALA','VENDEDOR',7698,'1991/02/22',1625,650,30)" ,
                    "INSERT INTO empleados VALUES (7566,'JIM NEZ','DIRECTOR',7839,'1991/04/02',2900,NULL,20)" ,
                    "INSERT INTO empleados VALUES (7654,'MART N','VENDEDOR',7698,'1991/09/29',1600,1020,30)" ,
                    "INSERT INTO empleados VALUES (7698,'NEGRO','DIRECTOR',7839,'1991/05/01',3005,NULL,30)" ,
                    "INSERT INTO empleados VALUES (7782,'CEREZO','DIRECTOR',7839,'1991/06/09',2885,NULL,10)" ,
                    "INSERT INTO empleados VALUES (7788,'GIL','ANALISTA',7566,'1991/11/09',3000,NULL,20)" ,
                    "INSERT INTO empleados VALUES (7839,'REY','PRESIDENTE',NULL,'1991/11/17',4100,NULL,10)" ,
                    "INSERT INTO empleados VALUES (7844,'TOVAR','VENDEDOR',7698,'1991/09/08',1350,0,30)" ,
                    "INSERT INTO empleados VALUES (7876,'ALONSO','EMPLEADO',7788,'1991/09/23',1430,NULL,20)" ,
                    "INSERT INTO empleados VALUES (7900,'JIMENO','EMPLEADO',7698,'1991/12/03',1335,NULL,30)" ,
                    "INSERT INTO empleados VALUES (7902,'FERN NDEZ','ANALISTA',7566,'1991/12/03',3000,NULL,20)" ,
                    "INSERT INTO empleados VALUES (7934,'MU OZ','EMPLEADO',7782,'1992/01/23',1690,NULL,10)");

            try (Statement crearTablaDep = miCon.createStatement()) {
                crearTablaDep.execute("DROP TABLE IF EXISTS empleados");
                crearTablaDep.executeUpdate(tablaEmp);

                for (String e : addEmps) {
                    crearTablaDep.execute(e);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
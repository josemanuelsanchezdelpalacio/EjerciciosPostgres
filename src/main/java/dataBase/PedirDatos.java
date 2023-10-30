package dataBase;

import javaBeans.Departamento;
import javaBeans.Empleado;
import libs.Leer;

import java.sql.*;

public class PedirDatos {

    public static void introducirNuevoEmpleado() {
        Empleado nuevoEmp = new Empleado();
        String nombreDep;
        Integer idDepRecuperado = 0;

        // Solicitar los datos del empleado
        nuevoEmp.setId_empleado(Leer.pedirEntero("Introduce ID empleado: "));
        nuevoEmp.setApellido(Leer.pedirCadena("Introduce apellido empleado: "));
        nuevoEmp.setOficio(Leer.pedirCadena("Introduce oficio empleado: "));
        nuevoEmp.setDir(Leer.pedirEntero("Introduce codigo director de empleado: "));
        nuevoEmp.setFecha_alta(Leer.pedirFecha("Introduce fecha alta empleado: ", "dd/MM/yy"));
        nuevoEmp.setSalario(Leer.pedirFloat("Introduce salario empleado: "));
        nuevoEmp.setComision(Leer.pedirFloat("Introduce comision empleado: "));
        nombreDep = Leer.pedirCadena("Introduce el nombre del departamento: ");

        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conexion = ConexionPostgreSQL.conectar("basepostgres")) {

            // Verificar si el departamento existe
            ps = conexion.prepareStatement("SELECT dept_no FROM departamentos WHERE dnombre = ?");
            ps.setString(1, nombreDep);
            rs = ps.executeQuery();
            if (rs.next()) {
                idDepRecuperado = rs.getInt("dept_no");
            } else {
                System.out.println("El departamento indicado no existe y el empleado no se insertará");
                return; // Salir del método si el departamento no existe
            }

            // Insertar el empleado en la base de datos
            ps = conexion.prepareStatement("INSERT INTO empleados (emp_no, apellido, dept_no, oficio, dir, fecha_alt, salario, comision) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, nuevoEmp.getId_empleado());
            ps.setString(2, nuevoEmp.getApellido());
            ps.setInt(3, idDepRecuperado);
            ps.setString(4, nuevoEmp.getOficio());
            ps.setInt(5, nuevoEmp.getDir());
            ps.setDate(6, new Date(nuevoEmp.getFecha_alta().getTime()));
            ps.setFloat(7, nuevoEmp.getSalario());
            ps.setFloat(8, nuevoEmp.getComision());
            ps.execute();

            System.out.println("Empleado insertado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al conectar o insertar empleado: " + e.getMessage());
        }
    }

    public static void introducirNuevoDep(){

        Departamento nuevoDep = new Departamento();

        nuevoDep.setId_departamento(Leer.pedirEntero("Introduce un ID dep: "));
        nuevoDep.setNombre(Leer.pedirCadena("Introduce un nombre dep: "));
        nuevoDep.setLocalidad(Leer.pedirCadena("Introduce una localidad dep: "));

        if (nuevoDep.getId_departamento() <= 0 || nuevoDep.getId_departamento() > 99) {
            System.out.println("El ID del departamento debe estar entre 1 y 99.");
            return;
        }
        if (nuevoDep.getNombre() == null || nuevoDep.getNombre().isEmpty() || nuevoDep.getNombre().length() > 15) {
            System.out.println("El nombre del departamento no es valida.");
            return;
        }
        if (nuevoDep.getLocalidad() == null || nuevoDep.getLocalidad().isEmpty() || nuevoDep.getLocalidad().length() > 15) {
            System.out.println("La localidad del departamento no es valida.");
            return;
        }

        try (Connection conexion = ConexionPostgreSQL.conectar("basepostgres")) {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO departamentos VALUES (?,?,?)");
            ps.setInt(1, nuevoDep.getId_departamento());
            ps.setString(2, nuevoDep.getNombre());
            ps.setString(3, nuevoDep.getLocalidad());
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Error al insertar el departamento: " + e.getMessage());
        }
    }
}

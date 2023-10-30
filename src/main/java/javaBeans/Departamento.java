package javaBeans;

import java.io.Serializable;

public class Departamento implements Serializable {

    private Integer id_departamento;
    private String nombre, localidad;

    public Departamento(Integer id_departamento, String nombre, String localidad) {
        this.id_departamento = id_departamento;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public Departamento() {}

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id_departamento=" + id_departamento +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}

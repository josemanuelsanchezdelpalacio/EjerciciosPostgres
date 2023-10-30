package javaBeans;

import java.io.Serializable;
import java.util.Date;

public class Empleado implements Serializable {

    private Integer id_empleado, director;
    private String apellido, oficio;
    private Date fecha_alta;
    private Float salario, comision;
    private Integer idDepartamento;

    public Empleado(Integer id_empleado, String apellido, String oficio, Integer director, Date fecha_alta, Float salario, Float comision, Integer idDepartamento) {
        this.id_empleado = id_empleado;
        this.apellido = apellido;
        this.oficio = oficio;
        this.director = director;
        this.fecha_alta = fecha_alta;
        this.salario = salario;
        this.comision = comision;
        this.idDepartamento = idDepartamento;
    }

    public Empleado() {}

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Integer getDir() {
        return director;
    }

    public void setDir(Integer director) {
        this.director = director;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id_empleado=" + id_empleado +
                ", apellido='" + apellido + '\'' +
                ", oficio='" + oficio + '\'' +
                ", director=" + director +
                ", fecha_alta=" + fecha_alta +
                ", salario=" + salario +
                ", comision=" + comision +
                ", idDepartamento=" + idDepartamento +
                '}';
    }
}

package model;

import java.time.LocalDate;

public class Prestamo {
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int idUsuario;
    private int idLibro;

    public Prestamo(){}

    public Prestamo(int id, LocalDate fechaInicio, LocalDate fechaFin, int idUsuario, int idLibro) {
        this.id = id;
        this.fechaInicio = LocalDate.now();
        this.fechaFin = LocalDate.now();
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
    }

    public Prestamo (LocalDate fechaInicio, LocalDate fechaFin, int idUsuario, int idLibro) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", idUsuario=" + idUsuario +
                ", idLibro=" + idLibro +
                '}';
    }
}

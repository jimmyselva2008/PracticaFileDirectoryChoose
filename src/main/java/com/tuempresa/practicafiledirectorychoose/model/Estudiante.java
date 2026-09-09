package com.tuempresa.practicafiledirectorychoose.model;

public class Estudiante {

    private String cif;
    private String nombreCompleto;
    private String carrera;
    private String correo;

    public Estudiante(String cif, String nombreCompleto, String carrera, String correo) {
        this.cif = cif;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
        this.correo = correo;
    }

    public String getCif() { return cif; }
    public void setCif(String cif) { this.cif = cif; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}

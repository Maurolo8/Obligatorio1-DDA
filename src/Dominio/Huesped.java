package Dominio;

import java.time.LocalDate;

public class Huesped {
    private int idHuesped;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String tipo_documento;
    private String num_documento;
    private LocalDate fecha_nacimineto;
    private String telefono;
    private String pais;

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public LocalDate getFecha_nacimineto() {
        return fecha_nacimineto;
    }

    public void setFecha_nacimineto(LocalDate fecha_nacimineto) {
        this.fecha_nacimineto = fecha_nacimineto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Huesped(int idHuesped, String nombre, String apaterno, String amaterno, String tipo_documento, String num_documento, LocalDate fecha_nacimineto, String telefono, String pais) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.fecha_nacimineto = fecha_nacimineto;
        this.telefono = telefono;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "idHuesped=" + idHuesped +
                ", nombre='" + nombre + '\'' +
                ", apaterno='" + apaterno + '\'' +
                ", amaterno='" + amaterno + '\'' +
                ", tipo_documento='" + tipo_documento + '\'' +
                ", num_documento='" + num_documento + '\'' +
                ", fecha_nacimineto=" + fecha_nacimineto +
                ", telefono='" + telefono + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}

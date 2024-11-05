package Dominio;

import java.time.LocalDate;

public class Reserva {

    private static int contId = 0;

    private int idReserva;
    private int idHotel;
    private int idHabitacion;
    private int idHuesped;
    private int cantidad_personas;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDate fechaRes;
    private String observacion;
    private boolean estado_pago;
    private boolean pagoCompleto;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public int getCantidad_personas() {
        return cantidad_personas;
    }

    public void setCantidad_personas(int cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public LocalDate getFechaRes() {
        return fechaRes;
    }

    public void setFechaRes(LocalDate fechaRes) {
        this.fechaRes = fechaRes;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean isEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(boolean estado_pago) {
        this.estado_pago = estado_pago;
    }

    public boolean isPagoCompleto() {
        return pagoCompleto;
    }

    public void setPagoCompleto(boolean pagoCompleto) {
        this.pagoCompleto = pagoCompleto;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", idHotel=" + idHotel +
                ", idHabitacion=" + idHabitacion +
                ", idHuesped=" + idHuesped +
                ", cantidad_personas=" + cantidad_personas +
                ", tipo='" + tipo + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", fechaRes=" + fechaRes +
                ", observacion='" + observacion + '\'' +
                ", estado_pago=" + estado_pago +
                ", pagoCompleto=" + pagoCompleto +
                '}';
    }

    public Reserva(int idHotel, int idHabitacion, int idHuesped, int cantidad_personas, String tipo,  LocalDate fechaRes, LocalDate fechaInicio, LocalDate fechaFin, String observacion, boolean estado_pago, boolean pagoCompleto) {
        this.idReserva = ++contId;
        this.idHotel = idHotel;
        this.idHabitacion = idHabitacion;
        this.idHuesped = idHuesped;
        this.cantidad_personas = cantidad_personas;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaRes = fechaRes;
        this.observacion = observacion;
        this.estado_pago = estado_pago;
        this.pagoCompleto = pagoCompleto;
    }
    public Reserva(int idReserva ,int idHotel, int idHabitacion, int idHuesped, int cantidad_personas, String tipo, LocalDate fechaRes, LocalDate fechaInicio, LocalDate fechaFin, String observacion, boolean estado_pago, boolean pagoCompleto) {
        this.idReserva = idReserva;
        this.idHotel = idHotel;
        this.idHabitacion = idHabitacion;
        this.idHuesped = idHuesped;
        this.cantidad_personas = cantidad_personas;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaRes = fechaRes;
        this.observacion = observacion;
        this.estado_pago = estado_pago;
        this.pagoCompleto = pagoCompleto;
    }
}


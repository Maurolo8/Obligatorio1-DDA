package Dominio;

import java.time.LocalDate;

public class Tarifa {
    private int idTarifa;
    private int idHotel;
    private LocalDate fechaVigencia;
    private Double monto;

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Tarifa(int idTarifa, int idHotel, LocalDate fechaVigencia, Double monto) {
        this.idTarifa = idTarifa;
        this.idHotel = idHotel;
        this.fechaVigencia = fechaVigencia;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "idTarifa=" + idTarifa +
                ", idHotel=" + idHotel +
                ", fechaVigencia=" + fechaVigencia +
                ", monto=" + monto +
                '}';
    }
}

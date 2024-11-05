package Dominio;

public class Habitacion {
    private int idHabitacion;
    private int idHotel;
    private int capacidadCamas;
    private int camasMatrimoniales;
    private boolean aireAcondicionado;
    private boolean balcon;
    private boolean vista;
    private String amenities;
    private String estado;

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public int getCapacidadCamas() {
        return capacidadCamas;
    }

    public void setCapacidadCamas(int capacidadCamas) {
        this.capacidadCamas = capacidadCamas;
    }

    public int getCamasMatrimoniales() {
        return camasMatrimoniales;
    }

    public void setCamasMatrimoniales(int camasMatrimoniales) {
        this.camasMatrimoniales = camasMatrimoniales;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isBalcon() {
        return balcon;
    }

    public void setBalcon(boolean balcon) {
        this.balcon = balcon;
    }

    public boolean isVista() {
        return vista;
    }

    public void setVista(boolean vista) {
        this.vista = vista;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Habitacion(int idHabitacion, int idHotel, int capacidadCamas, int camasMatrimoniales, boolean aireAcondicionado, boolean balcon, boolean vista, String amenities, String estado) {
        this.idHabitacion = idHabitacion;
        this.idHotel = idHotel;
        this.capacidadCamas = capacidadCamas;
        this.camasMatrimoniales = camasMatrimoniales;
        this.aireAcondicionado = aireAcondicionado;
        this.balcon = balcon;
        this.vista = vista;
        this.amenities = amenities;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "idHabitacion=" + idHabitacion +
                ", idHotel=" + idHotel +
                ", capacidadCamas=" + capacidadCamas +
                ", camasMatrimoniales=" + camasMatrimoniales +
                ", aireAcondicionado=" + aireAcondicionado +
                ", balcon=" + balcon +
                ", vista=" + vista +
                ", amenities='" + amenities + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

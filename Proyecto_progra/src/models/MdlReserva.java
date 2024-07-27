package models;

import java.sql.Date;

public class MdlReserva {
    private int idReserva;
    private int idVuelo;
    private int idPasajero;
    private int numeroAsiento;
    private int pesoEquipaje;
    private int costoTotal;
    private Date fechaReserva;

    public MdlReserva(int idReserva, int idVuelo, int idPasajero, int numeroAsiento, int pesoEquipaje, int costoTotal, Date fechaReserva) {
        this.idReserva = idReserva;
        this.idVuelo = idVuelo;
        this.idPasajero = idPasajero;
        this.numeroAsiento = numeroAsiento;
        this.pesoEquipaje = pesoEquipaje;
        this.costoTotal = costoTotal;
        this.fechaReserva = fechaReserva;
    }

    public MdlReserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public int getPesoEquipaje() {
        return pesoEquipaje;
    }

    public void setPesoEquipaje(int pesoEquipaje) {
        this.pesoEquipaje = pesoEquipaje;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}

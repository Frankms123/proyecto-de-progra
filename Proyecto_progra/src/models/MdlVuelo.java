package models;
public class MdlVuelo {
    private int ID_Vuelo;
    private int ID_Aeropuerto_Origen;
    private int ID_Aeropuerto_Destino;
    private int ID_Avion;
    private Date Fecha_Salida;
    private Date Fecha_Llegada;
    private int Distacia;
    private int Costo_Base;
    private int Capacidad_Disponible;

    public MdlVuelo(int ID_Vuelo, int ID_Aeropuerto_Origen, int ID_Aeropuerto_Destino, int ID_Avion, Date fecha_Salida, Date fecha_Llegada, int distacia, int costo_Base, int capacidad_Disponible) {
        this.ID_Vuelo = ID_Vuelo;
        this.ID_Aeropuerto_Origen = ID_Aeropuerto_Origen;
        this.ID_Aeropuerto_Destino = ID_Aeropuerto_Destino;
        this.ID_Avion = ID_Avion;
        this.Fecha_Salida = fecha_Salida;
        this.Fecha_Llegada = fecha_Llegada;
        this.Distacia = distacia;
        this.Costo_Base = costo_Base;
        this.Capacidad_Disponible = capacidad_Disponible;
    }

    public MdlVuelo() {
    }

    public int getID_Vuelo() {
        return ID_Vuelo;
    }

    public void setID_Vuelo(int ID_Vuelo) {
        this.ID_Vuelo = ID_Vuelo;
    }

    public int getID_Aeropuerto_Origen() {
        return ID_Aeropuerto_Origen;
    }

    public void setID_Aeropuerto_Origen(int ID_Aeropuerto_Origen) {
        this.ID_Aeropuerto_Origen = ID_Aeropuerto_Origen;
    }

    public int getID_Aeropuerto_Destino() {
        return ID_Aeropuerto_Destino;
    }

    public void setID_Aeropuerto_Destino(int ID_Aeropuerto_Destino) {
        this.ID_Aeropuerto_Destino = ID_Aeropuerto_Destino;
    }

    public int getID_Avion() {
        return ID_Avion;
    }

    public void setID_Avion(int ID_Avion) {
        this.ID_Avion = ID_Avion;
    }

    public Date getFecha_Salida() {
        return Fecha_Salida;
    }

    public void setFecha_Salida(Date fecha_Salida) {
        Fecha_Salida = fecha_Salida;
    }

    public Date getFecha_Llegada() {
        return Fecha_Llegada;
    }

    public void setFecha_Llegada(Date fecha_Llegada) {
        Fecha_Llegada = fecha_Llegada;
    }

    public int getDistacia() {
        return Distacia;
    }

    public void setDistacia(int distacia) {
        Distacia = distacia;
    }

    public int getCosto_Base() {
        return Costo_Base;
    }

    public void setCosto_Base(int costo_Base) {
        Costo_Base = costo_Base;
    }

    public int getCapacidad_Disponible() {
        return Capacidad_Disponible;
    }

    public void setCapacidad_Disponible(int capacidad_Disponible) {
        Capacidad_Disponible = capacidad_Disponible;
    }
}
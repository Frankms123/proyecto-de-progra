package models;

public class MdlAeropuerto {
    private int ID_Aeropuerto;
    private String nombre;
    private String ID_provincia;

    public MdlAeropuerto(int ID_Aeropuerto, String nombre, String ID_provincia) {
        this.ID_Aeropuerto = ID_Aeropuerto;
        this.nombre = nombre;
        this.ID_provincia = ID_provincia;
    }

    public MdlAeropuerto() {
    }

    public int getID_Aeropuerto() {
        return ID_Aeropuerto;
    }

    public void setID_Aeropuerto(int ID_Aeropuerto) {
        this.ID_Aeropuerto = ID_Aeropuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID_provincia() {
        return ID_provincia;
    }

    public void setID_provincia(String ID_provincia) {
        this.ID_provincia = ID_provincia;
    }
}

package models;
public class MdlPasajeros {
    private int id_pasajero;
    private String nombre_pasajero;
    private String primerApellido;
    private String segundoApellido;
    private date FechaNacimiento;
    private int Cedula;

    public MdlPasajeros(int id_pasajero, String nombre_pasajero, String primerApellido, String segundoApellido, date fechaNacimiento, int cedula) {
        this.id_pasajero = id_pasajero;
        this.nombre_pasajero = nombre_pasajero;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.FechaNacimiento = fechaNacimiento;
        this.Cedula = cedula;
    }

    public MdlPasajeros() {
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public String getNombre_pasajero() {
        return nombre_pasajero;
    }

    public void setNombre_pasajero(String nombre_pasajero) {
        this.nombre_pasajero = nombre_pasajero;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(date fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int cedula) {
        Cedula = cedula;
    }
}
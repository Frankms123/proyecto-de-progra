package models;

import java.sql.Date;

public class mdl_Persona {
    // Create the class attributes
    private int id;
    private int cedula;
    private String nombre;
    private String apell1;
    private String apell2;
    private Date fecNac;

    // Create the class constructor
    public mdl_Persona(int id, int cedula, String nombre, String apell1, String apell2, Date fecNac) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apell1 = apell1;
        this.apell2 = apell2;
        this.fecNac = fecNac;
    }

    // Create the class methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApell1() {
        return apell1;
    }

    public void setApell1(String apell1) {
        this.apell1 = apell1;
    }

    public String getApell2() {
        return apell2;
    }

    public void setApell2(String apell2) {
        this.apell2 = apell2;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }
}

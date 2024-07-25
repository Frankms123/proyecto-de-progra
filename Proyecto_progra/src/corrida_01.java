/*================================================================================================
Study Center....: Universidad Técnica Nacional
Campus..........: Pacífico (JRMP)
College career..: Ingeniería en Tecnologías de Información
Period..........: 2C-2024
Course..........: ITI-221 - Programación I
Document........: class_07 - corrida_01.java
Goals...........: Using JDBC to connect to a SQL Server database and execute a queries to:
                     - Connect to the database
                     - Apply CRUD operations
                          - Insert, Update, Delete records into / from a table
                          - Execute a query to retrieve all the records from a table
                     - Close the connection
Professor.......: Jorge Ruiz (york)
Student.........:
================================================================================================*/

// Call external libraries
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import controllers.ctrl_Persona;
import misc.functions;
import models.mdl_Persona;

public class corrida_01 {
    public static void main(String[] args) {

        // Create an instance of the ctrl_Persona class
        ctrl_Persona ctrlPer = new ctrl_Persona();

        // Create an instance of the misc.functions class
        functions funcs = new functions();

        // Try to insert a record into the table
        int cant = 15;
        for(int i = 0; i < cant; i++) {
            try {
                ctrlPer.add_Persona(new mdl_Persona(0, funcs.Cedula(),funcs.Nombre(),funcs.Apellido(),funcs.Apellido(),Date.valueOf(funcs.fecNac())));
                System.out.println("Record inserted...!\n");
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                i = i -1;
            }
        }

        // Try to update a record into the table
        /*try {
            ctrlPer.upd_Persona(new mdl_Persona(13, funcs.Cedula(),funcs.Nombre(),funcs.Apellido(),funcs.Apellido(),Date.valueOf(funcs.fecNac())));
            System.out.println("Record updated...!\n");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }*/

        // Try to delete a record from the table
        /*try {
            ctrlPer.del_Persona(13);
            System.out.println("Record deleted...!\n");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }*/

        // Try to retrieve all the records from the table
        try {
            ArrayList<mdl_Persona> personas = ctrlPer.get_Personas();
            System.out.println("Records retrieved...!\n");
            System.out.printf("%-5s | %-10s | %-15s | %-15s | %-15s | %-12s\n", "ID", "Cedula", "Nombre", "Apellido1", "Apellido2", "Nacido en");
            System.out.println("------+------------+-----------------+-----------------+-----------------+--------------");
            for(mdl_Persona persona : personas){
                System.out.printf("%-5d | %-10d | %-15s | %-15s | %-15s | %-12s", persona.getId(), persona.getCedula(), persona.getNombre(), persona.getApell1(), persona.getApell2(), persona.getFecNac());
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

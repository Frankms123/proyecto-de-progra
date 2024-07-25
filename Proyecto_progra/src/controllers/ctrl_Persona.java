package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connections.conex_MSSQL;


import models.mdl_Persona;

public class ctrl_Persona {
    // Create the connection variables
    conex_MSSQL conex = new conex_MSSQL();

    private String motor = "MSSQL";
    //private String motor = "MySQL";
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ArrayList<mdl_Persona> get_Personas() throws SQLException {
        ArrayList<mdl_Persona> personas;

        try {
            // Try to connect to the database and prepare the statement
            stmt = conex.toConnect().prepareStatement("select * from tb_Ejemplo");

            // Execute the statement
            rs = stmt.executeQuery();

            // Create an array list to store the records
            personas = new ArrayList<mdl_Persona>();

            // Iterate the result set
            while (rs.next()) {
                // Create an instance of the mdl_Persona class
                mdl_Persona persona = new mdl_Persona(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));

                // Add the instance to the array list
                personas.add(persona);
            }

            // Try to close
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }

        } catch (SQLException e) {
            throw new SQLException("Error: " + e.getMessage());
        } finally {
            // Try to disconnect from the database
            conex.toDisConnect();
        }
        return personas;
    }

    public void add_Persona(mdl_Persona persona) throws SQLException{
        String auxSql = "";
        try {
            if(motor.compareTo("MSSQL") == 0){
                // Try to connect to the database and prepare the statement
                auxSql = "exec ins_Ejemplo ?, ?, ?, ?, ?";
            } else if (motor.compareTo("MySQL") == 0) {
                auxSql = "call ins_Ejemplo(?, ?, ?, ?, ?)";
            }

            // Try to connect to the database and prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if(persona != null){
                stmt.setInt(1, persona.getCedula());
                stmt.setString(2, persona.getNombre());
                stmt.setString(3, persona.getApell1());
                stmt.setString(4, persona.getApell2());
                stmt.setDate(5, persona.getFecNac());

                // Execute the statement
                stmt.execute();
            }

            // Try to close
            if(stmt != null){
                stmt.close();
                stmt = null;
            }

        }catch (SQLException e){
            throw new SQLException("Error: " + e.getMessage());
        }finally{
            // Try to disconnect from the database
            conex.toDisConnect();
        }
    }

    public void upd_Persona(mdl_Persona persona) throws SQLException{
        String auxSql = "";
        try {
            if(motor.compareTo("MSSQL") == 0){
                // Try to connect to the database and prepare the statement
                auxSql = "exec upd_Ejemplo ?, ?, ?, ?, ?, ?";
            } else if (motor.compareTo("MySQL") == 0) {
                auxSql = "call upd_Ejemplo(?, ?, ?, ?, ?, ?)";
            }

            // Try to connect to the database and prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if(persona != null){
                stmt.setInt(1, persona.getId());
                stmt.setInt(2, persona.getCedula());
                stmt.setString(3, persona.getNombre());
                stmt.setString(4, persona.getApell1());
                stmt.setString(5, persona.getApell2());
                stmt.setDate(6, persona.getFecNac());

                // Execute the statement
                stmt.execute();
            }

            // Try to close
            if(stmt != null){
                stmt.close();
                stmt = null;
            }

        }catch (SQLException e){
            throw new SQLException("Error: " + e.getMessage());
        }finally{
            // Try to disconnect from the database
            conex.toDisConnect();
        }
    }

    public void del_Persona(int id) throws SQLException{
        String auxSql = "";
        try {
            if(motor.compareTo("MSSQL") == 0){
                // Try to connect to the database and prepare the statement
                auxSql = "exec del_Ejemplo ?";
            } else if (motor.compareTo("MySQL") == 0) {
                auxSql = "call del_Ejemplo(?)";
            }

            // Try to connect to the database and prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if(id > 0){
                stmt.setInt(1, id);

                // Execute the statement
                stmt.execute();
            }

            // Try to close
            if(stmt != null){
                stmt.close();
                stmt = null;
            }

        }catch (SQLException e){
            throw new SQLException("Error: " + e.getMessage());
        }finally{
            // Try to disconnect from the database
            conex.toDisConnect();
        }
    }

}

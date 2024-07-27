package controllers;
import models.MdlAvion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connections.conex_MSSQL;

public class CtrlAvion {
    // Create the connection variables
    ConexMSSQL conex = new ConexMSSQL();

    private String motor = "MSSQL";
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ArrayList<MdlAvion> getAviones() throws SQLException {
        ArrayList<MdlAvion> aviones;

        try {
            // Try to connect to the database and prepare the statement
            stmt = conex.toConnect().prepareStatement("SELECT * FROM Aviones");

            // Execute the statement
            rs = stmt.executeQuery();

            // Create an array list to store the records
            aviones = new ArrayList<MdlAvion>();

            // Iterate the result set
            while (rs.next()) {
                // Create an instance of the MdlAvion class
                MdlAvion avion = new MdlAvion(
                        rs.getInt(1), // ID_Avion
                        rs.getString(2), // Modelo
                        rs.getInt(3), // Capacidad_pasajeros
                        rs.getInt(4), // Capacidad_Carga
                        rs.getInt(5)  // Peso
                );

                // Add the instance to the array list
                aviones.add(avion);
            }

        } catch (SQLException e) {
            throw new SQLException("Error: " + e.getMessage());
        } finally {
            // Try to close
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            // Try to disconnect from the database
            conex.toDisConnect();
        }
        return aviones;
    }

    public void addAvion(MdlAvion avion) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC ins_Avion ?, ?, ?, ?, ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL ins_Avion(?, ?, ?, ?, ?)";
            }

            // Prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if (avion != null) {
                stmt.setInt(1, avion.getIdAvion());
                stmt.setString(2, avion.getModelo());
                stmt.setInt(3, avion.getCapacidadPasajeros());
                stmt.setInt(4, avion.getCapacidadCarga());
                stmt.setInt(5, avion.getPeso());

                // Execute the statement
                stmt.execute();
            }

        } catch (SQLException e) {
            throw new SQLException("Error: " + e.getMessage());
        } finally {
            // Try to close
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            // Try to disconnect from the database
            conex.toDisConnect();
        }
    }

    public void updateAvion(MdlAvion avion) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC upd_Avion ?, ?, ?, ?, ?, ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL upd_Avion(?, ?, ?, ?, ?, ?)";
            }

            // Prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if (avion != null) {
                stmt.setInt(1, avion.getIdAvion());
                stmt.setString(2, avion.getModelo());
                stmt.setInt(3, avion.getCapacidadPasajeros());
                stmt.setInt(4, avion.getCapacidadCarga());
                stmt.setInt(5, avion.getPeso());

                // Execute the statement
                stmt.execute();
            }

        } catch (SQLException e) {
            throw new SQLException("Error: " + e.getMessage());
        } finally {
            // Try to close
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            // Try to disconnect from the database
            conex.toDisConnect();
        }
    }

    public void deleteAvion(int id) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC del_Avion ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL del_Avion(?)";
            }

            // Prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if (id > 0) {
                stmt.setInt(1, id);

                // Execute the statement
                stmt.execute();
            }

        } catch (SQLException e) {
            throw new SQLException("Error: " + e.getMessage());
        } finally {
            // Try to close
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            // Try to disconnect from the database
            conex.toDisConnect();
        }
    }
}
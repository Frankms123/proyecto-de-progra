import models.MdlVuelo;
import java.sql.*;
import java.util.ArrayList;

public class CtrlVuelo {
    // Create the connection variables
    ConexMSSQL conex = new ConexMSSQL();

    private String motor = "MSSQL";
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ArrayList<MdlVuelo> getVuelos() throws SQLException {
        ArrayList<MdlVuelo> vuelos;

        try {
            // Try to connect to the database and prepare the statement
            stmt = conex.toConnect().prepareStatement("SELECT * FROM Vuelos");

            // Execute the statement
            rs = stmt.executeQuery();

            // Create an array list to store the records
            vuelos = new ArrayList<MdlVuelo>();

            // Iterate the result set
            while (rs.next()) {
                // Create an instance of the MdlVuelo class
                MdlVuelo vuelo = new MdlVuelo(
                        rs.getInt(1), // ID_Vuelo
                        rs.getInt(2), // ID_Aeropuerto_Origen
                        rs.getInt(3), // ID_Aeropuerto_Destino
                        rs.getInt(4), // ID_Avion
                        rs.getDate(5), // Fecha_Salida
                        rs.getDate(6), // Fecha_Llegada
                        rs.getInt(7), // Distacia
                        rs.getInt(8), // Costo_Base
                        rs.getInt(9)  // Capacidad_Disponible
                );

                // Add the instance to the array list
                vuelos.add(vuelo);
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
        return vuelos;
    }

    public void addVuelo(MdlVuelo vuelo) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC ins_Vuelo ?, ?, ?, ?, ?, ?, ?, ?, ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL ins_Vuelo(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            }

            // Prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if (vuelo != null) {
                stmt.setInt(1, vuelo.getID_Vuelo());
                stmt.setInt(2, vuelo.getID_Aeropuerto_Origen());
                stmt.setInt(3, vuelo.getID_Aeropuerto_Destino());
                stmt.setInt(4, vuelo.getID_Avion());
                stmt.setDate(5, vuelo.getFecha_Salida());
                stmt.setDate(6, vuelo.getFecha_Llegada());
                stmt.setInt(7, vuelo.getDistacia());
                stmt.setInt(8, vuelo.getCosto_Base());
                stmt.setInt(9, vuelo.getCapacidad_Disponible());

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

    public void updateVuelo(MdlVuelo vuelo) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC upd_Vuelo ?, ?, ?, ?, ?, ?, ?, ?, ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL upd_Vuelo(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            }

            // Prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if (vuelo != null) {
                stmt.setInt(1, vuelo.getID_Vuelo());
                stmt.setInt(2, vuelo.getID_Aeropuerto_Origen());
                stmt.setInt(3, vuelo.getID_Aeropuerto_Destino());
                stmt.setInt(4, vuelo.getID_Avion());
                stmt.setDate(5, vuelo.getFecha_Salida());
                stmt.setDate(6, vuelo.getFecha_Llegada());
                stmt.setInt(7, vuelo.getDistacia());
                stmt.setInt(8, vuelo.getCosto_Base());
                stmt.setInt(9, vuelo.getCapacidad_Disponible());

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

    public void deleteVuelo(int id) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC del_Vuelo ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL del_Vuelo(?)";
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

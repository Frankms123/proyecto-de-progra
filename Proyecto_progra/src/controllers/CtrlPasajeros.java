import models.MdlPasajeros;
import java.sql.*;
import java.util.ArrayList;

public class CtrlPasajeros {
    // Create the connection variables
    ConexMSSQL conex = new ConexMSSQL();

    private String motor = "MSSQL";
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ArrayList<MdlPasajeros> getPasajeros() throws SQLException {
        ArrayList<MdlPasajeros> pasajeros;

        try {
            // Try to connect to the database and prepare the statement
            stmt = conex.toConnect().prepareStatement("SELECT * FROM Pasajeros");

            // Execute the statement
            rs = stmt.executeQuery();

            // Create an array list to store the records
            pasajeros = new ArrayList<MdlPasajeros>();

            // Iterate the result set
            while (rs.next()) {
                // Create an instance of the MdlPasajeros class
                MdlPasajeros pasajero = new MdlPasajeros(
                        rs.getInt(1), // idPasajero
                        rs.getString(2), // nombrePasajero
                        rs.getString(3), // primerApellido
                        rs.getString(4), // segundoApellido
                        rs.getDate(5), // fechaNacimiento
                        rs.getInt(6)  // cedula
                );

                // Add the instance to the array list
                pasajeros.add(pasajero);
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
        return pasajeros;
    }

    public void addPasajero(MdlPasajeros pasajero) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC ins_Pasajero ?, ?, ?, ?, ?, ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL ins_Pasajero(?, ?, ?, ?, ?, ?)";
            }

            // Prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if (pasajero != null) {
                stmt.setInt(1, pasajero.getIdPasajero());
                stmt.setString(2, pasajero.getNombrePasajero());
                stmt.setString(3, pasajero.getPrimerApellido());
                stmt.setString(4, pasajero.getSegundoApellido());
                stmt.setDate(5, pasajero.getFechaNacimiento());
                stmt.setInt(6, pasajero.getCedula());

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

    public void updatePasajero(MdlPasajeros pasajero) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC upd_Pasajero ?, ?, ?, ?, ?, ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL upd_Pasajero(?, ?, ?, ?, ?, ?)";
            }

            // Prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if (pasajero != null) {
                stmt.setInt(1, pasajero.getIdPasajero());
                stmt.setString(2, pasajero.getNombrePasajero());
                stmt.setString(3, pasajero.getPrimerApellido());
                stmt.setString(4, pasajero.getSegundoApellido());
                stmt.setDate(5, pasajero.getFechaNacimiento());
                stmt.setInt(6, pasajero.getCedula());

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

    public void deletePasajero(int id) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC del_Pasajero ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL del_Pasajero(?)";
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

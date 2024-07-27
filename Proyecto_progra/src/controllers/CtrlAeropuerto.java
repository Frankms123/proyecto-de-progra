import models.MdlAeropuerto;
import java.sql.*;
import java.util.ArrayList;

public class CtrlAeropuerto {
    // Create the connection variables
    ConexMSSQL conex = new ConexMSSQL();

    private String motor = "MSSQL";
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ArrayList<MdlAeropuerto> getAeropuertos() throws SQLException {
        ArrayList<MdlAeropuerto> aeropuertos;

        try {
            // Try to connect to the database and prepare the statement
            stmt = conex.toConnect().prepareStatement("SELECT * FROM Aeropuertos");

            // Execute the statement
            rs = stmt.executeQuery();

            // Create an array list to store the records
            aeropuertos = new ArrayList<MdlAeropuerto>();

            // Iterate the result set
            while (rs.next()) {
                // Create an instance of the MdlAeropuerto class
                MdlAeropuerto aeropuerto = new MdlAeropuerto(
                        rs.getInt(1), // ID_Aeropuerto
                        rs.getString(2), // Nombre
                        rs.getString(3)  // ID_provincia
                );

                // Add the instance to the array list
                aeropuertos.add(aeropuerto);
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
        return aeropuertos;
    }

    public void addAeropuerto(MdlAeropuerto aeropuerto) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC ins_Aeropuerto ?, ?, ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL ins_Aeropuerto(?, ?, ?)";
            }

            // Prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if (aeropuerto != null) {
                stmt.setInt(1, aeropuerto.getID_Aeropuerto());
                stmt.setString(2, aeropuerto.getNombre());
                stmt.setString(3, aeropuerto.getID_provincia());

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

    public void updateAeropuerto(MdlAeropuerto aeropuerto) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC upd_Aeropuerto ?, ?, ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL upd_Aeropuerto(?, ?, ?)";
            }

            // Prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if (aeropuerto != null) {
                stmt.setInt(1, aeropuerto.getID_Aeropuerto());
                stmt.setString(2, aeropuerto.getNombre());
                stmt.setString(3, aeropuerto.getID_provincia());

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

    public void deleteAeropuerto(int id) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC del_Aeropuerto ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL del_Aeropuerto(?)";
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
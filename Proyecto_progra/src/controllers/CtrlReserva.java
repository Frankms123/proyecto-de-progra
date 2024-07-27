import models.MdlReserva;
import java.sql.*;
import java.util.ArrayList;
import models.*;

public class CtrlReserva {
    // Create the connection variables
    ConexMSSQL conex = new ConexMSSQL();

    private String motor = "MSSQL";
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public ArrayList<MdlReserva> getReservas() throws SQLException {
        ArrayList<MdlReserva> reservas;

        try {
            // Try to connect to the database and prepare the statement
            stmt = conex.toConnect().prepareStatement("SELECT * FROM Reservas");

            // Execute the statement
            rs = stmt.executeQuery();

            // Create an array list to store the records
            reservas = new ArrayList<MdlReserva>();

            // Iterate the result set
            while (rs.next()) {
                // Create an instance of the MdlReserva class
                MdlReserva reserva = new MdlReserva(
                        rs.getInt(1), // idReserva
                        rs.getInt(2), // idVuelo
                        rs.getInt(3), // idPasajero
                        rs.getInt(4), // numeroAsiento
                        rs.getInt(5), // pesoEquipaje
                        rs.getInt(6), // costoTotal
                        rs.getDate(7) // fechaReserva
                );

                // Add the instance to the array list
                reservas.add(reserva);
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
        return reservas;
    }

    public void addReserva(MdlReserva reserva) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC ins_Reserva ?, ?, ?, ?, ?, ?, ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL ins_Reserva(?, ?, ?, ?, ?, ?, ?)";
            }

            // Prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if (reserva != null) {
                stmt.setInt(1, reserva.getIdReserva());
                stmt.setInt(2, reserva.getIdVuelo());
                stmt.setInt(3, reserva.getIdPasajero());
                stmt.setInt(4, reserva.getNumeroAsiento());
                stmt.setInt(5, reserva.getPesoEquipaje());
                stmt.setInt(6, reserva.getCostoTotal());
                stmt.setDate(7, reserva.getFechaReserva());

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

    public void updateReserva(MdlReserva reserva) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC upd_Reserva ?, ?, ?, ?, ?, ?, ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL upd_Reserva(?, ?, ?, ?, ?, ?, ?)";
            }

            // Prepare the statement
            stmt = conex.toConnect().prepareStatement(auxSql);

            // Update the statement with the data
            if (reserva != null) {
                stmt.setInt(1, reserva.getIdReserva());
                stmt.setInt(2, reserva.getIdVuelo());
                stmt.setInt(3, reserva.getIdPasajero());
                stmt.setInt(4, reserva.getNumeroAsiento());
                stmt.setInt(5, reserva.getPesoEquipaje());
                stmt.setInt(6, reserva.getCostoTotal());
                stmt.setDate(7, reserva.getFechaReserva());

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

    public void deleteReserva(int id) throws SQLException {
        String auxSql = "";
        try {
            if (motor.equals("MSSQL")) {
                auxSql = "EXEC del_Reserva ?";
            } else if (motor.equals("MySQL")) {
                auxSql = "CALL del_Reserva(?)";
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
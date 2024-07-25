package connections;

// Call external libraries
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conex_MSSQL {
    private Connection conex = null;
    private ResultSet rs = null;
    private String dbURL = "jdbc:sqlserver://localhost\\SQLserver:1433;database=AeroTax;user=;password=frank";
    private String user = "sa";
    private String pass = "frank";

    public conex_MSSQL() {
    }

    public Connection toConnect() throws SQLException {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            this.conex = DriverManager.getConnection(this.dbURL, this.user, this.pass);
            if (this.conex != null) {
                this.conex.setAutoCommit(true);
                System.out.println("Connected to the database...!\n");
            }
        } catch (SQLException var2) {
            SQLException e = var2;
            throw new SQLException("Error: " + e.getMessage());
        }

        return this.conex;
    }

    public void toDisConnect() throws SQLException {
        try {
            if (this.rs != null) {
                this.rs.close();
            }

            if (this.conex != null) {
                this.conex.close();
            }

            System.out.println("Disconnected from the database...!\n");
        } catch (SQLException var2) {
            SQLException e = var2;
            System.out.println("Error: " + e.getMessage());
        }

    }
}
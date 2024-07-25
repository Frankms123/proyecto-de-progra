package connections;

// Call external libraries
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conex_MSSQL {
    // Create the connection variables
    private Connection conex = null;
    private ResultSet rs = null;

    // Create the connection string
    private String dbURL = "jdbc:sqlserver:package connections";


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
    };
    private String user = "sa";
    private String pass = "frank";

    // Create the connection method
    public Connection toConnect() throws SQLException {
        // Try to connect to the database
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            conex = DriverManager.getConnection(dbURL, user, pass);
            if (conex != null) {
                conex.setAutoCommit(true);
                System.out.println("Connected to the database...!\n");
            }
        }catch (SQLException e){
            throw new SQLException("Error: " + e.getMessage());
        }
        return conex;
    }

    // Create the disconnection method
    public void toDisConnect() throws SQLException{
        try {
            if (rs != null) {
                rs.close();
            }
            if (conex != null) {
                conex.close();
            }
            System.out.println("Disconnected from the database...!\n");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

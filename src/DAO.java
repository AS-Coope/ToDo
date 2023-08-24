import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// Access to the database is made via this class
public class DAO {

    public Connection connectToDb(String db, String user, String password) {
        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + db, user, password);

            if (conn != null) {
                System.out.println("Connection established with " + db + "!");
            } else {
                System.out.println("Connection to " + db + " was unsuccessful!");
            }
        } catch (Exception e) {
            System.out.println("Error connecting to the database! " + e);
        }

        return conn;
    }

    public void createTable(Connection conn, String db, String entity) {
        Statement stmt = null;

        try {
            String query = String.format("CREATE TABLE IF NOT EXISTS %s ("
                    + "tdid SERIAL, task VARCHAR(200), status BOOLEAN, PRIMARY KEY (tdid) );", entity);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Table '" + entity + "' has been created!");
        } catch (Exception e) {
            System.out.println("Error with this statement: " + e + "!");
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;

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
}

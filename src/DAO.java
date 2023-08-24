import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

    public void createTable(Connection conn, String entity) {
        Statement stmt = null;

        try {
            String query = String.format("CREATE TABLE IF NOT EXISTS %s ("
                    + "tdid SERIAL, task VARCHAR(200), status BOOLEAN, PRIMARY KEY (tdid) );", entity);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println(String.format("Table '%s' has been created!", entity));
        } catch (Exception e) {
            System.out.println("Error with this statement: " + e + "!");
        }
    }

    public void insertTodo(Connection conn, String entity, String task, boolean status) {
        Statement stmt = null;

        try {
            String query = String.format("INSERT INTO %s(task, status) VALUES ('%s', %s);", entity, task, status);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println(String.format("Todo: %s, Complete: %s, add to TABLE %s", task, status, entity));
        } catch (Exception e) {
            System.out.println("Error with this statement: " + e + "!");
        }
    }

    public void selectAll(Connection conn, String entity) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String query = String.format("SELECT * FROM %s;", entity);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("tdid") + " ");
                System.out.print(rs.getString("task") + " ");
                System.out.println(rs.getString("status"));
            }
        } catch (Exception e) {
            System.out.println("Error with this statement: " + e + "!");
        }
    }
}

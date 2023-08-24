import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {
        DAO dao = new DAO();
        Connection dbConn = dao.connectToDb("todo", "postgres", "password");
        dao.createTable(dbConn, "todo", "ToDo");
    }
}

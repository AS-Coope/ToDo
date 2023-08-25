import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {
        DAO dao = new DAO();
        Connection dbConn = dao.connectToDb("todo", "postgres", "password");

        MainMenu mMenu = new MainMenu(dbConn);
        mMenu.showMenu();
        // dao.createTable(dbConn, "ToDo");
        // dao.insertTodo(dbConn, "ToDo", "Create ToDo app", false);
        // dao.selectAll(dbConn, "ToDo");
    }
}

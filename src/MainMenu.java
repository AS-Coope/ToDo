import java.sql.Connection;
import java.util.Scanner;

public class MainMenu {

    // attributes
    DAO dao = new DAO();
    Connection conn;
    Scanner scan = new Scanner(System.in);

    int menuChoice = 0;
    int exitValue = 3;

    public MainMenu(Connection conn) {
        this.conn = conn;
    }

    // methods
    public void showMenu() {
        do {
            // user interface options
            System.out.println("| TODO APP |");
            System.out.println("| 1. View all ToDos");
            System.out.println("| 2. Create a ToDo");
            // future database related functions come here
            System.out.println(String.format("| %s. Exit ToDo App", exitValue));
            System.out.print("| Choice (Enter the number beside the option): ");

            menuChoice = scan.nextInt();
            scan.nextLine(); // consumes the newline character leftover from nextInt
            System.out.println("");

            // making the decision of what option to perform
            switch (menuChoice) {
                case 1:
                    viewTodo();
                    break;

                case 2:
                    createTodo();
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Invalid option (Choose the number associated with an option).");
                    System.out.println("");
                    break;
            }

        } while (menuChoice != exitValue);
    }

    public void viewTodo() {
        // note to self: proper access of static variable entityName through class
        // and not instance of the class
        System.out.println("| All ToDos:");
        dao.selectAll(this.conn, DAO.entityName);
        System.out.println("");
        showMenu();
    }

    public void createTodo() {
        // set up local variables
        String task;
        System.out.println("| Create a ToDo:");
        System.out.println("| Enter your ToDo: ");
        task = scan.nextLine();

        // adding ToDo to database
        dao.insertTodo(conn, DAO.entityName, task, false);
        System.out.println("");
        showMenu();
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private final String username;
    private final String password;
    private final String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    } 

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class RegistrationProgram {
    private Map<String, User> users; 
    private Scanner scanner;

    public RegistrationProgram() {
        this.users = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please try again.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String email = scanner.nextLine();

        User user = new User(username, password, email);
        users.put(username, user);

        System.out.println("Registration successful!");
    }

    public void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid password. Please try again.");
            }
        } else {
            System.out.println("Username not found. Please register first.");
        }
    }

    public void run() {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Done");

            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        RegistrationProgram program = new RegistrationProgram();
        program.run();
    }
}
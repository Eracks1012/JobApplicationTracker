import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        displayBanner();

        User loggedInUser = null;

        while (true) {
            if (loggedInUser == null) {
                displayDivider();
                System.out.println("[1] Register");
                System.out.println("[2] Login");
                System.out.println("[3] Exit");
                displayDivider();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        userManager.registerUser(username, password);
                        break;
                    case 2:
                        System.out.print("Enter username: ");
                        username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        password = scanner.nextLine();
                        loggedInUser = userManager.loginUser(username, password);
                        if (loggedInUser != null) {
                            userManager.checkReminders(loggedInUser);
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        displayErrorMessage("Invalid option. Please try again.");
                }
            } else {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        userManager.displayDashboard(loggedInUser);
                        break;
                    case 2:
                        userManager.addJobApplication(loggedInUser);
                        break;
                    case 3:
                        userManager.updateJobApplicationStatus(loggedInUser);
                        break;
                    case 4:
                        userManager.setReminder(loggedInUser);
                        break;
                    case 5:
                        userManager.generateReport(loggedInUser);
                        break;
                    case 6:
                        loggedInUser = null;
                        displaySuccessMessage("Logged out successfully!");
                        break;
                    default:
                        displayErrorMessage("Invalid option. Please try again.");
                }
            }
        }
    }

    public static void displayBanner() {
        System.out.println("********************************************");
        System.out.println("*           JOB APPLICATION TRACKER        *");
        System.out.println("********************************************");
        System.out.println("*      Track and Manage Your Job Search     *");
        System.out.println("********************************************\n");
    }

    public static void displayDivider() {
        System.out.println("============================================");
    }

    public static void displayMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("[1] View Dashboard");
        System.out.println("[2] Add Job Application");
        System.out.println("[3] Update Job Application Status");
        System.out.println("[4] Set Reminder for Job Application");
        System.out.println("[5] Generate Report and Analytics");
        System.out.println("[6] Logout");
        System.out.print("Enter your choice: ");
    }

    public static void displaySuccessMessage(String message) {
        System.out.println("\n*** " + message + " ***\n");
    }

    public static void displayErrorMessage(String message) {
        System.out.println("\n!!! " + message + " !!!\n");
    }
}


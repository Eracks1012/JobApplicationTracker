import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserManager{

    //Data Field (List of User Objects)
    private List<User> users;

    //Constructor
    public UserManager(){
        this.users = new ArrayList<>();
    }

    //Register a new user
    public void registerUser(String username, String password) {
        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("User registered successfully!");
        System.out.println("");
    }

    //User log in
    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!");
                return user;
            }
        }
        System.out.println("Invalid username or password.");
        System.out.println("");
        return null;
    }

    //Display User dashboard
    public void displayDashboard(User user) {
        System.out.println("");
        System.out.println("Welcome " + user.getUsername() + "!");
        System.out.println("Your Job Applications:");
        List<JobApplication> applications = user.getJobApplications();
        if (applications.isEmpty()) {
            System.out.println("No job applications found.");
        } else {
            for (JobApplication application : applications) {
                System.out.println(application.toString());
                System.out.println("----------------------");
            }
        }
    }

    //Create and add job application object
    public void addJobApplication(User user){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Company Name: ");
        String companyName = scanner.nextLine();

        System.out.print("Enter Job Title: ");
        String jobTitle = scanner.nextLine();

        System.out.print("Enter Date of Application (yyyy-mm-dd): ");
        String dateString = scanner.nextLine();
        Date applicationDate = null;
        try {
            applicationDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-mm-dd.");
            return;
        }

        System.out.print("Enter Job Description: ");
        String jobDescription = scanner.nextLine();

        System.out.print("Enter Application Status: ");
        String applicationStatus = scanner.nextLine();

        System.out.print("Enter Contact Information: ");
        String contactInformation = scanner.nextLine();

        JobApplication jobApplication = new JobApplication(companyName, jobTitle, applicationDate, jobDescription, applicationStatus, contactInformation);
        user.addJobApplication(jobApplication);

        System.out.println("Job application added successfully!");
    }

    // Method to update the status of a job application
    public void updateJobApplicationStatus(User user) {
        Scanner scanner = new Scanner(System.in);
        List<JobApplication> applications = user.getJobApplications();

        if (applications.isEmpty()) {
            System.out.println("No job applications found.");
            return;
        }

        System.out.println("Select a job application to update:");
        for (int i = 0; i < applications.size(); i++) {
            System.out.println((i + 1) + ". " + applications.get(i).getJobTitle() + " at " + applications.get(i).getCompanyName());
        }

        System.out.print("Enter the number of the application: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice < 1 || choice > applications.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        JobApplication selectedApplication = applications.get(choice - 1);

        System.out.print("Enter the new status (e.g., applied, interview scheduled, offer received, rejected): ");
        String newStatus = scanner.nextLine();

        selectedApplication.setApplicationStatus(newStatus);
        System.out.println("Application status updated successfully!");
        System.out.println("Updated Application Details:");
        System.out.println(selectedApplication);
    }

    // Method to set a reminder for a job application
    public void setReminder(User user) {
        Scanner scanner = new Scanner(System.in);
        List<JobApplication> applications = user.getJobApplications();

        if (applications.isEmpty()) {
            System.out.println("No job applications found.");
            return;
        }

        System.out.println("Select a job application to set a reminder for:");
        for (int i = 0; i < applications.size(); i++) {
            System.out.println((i + 1) + ". " + applications.get(i).getJobTitle() + " at " + applications.get(i).getCompanyName());
        }

        System.out.print("Enter the number of the application: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice < 1 || choice > applications.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        JobApplication selectedApplication = applications.get(choice - 1);

        System.out.print("Enter the reminder date and time (yyyy-MM-dd HH:mm): ");
        String dateString = scanner.nextLine();
        Date reminderDate = null;
        try {
            reminderDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd HH:mm.");
            return;
        }

        selectedApplication.setReminderDate(reminderDate);
        System.out.println("Reminder set successfully!");
        System.out.println("Updated Application Details:");
        System.out.println(selectedApplication);
    }

    // Method to check for upcoming reminders
    public void checkReminders(User user) {
        Date now = new Date();
        List<JobApplication> applications = user.getJobApplications();

        for (JobApplication application : applications) {
            if (application.getReminderDate() != null && application.getReminderDate().before(now)) {
                System.out.println("Reminder: Follow up on your application for " + application.getJobTitle() + " at " + application.getCompanyName());
                // Clear the reminder after notifying the user
                application.setReminderDate(null);
            }
        }
    }

    // Method to generate reports and analytics
    public void generateReport(User user) {
        List<JobApplication> applications = user.getJobApplications();
        if (applications.isEmpty()) {
            System.out.println("No job applications found. No report generated.");
            return;
        }

        int totalApplications = applications.size();
        int interviews = 0;
        int offers = 0;
        int rejections = 0;

        Map<String, Integer> statusCounts = new HashMap<>();
        for (JobApplication application : applications) {
            String status = application.getApplicationStatus().toLowerCase();
            statusCounts.put(status, statusCounts.getOrDefault(status, 0) + 1);

            switch (status) {
                case "interview scheduled":
                    interviews++;
                    break;
                case "offer received":
                    offers++;
                    break;
                case "rejected":
                    rejections++;
                    break;
            }
        }

        System.out.println("Job Search Report:");
        System.out.println("------------------------------");
        System.out.println("Total Applications Submitted: " + totalApplications);
        System.out.println("Interviews Scheduled: " + interviews);
        System.out.println("Offers Received: " + offers);
        System.out.println("Rejections: " + rejections);
        System.out.println("------------------------------");
        System.out.println("Detailed Status Breakdown:");
        for (Map.Entry<String, Integer> entry : statusCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("------------------------------");
    }
}

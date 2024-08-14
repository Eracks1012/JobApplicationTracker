import java.util.List;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private List<JobApplication> jobApplications; 

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.jobApplications = new ArrayList<>(); 
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<JobApplication> getJobApplications() { 
        return jobApplications;
    }

    public void addJobApplication(JobApplication jobApplication) { 
        this.jobApplications.add(jobApplication);
    }

    @Override
    public String toString() {
        return "Username: " + username + "\n" +
               "Password: " + password + "\n" +
               "Job Applications: " + jobApplications.size() + " applications";
    }
}


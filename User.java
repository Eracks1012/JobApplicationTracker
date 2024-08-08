public class User {
    private int userID;
    private String username;
    private String password;
    private String email;
    private String profileDetails;
    private List<JobApplication> dashboard;

    // Constructor
    public User(int userID, String username, String password, String email, String profileDetails) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.profileDetails = profileDetails;
        this.dashboard = new ArrayList<>();
    }

    // Methods
    public void register() {
        System.out.println("User registered successfully.");
    }

    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Login failed. Invalid credentials.");
            return false;
        }
    }

    public void updateProfile(String newDetails) {
        this.profileDetails = newDetails;
        System.out.println("Profile updated successfully.");
    }

    public List<JobApplication> viewDashboard() {
        return dashboard;
    }

    public void addJobApplication(JobApplication application) {
        dashboard.add(application);
        System.out.println("Job application added successfully.");
    }

    public void removeJobApplication(int applicationID) {
        dashboard.removeIf(app -> app.getApplicationID() == applicationID);
        System.out.println("Job application removed successfully.");
    }
}

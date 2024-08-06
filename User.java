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
        // Implementation here
    }

    public void login() {
        // Implementation here
    }

    public void updateProfile(String newDetails) {
        // Implementation here
    }

    public List<JobApplication> viewDashboard() {
        return dashboard;
    }
}

public class Application{
    private int applicationID;
    private String companyName;
    private String jobTitle;
    private String dateOfApplication;
    private String jobDescription;
    private String applicationStatus;
    private String contactInformation;

    // Constructor
    public Application(int applicationID, String companyName, String jobTitle, String dateOfApplication, String jobDescription, String applicationStatus, String contactInformation) {
        this.applicationID = applicationID;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.dateOfApplication = dateOfApplication;
        this.jobDescription = jobDescription;
        this.applicationStatus = applicationStatus;
        this.contactInformation = contactInformation;
    }

    // Methods
    public void addApplication() {
    }

    public void updateStatus(String newStatus){
        this.applicationStatus = newStatus;
    }

    public void setReminder(Reminder reminder) {
    }

    public String getApplicationDetails() {
        return companyName + " - " + jobTitle;
    }
}

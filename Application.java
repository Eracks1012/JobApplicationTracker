import java.util.ArrayList;
import java.util.List;

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
        System.out.println("Application added: " + getApplicationDetails());
    }

    public void updateStatus(String newStatus){
        this.applicationStatus = newStatus;
        System.out.println("Application status updated to: " + newStatus);
    }

    public void setReminder(Reminder reminder) {
        reminders.add(reminder);
        System.out.println("Reminder set for application: " + getApplicationDetails());
    }

    public String getApplicationDetails() {
        return companyName + " - " + jobTitle;
    }

    //getters and setters
    public int getApplicationID() {
        return applicationID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDateOfApplication() {
        return dateOfApplication;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    // Setters for updating private fields
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDateOfApplication(String dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}

import java.util.Date;

public class JobApplication {
    private String companyName;
    private String jobTitle;
    private Date applicationDate;
    private String jobDescription;
    private String applicationStatus;
    private String contactInformation;
    private Date reminderDate;  

    // Constructor
    public JobApplication(String companyName, String jobTitle, Date applicationDate, 
                          String jobDescription, String applicationStatus, String contactInformation) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.applicationDate = applicationDate;
        this.jobDescription = jobDescription;
        this.applicationStatus = applicationStatus;
        this.contactInformation = contactInformation;
        this.reminderDate = null;  
    }

    // Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    // Visual representation of application status
    public String getStatusVisual() {
        switch (applicationStatus.toLowerCase()) {
            case "applied":
                return "[Applied] ---------- Interview Scheduled ---------- Offer Received ---------- Rejected";
            case "interview scheduled":
                return "Applied ---------- [Interview Scheduled] ---------- Offer Received ---------- Rejected";
            case "offer received":
                return "Applied ---------- Interview Scheduled ---------- [Offer Received] ---------- Rejected";
            case "rejected":
                return "Applied ---------- Interview Scheduled ---------- Offer Received ---------- [Rejected]";
            default:
                return "[Status Unknown]";
        }
    }

    @Override
    public String toString() {
        return "Company: " + companyName + "\n" +
               "Job Title: " + jobTitle + "\n" +
               "Application Date: " + applicationDate + "\n" +
               "Description: " + jobDescription + "\n" +
               "Status: " + applicationStatus + "\n" +
               "Contact Info: " + contactInformation + "\n" +
               "Reminder Date: " + (reminderDate != null ? reminderDate : "No reminder set") + "\n" +
               "Progress: " + getStatusVisual();
    }
}

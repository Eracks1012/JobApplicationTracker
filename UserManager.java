public class Reminder {
    private int reminderID;
    private int applicationID;
    private String reminderDate;
    private String reminderMessage;

    // Constructor
    public Reminder(int reminderID, int applicationID, String reminderDate, String reminderMessage) {
        this.reminderID = reminderID;
        this.applicationID = applicationID;
        this.reminderDate = reminderDate;
        this.reminderMessage = reminderMessage;
    }

    // Methods
    public void setReminder(Date newReminderDate, String newReminderMessage) {
        this.reminderDate = newReminderDate;
        this.reminderMessage = newReminderMessage;
        System.out.println("Reminder set for application ID: " + applicationID + " on " + reminderDate);
    }

    public String getReminderDetails() {
        return "Reminder ID: " + reminderID + ", Application ID: " + applicationID +
               ", Date: " + reminderDate + ", Message: " + reminderMessage;
    }

    public void deleteReminder() {
        // Logic to delete the reminder from the system
        System.out.println("Reminder deleted for application ID: " + applicationID);
    }

    // Getters for the private fields
    public int getReminderID() {
        return reminderID;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public String getReminderMessage() {
        return reminderMessage;
    }

    // Setters for the private fields
    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public void setReminderMessage(String reminderMessage) {
        this.reminderMessage = reminderMessage;
    }

}

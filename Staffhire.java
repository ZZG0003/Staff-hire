
/**
 * This is a superclass to store the common information of its subclasses FullTimeStaffHire and PartTimeStaffHire
 *
 * @author (24006405)
 * @version (1.0.0)
 */
public class Staffhire
{
    private int vacancyNumber;
    private String designation;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;

    
    /**
     * Constructor for objects of class Staffhire
     */
    public Staffhire(
        int newVacancyNumber,
        String newDesignation,
        String newJobType,
        String newStaffName,
        String newJoiningDate,
        String newQualification,
        String newAppointedBy,
        boolean newJoined
    )
    {
        // initialise instance variables
        vacancyNumber = newVacancyNumber;
        designation = newDesignation;
        jobType = newJobType;
        staffName = newStaffName;
        joiningDate = newJoiningDate;
        qualification = newQualification;
        appointedBy = newAppointedBy;
        joined = newJoined;
        System.out.println("Staffhire constructor");
    }
    
    /**
     * Setters and Getters for all the private variables
     */
    public void SetVacancyNumber(int newVacancyNumber){
        vacancyNumber = newVacancyNumber;
    }
        
    public int GetVacancyNumber(){
        return vacancyNumber;
    }
    
    public void SetDesignation(String newDesignation){
        designation = newDesignation;
    }
        
    public String GetDesignation(){
        return designation;
    }

    public void SetJobType(String newJobType){
        jobType = newJobType;
    }
        
    public String GetJobType(){
        return jobType;
    }
    
    public void SetStaffName(String newStaffName){
        staffName = newStaffName;
    }
        
    public String GetStaffName(){
        return staffName;
    }

    public void SetJoiningDate(String newJoiningDate){
        joiningDate = newJoiningDate;
    }
        
    public String GetJoiningDate(){
        return joiningDate;
    }
    
    public void SetQualification(String newQualification){
        qualification = newQualification;
    }
        
    public String GetQualification(){
        return qualification;
    }
    
    public void SetAppointedBy(String newAppointedBy){
        appointedBy = newAppointedBy;
    }
        
    public String GetAppointedBy(){
        return appointedBy;
    }
    
    public void SetJoined(boolean newJoined){
        joined = newJoined;
    }
        
    public boolean GetJoined(){
        return joined;
    }
    
}

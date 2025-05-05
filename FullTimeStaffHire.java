
/**
 * This is a subclass of Staffhire for full time staff
 *
 * @author (24006403)
 * @version (1.0.0)
 */
public class FullTimeStaffHire extends Staffhire
{
    private double salary;
    private int weeklyFractionalHours;
    
    /**
     * Constructor for objects of class Staffhire
     */
    public FullTimeStaffHire(
        int newVacancyNumber,
        String newDesignation,
        String newJobType,
        String newStaffName,
        String newJoiningDate,
        String newQualification,
        String newAppointedBy,
        boolean newJoined,
        double newSalary,
        int newWeeklyFractionalHours
    )
    {
         // initialise instance variables
         super(newVacancyNumber, newDesignation, newJobType, newStaffName, newJoiningDate, newQualification, newAppointedBy, newJoined);
         salary = newSalary;
         weeklyFractionalHours = newWeeklyFractionalHours;
    }
    
    /**
     * Setters and Getters for all the private variables
     */
    
    public void SetSalary(double newSalary){
        salary = newSalary;
    }
        
    public double GetSalary(){
        return salary;
    }
    
    public void SetWeeklyFractionalHours(int newWeeklyFractionalHours){
        weeklyFractionalHours = newWeeklyFractionalHours;
    }
        
    public int GetWeeklyFractionalHours(){
        return weeklyFractionalHours;
    }

}

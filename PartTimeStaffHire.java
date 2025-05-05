
/**
 * This is a subclass of Staffhire for part time staff
 *
 * @author (24006403)
 * @version (1.0.0)
 */
public class PartTimeStaffHire extends Staffhire
{
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;
    
    public PartTimeStaffHire(
        int newVacancyNumber,
        String newDesignation,
        String newJobType,
        String newStaffName,
        String newJoiningDate,
        String newQualification,
        String newAppointedBy,
        boolean newJoined,
        int newWorkingHour,
        double newWagesPerHour,
        String newShifts,
        boolean newTerminated
    )
    {
        super(newVacancyNumber, newDesignation, newJobType, newStaffName, newJoiningDate, newQualification, newAppointedBy, newJoined);
        workingHour = newWorkingHour;
        wagesPerHour = newWagesPerHour;
        shifts = newShifts;
        terminated = newTerminated;
    }
    
    /**
     * Setters and Getters for all the private variables
     */
    
    public void SetWorkingHour(int newWorkingHour){
        workingHour = newWorkingHour;
    }
        
    public int GetWorkingHour(){
        return workingHour;
    }
    
    public void SetWagesPerHour(double newWagesPerHour){
        wagesPerHour = newWagesPerHour;
    }
        
    public double GetWagesPerHour(){
        return wagesPerHour;
    }
    
    public String GetShifts(){
        return shifts;
    }

    public void SetShifts(String newShifts){
        shifts = newShifts;
    }
    
    public boolean GetTerminated(){
        return terminated;
    }

    public void SetTerminated(boolean newTerminated){
        terminated = newTerminated;
    }
    
}

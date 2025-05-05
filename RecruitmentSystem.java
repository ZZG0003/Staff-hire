
/**
 * This is the main class that creates the GUI, takes inputs, displays outputs, and preforms all other operations using buttons
 *
 * @author (24006403)
 * @version (1.0.0)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class RecruitmentSystem implements ActionListener
{
    
    private JLabel vacancyNumberLBL;
    private JTextField vacancyNumberTXT;
    
    private JLabel designationLBL;
    private JTextField designationTXT;
    
    private JLabel jobTypeLBL;
    private JTextField jobTypeTXT;
    
    private JLabel staffNameLBL;
    private JTextField staffNameTXT;
    
    private JLabel joiningDateLBL;
    private JTextField joiningDateTXT;
    
    private JLabel qualificationLBL;
    private JTextField qualificationTXT;
    
    private JLabel appointedByLBL;
    private JTextField appointedByTXT;
    
    private JLabel joinedLBL;
    private JCheckBox joinedCKB;
    
    private JLabel salaryLBL;
    private JTextField salaryTXT;
    
    private JLabel weeklyFractionalHourLBL;
    private JTextField weeklyFractionalHourTXT;
    
    private JLabel workingHourLBL;
    private JTextField workingHourTXT;
    
    private JLabel wagesPerHourLBL;
    private JTextField wagesPerHourTXT;
    
    private JLabel shiftsLBL;
    private JTextField shiftsTXT;
    
    private JLabel terminatedLBL;
    private JCheckBox terminatedCKB;
    
    private JLabel displayNumberLBL;
    private JTextField displayNumberTXT;    
    private boolean isDisplayInProgress = false;
    
    // dummy lables to add space in the GUI for aesthetic purposes
    private JLabel dummy1LBL;
    private JLabel dummy2LBL;
    private JLabel dummy3LBL;
    private JLabel dummy4LBL;
    
    private JButton addFulltimeStaff;
    private JButton addParttimeStaff;
    private JButton addSalary;
    private JButton addWorkingShifts;
    private JButton terminate;
    private JButton displayNumber;
    private JButton clearText;
    
    private JFrame frame;
    
    ArrayList<Staffhire> staff = new ArrayList<>(); //This is an array list for Staffhire superclass that will store instances of the subclasses
    
    public void actionPerformed(ActionEvent event)
    {
        //used for debugging
        //System.out.println("menu item: " + event.getActionCommand());
    }
    
    //Method which clears the GUI
    private void clearGUI() 
    {
        System.out.println("clear GUI");   
        vacancyNumberTXT.setText("");
        designationTXT.setText("");
        jobTypeTXT.setText("");
        joiningDateTXT.setText("");
        staffNameTXT.setText("");
        appointedByTXT.setText("");
        qualificationTXT.setText("");
        salaryTXT.setText("");
        joinedCKB.setSelected(false);
        weeklyFractionalHourTXT.setText("");
        workingHourTXT.setText("");
        wagesPerHourTXT.setText("");
        shiftsTXT.setText("");
        terminatedCKB.setSelected(false);
        displayNumberTXT.setText("");
        isDisplayInProgress = false;
    }
    
    //Method used to display information stored in the array
    private void displayGUI(int displayVal)
    {
        clearGUI();
        vacancyNumberTXT.setText(Integer.toString(staff.get(displayVal-1).GetVacancyNumber()));
        designationTXT.setText(staff.get(displayVal-1).GetDesignation());
        jobTypeTXT.setText(staff.get(displayVal-1).GetJobType());
        joiningDateTXT.setText(staff.get(displayVal-1).GetJoiningDate());
        staffNameTXT.setText(staff.get(displayVal-1).GetStaffName());
        appointedByTXT.setText(staff.get(displayVal-1).GetAppointedBy());
        qualificationTXT.setText(staff.get(displayVal-1).GetQualification());
        if (staff.get(displayVal-1).GetJoined() == true)
        {
            joinedCKB.setSelected(true);
        }
        else
        {
            joinedCKB.setSelected(false);
        }
        if (staff.get(displayVal-1) instanceof FullTimeStaffHire)
        {
            FullTimeStaffHire fts = (FullTimeStaffHire) staff.get(displayVal-1);
            salaryTXT.setText(Double.toString(fts.GetSalary()));
            weeklyFractionalHourTXT.setText(Integer.toString(fts.GetWeeklyFractionalHours()));
        }
        else
        {
            PartTimeStaffHire pts = (PartTimeStaffHire) staff.get(displayVal-1);
            workingHourTXT.setText(Integer.toString(pts.GetWorkingHour()));
            wagesPerHourTXT.setText(Double.toString(pts.GetWagesPerHour()));
            shiftsTXT.setText(pts.GetShifts());
            if (pts.GetTerminated() == true)
            {
                terminatedCKB.setSelected(true);
            }
            else
            {
                terminatedCKB.setSelected(false);
            }
        }
        displayNumberTXT.setText(Integer.toString(displayVal));
        isDisplayInProgress = true;
    }
    
    //Empty constructor
    public RecruitmentSystem()
    {
        frame = new JFrame("Staff hire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        vacancyNumberLBL = new JLabel("Vacancy");
        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPane.add(vacancyNumberLBL, gbc);
        
        vacancyNumberTXT = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 0;
        contentPane.add(vacancyNumberTXT, gbc);
            
        designationLBL = new JLabel("Designation");
        gbc.gridx = 3;
        gbc.gridy = 0;
        contentPane.add(designationLBL, gbc);
        
        designationTXT = new JTextField(15);
        gbc.gridx = 4;
        gbc.gridy = 0;
        contentPane.add(designationTXT, gbc);
        
        jobTypeLBL = new JLabel("Job Type");
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPane.add(jobTypeLBL, gbc);
        
        jobTypeTXT = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 1;
        contentPane.add(jobTypeTXT, gbc);
        
        joiningDateLBL = new JLabel("Joining Date");
        gbc.gridx = 3;
        gbc.gridy = 1;
        contentPane.add(joiningDateLBL, gbc);
        
        joiningDateTXT = new JTextField(15);
        gbc.gridx = 4;
        gbc.gridy = 1;
        contentPane.add(joiningDateTXT, gbc);
        
        staffNameLBL = new JLabel("Staff Name");
        gbc.gridx = 1;
        gbc.gridy = 2;
        contentPane.add(staffNameLBL, gbc);
        
        staffNameTXT = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 2;
        contentPane.add(staffNameTXT, gbc);
        
        appointedByLBL = new JLabel("Appointed By");
        gbc.gridx = 3;
        gbc.gridy = 2;
        contentPane.add(appointedByLBL, gbc);
        
        appointedByTXT = new JTextField(15);
        gbc.gridx = 4;
        gbc.gridy = 2;
        contentPane.add(appointedByTXT, gbc);
        
        qualificationLBL = new JLabel("Qualification");
        gbc.gridx = 1;
        gbc.gridy = 3;
        contentPane.add(qualificationLBL, gbc);
        
        qualificationTXT = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 3;
        contentPane.add(qualificationTXT, gbc);

        joinedLBL = new JLabel("Joined");
        gbc.gridx = 3;
        gbc.gridy = 3;
        contentPane.add(joinedLBL, gbc);
        
        joinedCKB = new JCheckBox();
        gbc.gridx = 4;
        gbc.gridy = 3;
        contentPane.add(joinedCKB, gbc);
        
        dummy1LBL = new JLabel(" ");
        gbc.gridx = 1;
        gbc.gridy = 4;
        contentPane.add(dummy1LBL, gbc);
        
        salaryLBL = new JLabel("Full Time Staff: Salary");
        gbc.gridx = 1;
        gbc.gridy = 5;
        contentPane.add(salaryLBL, gbc);
        
        salaryTXT = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 5;
        contentPane.add(salaryTXT, gbc);
                        
        weeklyFractionalHourLBL = new JLabel("Weekly Fractional Hour");
        gbc.gridx = 3;
        gbc.gridy = 5;
        contentPane.add(weeklyFractionalHourLBL, gbc);
        
        weeklyFractionalHourTXT = new JTextField(15);
        gbc.gridx = 4;
        gbc.gridy = 5;
        contentPane.add(weeklyFractionalHourTXT, gbc);
        
        workingHourLBL = new JLabel("Part Time Staff: Working Hours");
        gbc.gridx = 1;
        gbc.gridy = 6;
        contentPane.add(workingHourLBL, gbc);
        
        workingHourTXT = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 6;
        contentPane.add(workingHourTXT, gbc);
        
        wagesPerHourLBL = new JLabel("Wages Per Hour");
        gbc.gridx = 3;
        gbc.gridy = 6;
        contentPane.add(wagesPerHourLBL, gbc);
        
        wagesPerHourTXT = new JTextField(15);
        gbc.gridx = 4;
        gbc.gridy = 6;
        contentPane.add(wagesPerHourTXT, gbc);
        
        shiftsLBL = new JLabel("Shifts");
        gbc.gridx = 1;
        gbc.gridy = 7;
        contentPane.add(shiftsLBL, gbc);
        
        shiftsTXT = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 7;
        contentPane.add(shiftsTXT, gbc);
        
        terminatedLBL = new JLabel("Terminated");
        gbc.gridx = 3;
        gbc.gridy = 7;
        contentPane.add(terminatedLBL, gbc);
        
        terminatedCKB = new JCheckBox();
        gbc.gridx = 4;
        gbc.gridy = 7;
        contentPane.add(terminatedCKB, gbc);

        dummy2LBL = new JLabel(" ");
        gbc.gridx = 1;
        gbc.gridy = 8;
        contentPane.add(dummy2LBL, gbc);
        
        // adding the buttons 
        
        addFulltimeStaff = new JButton("Add Fulltime Staff");
        gbc.gridx = 2;
        gbc.gridy = 9;
        contentPane.add(addFulltimeStaff, gbc);
        
        //add the fulltime staff when revelvant button is clicked - check for all errors in this method
        addFulltimeStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean valid = true;
                int vacancyNumber = 0;
                double salary = 0;
                int weeklyFractionalHours = 0;
                System.out.println("Adding full-time staff member");
                try {
                    vacancyNumber = Integer.parseInt(vacancyNumberTXT.getText());
                    // Now you have your integer value in vacancyNumber
                    System.out.println("Vacancy number: " + vacancyNumber);
                } catch (NumberFormatException exc) {
                    // Show an error message to the user
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number", "Input Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }
                
                try {
                    salary = Double.parseDouble(salaryTXT.getText());
                    // Now you have your double value
                    System.out.println("The value is: " + salary);
                } catch (NumberFormatException exc) {
                    // Handle the case where the input isn't a valid double
                    System.out.println("Please enter a valid salary");
                    // Optionally show an error message to the user
                    JOptionPane.showMessageDialog(null, "Please enter a valid salary", "Input Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }
                
                try {
                    weeklyFractionalHours = Integer.parseInt(weeklyFractionalHourTXT.getText());
                    // Now you have your integer value in weeklyFractionalHours
                    System.out.println("weeklyFractionalHours: " + weeklyFractionalHours);
                } catch (NumberFormatException exc) {
                    System.out.println("Please enter a valid weekly fractional hours");
                    // Show an error message to the user
                    JOptionPane.showMessageDialog(frame, "Please enter a valid weekly fractional hours", "Input Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }
                
                if (valid)
                {
                    staff.add(new FullTimeStaffHire(vacancyNumber,designationTXT.getText(),jobTypeTXT.getText(),staffNameTXT.getText(),
                    joiningDateTXT.getText(),qualificationTXT.getText(),appointedByTXT.getText(),joinedCKB.isSelected(),salary,
                    weeklyFractionalHours));
                    JOptionPane.showMessageDialog(null, "Full time staff info added successfully. Display num = " + staff.size(), "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearGUI();
                }

                
        }
    });
        
        addParttimeStaff = new JButton("Add Parttime Staff");
        gbc.gridx = 3;
        gbc.gridy = 9;
        contentPane.add(addParttimeStaff, gbc);
        
        // add the parttime staff when revelvant button is clicked - check for all errors in this method
        addParttimeStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean valid = true;
                int vacancyNumber = 0;
                int workingHour = 0;
                double wagesPerHour = 0;
                boolean terminated = false; 
                System.out.println("Adding part-time staff member"); 
                
                try {
                    vacancyNumber = Integer.parseInt(vacancyNumberTXT.getText());
                    // Now you have your integer value in vacancyNumber
                    System.out.println("Vacancy number: " + vacancyNumber);
                } catch (NumberFormatException exc) {
                    // Show an error message to the user
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number", "Input Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }
                
                try {
                    workingHour = Integer.parseInt(workingHourTXT.getText());
                    // Now you have your integer value in workingHour
                    System.out.println("Working Hours: " + workingHour);
                } catch (NumberFormatException exc) {
                    // Show an error message to the user
                    JOptionPane.showMessageDialog(frame, "Please enter valid working hours", "Input Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }
                
                try {
                    wagesPerHour = Double.parseDouble(wagesPerHourTXT.getText());
                    // Now you have your double value
                    System.out.println("The value is: " + wagesPerHour);
                } catch (NumberFormatException exc) {
                    // Handle the case where the input isn't a valid double
                    System.out.println("Please enter a valid hourly wage");
                    // Optionally show an error message to the user
                    JOptionPane.showMessageDialog(null, "Please enter a valid hourly wage", "Input Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }
                
                if (valid)
                {
                    staff.add(new PartTimeStaffHire(vacancyNumber,designationTXT.getText(),jobTypeTXT.getText(),staffNameTXT.getText(),
                    joiningDateTXT.getText(),qualificationTXT.getText(),appointedByTXT.getText(),joinedCKB.isSelected(),workingHour,wagesPerHour,
                    shiftsTXT.getText(),terminatedCKB.isSelected()));
                    JOptionPane.showMessageDialog(null, "Part time staff info added successfully. Display num = " + staff.size(), "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearGUI();
                }
        }
    });
        
        dummy3LBL = new JLabel(" ");
        gbc.gridx = 1;
        gbc.gridy = 10;
        contentPane.add(dummy3LBL, gbc);
        
        displayNumberLBL = new JLabel("Display number");
        gbc.gridx = 1;
        gbc.gridy = 11;
        contentPane.add(displayNumberLBL, gbc);
        
        displayNumberTXT = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 11;
        contentPane.add(displayNumberTXT, gbc);
    
        displayNumber = new JButton("Display number");
        gbc.gridx = 3;
        gbc.gridy = 11;
        contentPane.add(displayNumber, gbc);
        
        //Display all stored information based on the display number/value when button is pressed
        displayNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int displayVal;
                try {
                    displayVal = Integer.parseInt(displayNumberTXT.getText());
                    if((displayVal <= 0) || (displayVal > staff.size()))
                    {
                        JOptionPane.showMessageDialog(frame, "The number is not in a valid range", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        displayGUI(displayVal);
                    }
                    // Now you have your integer value in workingHour
                    System.out.println("Displaying number: " + displayVal);
                } catch (NumberFormatException exc) {
                    // Show an error message to the user
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
        }
    });
        
        addSalary = new JButton("Add salary");
        gbc.gridx = 1;
        gbc.gridy = 12;
        contentPane.add(addSalary, gbc);
        
        //Button to add/update salary for full time staff if they have joined
        addSalary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double salary = 0;
                boolean valid = true;
                System.out.println("Adding salary");
                try {
                    salary = Double.parseDouble(salaryTXT.getText());
                    // Now you have your double value
                    System.out.println("The value is: " + salary);
                } catch (NumberFormatException exc) {
                    // Handle the case where the input isn't a valid double
                    System.out.println("Please enter a valid salary");
                    // Optionally show an error message to the user
                    JOptionPane.showMessageDialog(null, "Please enter a valid salary", "Input Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }
                
                if (!joinedCKB.isSelected())
                {
                    JOptionPane.showMessageDialog(null, "the employee has to have joined to add a salary", "Input Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }
                
                if (valid && isDisplayInProgress)
                {
                    int displayVal = Integer.parseInt(displayNumberTXT.getText());
                    staff.get(displayVal-1).SetJoined(true);
                    if (staff.get(displayVal-1) instanceof FullTimeStaffHire)
                    {
                         FullTimeStaffHire fts = (FullTimeStaffHire) staff.get(displayVal-1);
                         fts.SetSalary(Double.parseDouble(salaryTXT.getText()));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Salary can only be added to full time staff", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                    //FullTimeStaffHire fts = (FullTimeStaffHire) staff.get(displayVal-1);
                    // staff.add(new FullTimeStaffHire(salary));
                }
        }
    });
        
        addWorkingShifts = new JButton("Add shifts");
        gbc.gridx = 2;
        gbc.gridy = 12;
        contentPane.add(addWorkingShifts, gbc);
        
        //button to add/update working shifts for part time staff members who have joined
        addWorkingShifts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean valid = true;
                System.out.println("Adding employee shifts");
                
                if (shiftsTXT.getText() != null && !shiftsTXT.getText().trim().isEmpty())
                {
                    // everything works at this point
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Shifts has to contain a valid value", "Input Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }
                
                if (!joinedCKB.isSelected())
                {
                    JOptionPane.showMessageDialog(null, "the employee has to have joined to add their shifts", "Input Error", JOptionPane.ERROR_MESSAGE);
                    valid = false;
                }
                
                if (valid && isDisplayInProgress)
                {
                    int displayVal = Integer.parseInt(displayNumberTXT.getText());
                    staff.get(displayVal-1).SetJoined(true);
                    if (staff.get(displayVal-1) instanceof PartTimeStaffHire)
                    {
                         PartTimeStaffHire pts = (PartTimeStaffHire) staff.get(displayVal-1);
                         pts.SetShifts(shiftsTXT.getText());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Shifts can only be added to part time staff", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                    //FullTimeStaffHire fts = (FullTimeStaffHire) staff.get(displayVal-1);
                    // staff.add(new FullTimeStaffHire(salary));
                }
        }
    });
        
        terminate = new JButton("Terminate");
        gbc.gridx = 3;
        gbc.gridy = 12;
        contentPane.add(terminate, gbc);
        
        // button to terminate part time staff members 
        terminate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Terminated");
                if (joinedCKB.isSelected())
                {
                    int displayVal = Integer.parseInt(displayNumberTXT.getText());
                    staff.get(displayVal-1).SetJoined(false);
                    staff.get(displayVal-1).SetStaffName("");
                    staff.get(displayVal-1).SetAppointedBy("");
                    staff.get(displayVal-1).SetQualification("");
                    staff.get(displayVal-1).SetJoiningDate("");
                    PartTimeStaffHire pts = (PartTimeStaffHire) staff.get(displayVal-1);
                    pts.SetTerminated(true);
                    displayGUI(displayVal);
                }
                else
                {
                     JOptionPane.showMessageDialog(null, "Employee has not joined or is already terminated", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
        }
    });
        

        clearText = new JButton("Clear text");
        gbc.gridx = 4;
        gbc.gridy = 12;
        contentPane.add(clearText, gbc);
        
        //clear the GUI when button is pressed
        clearText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Text cleared");   
                clearGUI();
                
        }
    });
        
        frame.pack();
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
        
    }
    
    //The main method
    public static void main(String[] args) {
        RecruitmentSystem recruitmentSystem = new RecruitmentSystem();
    }
    
}

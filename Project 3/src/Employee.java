/**
 * Object Class for holding information about an employee
 */

public class Employee extends Person implements DataHandler
{
	private String employeeId, clockedIn, hiredDate;
	//object constructor
	public Employee(String employeeId, String firstName, String lastName, String email, String address,String phoneNumber, String clockedIn, String hiredDate)
	{
		super(firstName, lastName, address, phoneNumber, email);
		this.setEmployeeId(employeeId);
		this.setClockedIn(clockedIn);
		this.setHiredDate(hiredDate);
	}
	/**
	 * @return all information about employee to be logged
	 */
	@Override
	public String getInfo() 
	{
		return "Employee Info: Employee Name: " + super.getLastName() + "," + super.getFirstName()+ "	Employee ID: " + this.employeeId +"	Time Clocked In: "+clockedIn;
	}

	/**
	 * @return all information about employee to be written to csv
	 */
	@Override
	public String getFileData() 
	{
		return this.employeeId +","+super.getFirstName() + "," + super.getLastName()+","+clockedIn;
	}
	/**
	 * @return employee id
	 */
	public String getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId employee ID to be set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return time employee clocked in
	 */
	public String getClockedIn() {
		return clockedIn;
	}
	/**
	 * @param clockedIn clock in time to be set
	 */
	public void setClockedIn(String clockedIn) {
		this.clockedIn = clockedIn;
	}
	/**
	 * @return date employee was hired
	 */
	public String getHiredDate() {
		return hiredDate;
	}
	/**
	 * @param hiredDate date employee was hired to be set
	 */
	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}
	
	
}

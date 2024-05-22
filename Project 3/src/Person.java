/**
 * Object Class for holding info on a person
 */

public class Person implements DataHandler
{
	private String firstName, lastName, address, phoneNumber, email;
	//object constructor
	public Person(String firstName, String lastName, String address,String phoneNumber, String email)
	{
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
	}
	/**
	 * @return All info about a person to be logged
	 */
	public String getInfo()
	{
		return "Name: "+lastName+","+firstName+" Address: "+address+" Phone Number: "+phoneNumber+" Email: "+email;
	}
	/**
	 * @return All info about a person to written to csv
	 */
	public String getFileData()
	{
		return firstName+", "+lastName+", "+address+", "+phoneNumber+", "+email;
	}
	/**
	 * @return first name of person in string
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName first name to be set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return last name of a person
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName last name to be set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return address of a person in string
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address address to be set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return phone number of a person in string
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber phone number to be set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 *@return email of person in string
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email email to be set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	


	

}

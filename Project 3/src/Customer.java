/**
 * Object Class to hold information about customer
 */


public class Customer extends Person implements DataHandler
{
	private String customerId, accountNumber;
	//object constructor
	public Customer (String customerId, String firstName, String lastName, String email, String address,String phoneNumber, String accountNumber)
	{
		super(firstName, lastName, address, phoneNumber, email);
		this.setCustomerId(customerId);
		this.setAccountNumber(accountNumber);
	}
	/**
	 * @return all information about customer to be logged
	 */
	@Override
	public String getInfo() 
	{
		return "Customer Info: Customer Name: " + super.getLastName() + "," + super.getFirstName()+ "	Customer ID: " + this.customerId+ "	Account Number: " + this.accountNumber;
	}

	/**
	 * @return all information about customer to be written to csv
	 */
	@Override
	public String getFileData() 
	{
		return this.customerId+","+super.getFirstName() + "," + super.getLastName();
	}
	/**
	 * @return customer Id
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId customer ID to be set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/** accountNumber account number to be set
	 * @param
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}

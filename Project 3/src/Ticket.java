/**
 * takes given customer and creates a ticket
 */


public class Ticket implements DataHandler
{
	private Customer customer;
	private String createdAt, ticketId;
	
	public Ticket(Customer customer, String ticketId, String createdAt)
	{
	this.setCustomer(customer);
	this.setCreatedAt(createdAt);
	this.setTicketId(ticketId);
	}
	/**
	 * @return customer and ticket info to be logged
	 */
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.customer.getInfo()+"	Created At: "+this.createdAt+"	Ticket ID: "+ticketId;
	}

	/**
	 * @return customer and ticket info to be written to csv
	 */
	@Override
	public String getFileData() {
		// TODO Auto-generated method stub
		return this.customer.getFileData()+","+ticketId+","+createdAt;
	}
	/**
	 * @return customer object
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer customer object to be set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return ticket creation date
	 */
	public String getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt ticket creation date to be set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return ticket ID
	 */
	public String getTicketId() {
		return ticketId;
	}
	/**
	 * @param ticketId ticket ID to be set
	 */
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
}

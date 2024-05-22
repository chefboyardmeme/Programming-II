/**
 * takes given employee and ticket and creates a work order
 */


public class WorkOrder implements DataHandler
{
	private Employee employee;
	private Ticket ticket;
	private String createdAt;
	//object constructor
	public WorkOrder(Employee employee, Ticket ticket, String createdAt)
	{
		this.setEmployee(employee);
		this.setTicket(ticket);
		this.setCreatedAt(createdAt);
	}
	/**
	 * @return employee, ticket and workorder info to be logged
	 */
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.employee.getInfo()+"	"+this.ticket.getInfo()+"	Workorder Info: "+this.createdAt;
	}

	/**
	 * @return employee, ticket and workorder info to be written to csv
	 */
	@Override
	public String getFileData() {
		// TODO Auto-generated method stub
		return this.employee.getFileData()+","+this.ticket.getFileData()+","+this.createdAt;
	}
	/**
	 * @return employee object
	 */
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * @param employee employee object to be set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	/**
	 * @return ticket object
	 */
	public Ticket getTicket() {
		return ticket;
	}
	/**
	 * @param ticket ticket object to be set
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	/**
	 * @return work order creation date
	 */
	public String getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt work order creation date to be set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}



}

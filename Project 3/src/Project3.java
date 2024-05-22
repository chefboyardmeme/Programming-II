import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Michael Morrison
 * Course: COP3503 
 *  Project #: 3
 *  Title: Objects & Classes
 *  Due Date:  11/27/2022
 *  
 *  Create class files that serve as templates for creating objects &
 *  setup inheritance and implement interfaces 
 *
 */
public class Project3
{
	static String employeeFileName, ticketFileName, workOrderFileName;
	static ArrayList<Employee> employeeList = new ArrayList <Employee>();
	static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	static ArrayList <WorkOrder> workOrderList = new ArrayList <WorkOrder>();
	public static void main(String[] args)
	{
		employeeFileName = "employee_data.csv";
		ticketFileName = "ticket_data.csv";
		workOrderFileName = "workorder_data.csv";
		System.out.println("Project 3 Work Order Generator");
		FileHandler fileHandler = new FileHandler();
		System.out.println("Loading Employee Data");
		fileHandler.logger("Loading Employee Data");
		fileHandler.readEmployeeData(employeeFileName);//reads in employee data and fills employee list
		System.out.println("Loading Ticket Data");
		fileHandler.logger("Loading Ticket Data");
		fileHandler.readTicketData(ticketFileName);//reads in ticket data and fill ticket list
		System.out.println("Creating Work Orders");
		fileHandler.logger("Creating Work Orders");
		createWorkOrders();//fill work order list
		System.out.println("Writing Work Order Data to File");
		fileHandler.logger("Writing Work Order Data to File");
		for (int i = 0; i < workOrderList.size(); i++)//loop to print work order info to log.txt
		{
			fileHandler.logger(workOrderList.get(i).getInfo());
		}
		fileHandler.writeData(workOrderFileName);
		System.out.println("Work Orders Created. Program Exiting");
		fileHandler.logger("Work Orders Created. Program Exiting");
		
	}//end main
	
	/** 
	 * Iterates Through employee and ticket lists to dynamically create work orders.
	* @return
	*/ 
	public static void createWorkOrders()
	{
		
		int i = 0; 
		int empCount = 0;
		//formats date object for string 
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//loop to iterate full ticket list
		while (i < ticketList.size())
		{
			Date date = new Date();
			String now = dateFormat.format(date);
			for(int j = 0; j < ticketList.size()/ employeeList.size(); j++)//loop to dynamically assign work orders
			{
				WorkOrder workOrder = new WorkOrder(employeeList.get(empCount), ticketList.get(i), now);
				workOrderList.add(workOrder);
				i++;
			}
			empCount++;
			if(empCount >= employeeList.size())
			{empCount = 0;}
		}//end while
	}

}

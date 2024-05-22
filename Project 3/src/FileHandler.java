import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Reads in ticket and employee data and writes out info and file data to respective output.
 */
public class FileHandler
{
	private Scanner scnr;
	/** 
	   * Formats and writes work order file data to csv file.
	* @param workOrderFileName The name of the output file (workorder_data.csv)
	* @return
	*/ 
	public void writeData(String workOrderFileName)
	{
		
		try
		{
			FileWriter fileWriter = new FileWriter(workOrderFileName);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			//creates header
			printWriter.println("employee_id,employee_first_name,employee_last_name,clocked_in,customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt");

			for (int i = 0; i < Project3.workOrderList.size();i++)//iteration loop to write work order file data
			{
				printWriter.println(Project3.workOrderList.get(i).getFileData());
			}//end for
			printWriter.close();
		}//end try
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			Thread.currentThread().getStackTrace();
			System.out.println("Output File Could Not Be Created, Close Output Files If Open");
		}//end catch
	}//end writeData
	
	/**
	 * Reads employee data and adds to employee list
	 * @param employeeFileName Name of csv file containing employee data to be read
	 * @return
	 */
	public void  readEmployeeData(String employeeFileName)
	{
		
		try
		{
			FileInputStream fileNameStream = new FileInputStream(employeeFileName);
			scnr = new Scanner(fileNameStream);
			String input = scnr.nextLine();
			
			while (scnr.hasNextLine())//loop to read until end of file
			{
				input = scnr.nextLine();
				Scanner inputscnr = new Scanner(input).useDelimiter(",");
				Employee employee = new Employee(inputscnr.next(), inputscnr.next(), inputscnr.next(), inputscnr.next(), inputscnr.next(), inputscnr.next(), inputscnr.next(), inputscnr.next());
				Project3.employeeList.add(employee);
			}//end while
		}//end try
			catch (FileNotFoundException e)
			{
				System.out.println("*File does not exist or path was entered incorrectly.*\nPlease try again.");
			}//end catch
	}//end readEmployeeData
	
	/**
	 * Reads ticket data and creates a customer to be added to the ticket to be added to the ticket list
	 * @param ticketFileName name of csv file containing ticket information to be read in
	 * @return
	 */
	public void readTicketData (String ticketFileName)
	{
		try
		{
			FileInputStream fileNameStream = new FileInputStream(ticketFileName);
			scnr = new Scanner(fileNameStream);
			String input = scnr.nextLine();
			
			while (scnr.hasNextLine())//loop to read until end of file
			{
				input = scnr.nextLine();
				Scanner inputscnr = new Scanner(input).useDelimiter(",");
				Customer customer = new Customer(inputscnr.next(), inputscnr.next(), inputscnr.next(), inputscnr.next(), inputscnr.next(), inputscnr.next(), inputscnr.next());
				Ticket ticket = new Ticket(customer, inputscnr.next(), inputscnr.next());
				Project3.ticketList.add(ticket);
			}//end while
		}//end try
			catch (FileNotFoundException e)
			{
				System.out.println("*File does not exist or path was entered incorrectly.*\nPlease try again.");
			}//end catch
	}//end readTicketData
	
	/**
	 * Appends to log file while adding current time action was performed
	 * @param log String to be appended to log
	 * @return
	 */
	public void logger(String log)
	{
		String outputFileName = "log.txt";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//date format for string
		Date date = new Date();
		String now = dateFormat.format(date);
		try
		{
			FileWriter fileWriter = new FileWriter(outputFileName, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(now+": "+log);
			printWriter.close();
		}//end try
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Output File Could Not Be Created");
		}//end catch
		
	}//end logger
}

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Object Class that handles output to files
 */
public class FileHandler 
{
	private String surveyFile = "survey_results.csv";
	private FileWriter fileOutput;
	private PrintWriter printWriter;
	

	/**
	 * FileHandler constructor
	 * creates output file with header
	 */
	public FileHandler() 
	{
		try
		{
			fileOutput = new FileWriter(surveyFile);
			printWriter = new PrintWriter(fileOutput);
			//creates header
			printWriter.println("DateTime,FirstName,LastName,PhoneNumber,Email,Sex,Water,Meals,Wheat,Sugar,Dairy,Miles,Weight ");
			printWriter.close();
		}//end try
		catch (IOException e)
		{
			Thread.currentThread().getStackTrace();
			System.out.println("Output File Could Not Be Created");
		}//end catch
	}//end constructor
	
	/**
	 * Takes given string and appends to file with each button press
	 * @param surveyData Comma parsed string to pass to CSV
	 * @return
	 */
	public void writeResults (String surveyData)
	{
		
		try
		{
			fileOutput = new FileWriter(surveyFile, true);
			printWriter = new PrintWriter(fileOutput);
			printWriter.println(surveyData);
			fileOutput.close();
			printWriter.close();
		}//end try
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Output File Could Not Be Created");
		}//end catch
	}//end writeResults



}//end class

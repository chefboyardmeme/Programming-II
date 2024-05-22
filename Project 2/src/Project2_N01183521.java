import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Project2_N01183521 {

	public static ArrayList<String> header = new ArrayList<String>();
	public static ArrayList<String> dates = new ArrayList<String>();
	public static ArrayList<String> times = new ArrayList<String>();
	public static ArrayList<Double> sensor2278 = new ArrayList<Double>();
	public static ArrayList<Double> sensor3276 = new ArrayList<Double>();
	public static ArrayList<Double> sensor4689 = new ArrayList<Double>();
	public static ArrayList<Double> sensor5032 = new ArrayList<Double>();
	public static ArrayList<Double> section1Diff = new ArrayList<Double>();
	public static ArrayList<Double> section2Diff = new ArrayList<Double>();
	public static ArrayList<Double> totalAvg = new ArrayList<Double>();
	public static String inputFileName;
	public static int counter = 0;

// method for input
	/** 
	* Takes input from user for input file name
	* Throws FileNotFound Exception
	*/ 
	public static void readInput ()
	{
		
		System.out.println("Enter file name & location.");
		Scanner scnr = new Scanner(System.in);
		inputFileName = scnr.nextLine();
		System.out.println("Reading in Data from the file " + inputFileName);
		
		try
		{
			FileInputStream fileNameStream = new FileInputStream(inputFileName);
			Scanner fileNameScanner = new Scanner(fileNameStream);
			String input = fileNameScanner.nextLine();
			Scanner inputscnr = new Scanner(input).useDelimiter(",");
		
		//while loop to set header values
		while(inputscnr.hasNext())
			{
			header.add(inputscnr.next());
			}
			header.add("Section1_Diff"); header.add("Section2_Diff"); header.add("Total_Avg");
			
		System.out.println("Converting Dates from MM/DD/YYYY to YYYY/MM/DD");	
		//while loop to read in data per line
		while (fileNameScanner.hasNextLine())
		{
		input =fileNameScanner.nextLine();
		parseLine(input);
		}
		
		
		//begin converting dates
		
		
		
		}//end try
		
		
		catch (FileNotFoundException e)
		{
			System.out.println("*File does not exist or path was entered incorrectly.*\nPlease try again.");
			clearAll();
			readInput();
		}
		catch (NumberFormatException e)
		{
			System.out.println("*Bad Number Data in CSV File.* \nCheck CSV file data and try again. ");
			clearAll();
			readInput();
		}
		
		//end catch
		
    }
	/** 
	* Takes a line from the text file to read in and sorts out data to add to array lists.
	* @param input The line read in from Speed_Data
	* @return  
	*/ 
	public static void parseLine(String input)
	{
		Scanner inputscnr = new Scanner(input).useDelimiter(",");
		while (inputscnr.hasNext())
		{
			
			String temp = inputscnr.next();
			reverseDates(temp);
			times.add(inputscnr.next());
			sensor2278.add(Double.parseDouble(inputscnr.next()));
			sensor3276.add(Double.parseDouble(inputscnr.next()));
			sensor4689.add(Double.parseDouble(inputscnr.next()));
			sensor5032.add(Double.parseDouble(inputscnr.next()));
			if(counter == 0)
			{
				System.out.println("Calculating Speed Difference");
				System.out.println("Calculating Speed Average");
			}
			section1Diff.add(sensor2278.get(counter) - sensor3276.get(counter));
			section2Diff.add(sensor4689.get(counter) - sensor5032.get(counter));
			totalAvg.add((sensor2278.get(counter) + sensor3276.get(counter) + sensor4689.get(counter) + sensor5032.get(counter))/4);
			
			counter++;
		}
	}
	//reverse dates method
	/** 
	* Reverses the given date and adds to array list.
	* @param temp Date from Speed_Data to be reversed.
	* @return  
	* @throws Parse Exception
	*/ 
	public static void reverseDates(String temp)
	{
		 try
		 {
			 
			 SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
			 Date date = formatter.parse(temp); 
			 formatter = new SimpleDateFormat("YYYY/MM/dd");  
			 temp = formatter.format(date);
			 dates.add(temp);
		 }
		 catch (ParseException e)
			{
				System.out.println("*Bad Date Data in CSV File.* \nCheck CSV file data and try again.");
				clearAll();
				readInput();
			}
	}
	
	//clearing method
	/** 
	* 
	*Clears all array lists
	* @return  
	*/ 
	public static void clearAll()
	{
		header.clear();
		dates.clear();
		times.clear();
		 sensor2278.clear();
		sensor3276.clear();
		sensor4689.clear();
		sensor5032.clear();
		section1Diff.clear();
		section2Diff.clear();
		totalAvg.clear();
		counter = 0;
		inputFileName = "";
	}
	
	
	//method for output 
	/** 
	* 
	* Takes the array lists that have been loaded from input file and writes them to output file.
	* @return  
	*/ 
	public static void writeOutput()
	{
		String outputFileName;
		int position = inputFileName.indexOf(".");
		outputFileName = inputFileName.substring(0, position);
		outputFileName += "_Difference.csv";
		System.out.println("Writing data to file "+outputFileName);
		
		try
		{
			FileWriter fileWriter = new FileWriter(outputFileName);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			//print headers
			for (int i = 0; i < header.size(); i++)
			{
				if(i+1 == header.size())
				{
					printWriter.println(header.get(i));
				}
				else
				{
					printWriter.print(header.get(i)+",");
				}
			}
			
			//print arrays
			for (int i = 0; i < counter; i++)
			{
				printWriter.println(dates.get(i)+","+times.get(i)+","+sensor2278.get(i)+","+sensor3276.get(i)+","+sensor4689.get(i)+","+sensor5032.get(i)
				+","+section1Diff.get(i)+","+section2Diff.get(i)+","+totalAvg.get(i));
			}
			printWriter.close();
		}
		catch (IOException e)
		{
			clearAll();
			readInput();
		}
		
		      
		    
		
		
	}
	
	public static void main(String[] args) 
	{
		
		/* 
		*  Author: Michael Morrison
		*  Course: COP3503 
		*  Project #: 2
		*  Title  : Data Preprocessing
		*  Due Date:  10/26/2022
		*  
		*  Takes a list of Integers and gives options to 
		*  display statistics until the option to end the program is entered.
		*/ 
		System.out.println("Project 2 Data Preprocessing\n");
		readInput();
		writeOutput();
		System.out.println("Done! Exiting Program ");
			
		
		
	}

}

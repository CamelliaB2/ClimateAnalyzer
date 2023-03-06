package climatechange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Camellia
 */
public class Weather implements IWeatherIO {
	

	/**
	 * Creates an ArrayList and transfers the data from the file
	 * @param fileName
	 */
	public ArrayList<ITemperature> readDataFromFile(String fileName) 
	{
		fileName = "data/world_temp_2000-2016.csv";
		File file = new File(fileName); //Creates a new file and transfers the file with all the data to it
		ArrayList<ITemperature> array = new ArrayList<>(); //Create a new ArrayList
		Scanner scan;
		try 
		{
			scan = new Scanner(file); //Create a new Scanner and transfers new file to it
			String t = scan.nextLine(); //Assign first line of data, the header, to unused variable
			while (scan.hasNextLine()) //While the data file has not reached its end
			{
				String line = scan.nextLine(); //Puts next line to String variable line
				String[] s1 = line.split(","); //Splits line among the comma
				String[] s = s1[0].split("\\s+"); //Splits line among spaces, separates each element from each line
				double temperature = Double.parseDouble(s[0]); //Converts temperature from String to Double
				int year = Integer.parseInt(s[1]); //Converts year from String to Double
				String month = s[2]; //Assigns month
				String country = s[3]; //Assigns country
				String code = s[4]; //Assigns 3 letter code
				//System.out.println(temperature + ", " + year + ", " + month + ", " + country + ", " + code);
				ITemperature temp = new Temperature(temperature, year, month, country, code); //Creates a new ITemperature object and adds every element for each line
				array.add(temp); //Adds object to ArrayList
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		return array; //Return the ArrayList
		
		
	}

	/**
	 * Write the subject header before dumping data returned from each ClimateAnalyzer method
	 * A subject header is to be written for each ClimateAnalyzer method call
	 * @param filename
	 * @param subject
	 */
	public void writeSubjectHeaderInFile(String filename, String subject) 
	{
		File file = new File(filename); //Assign header to subject
		try 
		{
			FileWriter fr = new FileWriter(file); //Create a new FileWriter
			fr.write(subject); //Append header to file
			
			
			fr.close(); //Close the file
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * File name should be called “taskXX_climate_info.csv” where XX will be replaced by the task id: A1, A2, etc
	 * Use this method to store the temperature info(for each ClimateAnalyzer task)
	 * One row for each temperature data object (i.e. all fields in one row (each comma delimited))
	 *      b) similar to the original input data file)
	 *  Temperature value should be formatted to use a maximum of 2 decimal places
	 *  Temperature field should also show the Fahrenheit value (using decimal rules above)
	 *   a) the temperature field should look like i.e. 21.34(C) 70.42(F)
	 */
	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) 
	{
		String theTopic = "Temperature, Year, Month_Avg, Country, Country_Code";
		filename = filename.replace("XX", topic); //Replace XX with topic (A1, A2, etc)
		File file = new File("data", filename); //Transfer data and filename to file
		
		try 
		{
			//Borrowed in part from hw#4
			FileWriter fr = new FileWriter(file); //Transfer file to FileWriter
			BufferedWriter bw = new BufferedWriter(fr); //Transfer FileReader to BufferedReader
			bw.append(theTopic); //Start new line
			bw.append('\n');
			
			for (ITemperature t: theWeatherList) //Loop through data
			{
				double celcius = Math.round(t.getTemperature(false)*100.0)/100.0; //Get celcius temperature and round to 2 decimal places
				String C = Double.toString(celcius); //Convert celcius to String
				
				double farenheight = Math.round(t.getTemperature(true)*100.0)/100.0; //Get fahrenheit temperature and round to 2 decimal places
				String F = Double.toString(farenheight); //Convert to String
				
				bw.append(C).append("(C) ").append(F).append("(F)").append(", "); //Add celcius, (c), fahrenheit, (f), and a comma
				String year = Integer.toString(t.getYear()); //Convert year to string
				bw.append(year).append(", ").append(t.getMonth()).append(", "); //Add year, comma, month, and comma
				bw.append(t.getCountry()).append(", ").append(t.getCountry3LetterCode()); //Add country, comma, and code
				bw.append('\n'); //Start new line
			}
			bw.close(); //Close BufferedWriter
			fr.close(); //Close FileWriter
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args)
	{
		Weather a = new Weather();
		ArrayList<ITemperature> array = new ArrayList<>();
		array = a.readDataFromFile("data/world_temp_2000-2016.csv");
		a.writeDataToFile("taskXX_climate_info.csv", "A1", array);
	}

}

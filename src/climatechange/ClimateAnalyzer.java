package climatechange;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import climatechange.IClimateAnalyzer;
import climatechange.ITemperature;
import climatechange.Temperature;
import climatechange.Weather;

public class ClimateAnalyzer implements IClimateAnalyzer 
{
	private ArrayList<ITemperature> array;
	private String fileName = "taskA1_climate_info.csv";
	
	/**
	 * Constructs a ClimateAnalyzer that initializes the ArrayList containing the data
	 */
	public ClimateAnalyzer()
	{
		array = new ArrayList<>();
		Weather a = new Weather();
		array = a.readDataFromFile("world_temp_2000-2016.csv");
	}
	
	/**
	 * Converts user input of numbers 1-12 into their corresponding months
	 * @param month
	 * @return the month as a String
	 */
	public String monthConverter(int month)
	{
		if (month == 1)
		{
			return "Jan";
		}
		else if (month == 2)
		{
			return "Feb";
		}
		else if (month == 3)
		{
			return "Mar";
		}
		else if (month == 4)
		{
			return "Apr";
		}
		else if (month == 5)
		{
			return "May";
		}
		else if (month == 6)
		{
			return "Jun";
		}
		else if (month == 7)
		{
			return "Jul";
		}
		else if (month == 8)
		{
			return "Aug";
		}
		else if (month == 9)
		{
			return "Sep";
		}
		else if (month == 10)
		{
			return "Oct";
		}
		else if (month == 11)
		{
			return "Nov";
		}
		else if (month == 12)
		{
			return "Dec";
		}
		return null;
	}
	
	/**
	 * TASK A-1
	 * For all data that matches the specified month, get the lowest temperature reading 
	 * @param country
	 * @param month
	 * @return lowest temperature reading by month
	 */
	public ITemperature getLowestTempByMonth(String country, int month) 
	{
		ITemperature lowest = null;
		boolean check = false;
		boolean check2 = false;
		
		int count = 0;
		while (check == false || check2 == false)
		{
			lowest = array.get(count); //Sorts through the data
			count++; //Counter increases, allowing the lowest to attain the next element
			if (lowest.getCountry().equals(country)) //If the country of the current element matches the inputed country
			{
				if (lowest.getMonth().equals(this.monthConverter(month))) //If the month of the current element matches the inputed month
				{
					//Break from loop. Lowest is now initialized as the first element in the array with the same country and month
					check = true; 
					check2 = true;
					break;
				}
			}
		}
		
		for (ITemperature t: array)
		{
			if (t.getCountry().equals(country) && t.getMonth().equals(this.monthConverter(month))) //If the country and month match the inputed country and month
			{
				if (t.getTemperature(false) < lowest.getTemperature(false)) //If the temperature of the current element is lower the temperature of the lowest element
				{
					lowest = t; //Current element becomes new lowest
				}
			}
		}
		return lowest;
	}

	/**
	 * TASK A-1
	 * For all data that matches the specified month, get the highest temperature reading
	 * @param country
	 * @param month
	 * @return highest temperature reading by month
	 */
	public ITemperature getHighestTempByMonth(String country, int month) 
	{
		ITemperature highest = null;
		boolean check = false;
		boolean check2 = false;
		
		int count = 0;
		while (check == false || check2 == false)
		{
			highest = array.get(count); //Sorts through the data
			count++; //Counter increases, allowing the highest to attain the next element
			if (highest.getCountry().equals(country)) //If the country of the current element matches the inputed country
			{
				if (highest.getMonth().equals(this.monthConverter(month))) //If the month of the current element matches the inputed month
				{
					//Break from loop. Highest is now initialized as the first element with the same country and month.
					check = true;
					check2 = true;
					break;
				}
			}
		}
		
		for (ITemperature t: array) //Loops through data
		{
			if (t.getCountry().equals(country) && t.getMonth().equals(this.monthConverter(month))) //If the country and month of the element matches the inputed country and month
			{
				if (t.getTemperature(false) > highest.getTemperature(false)) //If the temperature of the current element is higher than the temperature of highest
				{
					
					highest = t; //The current element becomes highest
				}
			}
		}
		return highest;
	}

	/**
	 * TASK A-2
	 * For all data that matches the specified year, get the lowest temperature reading
	 * @param country
	 * @param year
	 * @return lowest temperature reading by year
	 */
	public ITemperature getLowestTempByYear(String country, int year) 
	{
		ITemperature lowestYear = null;
		boolean check = false;
		boolean check2 = false;
		
		int count = 0;
		while (check == false || check2 == false)
		{
			lowestYear = array.get(count); //Sorts through the data
			count++; //Counter increases, allowing the lowest to attain the next element
			if (lowestYear.getCountry().equals(country)) //If the country of the current element matches the inputed country
			{
				if (lowestYear.getYear() == year) //If the year of the current element matches the inputed year
				{
					//Break from loop, lowestYear is now initialized to the first element with the same country and year
					check = true;
					check2 = true;
					break;
				}
			}
		}
		
		for (ITemperature t: array) //Loops through data
		{
			if (t.getCountry().equals(country) && t.getYear() == year) //If the country and year of the current element matches inputed country and year
			{
				if (t.getTemperature(false) < lowestYear.getTemperature(false)) //If the temperature of the current element is lower than the temperature of lowestYear
				{
					lowestYear = t; //The current element becomes lowestYear
				}
			}
		}
		return lowestYear;
	}

	/**
	 * TASK A-2
	 * For all data that matches the specified year, get the highest temperature reading
	 * @param country
	 * @param year
	 * @return highest temperature reading by year
	 */
	public ITemperature getHighestTempByYear(String country, int year) 
	{
		ITemperature highestYear = null;
		boolean check= false;
		boolean check2 = false;
		
		int count = 0;
		while (check == false || check2 == false)
		{
			highestYear = array.get(count); //Sorts through the data
			count++; //Counter increases, allowing the highest to attain the next element
			if (highestYear.getCountry().equals(country)) //Counter increases, allowing the highest to attain the next element
			{
				if (highestYear.getYear() == year) //If the year of the current element matches the inputed year
				{
					//Break from loop. HighestYear is now initialized to the first element with the same country and year
					check = true;
					check2 = true;
					break;
				}
			}
		}
		
		for (ITemperature t: array) //Loops through data
		{
			if (t.getCountry().equals(country) && t.getYear() == year) //If the country and year of the current element matches the inputed country and year
			{
				if (t.getTemperature(false) > highestYear.getTemperature(false)) //If the temperature of the current element is higher than the temperature of HighestYear
				{
					highestYear = t; //Current element becomes highestYear
				}
			}
		}
		return highestYear;
	}

	/**
	 * TASK A-3
	 * Get all temperature data that fall within the given temperature range 
	 * The set is sorted from lowest to highest temperature
	 * Input parameter values are in Celsius
	 * @param country
	 * @param rangeLowTemp
	 * @param rangeHightemp
	 * @return temperature data that falls within given temperature range
	 */
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp) 
	{
		TreeSet<ITemperature> range = new TreeSet<>(); //New treeset, automatically sorts by lowest to highest temperature using the compareTo methid
		for (ITemperature t: array) //Loops through data
		{
			if (t.getCountry().equals(country)) //If the country of the current element matches the inputed country
			{
				if ((rangeLowTemp <= t.getTemperature(false)) && (t.getTemperature(false) <= rangeHighTemp)) //If the temperature of the current element is between the lower and higher temperature, or equal to them
				{
					range.add(t); //Add to treeset
				}
			}
		}
		return range;
	}

	/**
	 * TASK A-4
	 * Get the lowest temperature reading amongst all data for that country
	 * @param country
	 * @return lowest temperature reading by country
	 */
	public ITemperature getLowestTempYearByCountry(String country) 
	{
		ITemperature lowestCountry = array.get(0);
		boolean check = false;
		
		int count = 0;
		while (check == false)
		{
			lowestCountry = array.get(count); //Sorts through data
			count++; //Counter increases, allowing the lowest to attain the next element
			if (lowestCountry.getCountry().equals(country)) //If the country of the current element equals the inputed country
			{
				//Break from loop. LowestCountry is now initialized to the first element with the same country
				check = true;
				break;
			}
		}
		
		for (ITemperature t: array) //Loops through data
		{
			if (t.getCountry().equals(country)) //If the country of the current element equals the inputed country
			{
				if (t.getTemperature(false) < lowestCountry.getTemperature(false)) //If the temperature of the current element is lower than the temperature of lowestCountry
				{
					lowestCountry = t; //Current element becomes lowestCountry
				}
			}
		}
		return lowestCountry;
	}

	/**
	 * TASK A-4
	 * Get the highest temperature reading amongst all data for that country
	 * @param country
	 * @return highest temperature reading by country
	 */
	public ITemperature getHighestTempYearByCountry(String country)
	{
		ITemperature highestCountry = null;
		boolean check = false;
		
		int count = 0;
		while (check == false)
		{
			highestCountry = array.get(count); //Sorts through data
			count++; //Counter increases, allowing the highest to attain the next element
			if (highestCountry.getCountry().equals(country)) //If the country of the current element equals the inputed country
			{
				//Break from loop. highestCountry is now initialized to the first element with the same country
				check = true;
				break;
			}
		}
		
		for (ITemperature t: array) //Loops through data
		{
			if (t.getCountry().equals(country)) //If the country of the current element equals the inputed country
			{
				if (t.getTemperature(false) > highestCountry.getTemperature(false)) //If the temperature of the current element is higher than the temperature of highestCountry
				{
					highestCountry = t; //Current element becomes highestCountry
				}
			}
		}
		return highestCountry;
	}

	
	/**
	 * TASK B-1
	 * The return list is sorted from lowest to highest temperature
	 * @param month
	 * @return the list of 10 countries with the lowest temperature by month
	 */
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month) 
	{
		ArrayList<ITemperature> top10Lowest = new ArrayList<>();
		ArrayList<ITemperature> temp = new ArrayList<>();
		ArrayList<String> countries = new ArrayList<>();
		
		for (ITemperature t : array) //Loops through data
		{
			if (t.getMonth().equals(this.monthConverter(month))) //If the month of the current element equals the inputed month
			{
				temp.add(t); //Add to arraylist temp. This establishes an arraylist of elements with the same month
			}
		}
		
		TreeSet<ITemperature> tree = new TreeSet<>(temp); //Passes arraylist into treeset tree. TreeSet sorts it from lowest to highest temperature using the compareTo method
		ArrayList<ITemperature> a = new ArrayList<>(tree); //Passes tree back into arraylist a.
		
		int size = 0;
		for (ITemperature t: a) //Loops through arraylist a of elements with the same month
		{
			if (size < 10)
			{
				if (!countries.contains(t.getCountry())) //If the country of the current element is not already in araylist countries, it means it is not a duplicate country
				{
					top10Lowest.add(t); //Add current element to top10Lowest arraylist
					countries.add(t.getCountry()); //Add the country of the current element to the arraylist countries
					size++; //Size increases, allowing up to 10 elements to be added to the arraylist. These 10 are the first 10 elements received from a, i.e the 10 lowest temperatures
					
				}
			}
		}
		return top10Lowest;
	}

	/**
	 * TASK B-1
	 * The return list is sorted from lowest to highest temperature
	 * @param month
	 * @return the list of 10 countries with the highest temperature by month
	 */
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month) 
	{
		ArrayList<ITemperature> top10Highest = new ArrayList<>();
		ArrayList<ITemperature> temp = new ArrayList<>();
		ArrayList<String> countries = new ArrayList<>();
		
		for (ITemperature t : array) //Loops through data
		{
			if (t.getMonth().equals(this.monthConverter(month))) //If the month of the current element equals the inputed month
			{
				temp.add(t); //Add to arraylist temp. This establishes an arraylist of elements with the same month
			}
		}
		
		TreeSet<ITemperature> tree = new TreeSet<>(temp); //Passes arraylist into treeset tree. TreeSet sorts it from lowest to highest temperature using the compareTo method
		
		int size = 0;
		for (ITemperature t: tree.descendingSet()) //Loops through treeset in descending order, meaning it is now from highest to lowest temperature
		{
			if (size < 10)
			{
				if (!countries.contains(t.getCountry())) //If the country of the current element is not already in araylist countries, it means it is not a duplicate country
				{
					top10Highest.add(t); //Add current element to top10Highest
					countries.add(t.getCountry()); //Add the country of the current element to the arraylist countries
					size++; //Size increases, allowing up to 10 elements to be added to the arraylist. These 10 are the first 10 elements received from tree, i.e the 10 highest temperatures
					
				}
			}
		}
		return top10Highest;
	}	

			
		

	/**
	 * TASK B-2
	 * The return list is sorted from lowest to highest temperature
	 * @return the list of 10 countries with the lowest temperature
	 */
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() 
	{
		ArrayList<ITemperature> top10LowestCountries = new ArrayList<>();
		
		TreeSet<ITemperature> tree = new TreeSet<>(array); //Passes data to TreeSet tree, where it is automatically sorted from lowest to highest using the compareTo method
		ArrayList<ITemperature> list = new ArrayList<>(tree); //Passes TreeSet back to arraylist
		
		ArrayList<String> countries = new ArrayList<>();
		
		
		
		int size = 0;
		
		for (int i = 0; i <= list.size() - 1; i++) //Loops through ArrayList list. Because it is finding the lowest temperatures, it starts from the very first element, i.e. the lowest temperature
		{
			ITemperature lowest = list.get(i); //Lowest is initialized as the very first element in the list
			if (size < 10)
			{
				if (!(countries.contains(lowest.getCountry()))) //If the country of the current element is not already in araylist countries, it means it is not a duplicate country
				{
					top10LowestCountries.add(lowest); //Add current element to top10LowestCountries
					countries.add(lowest.getCountry()); //Add the country of the current element to the arraylist countries
					size++;  //Size increases, allowing up to 10 elements to be added to the arraylist. These 10 are the first 10 elements received from list, i.e the 10 lowest temperatures
				}
				
			}
		}
		return top10LowestCountries;
	}
		

	/**
	 * TASK B-2
	 * The return list is sorted from lowest to highest temperature
	 * @return the list of 10 countries with the highest temperature
	 */
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() 
	{
		ArrayList<ITemperature> top10HighestCountries = new ArrayList<>();
		
		TreeSet<ITemperature> tree = new TreeSet<>(array); //Passes data to TreeSet tree, where it is automatically sorted from lowest to highest using the compareTo method
		ArrayList<ITemperature> list = new ArrayList<>(tree); //Passes TreeSet back to arraylist
		
		ArrayList<String> countries = new ArrayList<>();
		
		int size = 0;
		for (int i = list.size() - 1; i >= 0; i--) //Loops through ArrayList list. Because it is finding the highest temperatures, it starts from the very last element, i.e. the highest temperature
		{
			ITemperature highest = list.get(i); //Highest is initialized as the very first element in the list
			if (size < 10)
			{
				if (!(countries.contains(highest.getCountry()))) //If the country of the current element is not already in araylist countries, it means it is not a duplicate country
				{
					top10HighestCountries.add(highest); //Adds current element to top10HighestCountries
					countries.add(highest.getCountry()); //Add the country of the current element to the arraylist countries
					size++; //Size increases, allowing up to 10 elements to be added to the arraylist. These 10 are the first 10 elements received from list, i.e the 10 lowest temperatures
				}
				
			}
		}
		return top10HighestCountries;
	}

	/**
	 * TASK B-3
	 * The return list is sorted from lowest to highest temperature
	 * @param lowRangeTemp
	 * @param highRangeTemp
	 * @return the list of temperature differences
	 */
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp) 
	{
		TreeSet<ITemperature> tree = new TreeSet<>();
		
		for (ITemperature t: array) //Loops through data
		{
			if ((t.getTemperature(false) >= lowRangeTemp) && (t.getTemperature(false) <= highRangeTemp)) //If the temperature of the current element is between the inputed lowest and righest temperatures, or equal to them
			{
				tree.add(t); //Add to treeset tree
			}
		}
		
		ArrayList<ITemperature> countriesRange = new ArrayList<>(tree); //Passes on tree to arraylist countriesRange. The treeset has sorted it from lowest to highest temperature, using the compareTo method
		return countriesRange;
	}

	/**
	 * TASK C-1
	 * The countries with the largest temperature differences(absolute value) of the same month between 2 given years
	 * The return list is sorted from lowest to highest temperature delta
	 * @param month
	 * @param year1
	 * @param year2
	 * @return the list of countries with the largest temperature difference by month
	 */
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2) 
	{
		TreeSet<ITemperature> tree = new TreeSet<>();
		ArrayList<String> countries = new ArrayList<>();
		ArrayList<ITemperature> theDelta = new ArrayList<>();
		
		
		double temp1 = 0;
		double temp2 = 0;
		double temp = 0;
		
		
		for (ITemperature t: array) //Loops through data
		{
			if (t.getMonth().equals(this.monthConverter(month))) //If the month of the current element equals the inputed month
			{
				if (t.getYear() == year1) //If the year of the current element matches the inputed year
				{
					temp1 = t.getTemperature(false); //Initialize temp1 as the temperature of that current element
					for (ITemperature a: array) //Loops through data again
					{
						if (a.getYear() == year2) //If the second year of the current element matches the inputed second year
						{
							temp2 = a.getTemperature(false); //Initialize temp2 as the temperature of that current element
							temp = Math.abs(temp2 - temp1); //Initialize temp as the absolute value of the second temperature minus the first temperature
							ITemperature delta = new Temperature(temp, year2, t.getMonth(), a.getCountry(), a.getCountry3LetterCode()); //Store data into ITemperature object
							tree.add(delta); //Add ITemperature object delta to TreeSet
						}
					}
						
					}
				}
			}
			
		
		
		ArrayList<ITemperature> list = new ArrayList<>(tree); //Pass TreeSet to arraylist. It is now sorted from lowest to highest by means of the compareTo method
		
		int size = 0;
		for (int i = list.size() - 1; i >= 0; i--) //Because we are getting the highest temperature differences, it loops through the list from the bottom, i.e. the highest temperatures
		{
			ITemperature highest = list.get(i); //Initialize highest as the current element
			if (size < 10)
			{
				if (!(countries.contains(highest.getCountry()))) //If the country of the current element is not already in araylist countries, it means it is not a duplicate country
				{
					theDelta.add(highest); //Add current element to theDelta arraylist
					countries.add(highest.getCountry()); //Add country of current element to arraylist countries
					size++; //Size increases, allowing up to 10 elements to be added to the arraylist. These 10 are the first 10 elements received from list, i.e the 10 lowest temperatures
				}
			}
		}
		return theDelta;
	}


	/**
	 * This method starts the climate-change task activities
	 * The ClimateChange methods must be called in the order as listed in the [description section], (first with the Task A 
	 * methods, second are the Task B methods, and third are the Task C methods)
	 * For each of the ClimateChange methods that require input parameters, this method must ask the user to
	 * enter the required information for each of the tasks.
	 * Each ClimateAnalyzer method returns data, so the data results must be written to data files 
	 */
	public void runClimateAnalyzer() 
	{
		Weather w = new Weather();
		ClimateAnalyzer c1 = new ClimateAnalyzer();
		Scanner scan = new Scanner(System.in);
		System.out.println("Task A1: Get The Lowest and Highest Temperature By Month For A Country");
		System.out.println("Enter a valid country");
		String country = scan.nextLine();
		System.out.println("Enter an integer for month (1 - 12)");
		int month = scan.nextInt();
		while (month > 12 || month < 1)
		{
			System.out.println("Not a valid input. Please try again.");
			month = scan.nextInt();
		}
		try 
		{
			w.writeSubjectHeaderInFile("taskA1_climate_info.csv", "Lowest And Highest Temperature Of" + country + "in" + this.monthConverter(month));
			ArrayList<ITemperature> array = new ArrayList<>();
			array.add(c1.getLowestTempByMonth(country, month));
			array.add(c1.getHighestTempByMonth(country, month));
			w.writeDataToFile("taskXX_climate_info.csv", "A1", array);
			System.out.println("File #1 Successfully Created!");
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		
		ClimateAnalyzer c2 = new ClimateAnalyzer();
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Task A2: Get The Lowest and Highest Temperature By Year For A Country");
		System.out.println("Enter a valid country");
		String country1 = scan1.nextLine();
		System.out.println("Enter a valid year from 2000-2016");
		int year = scan1.nextInt();
		while (year > 2016 || year < 2000)
		{
			System.out.println("Not a valid input. Please try again.");
			year = scan1.nextInt();
		}
		
		try
		{
			w.writeSubjectHeaderInFile("taskA2_climate_info.csv", "Lowest And Highest Temperature Of " + country1 + "in " + year);
			ArrayList<ITemperature> array1 = new ArrayList<>();
			array1.add(c2.getLowestTempByYear(country1, year));
			array1.add(c2.getHighestTempByYear(country1, year));
			w.writeDataToFile("taskXX_climate_info.csv", "A2", array1);
			System.out.println("File #2 Successfully Created!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ClimateAnalyzer c3 = new ClimateAnalyzer();
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Task A3: Get all temperature data that fall within the given temperature range");
		System.out.println("Enter a valid country");
		String country2 = scan2.nextLine();
		System.out.println("Enter a temperature");
		double temp1 = scan2.nextDouble();
		System.out.println("Enter another temperature");
		double temp2 = scan2.nextDouble();
		
		try
		{
			w.writeSubjectHeaderInFile("taskA3_climate_info.csv", "Temperature Within Range Of " + temp1 + "and " + temp2 + "for " + country2);
			TreeSet<ITemperature> tree1 = this.getTempWithinRange(country2, temp1, temp2);
			ArrayList<ITemperature> array2 = new ArrayList<>(tree1);
			w.writeDataToFile("taskXX_climate_info.csv", "A3", array2);
			System.out.println("File #3 Successfully Created!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ClimateAnalyzer c4 = new ClimateAnalyzer();
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Task A4: Get The Lowest and Highest Temperature By Country");
		System.out.println("Enter a valid country");
		String country3 = scan3.nextLine();
		
		try
		{
			w.writeSubjectHeaderInFile("taskA4_climate_info.csv", "Lowest And Highest Temperature Of " + country3);
			ArrayList<ITemperature> array = new ArrayList<>();
			array.add(c4.getLowestTempYearByCountry(country3));
			array.add(c4.getHighestTempYearByCountry(country3));
			w.writeDataToFile("taskXX_climate_info.csv", "A4", array);
			System.out.println("File #4 Successfully Created!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ClimateAnalyzer c5 = new ClimateAnalyzer();
		Scanner scan4 = new Scanner(System.in);
		System.out.println("Task B1: Get 10 Countries With The Lowest And Highest Temperature By Month");
		System.out.println("Enter an integer for month (1 - 12)");
		int month2 = scan4.nextInt();
		while (month2 > 12 || month2 < 1)
		{
			System.out.println("Not a valid input. Please try again.");
			month2 = scan4.nextInt();
		}
		
		try
		{
			w.writeSubjectHeaderInFile("taskB1_climate_info.csv", "10 Countries With Lowest And Highest Temperature In " + this.monthConverter(month2));
			ArrayList<ITemperature> a = c5.allCountriesGetTop10LowestTemp(month2);
			ArrayList<ITemperature> array = new ArrayList<>(a);
			ArrayList<ITemperature> b = c5.allCountriesGetTop10LowestTemp(month2);
			ArrayList<ITemperature> list = new ArrayList<>(b);
			w.writeDataToFile("taskXX_climate_info.csv", "B1-1", array);
			w.writeDataToFile("taskXX_climate_info.csv", "B1-2", list);
			System.out.println("Files #5 Successfully Created!");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ClimateAnalyzer c6 = new ClimateAnalyzer();
		System.out.println("Task B2: Get 10 Countries With The Lowest And Highest Temperature");
		
		try
		{
			w.writeSubjectHeaderInFile("taskB2_climate_info.csv", "10 Countries With Lowest And Highest Temperature");
			ArrayList<ITemperature> a = c6.allCountriesGetTop10LowestTemp();
			ArrayList<ITemperature> array = new ArrayList<>(a);
			ArrayList<ITemperature> b = c6.allCountriesGetTop10HighestTemp();
			ArrayList<ITemperature> list = new ArrayList<>(b);
			w.writeDataToFile("taskXX_climate_info.csv", "B2-1", array);
			w.writeDataToFile("taskXX_climate_info.csv", "B2-2", list);
			System.out.println("Files #6 Successfully Created!");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ClimateAnalyzer c7 = new ClimateAnalyzer();
		Scanner scan5 = new Scanner(System.in);
		System.out.println("Task B3: List Of Temperature Ranges");
		System.out.println("Enter A Temperature");
		double aTemp = scan5.nextDouble();
		System.out.println("Enter Another Temperature");
		double aTemp2 = scan5.nextDouble();
		
		try
		{
			w.writeSubjectHeaderInFile("taskB3_climate_info.csv", "List Of Temperature Ranges Between " + aTemp + "and " + aTemp2);
			ArrayList<ITemperature> a = c7.allCountriesGetAllDataWithinTempRange(aTemp, aTemp2);
			ArrayList<ITemperature> array = new ArrayList<>(a);
			w.writeDataToFile("taskXX_climate_info.csv", "B3", array);
			System.out.println("File #7 Successfully Created!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		ClimateAnalyzer c8 = new ClimateAnalyzer();
		Scanner scan6 = new Scanner(System.in);
		System.out.println("Task C1: List Of Temperature Differences Between 2 Years For A Month");
		System.out.println("Enter An Integer For Month (1-12)");
		int month3 = scan6.nextInt();
		while (month3 > 12 || month3 < 1)
		{
			System.out.println("Not a valid input. Please try again.");
			month3 = scan6.nextInt();
		}
		Scanner scan7 = new Scanner(System.in);
		System.out.println("Enter A Year");
		int year1 = scan7.nextInt();
		while (year1 > 2016 || year1 < 2000)
		{
			System.out.println("Not a valid input. Please try again.");
			year1 = scan7.nextInt();
		}
		Scanner scan8 = new Scanner(System.in);
		System.out.println("Enter Another Year");
		int year2 = scan8.nextInt();
		while (year2 > 2016 || year2 < 2000)
		{
			System.out.println("Not a valid input. Please try again.");
			year2 = scan8.nextInt();
		}
		
		try
		{
			w.writeSubjectHeaderInFile("taskC1_climate_info.csv", "List Of Temperature Differences Between " + year1 + "and " +year2 + "for " + this.monthConverter(month3));
			ArrayList<ITemperature> a = c8.allCountriesTop10TempDelta(month3, year1, year2);
			ArrayList<ITemperature> array = new ArrayList<>(a);
			w.writeDataToFile("taskXX_climate_info.csv", "C1", array);
			System.out.println("File #8 Successfully Created!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		ClimateAnalyzer c = new ClimateAnalyzer();
		//Scanner scan = new Scanner(System.in);
		//System.out.println("Enter a country");
		//String country = scan.nextLine();
		//System.out.println("Enter a number");
		//int month = scan.nextInt();
		//System.out.println(c.getLowestTempByMonth("Canada", 1));
		c.runClimateAnalyzer();
	}

}

package climatechange;

/**
 * @author Camellia
 */
public class Temperature implements ITemperature, Comparable<Temperature> {
	
	String country;
	String code;
	String month;
	int year;
	double temperature;
	
	double temp;
	String theMonth;
	int year1;
	int year2;
	String theCode;
	
	
	/**
	 * Constructs a Temperature and initializes the variables
	 * @param temperature
	 * @param year
	 * @param month
	 * @param country
	 * @param code
	 */
	public Temperature(double temperature, int year, String month, String country, String code)
	{
		this.country = country;
		this.code = code;
		this.month = month;
		this.year = year;
		this.temperature = temperature;
	}
	
	
	/**
	 * Converts a string of months into their corresponding numbers
	 * @param month
	 * @return the month as an integer
	 */
	public int monthConverter(String month)
	{
		if (month.equalsIgnoreCase("January") || month.equalsIgnoreCase("Jan"))
		{
			return 1;
		}
		else if (month.equalsIgnoreCase("February") || month.equalsIgnoreCase("Feb"))
		{
			return 2;
		}
		else if (month.equalsIgnoreCase("March") || month.equalsIgnoreCase("Mar"))
		{
			return 3;
		}
		else if (month.equalsIgnoreCase("April") || month.equalsIgnoreCase("Apr"))
		{
			return 4;
		}
		else if (month.equalsIgnoreCase("May"))
		{
			return 5;
		}
		else if (month.equalsIgnoreCase("June") || month.equalsIgnoreCase("Jun"))
		{
			return 6;
		}
		else if (month.equalsIgnoreCase("July") || month.equalsIgnoreCase("Jul"))
		{
			return 7;
		}
		else if (month.equalsIgnoreCase("August") || month.equalsIgnoreCase("Aug"))
		{
			return 8;
		}
		else if (month.equalsIgnoreCase("September") || month.equalsIgnoreCase("Sep"))
		{
			return 9;
		}
		else if (month.equalsIgnoreCase("October") || month.equalsIgnoreCase("Oct"))
		{
			return 10;
		}
		else if (month.equalsIgnoreCase("November") || month.equalsIgnoreCase("Nov"))
		{
			return 11;
		}
		else if (month.equalsIgnoreCase("December") || month.equalsIgnoreCase("Dec"))
		{
			return 12;
		}
		return 0;
	}
	
	/**
	 * Returns country
	 * @return the country
	 */
	public String getCountry() 
	{
		return country;
	}

	/**
	 * Returns the 3 letter code for the country
	 * @return the code
	 */
	public String getCountry3LetterCode() 
	{
		return code;
	}

	/**
	 * Returns month
	 * @return the month
	 */
	public String getMonth() 
	{
		return month;
	}

	/**
	 * Returns year
	 * @return the year
	 */
	public int getYear() 
	{
		return year;
	}

	/**
	 * Returns temperature. If getFahrenheit returns true, convert Celsius to Fahrenheit
	 * @return the temperature
	 */
	public double getTemperature(boolean getFahrenheit) 
	{
		if (getFahrenheit == true)
		{
			temperature = ((temperature/5) * 9) + 32;
		}
		return Math.round(temperature * 100.0)/100.0;
		
	}
	
	public String toString()
	{
		return getTemperature(false) + "(C)" + " " + getTemperature(true) + "(F)" + ", " + year + ", " + month + ", " + country + ", " + code;
	}
	
	/**
	 * Compares the temperature, country, year, and month of two ITemperature objects, in that order
	 */
	public int compareTo(Temperature other) 
	{
		if (Double.compare(temperature, other.temperature) != 0)
		{
			return Double.compare(temperature, other.temperature);
		}
		else if (country.compareTo(other.country) != 0)
		{
			return country.compareTo(other.country);
		}
		else if (Integer.compare(year, other.year) != 0)
		{
			return Integer.compare(year, other.year);
		}
		return Integer.compare(this.monthConverter(month), other.monthConverter(month));
	}
	
	public boolean equals(Object obj)
	{
		Temperature that = (Temperature)obj;
		return this.compareTo(that) == 0;
	}
	
	/**
	 * Returns the hashCode of the objects
	 * @return the hashCode
	 */
	public int hashCode()
	{
		return (int) temperature + year + month.hashCode() + country.hashCode() + code.hashCode();
	}
}

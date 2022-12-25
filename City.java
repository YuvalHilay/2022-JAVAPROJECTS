package cities;

/*
Class that describes city
*/
public class City implements Comparable<City> {
	private String name; //name of city
	private Country country; //country where the city locate
	private int population; //amount of population in the city
	public City(String name, Country country, int population) {//constructor
		this.name=name;
		this.country=country;
		this.population=population;
	}
	
	//return the name of city
	public String getName() {
		return name;
	}
	
	//return the country where the city locate
	public Country getCountry() {
		return country;
	}
	
	//return the amount of population
	public int getPopulation() {
		return population;
	}
	
	//toString
	@Override
	public String toString() {
		return String.format("%s (of %s)",name,country);
	}
	
	//comparing two city first by country and then the name of the cities
	@Override
	public int compareTo(City o) {//compare first the country than city
		if(country.compareTo(o.getCountry())>0) {
			return 1;
		}
		else if(country.compareTo(o.getCountry())<0)
			return -1;
		else
		{
			return name.compareTo(o.getName());
		}
	}
	
	//checking if two cities are equals
	@Override
	public boolean equals(Object obj) {
		City other=(City)obj;//casting
		if((name.equals(other.getName())) &&(country.equals(other.getCountry())))
			return true;
		
		return false;
	}
}

package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
Class that describes country
*/
public class Country implements Comparable<Country> {
	private Set<City> cities; //set of cities that locate in the country
	private String name; //name of the country
	public Country(String name) {//constructor
		this.name=name;
		cities=new TreeSet<>();
	}
	public void addCity(City city) {//add city to cities
		if(city.getCountry().equals(this)==false)//check country is ok
			throw new IllegalArgumentException();
		cities.add(city);//add the city
	}
	public int population() {//func calc population in country
		int sum=0;
		for(City c:cities) {//for each city sum the population
			sum+=c.getPopulation();
		}
		return sum;
	}
	
	//returning the name of the country
	@Override
	public String toString() {
		return name;
	}
	
	//return list of cities where the population is less then "under"
	public List<City> smallCities(int under){
		List<City> l=new ArrayList<>();//define the list
		for(City c: cities) {//for each city sum the population that is under and return the list
			if(c.getPopulation()<under)
				l.add(c);
		}
		return l;
	}
	
	//returning string which has all the details of the country and its cities
	public String report() {
		String s="";//define the string
		int count=0;
		s+=name+"("+population()+")"+" : ";
		for(City c: cities) {
			if(count!=cities.size()-1)//condition for comma
				s+=c.getName()+"("+c.getPopulation()+")"+", ";//add to the string 
			else
				s+=c.getName()+"("+c.getPopulation()+")";
			count++;
		}
		return s;
	}
	
	//checking of two countries are the same
	@Override
	public boolean equals(Object obj) {
		Country other=(Country)obj;//casting
		if(name.equals(other.name))
			return true;
		return false;
	}
	
	//comparing two countires
	@Override
	public int compareTo(Country o) {//use string compareto
		return name.compareTo(o.toString());
	}

}

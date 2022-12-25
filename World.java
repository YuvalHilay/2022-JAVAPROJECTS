package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Class that describes world 
*/
public class World {
	private Map<String, Country> countries; //all the countries in the world
	public World() {//constructor
		countries= new TreeMap<>();
	}
	
	public void addCountry(String name) {//add country to countries
		countries.put(name,new Country(name));
	}
	
	public void addCity(String name, String countryName, int population) {//func create city and add her
		int count=0;
		City c=new City(name,new Country(countryName),population);//create the city
		for(String i: countries.keySet()) {//run on country name
			if(i.equals(countryName)) //check if the country name of the city is the county name in countries
				countries.get(i).addCity(c);;//add to country
				count++;
		}
		if(count==0)//check if we add city
			throw new IllegalArgumentException();
	}
	public int population() {//fun return population of all counries
		int sum=0;
		for(String i: countries.keySet()) {//run on country name
			sum+=countries.get(i).population();//add every country population
		}
		return sum;
	}
	
	//function that return list of cities that their population is less then "under"
	public List<City> smallCities(int under){
		List<City> l=new ArrayList<>();//define the list
		for(String i: countries.keySet()) {
			l.addAll(countries.get(i).smallCities(under));//add all smallCities
		}
		return l;
	}
	
	//returning string which has all the details of all countries and their cities
	public String report() {
		String s="";
		for(String i: countries.keySet()) {
			s+=countries.get(i).report()+"\n";//take report from every country
		}
		s+="Total population is "+population()+"\n";
		return s;
	}

}

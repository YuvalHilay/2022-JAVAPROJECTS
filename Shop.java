package shop;

import java.util.ArrayList;
import java.util.List;

/*
Class that describe shop of musical Instruments
*/
public class Shop {
	private List<Instrument> instuArray=new ArrayList<>(); //define the ArrayList of Instruments
	public void add(Instrument i) {//func add Instrument
		instuArray.add(i);
	}
	public Instrument get(int serial) {//func return the Instrument that have the given serial
		for(Instrument i :instuArray)//run on Instruments and check serial
			if(i.getSerial()==serial)
				return i;
		return null;
	}
	public List<Integer> allSerials() { //func return serial of all Instruments
		List<Integer> serialArray=new ArrayList<>();//define the ArrayList of Integer
		for(Instrument i:instuArray)//run on Instruments and add serial
			serialArray.add(i.getSerial());
		return serialArray;
	}
	public List<Integer> guitarsOfType(Type t){//func return serial of all Guitar
		List<Integer> serialArray=new ArrayList<>();//define the ArrayList of Integer
		for(Instrument i:instuArray) {//run on Instruments and add check they are guitar and check the type and add their serial
			if(i instanceof Guitar && ((Guitar) i).getType() == t)
				serialArray.add(i.getSerial());
		}
		return serialArray;
	}
	public void sell(int serial) throws MusicShopException{//func that remove the Instrument with given serial
		int countguitar=0;
		Instrument g=get(serial);//get the Instrument with serial
		if(g==null)//check if he exists
			throw new MusicShopException("Instrument doesn't exsits");
		else if (g instanceof Guitar)//check if he guitar
		{
			for(Instrument i:instuArray) {//count the guitar Instrument and remove if we can
				if(i instanceof Guitar)
					countguitar++;
			}
			if(countguitar==1)
				throw new MusicShopException("only onr guiter");
			else
				instuArray.remove(g);
		}
		else
			instuArray.remove(g);
	}
	public int sellAll(int[] serials) throws MusicShopException {//func that remove the Instruments with given serial arrays
		int counter=0;
		for(int i=0;i<serials.length;i++) {//run on the array
			try {
				sell(serials[i]);//call sell
			}catch(MusicShopException e) {counter++;}//if sell dont succeed counter++
		}
		return counter;
	}

}

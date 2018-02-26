package controller;

import java.util.ArrayList;

import model.Household;

public class CentralHousehold {
	public static ArrayList<Household>households;
	private static CentralHousehold centralHousehold;
	
	private CentralHousehold(){
		households=new ArrayList<Household>();
		centralHousehold=null;
	}
	
	//create a singleton instance. 
	public static CentralHousehold getInstance(){
	        if (centralHousehold == null)
	            centralHousehold= new CentralHousehold();
	 
	        return centralHousehold;
	}
	
	public void printHouseholds(){
		households.forEach(s->System.out.println(s));
	}
	
	//find household by its ID
	public Household findHousehold(int id){
		for(Household h: households){
			if(h.getHouseholdID()==id)return h;
		}
		return null;
	}
	

}

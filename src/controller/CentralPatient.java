package controller;

import java.util.ArrayList;
import java.util.Collections;

import model.Patient;

public class CentralPatient {
	public static ArrayList<Patient>patients;
	private static CentralPatient centralPatient;
	
	private CentralPatient(){
		patients=new ArrayList<Patient>();
		centralPatient=null;
	}
	
	//create a singleton instance. 
	public static CentralPatient getInstance(){
	        if (centralPatient == null)
	            centralPatient= new CentralPatient();
	 
	        return centralPatient;
	}
	
	public void printPatients(){
		patients.forEach(s -> System.out.println(s));
	}
	
	//find patient by fname, lname, phone number
	public Patient findPatient(String fname, String lname, String phone){		
		for (Patient p : patients) {
				if(fname.equals(p.getFname()) && lname.equals(p.getLname())
						&& phone.equals(p.getPhone())){
					return p;
				}
		}
		return null;
	}
	
	//find patients by patient id
	public Patient findPatient(int pid){
		for (Patient p: patients){
			if(pid==p.getID())return p;
		}
		return null;
	}
	
	//print patients grouped by households
	public void printPatientsByHousehold(){
	   Collections.sort(
               patients,
               (p1, p2) -> p1.getHouseholdID()
                       - p2.getHouseholdID());
       patients.forEach(System.out::println);
	}
	
	

}

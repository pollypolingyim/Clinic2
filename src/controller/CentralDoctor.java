package controller;

import java.util.ArrayList;

import model.Doctor;

public class CentralDoctor {
	static ArrayList<Doctor> doctors;
	private static CentralDoctor centralDoctor;
	
	private CentralDoctor(){
		doctors = new ArrayList<Doctor>();
		centralDoctor = null;
	}
	
	//create a singleton instance. 
	public static CentralDoctor getInstance(){
	        if (centralDoctor == null)
	            centralDoctor= new CentralDoctor();
	 
	        return centralDoctor;
	}

	public void printDoctors(){
		doctors.forEach(s->System.out.println(s));
	}
	
	//find doctors by fullname
	public Doctor findDoctor(String fname){
		for (Doctor d: doctors){
			if(fname.equals(d.getFullname()))return d;
		}
		return null;
	}
	

}

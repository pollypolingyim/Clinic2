package controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import model.Payment;

public class CentralPayment {
	public static ArrayList<Payment>payments;
	private static CentralPayment centralPayment;
	
	private CentralPayment(){
		payments = new ArrayList<Payment>();
		centralPayment=null;
	}
	
	//create a singleton instance. 
	public static CentralPayment getInstance(){
	        if (centralPayment == null)
	            centralPayment= new CentralPayment();
	 
	        return centralPayment;
	}
	
	public void printPayments(){
		payments.forEach(s->System.out.println(s));
	}
	
	//find payment by date visited, time visited, patient ID
	public Payment findPayment(Date d, Time t, int pid){
		for(Payment p: payments){
			if(d.equals(p.getDateVisited())&&
					t.equals(p.getTimeVisited())&&
					pid==p.getPatientID())
					return p;
		}
		return null;
	}

}

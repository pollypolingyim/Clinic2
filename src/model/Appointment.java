package model;
import java.sql.Date;
import java.sql.Time;

public class Appointment {
	private Date date;
	private Time time;
	private String reason;
	private int doctorID;
	private int patientID;
	
	public Appointment(Date date, Time time, String reason, 
			int doctorID, int patientID){
		this.date=date;
		this.time=time;
		this.reason=reason;
		this.doctorID=doctorID;
		this.patientID=patientID;
	}
	
	private void setDate(Date d){date=d;}
	private void setTime(Time t){time=t;}
	private void setReason(String reason){this.reason=reason;}
	private void setDoctorID(int doc){doctorID=doc;}
	private void setPatientID(int patient){patientID=patient;}
	
	public void updateRecord(String updateField, Object newVal){
		if (updateField.equals("Date"))
			setDate((Date)newVal);
		else if (updateField.equals("Time"))
			setTime((Time)newVal);
		else if(updateField.equals("Reason"))
			setReason((String)newVal);
	}
	
	public void updateRecord(String updateField, int newVal){
		if (updateField.equals("Doctor ID"))
			setDoctorID(newVal);
		else if(updateField.equals("Patient ID"))
			setPatientID(newVal);
	}
	
	public String toString(){
		return "Date: "+ date+ " Time: "+time+" Patient ID: "
				+ patientID+ " Doctor ID: "+doctorID + " Reason: "
				+ reason+"\n";
	}
	
	public Date getDate(){return date;}
	public Time getTime(){return time;}
	public String getReason(){return reason;}
	public int getDoctorID(){return doctorID;}
	public int getPatientID(){return patientID;}

}

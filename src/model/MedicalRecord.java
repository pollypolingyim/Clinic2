package model;

import java.sql.Date;
import java.sql.Time;


public class MedicalRecord {
	public static enum BloodTestResult{Positive, Negative, NotApplicable};
	public static enum UrineTestResult{Positive, Negative, NotApplicable};
	
    private int patientID;
	private int doctorID;
	private Date appDate;
	private Time appTime;
	private String description;
	private BloodTestResult bresult;
	private UrineTestResult uresult;
	
	public MedicalRecord(int patientID, int doctorID, Date appDate, 
			Time appTime, String description, BloodTestResult bresult,
			UrineTestResult uresult){
		this.patientID=patientID;
		this.doctorID=doctorID;
		this.appDate = appDate;
		this.appTime = appTime;
		this.description=description;
		this.bresult = bresult;
		this.uresult = uresult;
	}
	
	private void setPatientID(int pid){patientID=pid;}
	private void setDoctorID(int did){doctorID = did;}
	private void setAppDate(Date date){appDate = date;}
	private void setAppTime(Time time){appTime = time;}
	private void setDescription(String des){description=des;}
	private void setBresult(BloodTestResult b){bresult = b;}
	private void setUresult(UrineTestResult u){uresult = u;}
	
	public void updateRecord(String updateField, Object newVal){
		if(updateField.equals("Appointment Date"))
			setAppDate((Date)newVal);
		else if(updateField.equals("Appointment Time"))
			setAppTime(appTime = (Time)newVal);
		else if (updateField.equals("Description"))
			setDescription((String)newVal);
		else if(updateField.equals("Blood Test Result"))
		    setBresult((BloodTestResult)newVal);
		else if (updateField.equals("Urine Test Result"))
			setUresult((UrineTestResult)newVal);
	}
	
	public void updateRecord(String updateField, int newVal){
		if(updateField.equals("Patient ID"))
			setPatientID(newVal);
		else if(updateField.equals("Doctor ID"))
			setDoctorID(newVal);
	}
	
	public String toString(){
		return "Patient ID: "+patientID+ " Doctor ID: "+doctorID
				+ " App date: "+ appDate + " App time: "+appTime
				+ " Description: "+description+ " Blood test result: "
				+ bresult+ " Urine test result: "+uresult+"\n";
	}
	
	public int getPatientID(){return patientID;}
	public int getDoctorID(){return doctorID;}
	public Date getAppDate(){return appDate;}
	public Time getAppTime(){return appTime;}
	public String getDecription(){return description;}
	public BloodTestResult getBresult(){return bresult;}
	public UrineTestResult getUresult(){return uresult;}
	
}

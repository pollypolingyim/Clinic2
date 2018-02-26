package model;

import java.sql.Date;

public class Patient {
	public static enum CoverageType {None, Single, Family};
	private static int patientCounter;
	
	private int id;
	private String fname;
	private String lname;
	private Date dob;
	private int primaryDocID;
	private char gender;
	private String phoneNum;
	private CoverageType coverage;
	private int householdID;
	
	public Patient (String fname, String lname, Date dob, int doc, 
			char gender, String phone, CoverageType ct,int householdID){
		this.fname = fname;
		this.lname = lname;
		this.dob=dob;
		primaryDocID = doc;
		this.gender = gender;
		phoneNum = phone;
		coverage = ct;
		if (coverage.equals(CoverageType.None))this.householdID=-1;
		else this.householdID = householdID;
		id = ++patientCounter;//this number cannot be changed
	}
	
	private void setFname (String fname){this.fname = fname;}
	private void setLname (String lname){this.lname = lname;}
	private void setDob (Date dob){this.dob=dob;}
	private void setDocID (int doc){primaryDocID = doc;}
	private void setGender (char gender){this.gender = gender;}
	private void setPhone (String phone){phoneNum = phone;}
	private void setCoverageType (CoverageType ct){coverage=ct;}
	private void setHouseholdID(int householdID){
		if (coverage.equals(CoverageType.None))this.householdID=-1;
		else this.householdID = householdID;
	}
	
	public void updateRecord(String updateField, Object newVal){
		if(updateField.equals("First name"))setFname((String)newVal);
		else if (updateField.equals("Last name"))setLname((String)newVal);
		else if (updateField.equals("DOB"))setDob((Date)newVal);
		else if (updateField.equals("Phone"))setPhone((String)newVal);
		else if (updateField.equals("Coverage type"))
			setCoverageType((CoverageType)newVal);
	}
	
	public void updateRecord(String updateField, int newVal){
		if(updateField.equals("Doctor ID"))setDocID(newVal);
		else if (updateField.equals("Household ID"))
			setHouseholdID(newVal);
		else if (updateField.equals("Gender"))
			setGender((char) newVal);
	}
	
	public String toString(){
		return "ID: "+ id + " First name: " +fname+" Last name: " +lname
				+ " DOB: "+ dob+ " Primary Doctor ID: " + primaryDocID
				+ " Gender: "+gender+ " Coverage Type: "+coverage
				+ " Household ID "+householdID+ "\n";
	}
	
	public int getID(){return id;}
	public String getFname (){return fname;}
	public String getLname (){return lname;}
	public Date getDob (){return dob;}
	public int getDocID (){return primaryDocID;}
	public char getGender (){return gender;}
	public String getPhone (){return phoneNum;}
	public CoverageType getCoverageType (){return coverage;}
	public int getHouseholdID(){return householdID;}


}

package model;

import java.sql.Date;
import java.sql.Time;


public class Schedule {
	public static enum Type{Off, Lunch, Vacation, 
		Booked, Conference,Available};
		
	private Date date;
	private Time time;
	private Type type;
	private int doctorID;
	
	public Schedule(Date date, Time time, Type type, int doctorID){
		this.date=date;
		this.time=time;
		this.type=type;
		this.doctorID=doctorID;
	}
	
	private void setDate(Date d){date =d;}
	private void setTime(Time t){time=t;}
	private void setType(Type t){type=t;}
	private void setDoctorID(int doc){doctorID=doc;}
	
	public void updateRecord(String updateField, Object newVal){
		if (updateField.equals("Date"))
			setDate((Date)newVal);
		else if (updateField.equals("Time"))
			setTime((Time)newVal);
		else if (updateField.equals("Type"))
			setType((Type)newVal);		
	}
	
	public void updateRecord (String updateField, int newVal){
		if (updateField.equals("Doctor ID"))
			setDoctorID(newVal);
	}
	
	public Date getDate(){return date;}
	public Time getTime(){return time;}
	public Type getType(){return type;}
	public int getDoctorID(){return doctorID;}

}

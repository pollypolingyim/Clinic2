package model;

import java.sql.Date;
import java.sql.Time;


public class Payment  {
	public static enum InsStatus{ReqSent, AmtRec, NotApplicable}
	
	private Date dateVisited;
	private Time timeVisited;
	private int patientID;
	private int doctorID;
	private float currentBal;
	private InsStatus insStat;
	private float amount; //requested or received amount, $0 if status not applicable
	private Date dateSentRec; //the request date or received date for insurance
	
	public Payment (Date dv, Time tv, int pid, int did, float bal, 
			InsStatus ins, float amount, Date dsr){
		dateVisited = dv;
		timeVisited=tv;
		patientID=pid;
		doctorID=did;
		insStat = ins;
		currentBal = bal;
		this.amount=amount;
		dateSentRec = dsr;
		if(ins.equals(InsStatus.NotApplicable)){
			this.amount = 0;
			dateSentRec = null;
		}
	}
	
	private void setDateVisited(Date dv){dateVisited=dv;}
	private void setTimeVisited(Time tv){timeVisited=tv;}
	private void setPatientID(int patient){patientID=patient;}
	private void setDoctorID(int doc){doctorID=doc;}
	private void setInsStat(InsStatus ins){insStat = ins;}
	private void setCurrentBal(float bal){currentBal=bal;}
	private void setAmount (float amt){
		if(insStat.equals(InsStatus.NotApplicable)) amount =0;
		else amount = amt;
	}
	private void setDateSentRec(Date d){dateSentRec=d;}
	
	public void updateRecord(String updateField, Object newVal){
		if(updateField.equals("Date visited"))
			setDateVisited((Date)newVal);
		else if(updateField.equals("Time visited"))
			setTimeVisited ((Time)newVal);
		else if (updateField.equals("Insurance Status"))
			setInsStat ((InsStatus)newVal);
		else if(updateField.equals("Insurance sent / received date"))
			setDateSentRec((Date)newVal);
	}
	
	public void updateRecord(String updateField, int newVal){
		if(updateField.equals("Patient ID"))
			setPatientID(newVal);
		else if(updateField.equals("Doctor ID"))
			setDoctorID(newVal);
	}
	
	public void updateRecord (String updateField, float newVal){
		if (updateField.equals("Amount requested or received"))
			setAmount(newVal);
		else if(updateField.equals("Current Balance"))
			setCurrentBal(newVal);
	}
	
	public Date getDateVisited(){return dateVisited;}
	public Time getTimeVisited(){return timeVisited;}
	public int getPatientID(){return patientID;}
	public int getDoctorID(){return doctorID;}
	public InsStatus getInsStat(){return insStat;}
	public float getCurrentBal(){return currentBal;}
	public float getAmount(){return amount;}
	public Date getDateSentRec(){return dateSentRec;}
	

}

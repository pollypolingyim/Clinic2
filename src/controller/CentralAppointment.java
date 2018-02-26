package controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import model.Appointment;
import model.Patient;
import model.Schedule;

public class CentralAppointment {
	public static ArrayList<Appointment>appointments;
	private static CentralAppointment centralAppointment;
	
	private CentralAppointment(){
		appointments = new ArrayList<Appointment>();
		centralAppointment=null;
	}
	
	//create a singleton instance. 
	public static CentralAppointment getInstance(){
	        if (centralAppointment == null)
	            centralAppointment= new CentralAppointment();
	 
	        return centralAppointment;
	}
	
	public void printAppointments(){
		appointments.forEach(s->System.out.println(s));
	}
	
	//print appointments grouped by doctors
	public void printAppsByDoctors(){
		Collections.sort(
				appointments,
				(a1,a2)->a1.getDoctorID()-
						a2.getDoctorID());
		appointments.forEach(System.out::println);
	}

	//find appointments by date, time, and doctorID
	public Appointment findAppointment(Date d, Time t, int doc){
		for (Appointment a:appointments){
			if(d.equals(a.getDate())&&t.equals(a.getTime())
					&& doc==a.getDoctorID())
				return a;
		}
		return null;
	}
	
	public void bookAppointment(Date d, Time t, String reason, int doctorID, 
			int patientID){
		if(isAvailable(d,t,doctorID)){
			appointments.add(new Appointment(d,t,reason,doctorID,
					patientID));//add an app record 
			System.out.println("Booked successfully");
		}
		System.out.println("Cannot book");
	}
	
	@SuppressWarnings("deprecation")
	private boolean isAvailable (Date d, Time t, int doctorID){
		CentralSchedule cs=CentralSchedule.getInstance();
		for (Schedule s: cs.schedules){
			if (d.getDay()==0){//if the requested date is a Sunday
				return false;
			}
			else if ((d.getTime()>=0 && d.getTime()<8)||
				    (d.getTime()>18)){//if the requested time is out of working hours
				return false;
			}
			else if(doctorID==s.getDoctorID()&&//if a record is found in schedules 
					t.equals(s.getTime())&&
					d.equals(s.getDate())){
				
					if(s.getType().equals(Schedule.Type.Available)){//if it is available
						s.updateRecord("Type",Schedule.Type.Booked);//change it to booked
						return true;
					}
					else return false;//if it is not available
			}
			else{//if a record is not found in schedules
					cs.schedules.add(new Schedule(d,t,
						Schedule.Type.Booked, doctorID));//add a record to schedules list
					return true;
			}
		}
		return false;
	}
	
	//parameter: doctor ID
	public void printNextDayAppByDoctor(int did){
		LocalDate d = LocalDate.now();
		for (Appointment a: appointments){
			if(a.getDate().compareTo(Date.valueOf(d))==1//one day after today
					&& a.getDoctorID()==did)
				System.out.println(a);
			if(Date.valueOf(d).getDay()==5 && //if today is friday
				a.getDoctorID()==did &&
				a.getDate().compareTo(Date.valueOf(d))==3)//monday is also included
				System.out.println(a);
		}
	}
	
	public void printNextDayCallList(){
		LocalDate d = LocalDate.now();
		CentralPatient cp=CentralPatient.getInstance();
		for(Appointment a: appointments){
			if(a.getDate().compareTo(Date.valueOf(d))==1||//one day after today
			   ((a.getDate().compareTo(Date.valueOf(d))==3)
			    && Date.valueOf(d).getDay()==5)){//three day after today if today is friday
				Patient p=cp.findPatient(a.getPatientID());	
				System.out.println("Time : "+a.getTime()+
						" First name: " + p.getFname()+
						" Last name: " + p.getLname()+
						" Phone " + p.getPhone() +"\n");
			}		
		}
	}	
}

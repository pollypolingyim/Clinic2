package controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;


import model.Appointment;
import model.Doctor;
import model.Household;
import model.MedicalRecord;
import model.Patient;
import model.Payment;
import model.Schedule;

public class Central{
	public static ArrayList<Appointment>appointments;
	public static ArrayList<Doctor> doctors;
	public static ArrayList<Household>households;
	public static ArrayList<MedicalRecord>medRecords;
	public static ArrayList<Patient>patients;
	public static ArrayList<Payment>payments;
	public static ArrayList<Schedule>schedules;
	
	public Central(){
		appointments = new ArrayList<Appointment>();
		doctors = new ArrayList<Doctor>();
		households=new ArrayList<Household>();
		medRecords=new ArrayList<MedicalRecord>();
		patients=new ArrayList<Patient>();
		payments = new ArrayList<Payment>();
		schedules = new ArrayList<Schedule>();
	}

	public void printAppointments(){
		appointments.forEach(s->System.out.println(s));
	}
	
	public void printDoctors(){
		doctors.forEach(s->System.out.println(s));
	}
	
	public void printHouseholds(){
		households.forEach(s->System.out.println(s));
	}
	
	public void printMedicalRecords(){
		medRecords.forEach(s->System.out.println(s));
	}
	
	public void printPatients(){
		patients.forEach(s -> System.out.println(s));
	}
	
	public void printPayments(){
		payments.forEach(s->System.out.println(s));
	}
	
	public void printSchedules(){
		schedules.forEach(s->System.out.println(s));
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
	
	//find doctors by fullname
	public Doctor findDoctor(String fname){
		for (Doctor d: doctors){
			if(fname.equals(d.getFullname()))return d;
		}
		return null;
	}
	
	//find household by its ID
	public Household findHousehold(int id){
		for(Household h: households){
			if(h.getHouseholdID()==id)return h;
		}
		return null;
	}
	
	//find medical record by doctor ID, app date and app time
	public MedicalRecord findMedRecord(int pid, Date d, Time t){
		for(MedicalRecord m: medRecords){
			if(pid==m.getPatientID()&&d.equals(m.getAppDate())
					&& t.equals(m.getAppTime()))
					return m;
		}
		return null;
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
	
	//find schedule by doctor id, date, and time
	public Schedule findSchedule(Date d, Time t, int did){
		for(Schedule s:schedules){
			if(d.equals(s.getDate())&&
				t.equals(s.getTime())&&
				did==s.getDoctorID())
				return s;
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
	
	//print medical records grouped by patients
	public void printMedRecordsByPatients(){
		Collections.sort(
				medRecords,
				(m1,m2)->m1.getPatientID()-
						m2.getPatientID());
		medRecords.forEach(System.out::println);
	}
	
	//print appointments grouped by doctors
	public void printAppsByDoctors(){
		Collections.sort(
				appointments,
				(a1,a2)->a1.getDoctorID()-
						a2.getDoctorID());
		appointments.forEach(System.out::println);
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
		for (Schedule s: schedules){
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
					schedules.add(new Schedule(d,t,
						Schedule.Type.Booked, doctorID));//add a record to schedules list
					return true;
			}
		}
		return false;
	}
	
	//para: doctor ID
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
		for(Appointment a: appointments){
			if(a.getDate().compareTo(Date.valueOf(d))==1||//one day after today
			   ((a.getDate().compareTo(Date.valueOf(d))==3)
			    && Date.valueOf(d).getDay()==5)){//three day after today if today is friday
				Patient p =findPatient(a.getPatientID());	
				System.out.println("Time : "+a.getTime()+
						" First name: " + p.getFname()+
						" Last name: " + p.getLname()+
						" Phone " + p.getPhone() +"\n");
			}		
		}
	}	
}


	


	

	
	



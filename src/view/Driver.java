package view;
import java.sql.Date;
import java.sql.Time;

import controller.CentralAppointment;
import controller.CentralDoctor;
import controller.CentralHousehold;
import controller.CentralMedicalRecord;
import controller.CentralPatient;
import controller.CentralSchedule;
import model.Patient;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CentralAppointment ca=CentralAppointment.getInstance();
		CentralDoctor cd=CentralDoctor.getInstance();
		CentralHousehold ch=CentralHousehold.getInstance();
		CentralMedicalRecord cm=CentralMedicalRecord.getInstance();
		CentralPatient cp=CentralPatient.getInstance();
		CentralPatient cpay = CentralPatient.getInstance();
		CentralSchedule cs=CentralSchedule.getInstance();
		
		
		//add patients
		cp.patients.add(new Patient("A","A",Date.valueOf("2014-11-13"),
				1, 'F',"6135005000", Patient.CoverageType.Single,2));
		cp.patients.add(new Patient("B","B",Date.valueOf("2014-11-13"),
				2, 'M',"6135005000", Patient.CoverageType.Family,1));
		cp.patients.add(new Patient("C","C",Date.valueOf("2014-11-13"),
				3, 'F',"6135005000", Patient.CoverageType.Single,3));
		cp.patients.add(new Patient("D","D",Date.valueOf("2014-11-13"),
				1, 'M',"6135005000", Patient.CoverageType.Family,1));
		cp.patients.add(new Patient("D","D",Date.valueOf("2014-11-13"),
				1, 'M',"6135005000", Patient.CoverageType.None,1));
		
		//print patients
		cp.printPatients();
		
		//update a patient
		cp.findPatient("B", "B", "6135005000").updateRecord("First name","BB");
		
		//print patients
		cp.printPatients();
		
		//delete a patient
		cp.patients.remove(cp.findPatient("A", "A", "6135005000"));
		
		//validate it has been deleted
		System.out.println("Validate it has been removed");
		cp.printPatients();
		
		//sort by household
		System.out.println("Print patients by households");
		cp.printPatientsByHousehold();
		
		//book an appointment
		ca.bookAppointment(Date.valueOf("2018-03-01"), Time.valueOf("10:00:00"), 
				"sick", 1, 1);
		
		//cancel an appointment
		ca.appointments.remove(ca.findAppointment(Date.valueOf("2018-03-01"),
				Time.valueOf("09:00:00"), 1));
		
	}

}

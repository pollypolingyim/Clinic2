package view;
import java.sql.Date;
import java.sql.Time;

import controller.Central;
import model.Patient;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Central c=new Central();
		
		//add patients
		c.patients.add(new Patient("A","A",Date.valueOf("2014-11-13"),
				1, 'F',"6135005000", Patient.CoverageType.Single,2));
		c.patients.add(new Patient("B","B",Date.valueOf("2014-11-13"),
				2, 'M',"6135005000", Patient.CoverageType.Family,1));
		c.patients.add(new Patient("C","C",Date.valueOf("2014-11-13"),
				3, 'F',"6135005000", Patient.CoverageType.Single,3));
		c.patients.add(new Patient("D","D",Date.valueOf("2014-11-13"),
				1, 'M',"6135005000", Patient.CoverageType.Family,1));
		c.patients.add(new Patient("D","D",Date.valueOf("2014-11-13"),
				1, 'M',"6135005000", Patient.CoverageType.None,1));
		
		//print patients
		c.printPatients();
		
		//update a patient
		c.findPatient("B", "B", "6135005000").updateRecord("First name","BB");
		
		//print patients
		c.printPatients();
		
		//delete a patient
		c.patients.remove(c.findPatient("A", "A", "6135005000"));
		
		//validate it has been deleted
		System.out.println("Validate it has been removed");
		c.printPatients();
		
		//sort by household
		System.out.println("Print patients by households");
		c.printPatientsByHousehold();
		
		//book an appointment
		c.bookAppointment(Date.valueOf("2018-03-01"), Time.valueOf("10:00:00"), 
				"sick", 1, 1);
		
		//cancel an appointment
		c.appointments.remove(c.findAppointment(Date.valueOf("2018-03-01"),
				Time.valueOf("09:00:00"), 1));
		
				
		
	
	}

}

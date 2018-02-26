package controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;

import model.MedicalRecord;

public class CentralMedicalRecord {
	public static ArrayList<MedicalRecord>medRecords;
	private static CentralMedicalRecord centralMedicalRecord;
	
	private CentralMedicalRecord(){
		medRecords=new ArrayList<MedicalRecord>();
		centralMedicalRecord = null;
	}
	
	//create a singleton instance. 
	public static CentralMedicalRecord getInstance(){
	        if (centralMedicalRecord == null)
	            centralMedicalRecord= new CentralMedicalRecord();
	 
	        return centralMedicalRecord;
	}
	
	public void printMedicalRecords(){
		medRecords.forEach(s->System.out.println(s));
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
	
	//print medical records grouped by patients
	public void printMedRecordsByPatients(){
		Collections.sort(
				medRecords,
				(m1,m2)->m1.getPatientID()-
						m2.getPatientID());
		medRecords.forEach(System.out::println);
	}

}

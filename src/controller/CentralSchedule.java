package controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import model.Schedule;

public class CentralSchedule {
	public static ArrayList<Schedule>schedules;
	private static CentralSchedule centralSchedule;
	
	private CentralSchedule(){
		schedules = new ArrayList<Schedule>();
		centralSchedule = null;
	}
	
	//create a singleton instance. 
	public static CentralSchedule getInstance(){
	        if (centralSchedule == null)
	            centralSchedule= new CentralSchedule();
	 
	        return centralSchedule;
	}
	
	public void printSchedules(){
		schedules.forEach(s->System.out.println(s));
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

}

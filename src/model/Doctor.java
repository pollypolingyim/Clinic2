package model;

public class Doctor {
	public static enum Specialty {GP, Cardiologist, Dermatologist};
    private static int doctorCounter;
	
	private int id;
	private String fullName;
	private Specialty specialty;
	
	public Doctor (String fullName, Specialty spec){
		this.fullName =fullName;
		specialty=spec;
		id=++doctorCounter;
	}
	
	private void setFullname(String fname){fullName = fname;}
	private void setSpecialty(Specialty spec){specialty=spec;}
	
	public void updateRecord(String updateField, Object newVal){
		if (updateField.equals("Full name"))
			setFullname((String)newVal);
		else if (updateField.equals("Specialty"))
			setSpecialty((Specialty)newVal);
	}
	
	public String toString(){
		return "Doctor ID: "+id+ " Full name: " + fullName+
				" Specialty: "+specialty+"\n";
	}
	
	public String getFullname (){return fullName;}
	public Specialty getSpecialty(){return specialty;}
	public int getID (){return id;}

}

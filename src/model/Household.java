package model;

public class Household {
	public static enum CoverageExt {medical, prescriptions, 
		paramedical, vision, dental};
	private static int householdCounter;
	
	private int id;
	private String insComName;
	private int policyNum;
	private CoverageExt coverage;
	
	public Household(String ins, int policyNum, CoverageExt coverage){
		insComName = ins;
		this.policyNum = policyNum;
		this.coverage=coverage;
		id=++householdCounter;
	}
	
	private void setInsComName (String ins){insComName = ins;}
    private void setPolicyNum(int policyNum){this.policyNum=policyNum;}
    private void setCoverage(CoverageExt coverage){this.coverage=coverage;}
    
    public void updateRecord(String updateField, Object newVal){
    	if(updateField.equals("Insurance Company"))
    		setInsComName((String)newVal);
    	else if (updateField.equals("Coverage Extent"))
    		setCoverage((CoverageExt) newVal);
	}
    
    public void updateRecord(String updateField, int newVal){
    	if (updateField.equals("Policy Number"))
    		setPolicyNum(newVal);
    }
    
    public String toString(){
    	return "ID: " + id+ " Insurance Company Name: "+insComName+
    			" Policy Number: "+policyNum + " Coverage: "+
    			coverage+"\n";
    }
	
    public int getHouseholdID(){return id;}
    public String getInsComName(){return insComName;}
    public int getPolicyNum(){return policyNum;}
    public CoverageExt getCoverage(){return coverage;}
    
	

}

package sales;

import java.util.Map;

public class salesparty {
	

	String sPId;
	String sPName;
	String sPNum;
	String  salesopeningAccount;
	
	public void salesPartyOpt() {
		
		System.out.println("Select: \n 1.Insert \n 2.View \n 3.update \n 4.Delete \n 5.Exit \n");
	}

	public String getsPId() {
		return sPId;
	}

	public void setsPId(String sPId) {
		this.sPId = sPId;
	}

	public String getsPName() {
		return sPName;
	}

	public void setsPName(String sPName) {
		this.sPName = sPName;
	}

	public String getsPNum() {
		return sPNum;
	}

	public void setsPNum(String sPNum) {
		this.sPNum = sPNum;
	}

	public String getSalesopeningAccount() {
		return salesopeningAccount;
	}

	public void setSalesopeningAccount(String salesopeningAccount) {
		this.salesopeningAccount = salesopeningAccount;
	}
	
	
	public void showSalesParty(Map<String,salesparty> map) {
		   
		   System.out.println(" |    Id    |   Name   |    Contact No.  |  Opening Account  | \n");
		  
		   
		   for(Map.Entry<String, salesparty> val:map.entrySet()) {
			   
			   System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getsPName()+"   \t\t  "
			   		+ "  "+val.getValue().getsPNum()+" \t "+" \t"+val.getValue().getSalesopeningAccount()+"\n");
			   
		   }
		   
		   
	   }
	
	
	
	 public void updateSalesParty(String sPId,Map<String,salesparty>map,String newVal,String updateKey,salesparty Sobj) {
		   
		   for(Map.Entry<String,salesparty>val:map.entrySet()) {
			   
			   if(updateKey.equals("Name")) {
				    if(val.getKey().equals(sPId)) {
				    	Sobj.setsPName(newVal);
				    	map.put(sPId,Sobj);
				    	
				    	System.out.println("Name updated .......");
				    	break;
				    }
				   
			   }
			   else if(updateKey.equals("number")) {
				   
				   if(val.getKey().equals(sPId)) {
				    	Sobj.setsPNum(newVal);
				    	map.put(sPId,Sobj);
				    	
				    	
				    	System.out.println("Number updated .......");
				    	break;
				    }
				   
				   
			   }
			   
			   else if(updateKey.equals("account")) {
				   
				   if(val.getKey().equals(sPId)) {
				    	Sobj.setSalesopeningAccount(newVal);
				    	map.put(sPId,Sobj);
				    	
				    	
				    	System.out.println("Account updated ......");
				    	break;
				    }
				   
			   }
		   }
		   
		   
	   }
	 
	 
	 
	  public void deleteSalesParty(String sPId,Map<String,salesparty>map) {
		   
		   for(Map.Entry<String,salesparty>val:map.entrySet()) {
			   
			   if(val.getKey().equals(sPId)) {
				   map.remove(sPId);
				   System.out.println("Sales Party Deleted ....");
				   break;
			   }
		   }
		   
	   }
	   
	
	

}

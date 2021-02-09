package sales;

import java.util.Map;

public class client {
	
	String clId;
	String clName;
	String clNum;
	String openingAccount;
	
	public void partyOpt() {
		
		System.out.println("Select: \n 1.Insert \n 2.View \n 3.update \n 4.Delete \n 5.Exit \n");
	}
	public String getClientId() {
		return clId;
	}
	
	
	
	
	public void setClientId(String clId) {
		this.clId = clId;
	}
	
	
	
	public String getClientName() {
		return clName;
	}
	
	
	public void setClientName(String clName) {
		this.clName = clName;
	}
	
	
	
	public String getClientNum() {
		return clNum;
	}
	
	
	
	
	public void setClientNum(String clNum) {
		this.clNum = clNum;
	}
	public String getOpeningAccount() {
		return openingAccount;
	}
	public void setOpeningAccount(String openingAccount) {
		this.openingAccount = openingAccount;
	}
	
	
	 public void showParty(Map<String,client> map) {
		   
		   System.out.println(" |    Id    |   Name   |    Contact No.  |  Opening Account  | \n");
		  
		   
		   for(Map.Entry<String, client> val:map.entrySet()) {
			   
			   System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getClientName()+"   \t\t  "
			   		+ "  "+val.getValue().getClientNum()+" \t "+" \t"+val.getValue().getOpeningAccount()+"\n");
			   
		   }
		   
		   
	   }
	 
	 
	 public void updateParty(String cid,Map<String,client>map,String updateVal,String updateKey,client obj) {
		   
		   for(Map.Entry<String,client>val:map.entrySet()) {
			   
			   if(updateKey.equals("Name")) {
				    if(val.getKey().equals(cid)) {
				    	obj.setClientName(updateVal);
				    	map.put(cid,obj);
				    	
				    	System.out.println("Name updated .......");
				    	break;
				    }
				   
			   }
			   else if(updateKey.equals("number")) {
				   
				   if(val.getKey().equals(cid)) {
				    	obj.setClientNum(updateVal);
				    	map.put(cid,obj);
				    	
				    	
				    	System.out.println("Number updated .......");
				    	break;
				    }
				   
				   
			   }
			   
			   else if(updateKey.equals("account")) {
				   
				   if(val.getKey().equals(cid)) {
				    	obj.setOpeningAccount(updateVal);
				    	map.put(cid,obj);
				    	
				    	
				    	System.out.println("Account updated ......");
				    	break;
				    }
				   
			   }
		   }
		   
		   
	   }
	   
	   public void deleteParty(String cid,Map<String,client>map) {
		   
		   for(Map.Entry<String,client>val:map.entrySet()) {
			   
			   if(val.getKey().equals(cid)) {
				   map.remove(cid);
				   System.out.println("Party Deleted ....");
				   break;
			   }
		   }
		   
	   }
	
	

}



import java.util.Map;

public class party {
	
	String partyId;
	String partyName;
	String partyNum;
	String openingAccount;
	
	public void partyOpt() {
		
		System.out.println("Select: \n 1.Insert \n 2.View \n 3.update \n 4.Delete \n 5.Exit \n");
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public String getPartyNum() {
		return partyNum;
	}
	public void setPartyNum(String partyNum) {
		this.partyNum = partyNum;
	}
	public String getOpeningAccount() {
		return openingAccount;
	}
	public void setOpeningAccount(String openingAccount) {
		this.openingAccount = openingAccount;
	}
	
	
	 public void showParty(Map<String,party> map) {
		   
		   System.out.println(" |    Id     |      Name     |    Contact Num      |  |  Opening Account  | \n");
		  
		   
		   for(Map.Entry<String, party> val:map.entrySet()) {
			   
			   System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getPartyName()+"   \t\t  "
			   		+ "  "+val.getValue().getPartyNum()+" \t "+" \t"+val.getValue().getOpeningAccount()+"\n");
			   
		   }
		   
		   
	   }
	 
	 
	 public void updateParty(String cid,Map<String,party>map,String updateVal,String updateKey,party obj) {
		   
		   for(Map.Entry<String,party>val:map.entrySet()) {
			   
			   if(updateKey.equals("Name")) {
				    if(val.getKey().equals(cid)) {
				    	obj.setPartyName(updateVal);
				    	map.put(cid,obj);
				    	System.out.println("Name updated Successfully");
				    	break;
				    }
				   
			   }
			   else if(updateKey.equals("number")) {
				   
				   if(val.getKey().equals(cid)) {
				    	obj.setPartyNum(updateVal);
				    	map.put(cid,obj);
				    	System.out.println("Number updated Successfully");
				    	break;
				    }
				   
				   
			   }
			   
			   else if(updateKey.equals("account")) {
				   
				   if(val.getKey().equals(cid)) {
				    	obj.setOpeningAccount(updateVal);
				    	map.put(cid,obj);
				    	System.out.println("Account updated Successfully");
				    	break;
				    }
				   
			   }
		   }
		   
		   
	   }
	   
	   public void deleteParty(String cid,Map<String,party>map) {
		   
		   for(Map.Entry<String,party>val:map.entrySet()) {
			   
			   if(val.getKey().equals(cid)) {
				   map.remove(cid);
				   System.out.println("Party Deleted Successfully!!!!");
				   break;
			   }
		   }
		   
	   }
	
	

}

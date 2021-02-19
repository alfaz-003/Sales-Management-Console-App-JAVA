package sales;

import java.util.Map;


import java.util.*;


import java.util.Scanner;


public class table {
	
	
	float price;
	
	float subTotal;
	
	int quantity;
	
	float total;
	
	String tablenum;
	
	String date;
	
	String partyName;
	
	//making table object
	table tb;
	
	public String gettablenum() {
		return tablenum;
	}
	public void settablenum(String tablenum) {
		this.tablenum = tablenum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}



	Scanner sc = new Scanner(System.in);
	
    public void viewtable(Map<String,table> map) {
		 
		 total = total+ price;
		 
		 System.out.println("\n|     table Number  |     issue  Date    |    Party    |    Total      |  Total Items    | \n");
		 
		 for(Map.Entry<String, table> val:map.entrySet()) {
			   
			   System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getDate()+"   \t\t  "
			   		+ "  "+" \t "+" \t"+val.getValue().getPartyName()+"\t"+val.getValue().getPrice()+"\t"+val.getValue().getQuantity());
			   
		   }
		 
		 
		 
	 }
    
    
    
    public void deletetable(String tableId,Map<String,table>tableMap) {
    	
        for(Map.Entry<String, table>val:tableMap.entrySet()) {
        	
        	
        	
 		
 		if(tableId.equalsIgnoreCase(val.getValue().gettablenum())) {
 			
 			tableMap.remove(tableId);
 			System.out.println("Deleted Successfully!!");
 			break;
 			
 		}
 		
 	}
 	
 }
    
    
    public boolean checktable(Map<String,table>map,int quantity,table obj,float price) { 
    	
	    boolean flag = false;
	    
	 
	
		for(Map.Entry<String, table>val:map.entrySet()) {
			
			if(obj.getPartyName().equals(val.getValue().getPartyName())) {
				
					obj.setPrice(price+val.getValue().getPrice());
					
					obj.setQuantity(quantity+val.getValue().getQuantity());
					map.put(val.getKey(), obj);
				
			System.out.println("Same Name Exists!!");
			break;
				
			}
			
			
			
		}
		
		return flag;
	

	
}
	
    
    
    
public boolean checktableid(Map<String,table>map,String partyName) {
    	
    	for(Map.Entry<String, table>value:map.entrySet()) {
    		
    		if(value.getValue().getPartyName().equals(partyName)) {
    			System.out.println("Same table Id Exists....");
    			return true;
    			
    		}
    	}
    	
    	return false;
    }
	




public void updatetable(String tableId,Map<String,table>tableMap) {
	
	System.out.println("What do you want to update: party/quantity/price \n");
	
	String updateKey = sc.next();
	
	tb = new table();
	
	for(Map.Entry<String, table>val:tableMap.entrySet()) {
		
		if(tableId.equalsIgnoreCase(val.getValue().gettablenum())) {
			
			if(updateKey.equals("party")) {
				System.out.println("Enter Party name: \n");
				String name = sc.next();
			   table obj = tableMap.get(tableId);
			   obj.setPartyName(name);
			   tableMap.put(tableId, obj);
			   System.out.println("party Name Updated Successfully!!");
			   break;
				
			}
			
             if(updateKey.equals("quantity")) {
            	 
            	 System.out.println("Enter quantity : \n");
 				int quant = sc.nextInt();
 			    table obj = tableMap.get(tableId);
 			    obj.setQuantity(quant);
 			    tableMap.put(tableId, obj);
 			    System.out.println("Quantity updated successfully!!");
 			    break;
				
			}
             
             if(updateKey.equals("price")) {
 				
            	 System.out.println("Enter new Price: \n");
            	 float newPrice = sc.nextFloat();
            	 table obj = tableMap.get(tableId);
            	 obj.setPrice(newPrice);
            	 tableMap.put(tableId, obj);
            	 System.out.println("Price updated successfully!!");
            	 break;
 			}
			
		}
		
	}
	
	
	tb.viewtable(tableMap);
	
}



	

}


package sales;

import java.util.Map;

public class table {
	
	
	float price;
	
	int quantity;
	
	float total;
	
	String ordernum;
	
	String date;
	
	String partyName;
	
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
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
	
    public void viewOrder(Map<String,table> map) {
		 
		 total = total+ price;
		 
		 System.out.println("\n|     Order Number  |     issue  Date    |    Party    |    Total      |  Total Items    | \n");
		 
		 for(Map.Entry<String, table> val:map.entrySet()) {
			   
			   System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getDate()+"   \t\t  "
			   		+ "  "+" \t "+" \t"+val.getValue().getPartyName()+"\t"+val.getValue().getPrice()+"\t"+val.getValue().getQuantity());
			   
		   }
		 
		 
		 
		 
		 
		 
	 }
	
	
	

}


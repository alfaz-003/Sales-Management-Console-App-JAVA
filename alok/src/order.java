import java.util.Map;
import java.util.Scanner;

public class order {
	
	String ordernum;
	String date;
	String partyName;
	float price;
	int quantity;
	float total;
	String productId;
	order orderObj;
	String partyId;
	Scanner sc = new Scanner(System.in);
	
	public void setPartyId(String partyId) {
		this.partyId=partyId;
	}
	
	public String getPartyId() {
		return partyId;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
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
	
    public void viewOrder(Map<String,order> map) {
		 
		
		 
		 System.out.println("\n| Order No. |      Date     |     Party     |    Sub Total    |  Total Item  | \n");
		 
		 
		 for(Map.Entry<String, order> val:map.entrySet()) {
			 
			 float total = val.getValue().getQuantity()*val.getValue().getPrice();
			   
			   System.out.println(" "+val.getValue().getOrdernum()+"  \t"+val.getValue().getDate()+"   \t\t  "
			   		+ "  "+" \t"+val.getValue().getPartyName()+"\t"+total+"\t"+val.getValue().getQuantity());
			   
		   } 
		 
	 }
    
    public boolean checkOrder(Map<String,order>map,int quantity,order obj,float price) { 
    	
    	    boolean flag = false;
    	    
    	 
    	
    		for(Map.Entry<String, order>val:map.entrySet()) {
    			
    			if(obj.getPartyName().equals(val.getValue().getPartyName())) {
    					//obj = map.get(orderid);
    					//float price =
    					obj.setPrice(price+val.getValue().getPrice());
    					obj.setQuantity(quantity+val.getValue().getQuantity());
    					map.put(val.getKey(), obj);
    				
    			System.out.println("Same Name Exists!!");
    			break;
    				
    			}
    			
    			
    			
    		}
    		
    		return flag;
    	

    	
    }
    
    public void searchByOrderNum(Map<String,order>map,String orderNum) {
    	
    	 System.out.println("\n| Order No. |      Date     |     Party     |    Sub Total    |  Total Item  | \n");
		 
    	
    	for(Map.Entry<String, order>values:map.entrySet()) {
    		
    		if(values.getKey().equals(orderNum)) {
    			
    			System.out.println(" "+orderNum+"\t"+values.getValue().getDate()+"\t"
    			+values.getValue().getPartyName()+"\t"+values.getValue().getPrice()+"\t"+values.getValue().getQuantity());
    			
    			break;
    		}
    		
    	}
		  
	 }
    
    public void searchByPartyName(Map<String,order>map,String partyName) {
    	
   	 System.out.println("\n| Order No. |      Date     |     Party     |    Sub Total    |  Total Item  | \n");
		 
   	
   	for(Map.Entry<String, order>values:map.entrySet()) {
   		
   		if(values.getValue().getPartyName().equals(partyName)) {
   			
   			System.out.println(" "+values.getValue().getOrdernum()+"\t"+values.getValue().getDate()+"\t"
   			+values.getValue().getPartyName()+"\t"+values.getValue().getPrice()+"\t"+values.getValue().getQuantity());
   			
   			break;
   		}
   		
   	}
		 	 
		 
	 }
    
    public boolean checkOrderid(Map<String,order>map,String partyName) {
    	
    	for(Map.Entry<String, order>value:map.entrySet()) {
    		
    		if(value.getValue().getPartyName().equals(partyName)) {
    			System.out.println("Same Order Id Exists....");
    			return true;
    			
    		}
    	}
    	
    	return false;
    }
    
    public void updateOrder(String orderId,Map<String,order>orderMap) {
    	
    	System.out.println("What do you want to update: party/quantity/price \n");
    	
    	String updateKey = sc.next();
    	orderObj = new order();
    	
    	for(Map.Entry<String, order>val:orderMap.entrySet()) {
    		
    		if(orderId.equalsIgnoreCase(val.getValue().getOrdernum())) {
    			
    			if(updateKey.equals("party")) {
    				System.out.println("Enter Party name: \n");
    				String name = sc.next();
    			   order obj = orderMap.get(orderId);
    			   obj.setPartyName(name);
    			   orderMap.put(orderId, obj);
    			   System.out.println("party Name Updated Successfully!!");
    			   break;
    				
    			}
    			
                 if(updateKey.equals("quantity")) {
                	 
                	 System.out.println("Enter quantity : \n");
     				int quant = sc.nextInt();
     			    order obj = orderMap.get(orderId);
     			    obj.setQuantity(quant);
     			    orderMap.put(orderId, obj);
     			    System.out.println("Quantity updated successfully!!");
     			    break;
    				
    			}
                 
                 if(updateKey.equals("price")) {
     				
                	 System.out.println("Enter new Price: \n");
                	 float newPrice = sc.nextFloat();
                	 order obj = orderMap.get(orderId);
                	 obj.setPrice(newPrice);
                	 orderMap.put(orderId, obj);
                	 System.out.println("Price updated successfully!!");
                	 break;
     			}
    			
    		}
    		
    	}
    	
    	
    	orderObj.viewOrder(orderMap);
    	
    }
    
    public void deleteOrder(String orderId,Map<String,order>orderMap) {
    	
           for(Map.Entry<String, order>val:orderMap.entrySet()) {
    		
    		if(orderId.equalsIgnoreCase(val.getValue().getOrdernum())) {
    			
    			orderMap.remove(orderId);
    			System.out.println("Deleted Successfully!!");
    			break;
    			
    		}
    		
    	}
    	
    }
	
	
	

}

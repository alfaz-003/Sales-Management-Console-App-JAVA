import java.util.Map;

public class Account {
	
	public void accountOptions() {
		
		System.out.println(" 1.Purchase \n 2.Sales \n 3.Exit \n");
		
	}
	
	public void showPurchaseDetails(Map<String,order>purchaseMap) {
		
		 System.out.println("\n| Order No. |      Date     |     Party     |    Sub Total    |  Total Item  | \n");
		 
		for(Map.Entry<String, order>val:purchaseMap.entrySet()) {
			
			  System.out.println(" "+val.getValue().getOrdernum()+"  \t"+val.getValue().getDate()+"   \t\t  "
				   		+ "  "+" \t"+val.getValue().getPartyName()+"\t"+val.getValue().getPrice()+"\t"+val.getValue().getQuantity());
		}
		
	}
	
	public void showSalesDetails(Map<String,order>salesMap) {
		
		 System.out.println("\n| Order No. |      Date     |     Party     |    Sub Total    |  Total Item  | \n");
		
        for(Map.Entry<String, order>val:salesMap.entrySet()) {
        	
        	 System.out.println(" "+val.getValue().getOrdernum()+"  \t"+val.getValue().getDate()+"   \t\t  "
				   		+ "  "+" \t"+val.getValue().getPartyName()+"\t"+val.getValue().getPrice()+"\t"+val.getValue().getQuantity());
			
		     }
	}

}

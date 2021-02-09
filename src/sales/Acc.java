package sales;
import java.util.Map;

public class Acc {
	
	
	public void salesFinal(Map<String,table>salesMap) {
		
		 System.out.println("\n| Order No. |      Date of order    |     Party     |    Sub-Total    |  Total-Item  | \n");
		
       for(Map.Entry<String, table>val:salesMap.entrySet()) {
       	
       	 System.out.println(" "+val.getValue().gettablenum()+"  \t"+val.getValue().getDate()+"   \t\t  " + "  "+" \t"+val.getValue().getPartyName()+"\t"+val.getValue().getPrice()+"\t"+val.getValue().getQuantity());
			
		     }
	}
	

	
	public void purchaseFinal(Map<String,table>purchaseMap) {
		
		 System.out.println("\n| Order No. |      Date of Order    |     Party     |    Sub-Total    |  Total-Item  | \n");
		 
		for(Map.Entry<String, table>val:purchaseMap.entrySet()) {
			
			  System.out.println(" "+val.getValue().gettablenum()+"  \t"+val.getValue().getDate()+"   \t\t  " + "  "+" \t"+val.getValue().getPartyName()+"\t"+val.getValue().getPrice()+"\t"+val.getValue().getQuantity());
		}
		
	}
	
	

}

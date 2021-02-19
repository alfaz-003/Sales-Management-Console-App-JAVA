import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

public class purchaseOrder {
	
	String purchaseId;
	String purchaseNum;
	String purchasedate;
	float total = 0;
	
	public void purchaseOrderOption() {
		//System.out.println("Select \n 1.Insert \n 2.View. \n 3.Exit \n");
		System.out.println("Select \n 1.Insert \n 2.Update \n 3.Delete \n 4.Exit \n");
		
	}
	
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	
	
	public String getCurrentDate() {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		
		String currentDate = df.format(calobj.getTime());
		return currentDate;
		
	}
	
	 public void showPurchaseOrder(Map<String,purchaseOrder> map) {
		   
		   System.out.println(" |    Id     |      Order Number    |    Order Date      |   \n");
		  
		   
		   for(Map.Entry<String, purchaseOrder> val:map.entrySet()) {
			   
			   System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getPurchaseNum()+"   \t\t  "
			   		+ "  "+val.getValue().getPurchasedate()+" \t "+"\n");
			   
		   }
		   
		   
	   }
	 
	
	 
	
	 
	
	 

}

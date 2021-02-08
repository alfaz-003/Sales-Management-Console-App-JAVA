package sales;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

public class prChild {
	
	String prId;
	String prNum;
	
	
	String prdate;
	
	
	float total = 0;
	
	public void purchaseOrderOption() {
		System.out.println("Select \n 1.Insert \n 2.View. \n 3.Exit \n");
		
	}
	
	public String getprId() {
		return prId;
	}
	public void setPrId(String prId) {
		this.prId = prId;
	}
	public String getPrNum() {
		return prNum;
	}
	public void setPrNum(String prNum) {
		this.prNum = prNum;
	}
	public String getPrdate() {
		return prdate;
	}
	public void setPrdate(String prdate) {
		this.prdate = prdate;
	}
	
	 public String getDate() {
			
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			Calendar calobj = Calendar.getInstance();
			
			String currentDate = df.format(calobj.getTime());
			return currentDate;
			
		}
	 
	
	 


	
	
	 public void showPurchaseOrder(Map<String,prChild> map) {
		   
		   System.out.println(" |    Id     |      Order Number    |    Order Date      |   \n");
		  
		   
		   for(Map.Entry<String, prChild> val:map.entrySet()) {
			   
			   System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getPrNum()+"   \t\t  "  + "  "+val.getValue().getPrdate()+" \t "+"\n");
			   
		   }
		   
		   
	   }
	 
	 
	 }

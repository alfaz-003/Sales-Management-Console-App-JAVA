package sales;

import java.util.Map;

public class product {
	
//	String pId;
//	String pName;
//	String pDisc;
//	float pPrice;
//	float pSPrice;
//	int pOpenStock;
//	String pStatus;
	
	
	String productId;
	String productName;
	String productDisc;
	float productPrice;
	float productSPrice;
	int productOpenStock;
	String productStatus;
	
	
	
	
	
	public void products() {
		System.out.println("Select from the below Categories : \n");
		
		
		System.out.println(" 2.1 Insert \n 2.2 View \n 2.3 Update \n 2.4 Delete \n 2.5 Search \n 2.6 Exit \n");
		
	}
//	public String getpId() {
//		return pId;
//	}
//	public void setpId(String pId) {
//		this.pId = pId;
//	}
//	public String getpName() {
//		return pName;
//	}
//	public void setpName(String pName) {
//		this.pName = pName;
//	}
//	public String getpDisc() {
//		return pDisc;
//	}
//	public void setpDisc(String pDisc) {
//		this.pDisc = pDisc;
//	}
//	public float getpPrice() {
//		return pPrice;
//	}
//	public void setpPrice(float pPrice) {
//		this.pPrice = pPrice;
//	}
//	public float getpSPrice() {
//		return pSPrice;
//	}
//	public void setpSPrice(float pSPrice) {
//		this.pSPrice = pSPrice;
//	}
//	public int getpOpenStock() {
//		return pOpenStock;
//	}
//	public void setpOpenStock(int pOpenStock) {
//		this.pOpenStock = pOpenStock;
//	}
//	public String getpStatus() {
//		return pStatus;
//	}
//	public void setpStatus(String pStatus) {
//		this.pStatus = pStatus;
//	}
	
	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDisc() {
		return productDisc;
	}

	public void setProductDisc(String productDisc) {
		this.productDisc = productDisc;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public float getProductSPrice() {
		return productSPrice;
	}

	public void setProductSPrice(float productSPrice) {
		this.productSPrice = productSPrice;
	}

	public int getProductOpenStock() {
		return productOpenStock;
	}

	public void setProductOpenStock(int productOpenStock) {
		this.productOpenStock = productOpenStock;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	
	 public void showProducts(Map<String,product> map) {
		   
		   System.out.println(" |    Id     |   Name     |     Description | Purchase Price  | Sales Price |  | Opening Stock |  Status   | \n");
		  
		   
		   for(Map.Entry<String, product> val:map.entrySet()) {
			   
			   System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getProductName()+"   \t\t  "
			   		+ "  "+val.getValue().getProductDisc()+" \t "+" \t"+val.getValue().getProductPrice()+"\t"+val.getValue().getProductSPrice()+
			   		"\t"+val.getValue().getProductOpenStock()+"\t"+val.getValue().getProductStatus());
			   
		   }
		   
		   
	   }
	 
	 public void updateProducts(String cid,Map<String,product>map,String updateVal,String updateKey,product obj) {
		   
		   for(Map.Entry<String,product>val:map.entrySet()) {
			   
			   if(updateKey.equals("Name")) {
				    if(val.getKey().equals(cid)) {
				    	obj.setProductName(updateVal);
				    	map.put(cid,obj);
				    	System.out.println("Name updated Successfully");
				    	break;
				    }
				   
			   }
			   else if(updateKey.equals("desc")) {
				   
				   if(val.getKey().equals(cid)) {
				    	obj.setProductDisc(updateVal);
				    	map.put(cid,obj);
				    	System.out.println("Description updated Successfully");
				    	break;
				    }
				   
				   
			   }
			   
			   else if(updateKey.equals("purchase")) {
				   
				   if(val.getKey().equals(cid)) {
					   float price = Float.parseFloat(updateVal);
				    	obj.setProductPrice(price);
				    	map.put(cid,obj);
				    	System.out.println(" Purchase Price updated Successfully");
				    	break;
				    }
				   
			   }
			   
			   else if(updateKey.equals("sales")) {
				   
				   if(val.getKey().equals(cid)) {
					   float sales = Float.parseFloat(updateVal);
				    	obj.setProductSPrice(sales);
				    	map.put(cid,obj);
				    	System.out.println("Sales Price updated Successfully");
				    	break;
				    }
			   }
			   
              else if(updateKey.equals("stock")) {
            	  
            	  if(val.getKey().equals(cid)) {
            		  int stock = Integer.parseInt(updateVal);
				    	obj.setProductOpenStock(stock);
				    	map.put(cid,obj);
				    	System.out.println("Opening Stock updated Successfully");
				    	break;
				    }
				   
			   }
			   
              else if(updateKey.equals("status")) {
            	  
            	  if(val.getKey().equals(cid)) {
				    	obj.setProductStatus(updateVal);
				    	map.put(cid,obj);
				    	System.out.println("Status updated Successfully");
				    	break;
				    }
				   
			   }
			   
		   }
		   
		   
	   }
	 
	 public void deleteProduct(String pid,Map<String,product>map) {
		   
		   for(Map.Entry<String,product>val:map.entrySet()) {
			   
			   if(val.getKey().equals(pid)) {
				   map.remove(pid);
				   System.out.println("Deleted Successfully!!!!");
				   break;
			   }
		   }
		   
	   }
	 
	 
	 public void searchProductByName(Map<String,product>nameMap,String cName) {
		   
		   boolean flag = false;
		   
		   	
		        for(Map.Entry<String,product> val:nameMap.entrySet()) {
		        	
		        	if(val.getValue().getProductName().contains(cName.trim())) {
		        		
		        		System.out.println(" |    Id     |      Name     |     Description       |  |  Purchase Price  |  | Sales Price |  | Opening Stock |  |  Status   | \n");
		      		  
		        		System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getProductName()+"   \t\t  "
		    			   		+ "  "+val.getValue().getProductDisc()+" \t "+" \t"+val.getValue().getProductPrice()+"\t"+val.getValue().getProductSPrice()+
		    			   		"\t"+val.getValue().getProductOpenStock()+"\t"+val.getValue().getProductStatus());
	   	 			    
	   	 			     flag=true;
	   	 			     break;
		        	}
		        	
		        }
		        
		        if(!flag) {
		        	
		        		System.out.println("No Match Found!!");	
		        	
		        }
		   
		   
	   }
	 
	 public void searchProductById(Map<String,product> search,String pid) {
		   
         for(Map.Entry<String, product> val:search.entrySet()) {
        	 
        	 		if(val.getKey().equals(pid)) {
        	 			 
        	 			System.out.println(" |    Id     |      Name     |     Description       |  |  Purchase Price  |  | Sales Price |  | Opening Stock |  |  Status   | \n");
        	 			  
        	 			System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getProductName()+"   \t\t  "
        				   		+ "  "+val.getValue().getProductDisc()+" \t "+" \t"+val.getValue().getProductPrice()+"\t"+val.getValue().getProductSPrice()+
        				   		"\t"+val.getValue().getProductOpenStock()+"\t"+val.getValue().getProductStatus());
        	 			
        	 			break;
        	 		} else {
        	 			System.out.println("Match not Found!!\n");
        	 			break;
        	 		}
   
       
          
              } 

}
	 
	 public void showProductList(Map<String,product> map) {
		   
		   System.out.println(" |    Id     |      Name     | |  Purchase Price  | \n");
		  
		   
		   for(Map.Entry<String, product> val:map.entrySet()) {
			   
			   System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getProductName()+"   \t\t  "
			   		+ "  "+" \t "+" \t"+val.getValue().getProductPrice()+"\n");
			   
		   }
		   
		   
	   }
	

}


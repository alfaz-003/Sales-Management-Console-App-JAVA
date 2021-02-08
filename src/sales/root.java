package sales;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class root {

	public static void main(String[] args) {
		
		
		
		int pnum = 0;
		
		int prId = 0;
		
		int orderid = 1;
		
		int cId = 0;
		int prchId = 0;
		
		
		
		
		String repeat ="yes";
		String categoryName;
		
		
		 
		 Map<String,client> partyMap = new HashMap<>();
		 
		 
		 Map<String,prChild> prchMap = new HashMap<>();
		 
		 
		
		 Map<String,category> catMap = new HashMap<>();
		 
		 
		 
		 Map<String,product> prodMap = new HashMap<>();
		 
		 
		
		 String categoryDesc;
		 String categoryId;
		 category c1;
		 
		 Map<String,table> orderMap = new HashMap<>();
		 
		
		product p1;
		client par;
		prChild purchaseObj;
		table tb;
		
		
		 
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		System.out.println("******************  SALES MANAGEMENT  ************************");
		
		System.out.println("\n");
		
		System.out.println(" Choose one of the below category :  ");
		//System.out.println(" \n 1.Category \n 2.Product \n 3.Purchase \n 4.Sales \n 5.Account \n 6.Exit \n");
		
		int ccounter = 0;
		
		while(ccounter!=6) {

			System.out.println(" \n 1.Category \n 2.Product \n 3.Purchase \n 4.Sales \n 5.Account \n 6.Exit \n");
			ccounter = sc.nextInt();
			
			
			
		if(ccounter == 1) {
			
			   int q = 0;
			   category cat = new category();
			   
			   	while(q!=6) {
			
			      cat.categories();
				
				  q = sc.nextInt();
				 
				 if(q == 1) {
					 
					 c1 = new category();
						
					     c1.setId("c-"+cId);
						System.out.println(" Category Name: \n");
						categoryName = sc.next();
						boolean res = c1.validateName(categoryName,catMap);
						
						
						//System.out.println("Response: "+res);
						
						
						if(!res) {
							
							System.out.println("Not matched!!");
							
							
						}
						else if(res){
							
							String catName = c1.autoName(categoryName);
							
							if(!catName.equals("ok")) {
								
								c1.setName(catName);
								
								System.out.println(" Enter Category Description: \n");
								categoryDesc = sc.next();
								c1.setDescription(categoryDesc);
								catMap.put(c1.getId(),c1);
							}
	                        
							
						}
						
						System.out.println(catMap.size());
						cId++;
				 }
				 else if(q == 2) {
					 c1 = new category();
						System.out.println(catMap.size());
						c1.showCategories(catMap);
				 }
				 else if(q == 3) {
					 
					 c1 = new category();
					 System.out.println("Select: \n 1.Search by Id \n 2.Search by Name \n");
					 int searchOption = sc.nextInt();
					 if(searchOption == 1) {
						 System.out.println("Enter ID: \n");
						 String id = sc.next();
						 
						 c1.searchCategoryById(catMap,id);
						 
						 System.out.println(" Search By Id ");
						 
					 }
					 else if(searchOption == 2) {
						 System.out.println("Enter NAME: ");
						 String name = sc.next();
						 c1.searchCategoryByName(catMap,name);
					 }
					 else {
						 System.out.println("invalid Options");
						 
					 }
				 }
				 
				 else if(q == 4) {
					 
					 c1 = new category();
						System.out.println(" Enter the Id to Update ");
						String catId = sc.next();
						System.out.println("What do you Want to Update!!\n 1.Name \n 2.Description \n");
						int opt = sc.nextInt();
						c1 = catMap.get(catId);
						
						if(opt == 1) {
							System.out.println("Enter The name: ");
							
							
							String cName = sc.next();
							
							c1.updateCategory(catId,catMap,cName,"Name",c1);
							
							
						}
						else if(opt ==2 ) {
							System.out.println("Enter Description: ");
							String desc = sc.next();
							
							c1.updateCategory(catId,catMap,desc,"desc",c1);
							
						}
				 }
				 
				 else if(q ==5) {
					 
					 c1 = new category();
						System.out.println("Enter the Id for delete");
						String delId = sc.next();
						c1.deleteCategory(delId,catMap);
				 }
				 
				 else if(q == 6) {
					 System.out.println("Exit ");
					 break;
				 }
				 
			   	} //while loop
				
		}
			
		
			
			
		
		else if(ccounter == 2) {
			
			product obj = new product();
			
			     int pOption = 0;
				// pOption = sc.nextInt();
			    // obj.products();
				  
			     while(pOption!=6) {
			    	
			         obj.products();
					 pOption = sc.nextInt();
					 
				 
				
				 
				 if(pOption ==1) {
					 
					 p1 = new product();
					 p1.setProductId("P-"+pnum);
						
						System.out.println("Enter the Product name: \n");
						String pName = sc.next();
						p1.setProductName(pName);
						
						System.out.println("Enter the  product Description: \n");
						
						String pDesc = sc.next();
						p1.setProductDisc(pDesc);
						
						System.out.println("Enter Price: \n");
						
						float PPrice = sc.nextFloat();
						p1.setProductPrice(PPrice);
						
						System.out.println("Enter Sales Price:\n");
						
						float SPrice=sc.nextFloat();
						p1.setProductSPrice(SPrice);
						
						System.out.println("Enter the Opening Stock: \n");
						
						int stock = sc.nextInt();
						p1.setProductOpenStock(stock);
						
						System.out.println("Enter the Status: ");
						
						String status = sc.next();
						p1.setProductStatus(status);
						
						prodMap.put(p1.getProductId(),p1);
						System.out.println(prodMap.size());
						pnum++;
				 }
				 
				 else if(pOption == 2) {
					 obj.showProducts(prodMap);
				 }
				 
				 else if(pOption == 3) {
					      System.out.println(" Enter the Id to Update ");
						String pId = sc.next();
						p1 = prodMap.get(pId);
						
							System.out.println("What do you want to update: \n");
							String key = sc.next();
							System.out.println("Enter the New Value: \n");
							String updateVal = sc.next();
							obj.updateProducts(pId,prodMap,updateVal,key,p1);
				 }
				 
				 else if(pOption ==4) {
					 p1 = new product();
						System.out.println("Enter the Id to delete");
						String delId = sc.next();
						p1.deleteProduct(delId,prodMap);
				 }
				 
				 else if(pOption == 5) {
					 
					 p1 = new product();
					 System.out.println("Select: \n 1.Search by Id \n 2.Search by Name \n");
					 int searchOption=0;
					 
					
						 searchOption = sc.nextInt();
						 
					 
					 if(searchOption == 1) {
						 System.out.println("Enter ID: \n");
						 String id = sc.next();
						 
						 p1.searchProductById(prodMap,id);
						 
						 System.out.println(" Search By Id ");
						 
					 }
					 else if(searchOption == 2) {
						 System.out.println("Enter Name: ");
						 String name = sc.next();
						 p1.searchProductByName(prodMap,name);
					 }
					 else {
						 System.out.println("Incorrect Option Selected......");
						 
					 }
				 }
				 
				 else if(pOption==6) {
					 System.out.println("Exit!!");
					 break;
				 }
				 
			     } //while loop
				 
				 
				 
		}
		 
		 
		
		else if(ccounter ==3) {
			
			int purchaseOpt =0;
			client Pobj = new client();
			
			while(purchaseOpt!=3) {
			System.out.println("Select: \n 1.Party \n 2.Purchase Order \n 3.Exit \n");
			 purchaseOpt = sc.nextInt();
			
			if(purchaseOpt ==1) {
				
				int partyOption = 0;
				
				while(partyOption!=5) {
				
				 Pobj.partyOpt();
				  partyOption = sc.nextInt();
				 
				 if(partyOption ==1) {
					 
					 par = new client();
					 par.setClientId("par-"+prId);
					 
					 System.out.println("Enter Name: \n");
					 String partyName = sc.next();
					 par.setClientName(partyName);
					 
					 System.out.println("Enter Contact number: \n");
					 String partyNum = sc.next();
					 par.setClientNum(partyNum);
					 
					 System.out.println("Enter Opening Account: \n");
					 String openingAccount = sc.next();
					 par.setOpeningAccount(openingAccount);
					 
					 partyMap.put(par.getClientId(),par);
					 System.out.println("Map Size of Party: "+partyMap.size());
					  prId++;
				 }
				 
				 else if(partyOption==2) {
					 
					 Pobj.showParty(partyMap);
					 
				 }
				 else if(partyOption ==3) {
					 
					 System.out.println(" Enter the Id to Update ");
						String pId = sc.next();
						 Pobj = partyMap.get(pId);
						
							System.out.println("What do you want to update: \n");
							String key = sc.next();
							System.out.println("Enter the New Value: \n");
							String updateVal = sc.next();
							Pobj.updateParty(pId,partyMap,updateVal,key,Pobj);
				 }
				 
				 else if(partyOption ==4) {
					 
					 Pobj = new client();
						System.out.println("Enter the Id to delete");
						String delId = sc.next();
						Pobj.deleteParty(delId,partyMap);
				 }
				 
				 else if(partyOption ==5) {
					 System.out.println("Exit!!");
					 
				 }
				 
				} //while loop
			}
			else if(purchaseOpt==2) {
				
				int select = 0;
				prChild	purObj = new prChild();
				 
				 while(select!=3) {
				 purObj.purchaseOrderOption();
				 
				  select = sc.nextInt();
				 
				 if(select ==1 ) {
					 
					 purchaseObj = new prChild();
						
					 purchaseObj.setPrId("purchase"+prchId);
					 
					 System.out.println("purchase ID: "+purchaseObj.getprId());
					 
					 purchaseObj.setPrNum("000"+orderid);
					 
					 String date = purObj.getDate();
					 
					 purchaseObj.setPrdate(date);
					 
					 
					 prchMap.put(purchaseObj.getprId(),purchaseObj);
//					
					 
					 orderid++;
					 prchId++;
				 }
				 
				 else if(select ==2) {
					 
					 while(repeat.equals("ok")) {
						 p1 = new product();
						 
						 
						 
						 par = new client();
					 purchaseObj = new prChild();
					 tb = new table();
//					 
//					 
					 System.out.println("PARTY LIST");
					 par.showParty(partyMap);
					 
					 
					 
				//	 System.out.println("LIST "+table());
					 
					 
					 
					 System.out.println("Select a party from above table: \n");
					 String partyId = sc.next();
					 tb.setOrdernum(partyId);
					 
					 
					 
					 String partyName = partyMap.get(partyId).getClientName();
					 p1.showProductList(prodMap);
					 
					 tb.setPartyName(partyName);
					 
					 System.out.println("Select a product: \n");
					 String prodId = sc.next();
					 
					 
					 float price = prodMap.get(prodId).getProductPrice();
					 
					 tb.setPrice(price);
					 
					 System.out.println("Enter Quantity");
					 int quantity = sc.nextInt();
					 
					 
					 
					 tb.setQuantity(quantity);
					 
					 tb.setDate(purchaseObj.getDate());
					 
					 
					 orderMap.put(purchaseObj.getPrNum(),tb);
					 
					 System.out.println("Repeat  it again ? enter yes: ");
					 
					 repeat = sc.next();
					 
					 
					 
					 
					 tb.viewOrder(orderMap);
					 
					 if(!repeat.equals("yes")) {
						 
						 break;
						 
					 }
					 
					 }
				 }
				 
				 else if(select ==3) {
					 
					 System.out.println("Exit Success!!");
				 }
				 
				 } //while loop
			}
			
			else if(purchaseOpt==3) {
				System.out.println("Exit from purchase");
				break;
			}
		
		
		else if(ccounter == 4) {
			
		}
			
			
		else if(ccounter ==5) {
			
		}
			
			
		
		else if(ccounter ==6) {
			System.out.println("Exit 0");
			break;
		}
		
			}
		
		
		
		
	}
		
		
		
		}
	}

}

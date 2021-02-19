import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class convert {

	public static void main(String[] args) {
		
		String categoryName;
		String categoryDesc;
		String categoryId;
		int num = 0;

		int pnum = 0;
		
		int partynum = 0;
		int purchasenum = 0;
		int orderid = 1;
		int salePartyNum = 0;
		int salesPurchaseNum = 0;
		int salesOrderId = 1;
		
		String repeat ="yes";
		
		boolean checkFlag = false;
		
		 Map<String,category> maps = new HashMap<>();
		 Map<String,product> productMap = new HashMap<>();
		 Map<String,party> partyMap = new HashMap<>();
		 Map<String,purchaseOrder> purchaseMap = new HashMap<>();
		 Map<String,order> orderMap = new HashMap<>();
		 
		 Map<String,party> salesPartyMap = new HashMap<>();
		 Map<String,order> salesOrderMap = new HashMap<>();
		 Map<String,purchaseOrder> salesPurchaseMap = new HashMap<>();
		 
		 Map<String,Map<String,order>>accountPurchaseMap = new HashMap<>();
		 Map<String,Map<String,order>>accountSalesMap = new HashMap<>();
		 
		category catg;
		product pObj;
		party partyobj;
		purchaseOrder purchaseObj;
		order orderObj;
		Sales salesObj;
		Account accountObj;
		
		 
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		System.out.println("\n\t\t\t--------------------WLCOME---------------------\n");
		System.out.println(" Select one from the Following:  ");
	
		
		int option = 0;
		
		while(option!=6) {

			System.out.println(" \n 1.Category \n 2.Product \n 3.Purchase \n 4.Sales \n 5.Account \n 6.Exit \n");
			option = sc.nextInt();
			
			
			
		if(option == 1) {
			
			   int value = 0;
			   category cat = new category();
			   
			   	while(value!=6) {
			
			      cat.categories();
				
				  value = sc.nextInt();
				 
				 if(value == 1) {
					 
					 catg = new category();
						
						catg.setId("category"+num);
						System.out.println(" Enter Category Name: \n");
						categoryName = sc.next();
						boolean res = catg.validateName(categoryName,maps);
						System.out.println("Response: "+res);
						if(!res) {
							
							System.out.println("Criteria  not matched!!");
							
							
						}
						else if(res){
							
							String catName = catg.autoName(categoryName);
							
							if(!catName.equals("done")) {
								
								catg.setName(catName);
								
								System.out.println(" Enter Category Description: \n");
								categoryDesc = sc.next();
								catg.setDescription(categoryDesc);
								//catg.storeData(catg);
								maps.put(catg.getId(),catg);
							}
	                        
							
						}
						
						System.out.println(maps.size());
							
						num++;
				 }
				 else if(value == 2) {
					   catg = new category();
						System.out.println(maps.size());
					   catg.showCategories(maps);
				 }
				 else if(value == 3) {
					 
					 catg = new category();
					 System.out.println("Select: \n 1.Search by Id \n 2.Search by Name \n");
					 int searchOption = sc.nextInt();
					 if(searchOption == 1) {
						 System.out.println("Enter ID: \n");
						 String id = sc.next();
						 
						 catg.searchCategoryById(maps,id);
						 
						 System.out.println(" Search By Id ");
						 
					 }
					 else if(searchOption == 2) {
						 System.out.println("Enter Middle Name, First Name or Last Name: ");
						 String name = sc.next();
						 catg.searchCategoryByName(maps,name);
					 }
					 else {
						 System.out.println("Incorrect Option Selected......");
						 
					 }
				 }
				 
				 else if(value == 4) {
					 
					 catg = new category();
						System.out.println(" Enter the Id to Update ");
						String catId = sc.next();
						System.out.println("What do you Want to Update!!\n 1.Name \n 2.Description \n");
						int opt = sc.nextInt();
						catg = maps.get(catId);
						
						if(opt == 1) {
							System.out.println("Enter The name: ");
							
							
							String cName = sc.next();
							
							catg.updateCategory(catId,maps,cName,"Name",catg);
							
							
						}
						else if(opt ==2 ) {
							System.out.println("Enter Description: ");
							String desc = sc.next();
							
							catg.updateCategory(catId,maps,desc,"desc",catg);
							
						}
				 }
				 
				 else if(value ==5) {
					 
					     catg = new category();
						System.out.println("Enter the Id to delete");
						String delId = sc.next();
						catg.deleteCategory(delId,maps);
				 }
				 
				 else if(value == 6) {
					 System.out.println("Exit from category!!");
					 break;
				 }
				 
			   	} //while loop
				
		}
			
		
			
			
		
		else if(option == 2) {
			
			product obj = new product();
			
			     int pOption = 0;
				// pOption = sc.nextInt();
			    // obj.products();
				  
			     while(pOption!=6) {
			    	
			         obj.products();
					 pOption = sc.nextInt();
					 
				 
				
				 
				 if(pOption ==1) {
					 
					 pObj = new product();
						pObj.setpId("product"+pnum);
						
						System.out.println("Enter Product name: \n");
						String pName = sc.next();
						pObj.setpName(pName);
						
						System.out.println("Enter product Description: \n");
						String pDesc = sc.next();
						pObj.setpDisc(pDesc);
						
						System.out.println("Enter Purchase Price: \n");
						float PPrice = sc.nextFloat();
						pObj.setpPrice(PPrice);
						
						System.out.println("Enter Sales Price:\n");
						float SPrice=sc.nextFloat();
						pObj.setpSPrice(SPrice);
						
						System.out.println("Enter the Opening Stock: \n");
						int stock = sc.nextInt();
						pObj.setpOpenStock(stock);
						
						System.out.println("Enter Status: ");
						String status = sc.next();
						pObj.setpStatus(status);
						
						productMap.put(pObj.getpId(),pObj);
						System.out.println(productMap.size());
						pnum++;
				 }
				 
				 else if(pOption == 2) {
					 obj.showProducts(productMap);
				 }
				 
				 else if(pOption == 3) {
					      System.out.println(" Enter the Id to Update ");
						String pId = sc.next();
						pObj = productMap.get(pId);
						
							System.out.println("What do you want to update: \n");
							String key = sc.next();
							System.out.println("Enter the New Value: \n");
							String updateVal = sc.next();
							obj.updateProducts(pId,productMap,updateVal,key,pObj);
				 }
				 
				 else if(pOption ==4) {
					 pObj = new product();
						System.out.println("Enter the Id to delete");
						String delId = sc.next();
						pObj.deleteProduct(delId,productMap);
				 }
				 
				 else if(pOption == 5) {
					 
					 pObj = new product();
					 System.out.println("Select: \n 1.Search by Id \n 2.Search by Name \n");
					 int searchOption=0;
					 
					
						 searchOption = sc.nextInt();
						 
					 
					 if(searchOption == 1) {
						 System.out.println("Enter ID: \n");
						 String id = sc.next();
						 
						 pObj.searchProductById(productMap,id);
						 
						 System.out.println(" Search By Id ");
						 
					 }
					 else if(searchOption == 2) {
						 System.out.println("Enter Name: ");
						 String name = sc.next();
						 pObj.searchProductByName(productMap,name);
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
		 
		 
		
		else if(option ==3) {
			
			int purchaseOpt =0;
			party Pobj = new party();
			
			while(purchaseOpt!=3) {
			System.out.println("Select: \n 1.Party \n 2.Purchase Order \n 3.Exit \n");
			 purchaseOpt = sc.nextInt();
			
			if(purchaseOpt ==1) {
				
				int partyOption = 0;
				
				while(partyOption!=5) {
				
				 Pobj.partyOpt();
				  partyOption = sc.nextInt();
				 
				 if(partyOption ==1) {
					 
					 partyobj = new party();
					 partyobj.setPartyId("party"+partynum);
					 
					 System.out.println("Enter Name: \n");
					 String partyName = sc.next();
					 partyobj.setPartyName(partyName);
					 
					 System.out.println("Enter Contact number: \n");
					 String partyNum = sc.next();
					 partyobj.setPartyNum(partyNum);
					 
					 System.out.println("Enter Opening Account: \n");
					 String openingAccount = sc.next();
					 partyobj.setOpeningAccount(openingAccount);
					 
					 partyMap.put(partyobj.getPartyId(),partyobj);
					 System.out.println("Map Size of Party: "+partyMap.size());
					 
					 partynum++;
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
					 
					 Pobj = new party();
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
				 purchaseOrder	purObj = new purchaseOrder();
				 
				 while(select!=4) {
				 purObj.purchaseOrderOption();
				 
				  select = sc.nextInt();
				 
				 if(select ==1 ) {
					 while(repeat.equals("yes")) {
					 purchaseObj = new purchaseOrder();
						
					 purchaseObj.setPurchaseId("purchase"+purchasenum);
					 
					 System.out.println("purchase ID: "+purchaseObj.getPurchaseId());
					 
					 purchaseObj.setPurchaseNum("000"+orderid);
					 
					 String date = purObj.getCurrentDate();
					 
					 purchaseObj.setPurchasedate(date);
					 
					 
					 purchaseMap.put(purchaseObj.getPurchaseId(),purchaseObj);
//					 System.out.println("Map Size of purchase: "+purchaseMap.size());
//					 System.out.println("purchaseNum: "+purchasenum);
					 
//					 orderid++;
					 purchasenum++;
				// }
				 
//				 else if(select ==2) {
					 
//					 while(repeat.equals("yes")) {
					 pObj = new product();
					 partyobj = new party();
					 purchaseObj = new purchaseOrder();
					 orderObj = new order();

					 System.out.println("\n--------------Party List-------------- \n");
					 partyobj.showParty(partyMap);
					 System.out.println("Select a party from above table: \n");
					 String partyId = sc.next();
					 
					 orderObj.setOrdernum("order"+(orderid-1));
					 
					 String partyName = partyMap.get(partyId).getPartyName();
					 pObj.showProductList(productMap);
					 
					 orderObj.setPartyName(partyName);
					 
					 System.out.println("Select a product: \n");
					 String prodId = sc.next();
					 orderObj.setProductId(prodId);
					 float price = productMap.get(prodId).getpPrice();
					 
					 orderObj.setPrice(price);
					 System.out.println("Enter Quantity");
					 int quantity = sc.nextInt();
					 
					 orderObj.setQuantity(quantity);
					 orderObj.setDate(purchaseObj.getCurrentDate());
					
					 if(repeat.equals("yes")) {
						
							boolean check = orderObj.checkOrder(orderMap,quantity,orderObj,price);
							
							if(!check) {
								 orderObj.viewOrder(orderMap);
							}
						 }
					boolean val= orderObj.checkOrderid(orderMap,partyName);
					if(!val) {
						 orderid++;
						 orderMap.put("order"+(orderid-1), orderObj);
						 accountPurchaseMap.put("purchase"+(purchasenum-1), orderMap); //account purchase map
					}
					
					 
					 System.out.println("Repeat? enter yes/no: ");
					 
					 repeat = sc.next();
					 
//					 if(repeat.equals("yes")) {
//						 
//						boolean check = orderObj.checkOrder(orderMap,quantity,orderObj,price);
//						
//						if(!check) {
//							 orderObj.viewOrder(orderMap);
//						}
//					 }
					 if(repeat.equals("no")) {
						 orderObj.viewOrder(orderMap);
					 }
					
					 
					 if(!repeat.equals("yes")) {
						 
						 break;
						 
					 }
					 
					 }
					 
				 }
				 
				 else if(select ==2) {
					 
					 orderObj = new order();
					 System.out.println(" Enter the Order Id to Update!! ");
					 String orderID = sc.next();
					 orderObj.updateOrder(orderID, orderMap);
					 
				 }
				 else if(select ==3) {
					 
					 orderObj = new order();
					 System.out.println(" Enter the Order Id to Delete!! ");
					 String orderID = sc.next();
					 orderObj.updateOrder(orderID, orderMap);
					 
					
				 }
				 else if(select ==4) {
					 System.out.println("Exit Success!!");
					 
				 }
				 
				 } //while loop
				 
			}     
			
			
			
			else if(purchaseOpt==3) {
				System.out.println("Exit from purchase");
				break;
			}
		
			}
		//while loop
	}
		
		
      else if(option == 4) {
    	  
    	  System.out.println("Select from the following: \n");
    	 Sales sales = new Sales();
    	  int choice =0;
    	  
    	  while(choice!=3) {
    		  
    	  sales.salesOption();
    	  choice = sc.nextInt();
    	  
    	  
    	  if(choice ==1) {
    		  
    		  party Pobj = new party();
    		  int partyOption = 0;
				
				while(partyOption!=5) {
				
				 Pobj.partyOpt();
				  partyOption = sc.nextInt();
				 
				 if(partyOption ==1) {
					 
					 partyobj = new party();
					 partyobj.setPartyId("party"+salePartyNum);
					 
					 System.out.println("Enter Name: \n");
					 String partyName = sc.next();
					 partyobj.setPartyName(partyName);
					 
					 System.out.println("Enter Contact number: \n");
					 String partyNum = sc.next();
					 partyobj.setPartyNum(partyNum);
					 
					 System.out.println("Enter Opening Account: \n");
					 String openingAccount = sc.next();
					 partyobj.setOpeningAccount(openingAccount);
					 
					 salesPartyMap.put(partyobj.getPartyId(),partyobj);
					 System.out.println("Map Size of Party: "+salesPartyMap.size());
					 
					 salePartyNum++;
				 }
				 
				 else if(partyOption==2) {
					 
					 Pobj.showParty(salesPartyMap);
					 
				 }
				 else if(partyOption ==3) {
					 
					 System.out.println(" Enter the Id to Update ");
						String pId = sc.next();
						 Pobj = salesPartyMap.get(pId);
						
							System.out.println("What do you want to update: \n");
							String key = sc.next();
							System.out.println("Enter the New Value: \n");
							String updateVal = sc.next();
							Pobj.updateParty(pId,salesPartyMap,updateVal,key,Pobj);
				 }
				 
				 else if(partyOption ==4) {
					 
					 Pobj = new party();
						System.out.println("Enter the Id to delete");
						String delId = sc.next();
						Pobj.deleteParty(delId,salesPartyMap);
				 }
				 
				 else if(partyOption ==5) {
					 System.out.println("Exit!!");
					 
				 }
				 
				} //while loop
    		  
    	  }
    	  
    	  else if(choice ==2) {
    		  
    		  
    		  int select = 0;
				 purchaseOrder	purObj = new purchaseOrder();
				 
				 while(select!=4) {
				 purObj.purchaseOrderOption();
				 
				  select = sc.nextInt();
				 
				 if(select ==1 ) {
					 while(repeat.equals("yes")) {
					 purchaseObj = new purchaseOrder();
						
					 purchaseObj.setPurchaseId("sale"+salesPurchaseNum);
					 
					 System.out.println("purchase ID: "+purchaseObj.getPurchaseId());
					 
					 purchaseObj.setPurchaseNum("000"+orderid);
					 
					 String date = purObj.getCurrentDate();
					 
					 purchaseObj.setPurchasedate(date);
					 
					 
					 salesPurchaseMap.put(purchaseObj.getPurchaseId(),purchaseObj);
//					 System.out.println("Map Size of purchase: "+purchaseMap.size());
//					 System.out.println("purchaseNum: "+purchasenum);
					 
//					 orderid++;
					 salesPurchaseNum++;
				// }
				 
//				 else if(select ==2) {
					 
//					 while(repeat.equals("yes")) {
					 pObj = new product();
					 partyobj = new party();
					 purchaseObj = new purchaseOrder();
					 orderObj = new order();
//					 System.out.println("\n-------------------Purchase Order List-----------------------\n");
//					 purObj.showPurchaseOrder(purchaseMap);
//					 
					 System.out.println("\n--------------Party List-------------- \n");
					 partyobj.showParty(salesPartyMap);
					 System.out.println("Select a party from above table: \n");
					 String partyId = sc.next();
					 
					 orderObj.setOrdernum("order"+(orderid-1));
					 
					 String partyName = salesPartyMap.get(partyId).getPartyName();
					 pObj.showProductList(productMap);
					 
					 orderObj.setPartyName(partyName);
					 
					 System.out.println("Select a product: \n");
					 String prodId = sc.next();
					 orderObj.setProductId(prodId);
					 float price = productMap.get(prodId).getpPrice();
					 
					 orderObj.setPrice(price);
					 System.out.println("Enter Quantity");
					 int quantity = sc.nextInt();
					 
					 orderObj.setQuantity(quantity);
					 orderObj.setDate(purchaseObj.getCurrentDate());
					// orderMap.put(purchaseObj.getPurchaseNum(),orderObj);
					 if(repeat.equals("yes")) {
						
							boolean check = orderObj.checkOrder(salesOrderMap,quantity,orderObj,price);
							
							if(!check) {
								 orderObj.viewOrder(orderMap);
							}
						 }
					boolean val= orderObj.checkOrderid(salesOrderMap,partyName);
					if(!val) {
						 salesOrderId++;
						 salesOrderMap.put("order"+(salesOrderId-1), orderObj);
						 accountSalesMap.put("Sale"+(salesPurchaseNum-1), salesOrderMap);
					}
					
					 
					 System.out.println("Repeat? enter yes/no: ");
					 
					 repeat = sc.next();
				
					 if(repeat.equals("no")) {
						 orderObj.viewOrder(salesOrderMap);
					 }
					
					 
					 if(!repeat.equals("yes")) {
						 
						 break;
						 
					 }
					 
					 }
					 
				 }
				 
				 else if(select ==2) {
					 
					 orderObj = new order();
					 System.out.println(" Enter the Order Id to Update!! ");
					 String orderID = sc.next();
					 orderObj.updateOrder(orderID, salesOrderMap);
					 
				 }
				 else if(select ==3) {
					 
					 orderObj = new order();
					 System.out.println(" Enter the Order Id to Delete!! ");
					 String orderID = sc.next();
					 orderObj.updateOrder(orderID, salesOrderMap);
					 
					
				 }
				 else if(select ==4) {
					 System.out.println("Exit Success!!");
					 
				 }
				 
				 } //while loop
    		  
    		  
    		  
    	  }
    	  
    	  else if(choice ==3) {
    		  
    		  System.out.println("sales Exit: ");
    		  
    	  }
    	  
      } //while loop closed
    	  
			
		}
		
		else if(option ==5) {
			
			Account account = new Account();
			System.out.println("Select from the following: \n");
			int choice = 0;
			
			while(choice!=3) {
			
		
			account.accountOptions();
			choice = sc.nextInt();
			
			if(choice ==1) {
				System.out.println("Showing purchase Content from Account section.....\n");
				account.showPurchaseDetails(orderMap);
			}
			else if(choice ==2) {
				
				System.out.println("showing Sales Content from Account section....\n");
				account.showSalesDetails(salesOrderMap);
				
			}
			else if(choice ==3) {
				System.out.println("Exit from Account Section");
			}
		}
			
			
		}
		
		
		else if(option ==6) {
			System.out.println("Exit Sucess!!");
			break;
		}
		
		
		
		}
	}

}

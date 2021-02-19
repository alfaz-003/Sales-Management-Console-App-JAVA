import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class home {

	public static void main(String[] args) {
		
		String categoryName;
		String categoryDesc;
		String categoryId;
		int num = 0;
		
		String productId;
		String productName;
		String productDisc;
		float productPPrice;
		float productSPrice;
		int productOpenStock;
		boolean productStatus;
		int pnum = 0;
		
		int partynum = 0;
		int purchasenum = 0;
		int orderid = 1;
		
		String repeat ="yes";
		
		 Map<String,category> maps = new HashMap<>();
		 Map<String,product> productMap = new HashMap<>();
		 Map<String,party> partyMap = new HashMap<>();
		 Map<String,purchaseOrder> purchaseMap = new HashMap<>();
		 Map<String,order> orderMap = new HashMap<>();
		 
		category catg;
		product pObj;
		party partyobj;
		purchaseOrder purchaseObj;
		order orderObj;
		
		
		 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n\t\t\t--------------------WLCOME---------------------\n");
		System.out.println(" Select one from the Following:  ");
		System.out.println(" \n 1.Category \n 2.Product \n 3.Purchase \n 4.Sales \n 5.Account \n 6.Exit \n");
		int option = sc.nextInt();
		
		
		while(true) {
			
			
			
			
			
			//option = sc.nextInt();
			
			
			switch(option) {
			
			case 1:
				category cat = new category();
				 cat.categories();
					
					 int value = sc.nextInt();
					
					
				switch(value) {
				 
				     case 1:
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
					
					
					
					//System.out.println("MapData "+maps.get("category0").getDescription());
					
					
					num++;
					break;
					
				case 2:
					
					catg = new category();
					System.out.println(maps.size());
				   catg.showCategories(maps);
					break;
					
				case 3:
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
					break;
					
				case 4:
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
					
					break;
					
				case 5:
					catg = new category();
					System.out.println("Enter the Id to delete");
					String delId = sc.next();
					catg.deleteCategory(delId,maps);
					
				case 6:
					System.out.println("Exit success!!");
					break;
				}
				
				break;
				
				
			case 2:
				
				product obj = new product();
				
				int pOption = 0;
			
					
					
					 
					 pOption = sc.nextInt();
					 
					 if(pOption == 6) {
						 break;
					 }
					 obj.products();
				
				switch(pOption) {
				
				case 1:
					
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
					break;
					
				case 2:
					
					obj.showProducts(productMap);
					break;
					
				case 3:
					
					System.out.println(" Enter the Id to Update ");
					String pId = sc.next();
					pObj = productMap.get(pId);
					
						System.out.println("What do you want to update: \n");
						String key = sc.next();
						System.out.println("Enter the New Value: \n");
						String updateVal = sc.next();
						obj.updateProducts(pId,productMap,updateVal,key,pObj);
						
					
					break;
					
				case 4:
					
					pObj = new product();
					System.out.println("Enter the Id to delete");
					String delId = sc.next();
					pObj.deleteProduct(delId,productMap);
					
					break;
					
				case 5:
					
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
					
					 break;
					 
					 
					
				case 6:
					System.out.println("Exit Success from Products!!");
					break;
				
				}
				
				break;
			 
			case 3:
				
				party Pobj = new party();
				System.out.println("Select: \n 1.Party \n 2.Purchase Order \n 3.Exit \n");
				int purchaseOpt = sc.nextInt();
				 switch(purchaseOpt) {
				 
				 case 1:
					 Pobj.partyOpt();
					 int partyOption = sc.nextInt();
					 
					 switch(partyOption) {
					 
					 case 1:
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
						 break;
						 
					 case 2:
						 Pobj.showParty(partyMap);
						 
						 break;
						 
					 case 3:
						 
						    System.out.println(" Enter the Id to Update ");
							String pId = sc.next();
							 Pobj = partyMap.get(pId);
							
								System.out.println("What do you want to update: \n");
								String key = sc.next();
								System.out.println("Enter the New Value: \n");
								String updateVal = sc.next();
								Pobj.updateParty(pId,partyMap,updateVal,key,Pobj);
						 
						 break;
						 
					 case 4:
						 
						    Pobj = new party();
							System.out.println("Enter the Id to delete");
							String delId = sc.next();
							Pobj.deleteParty(delId,partyMap);
						 
						 break;
						 
					 case 5:
						 System.out.println("Exit successfull!!");
						 
						 break;
					 
					 }
					 
					 break;
					 
				 case 2:
					 
					 purchaseOrder	purObj = new purchaseOrder();
					 purObj.purchaseOrderOption();
					 
					 int select = sc.nextInt();
					 switch(select) {
					 
					 case 1:
						 
						
						 purchaseObj = new purchaseOrder();
						
						 purchaseObj.setPurchaseId("purchase"+purchasenum);
						 
						 System.out.println("purchase ID: "+purchaseObj.getPurchaseId());
						 
						 purchaseObj.setPurchaseNum("000"+orderid);
						 
						 String date = purObj.getCurrentDate();
						 
						 purchaseObj.setPurchasedate(date);
						 
						 
						 purchaseMap.put(purchaseObj.getPurchaseId(),purchaseObj);
//						 System.out.println("Map Size of purchase: "+purchaseMap.size());
//						 System.out.println("purchaseNum: "+purchasenum);
						 
						 orderid++;
						 purchasenum++;
						
						 
						break;
						
					 case 2:
						
							 
						 
						 pObj = new product();
						 partyobj = new party();
						 purchaseObj = new purchaseOrder();
						 orderObj = new order();
//						 System.out.println("\n-------------------Purchase Order List-----------------------\n");
//						 purObj.showPurchaseOrder(purchaseMap);
//						 
						 System.out.println("\n--------------Party List-------------- \n");
						 partyobj.showParty(partyMap);
						 System.out.println("Select a party from above table: \n");
						 String partyId = sc.next();
						 orderObj.setOrdernum(partyId);
						 
						 String partyName = partyMap.get(partyId).getPartyName();
						 pObj.showProductList(productMap);
						 
						 orderObj.setPartyName(partyName);
						 
						 System.out.println("Select a product: \n");
						 String prodId = sc.next();
						 float price = productMap.get(prodId).getpPrice();
						 
						 orderObj.setPrice(price);
						 System.out.println("Enter Quantity");
						 int quantity = sc.nextInt();
						 
						 orderObj.setQuantity(quantity);
						 orderObj.setDate(purchaseObj.getCurrentDate());
						 orderMap.put(purchaseObj.getPurchaseNum(),orderObj);
						 
						 System.out.println("Repeat? enter yes: ");
						 
						 repeat = sc.next();
						 
						 orderObj.viewOrder(orderMap);
						 
						 break;
						 
						 
						 
					 case 3:
						 
						 break;
					 
					 }
					 
					 break;
					 
				 case 3:
					 
					 break;
				 
				 }
				
				break;
				
			case 4:
				
				break;
				
			case 5:
				
				break;
				
			case 6:
				
				System.out.println("Exit from Main Successfull!!!");
				
				break;
				
			}
			
		}
		

	}

}

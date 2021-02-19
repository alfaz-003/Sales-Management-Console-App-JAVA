import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class category {
	
	private String id;
	

	private String name;
	private String description;
	private List<category> categoryData;
	//private Map<String,List<category>> mapData = new HashMap<String,List<category>>();
	//private Map<String,category> mapData = new HashMap<String,category>();
	//private List<Map<String,category>> list = new ArrayList<>();
	//List<category> newlist = new ArrayList<category>();
	
	String[] nameAr = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	String[] twoCharAr = {"ab","bc","cd","ef","gh","fg","gh","fh","ij","kl","mn","op","qr","st","uv","wx","yz","ac","ad","bd","be","bf","gf","hj","hg",
			"hf","ji","lk","mn","po","rp","pr","ts","rq","vu","xw","zy","as","ap","si","al","ok"};
	
	public void categories() {
		
		System.out.println(" Select The Operation ");
		
		System.out.println(" 1.1 Insert \n 1.2 View \n 1.3 Search \n 1.4 Update \n 1.5 Delete \n 1.6 Exit \n");
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean validateName(String cName,Map<String,category>map) {
		
		
		 if(cName.length()>3) {
			 
			 System.out.println("Incorrect!!");
			 return false;
			 
		 }
		 
		 else if(cName.length()<=3) {
			
			 
			for(Map.Entry<String, category> val:map.entrySet()) {
				   
				   if(val.getValue().getName().equals(cName.trim())) {
					   
					   System.out.println(" Name Already Present!! ");
					   return false;
				   }
				   
			   }
		}
		
		
		return true;
			
	}
	
	public String autoName(String cName) {
		
		Random rand = new Random();
		
		
		if(cName.length()==2) {
			int num1 = rand.nextInt(nameAr.length-1);
			String s = nameAr[num1];
			String newname = cName.concat(s);
			System.out.println("Newname: "+newname);
			return newname;
			
		}
		else if(cName.length()==1) {
			
			int num2 = rand.nextInt(twoCharAr.length-1);
			String s2 = twoCharAr[num2];
			String name2 = cName.concat(s2);
			System.out.println("Newname: "+name2);
			return name2;
			
		}
		
		else if(cName.length()==3) {
			return cName;
		}
		return "done";
	}
	
	
	
//	public void storeData(category obj) {
//		
//	//	categoryData = new ArrayList<category>();
//		
//		//categoryData.add(obj);
//		
//		
//		
//		mapData.put("category0", obj);
//		
//		
//		
//		
//		
//		
//		
//	}
//	
	
//   public Map<String, category> getMapData() {
//		
//	   
//		
//		return mapData;
//	}
	
	
   public void showCategories(Map<String,category> map) {
	   
	   System.out.println(" |    Id     |      Name     |     Description       | \n ");
	  
	   
	   for(Map.Entry<String, category> val:map.entrySet()) {
		   
		   System.out.println(" "+val.getKey()+"  \t  "+val.getValue().getName()+"   \t\t  "
		   		+ "  "+val.getValue().getDescription()+" \n");
		   
	   }
	   
	   
   }
   
   public void searchCategoryById(Map<String,category> search,String cid) {
	   
                 for(Map.Entry<String, category> val:search.entrySet()) {
                	 
                	 		if(val.getKey().equals(cid)) {
                	 			  System.out.println(" |    Id     |      Name     |     Description       | \n ");
                	 			  System.out.println(" "+cid+" \t\t"+val.getValue().getName()+" \t\t "+val.getValue().getDescription()+"\n");
                	 			
                	 			break;
                	 		} else {
                	 			System.out.println("Match not Found!!\n");
                	 			break;
                	 		}
		   
		       
		          
	                  } 
	   
   }
   
   public void searchCategoryByName(Map<String,category>nameMap,String cName) {
	   
	   boolean flag = false;
	   
	   	
	        for(Map.Entry<String,category> val:nameMap.entrySet()) {
	        	
	        	if(val.getValue().getName().contains(cName.trim())) {
	        		
	        		 System.out.println(" |    Id     |      Name     |     Description       | \n ");
   	 			     System.out.println(" "+val.getKey()+" \t\t"+val.getValue().getName()+" \t\t "+val.getValue().getDescription()+"\n");
   	 			     flag=true;
   	 			     break;
	        	}
	        	
	        }
	        
	        if(!flag) {
	        	
	        		System.out.println("No Match Found!!");	
	        	
	        }
	   
	   
   }
   
   public void updateCategory(String cid,Map<String,category>map,String updateVal,String updateKey,category obj) {
	   
	   for(Map.Entry<String,category>val:map.entrySet()) {
		   
		   if(updateKey.equals("Name")) {
			    if(val.getKey().equals(cid)) {
			    	obj.setName(updateVal);
			    	map.put(cid,obj);
			    	System.out.println("Name updated Successfully");
			    	break;
			    }
			   
		   }
		   else if(updateKey.equals("desc")) {
			   
			   if(val.getKey().equals(cid)) {
			    	obj.setDescription(updateVal);
			    	map.put(cid,obj);
			    	System.out.println("Description updated Successfully");
			    	break;
			    }
			   
			   
		   }
	   }
	   
	   
   }
   
   public void deleteCategory(String cid,Map<String,category>map) {
	   
	   for(Map.Entry<String,category>val:map.entrySet()) {
		   
		   if(val.getKey().equals(cid)) {
			   map.remove(cid);
			   System.out.println("Deleted Successfully!!!!");
			   break;
		   }
	   }
	   
   }
	
	
	

}

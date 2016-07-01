
/*Main Java Program to read URL and convert JSON to java object and Extract various Result */

package TestAssignment;
import TestAssignment.TodoJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
public class myTest {

	public static void main(String[] args) throws Exception {
		
		// Read URL
		URL url= new URL("http://localhost:81/nss-todo-automation-alpha/fake-api-call.php");
        URLConnection conn = url.openConnection();
         BufferedReader in = new BufferedReader(new InputStreamReader(
                                    conn.getInputStream()));
         
    /*  //Print Response Value from Server
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();  
		*/
         
         //Create a String buffer
        StringBuffer buffer=new StringBuffer();
		int read;
		char[] chars =new char[1024];
		while((read=in.read(chars))!=-1)
			buffer.append(chars,0,read);

		// JSON to java object parsing
		Gson gson = new GsonBuilder().create();
        TodoJava[] tobj = gson.fromJson(buffer.toString(), TodoJava[].class);
     
        // TASK ::  Find how many tasks do not have "category" assigned
       int count=0;
        for(int i=0;i<tobj.length;i++){
        	if(tobj[i].getCategory().isEmpty()) {
            		count = count+1;
            		}
        }
        System.out.println("Empty Category count  is :: "+count);
        
     // TASK :: Count and validate the number of tasks
        int j=0;
        for(int i=0;i<tobj.length;i++){
        	if(tobj[i].getStatus().contains("c")) {
            		j++;
        	}
        }
      System.out.println("\nCompleted (strike out) task are :: "+j);

        // TASK ::  Aggregate and print only "task names"
      	System.out.println("\nTotal task in list are : ") ;
        int cnt=0;
        for(int i=0;i<tobj.length;i++){
        	cnt=cnt+1;
        	System.out.println(tobj[i].getTaskname());
        }
       // System.out.println("\n Total Number of task are :: "+ cnt) ;
   
        
        // TASK :  Read API response and print tasks in descending "due date" order        
      	
       ArrayList<TodoJava> arList = new ArrayList<TodoJava> (Arrays.asList(tobj)); /*Convert array of JSON objects  to ArrayList */
        			
       /*int count1= arList.size();	System.out.println(count1);*/
                     
   System.out.println("\nRead API response and print tasks in descending due date order :" );	
   Collections.sort(arList, new Comparator <TodoJava> (){
              public int compare(TodoJava e1, TodoJava e2) {
            	  return e2.getDate().compareTo(e1.getDate());
   	}
   
  });
       for (int i=0;i<arList.size();i++) {
       System.out.println( arList.get(i).getDate() + "" + arList.get(i).getTaskname());}
}
}



/*      System.out.println("\n sorted list of task is :" );	
Collections.sort(arList, new Comparator <TodoJava> (){
   
     public int compare(TodoJava e1, TodoJava e2) {
       
     	if (!(e1.getDate().equals(e2.getDate()))){
         	System.out.println( e1.getDate()+ "" + e1.getTaskname() + "\n");
             return -1;
         } else                 	
             return 1;
     }
 });  */


/*     ArrayList<TodoJava> arList1 = new ArrayList<TodoJava> (Arrays.asList(tobj));
Collections.sort(arList1, new Comparator <TodoJava> (){
   
     public int compare(TodoJava e1, TodoJava e2) {
     	
     	return e2.getDate().compareTo(e1.getDate());
     	
     	            	if (e1.getDate().equals(e2.getDate())){
         	System.out.println( e2.getDate()); // "" + data2.getTaskname() + "\n");
             return -1;
         } else {
         	System.out.println(data2.getDate()+ "" + data2.getTaskname() + "\n");
             return 1;
            
         }
     }
    

 });
      	if (!(data2.getDate().equals(data1.getDate())))
     	 if (Integer.getInteger(data1.getID())< Integer.getInteger(data2.getID())){
         	System.out.println(data1.getID());
             return -1;
     	               }
     	if (data1.getDate().toString().compareTo(data2.getDate().toString())>1){
         	System.out.println( data2.getDate() ); 
             return -1;
         } else 
         	return 1;
     }   */

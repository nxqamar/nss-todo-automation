
/*Main Java Program to read URL and convert jason to java object and derive a result */

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
import java.util.Collections;
import java.util.List;

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
         
        // Print Response Value from Server
       /* String inputLine;
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

		// json to java object parsing
		
        Gson gson = new GsonBuilder().create();
        TodoJava[] tobj = gson.fromJson(buffer.toString(), TodoJava[].class);
        TodoJava[] arr = gson.fromJson(buffer.toString(), TodoJava[].class);
               
        // Task : Find how many tasks do not have "category" assigned
        int count=0;
        for(int i=0;i<tobj.length;i++){
        	if(tobj[i].getCategory().isEmpty()) {
            		count = count+1;
            		}
        }
        System.out.println("Empty Category count  is :: "+count);	
       
        
      //  Aggregate and print only "task names"
        
      /*  for(int i=0;i<tobj.length;i++){
        	System.out.println(tobj[i].getTaskname());
        }
      */  
        
        //Count and validate the number of tasks
        
        
       // Read API response and print tasks in descending "due date" order 
        Type collectionType = new TypeToken<List<TodoJava>>() {
        }.getType();
        List<TodoJava> list1 = gson.fromJson(buffer.toString(), collectionType);
        	//System.out.println(list1.get(0).getDate());
        	
	}

}

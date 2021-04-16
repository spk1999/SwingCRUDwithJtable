/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.User;

/**
 *
 * @author cod
 */
public class FileManager {
    
    public void fileMange(){
        try {
// Creating an object of a file
File myObj = new File("User.txt"); 
if (myObj.createNewFile()) {
System.out.println("File created: " + myObj.getName());
} else {
System.out.println("File already exists.");
}
} catch (IOException e) {
System.out.println("An error occurred.");
e.printStackTrace();
}
    }
    
    
    public boolean writeUser(User u){
        try {
      FileWriter myWriter = new FileWriter("User.txt");
      myWriter.write(u.getUsername());
      myWriter.write(u.getPassword());
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
      return true;
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        return false;
    }
    
    public boolean readUser(User u) 
    {
   try(BufferedReader bufferedReader = new BufferedReader(new FileReader("User.txt"))) {
    String line = bufferedReader.readLine();
    if(line != null) {
        String user=u.getUsername()+u.getPassword();
       
        System.out.println(line);
         if(line.equals(user)){
             return true;
         }
        line = bufferedReader.readLine();
    }
    
} catch (FileNotFoundException e) {
    // Exception handling
} catch (IOException e) {
    // Exception handling
}
   return false;
}
        
    
    }
    
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import file.FileManager;
import model.User;

/**
 *
 * @author cod
 */
public class Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // new Login().setVisible(true);
      new FileManager().writeUser(new User("mango ","mango"));
      //new FileManager().readUser(new User("mango","mango"));
       
    }
    
}

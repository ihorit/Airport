/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.view;

import airport.Main;
//import airport.admintab.Flight;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author it01
 */
public class MeinMenuController {
    private Main main;
    
    @FXML
    private Label message;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    
    @FXML
    private void goAdminTab() throws IOException{
        try
        {
            final String DB_URL = "jdbc:mysql://localhost:3306/airport";
            final String USER_NAME = "root";
            final String PASSWORD = "password";
            
            Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            
            Statement statement = connection.createStatement();
            //create and execute query
            final String QUERY = "SELECT username, password FROM users";
            
            ResultSet result = statement.executeQuery(QUERY);
            
            while(result.next()){
             
                //   data.add(new Flight(result.getString(1), result.getString(2), result.getString(3),result.getString(4),result.getString(5), result.getString(6)));
                if(userName.getText().equalsIgnoreCase(result.getString("username"))&& password.getText().equalsIgnoreCase(result.getString("password"))){
                  Main.showAdminTab();
                }else
                {
                    message.setText("Autentification failed!");
                }
            }
            
            //load records 
            connection.close();
        
        }//end try
        catch(SQLException sqlExeption){
        }
          
    }
    
    @FXML
    private void goUserTab() throws IOException{
        Main.showUserTab();
    }
    
    
}

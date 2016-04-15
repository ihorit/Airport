/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.admintab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author it01
 */
public class AddRecordController {
    
    @FXML
    private TextField time;
    @FXML
    private TextField flight;
    @FXML
    private TextField destination;
    @FXML
    private TextField carrier;
    @FXML
    private TextField terminal;
    @FXML
    private TextField status;
    
    @FXML
    private void saveRecordinDB(){
        try
        {
            final String DB_URL = "jdbc:mysql://localhost:3306/airport";
            final String USER_NAME = "root";
            final String PASSWORD = "ae201c8c";
            
            Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            
            Statement statement = connection.createStatement();
            //create and execute query
            final String QUERY = "SELECT ID, first_name, second_name FROM Authors";
            
            final String queryAdd = "INSERT INTO flights(time, flight,destination, carrier, terminal, status) VALUES (?,?,?,?,?,?);";
            
            //System.out.println(time.getText());
            PreparedStatement preparedsmt = connection.prepareStatement(queryAdd);
            preparedsmt.setString(1, time.getText());
            preparedsmt.setString(2, flight.getText());
            preparedsmt.setString(3, destination.getText());
            preparedsmt.setString(4, carrier.getText());
            preparedsmt.setString(5, terminal.getText());
            preparedsmt.setString(6, status.getText());
            
            preparedsmt.execute();
            
            AdminTabController.getInstance().add(new Flight(
                    time.getText(), 
                    flight.getText(), 
                    destination.getText(), 
                    carrier.getText(), 
                    terminal.getText(),
                    status.getText()));
            
            //load records 
            connection.close();
            
            //super.
            
           /*AdminTabController.updateTable(
                    time.getText(),
                    flight.getText(),
                    destination.getText(),
                    carrier.getText(),
                    terminal.getText(),
                    status.getText()
            );*/
            
           /* AdminTabController.*/
            
            //AdminTabController.initialize();
        
        }//end try
        catch(SQLException sqlExeption){
        }
    }
            
    
}

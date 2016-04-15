package airport.admintab;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import airport.Main;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author it01
 */
public class AdminTabController {
    
    private Main main;
    
    private static ObservableList<Flight> data;
    
    @FXML
    private TableView<Flight> tableFlight;
    @FXML
    private TableColumn<Flight, String> timeColumn;
    @FXML
    private TableColumn<Flight, String> flightColumn;
    @FXML
    private TableColumn<Flight, String> destinationColumn;
    @FXML
    private TableColumn<Flight, String> carriertColumn;
    @FXML
    private TableColumn<Flight, String> terminalColumn;
    @FXML
    private TableColumn<Flight, String> statusColumn;
    
    public AdminTabController(){
        data = FXCollections.observableArrayList();
    }
    
    @FXML
    public void initialize(){
        initData();
        
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        flightColumn.setCellValueFactory(new PropertyValueFactory<>("flight"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
        carriertColumn.setCellValueFactory(new PropertyValueFactory<>("carrier"));
        terminalColumn.setCellValueFactory(new PropertyValueFactory<>("terminal"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        tableFlight.setItems(data);
        
    }
    
    private void initData(){
        try
        {
            final String DB_URL = "jdbc:mysql://localhost:3306/airport";
            final String USER_NAME = "root";
            final String PASSWORD = "ae201c8c";
            
            Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            
            Statement statement = connection.createStatement();
            //create and execute query
            final String QUERY = "SELECT time, flight,destination, carrier, terminal, status FROM flights";
            
            ResultSet result = statement.executeQuery(QUERY);
            
            while(result.next()){
                data.add(new Flight(result.getString(1), result.getString(2), result.getString(3),result.getString(4),result.getString(5), result.getString(6)));
                           
            }
            
            //load records 
            connection.close();
        
        }//end try
        catch(SQLException sqlExeption){
        }
        
        
    }
    
    public static ObservableList<Flight> getInstance() {
        return data;
    }
   
    @FXML
    public void updateTable(String time, String flight, String destination,String carrier, String terminal, String status){
        data.add(new Flight(time, flight, destination, carrier, terminal, status));
    }
    
    
    @FXML
    private void addRecord() throws IOException{
        Main.showAddRecord();
    }
    
    @FXML
    private void deleteRecord(){
        Flight item = tableFlight.getSelectionModel().getSelectedItem();
        data.remove(item);
    }
    
    @FXML
    private void newUser() throws IOException{
        Main.showNewUser();
    }
    
    @FXML
    private void testAdd(){
        data.add(new Flight("3:54:34", "TestAdd", "TestAdd", "TestAdd", "TestAdd", "TestAdd"));
    }
    
}

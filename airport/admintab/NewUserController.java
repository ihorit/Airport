package airport.admintab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class NewUserController {
    @FXML
    private TextField login;
    @FXML
    private TextField firtName;
    @FXML
    private TextField secondName;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField checkPassword;
    @FXML
    private Label massage;
    
    @FXML
    public void addNewUser(){
        try
        {
            final String DB_URL = "jdbc:mysql://localhost:3306/airport";
            final String USER_NAME = "root";
            final String PASSWORD = "password";
            
            try (Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
                Statement statement = connection.createStatement();
                //create and execute query
                final String queryAdd = "INSERT INTO users (user_first_name, user_last_name, username, password) VALUES (?,?,?,?)";
                
                PreparedStatement addUser = connection.prepareStatement(queryAdd);
                addUser.setString(1, firtName.getText());
                addUser.setString(2, secondName.getText());
                addUser.setString(3, login.getText());
                addUser.setString(4, password.getText());
                addUser.execute();
                
                //ResultSet result = statement.executeQuery(QUERY);
                
                /*while(result.next()){
                    //data.add(new Flight(result.getString(1), result.getString(2), result.getString(3),result.getString(4),result.getString(5), result.getString(6)));
                    
                } */
                massage.setText("The user was added!");
            }
        
        }//end try//end try
        catch(SQLException sqlExeption){
        }
    }
    
}

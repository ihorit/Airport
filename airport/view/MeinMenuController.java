/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.view;

import airport.Main;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author it01
 */
public class MeinMenuController {
    private Main main;
    
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    
    @FXML
    private void goAdminTab() throws IOException{
        Main.showAdminTab();
        System.out.println(userName.getText());
        System.out.println(password.getText());
    
    }
    
    @FXML
    private void goUserTab() throws IOException{
        Main.showUserTab();
    }
    
    
}

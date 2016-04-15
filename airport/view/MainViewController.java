/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.view;

import airport.Main;
import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author it01
 */
public class MainViewController {
    
    private Main main;
    
    @FXML
    private void goHome() throws IOException{
        Main.showMainMenu();
    }
    
}

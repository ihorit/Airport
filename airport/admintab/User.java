/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport.admintab;

import javafx.scene.control.TextField;

/**
 *
 * @author it01
 */
public class User {
    private TextField firstName;
    private TextField lastName;
    
    public User(String fName, String lName){
        this.firstName.setText(fName);
        this.lastName.setText(lName);
    }

    public TextField getFirstName() {
        return firstName;
    }

    public TextField getLastName() {
        return lastName;
    }

    public void setFirstName(TextField firstName) {
        this.firstName = firstName;
    }

    public void setLastName(TextField lastName) {
        this.lastName = lastName;
    }
    
    
}

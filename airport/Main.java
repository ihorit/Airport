/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *
 * @author it01
 */
public class Main extends Application {
    private static Stage primaryStage;
    private static BorderPane mainLayout;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("Airport");
        showMainView();
        showMainMenu();
    
    }
    
    public void showMainView() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainView.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout,900,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void showMainMenu() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainMenu.fxml"));
        BorderPane mainMenu = loader.load();
        mainLayout.setCenter(mainMenu);
    
    }
    
    public static void showAdminTab() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("admintab/AdminTab.fxml"));
        BorderPane AdminTab = loader.load();
        mainLayout.setCenter(AdminTab);
    
    }
    
    public static void showUserTab() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/UserView.fxml"));
        BorderPane UserTab = loader.load();
        mainLayout.setCenter(UserTab);
    }
    
    public static void showAddRecord() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("admintab/AddRecord.fxml"));
        BorderPane addRecord = loader.load();
        Stage addRecoprdStage = new Stage();
        addRecoprdStage.setTitle("Add new Record");
        addRecoprdStage.initModality(Modality.WINDOW_MODAL);
       // addRecoprdStage.initOwner(primaryStage);
        Scene scene = new Scene(addRecord);
        addRecoprdStage.setScene(scene);
        addRecoprdStage.showAndWait();
    }
    
    public static void showNewUser() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("admintab/NewUser.fxml"));
        BorderPane newUser = loader.load();
        Stage newUserStage = new Stage();
        newUserStage.setTitle("New User");
        newUserStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(newUser);
        newUserStage.setScene(scene);
        newUserStage.showAndWait();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

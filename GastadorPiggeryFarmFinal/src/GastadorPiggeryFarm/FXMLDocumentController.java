/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GastadorPiggeryFarm;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Donald
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane main_form;

    @FXML
    private Button close;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginbtn;
    
    // DATABASE TOOLS
    private PreparedStatement prepare;
    private Connection connect;
    private ResultSet result;
    
    
    
    private double x = 0;
    private double y = 0;
    public void loginAdmin(){
        
        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
        
        connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());
            
            result = prepare.executeQuery();
            
            Alert alert;
            
            if (username.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else {
                if (result.next()){
                    //get the USERNAME of user
                    getData.username = username.getText();
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully!");
                    alert.showAndWait();
                    
                    loginbtn.getScene().getWindow().hide(); /*to hide login form*/
                    
                    //LINK DASHBOARD FORM
                    Parent root = FXMLLoader.load(getClass().getResource("FXML_DOCUMENT_Security.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene (root);
                    
                    root.setOnMousePressed((MouseEvent event) -> {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });

                root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);

                        stage.setOpacity(.8);
                    });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.initStyle(StageStyle.TRANSPARENT);
                    
                });
                    
                    
                    
                    stage.setScene(scene);
                    stage.show();
                    
                }else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong username/password");
                    alert.showAndWait();
                }
               
            }
            
        }catch (Exception e) {e.printStackTrace();}
        
    }
    
    
    @FXML
    public void close(){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

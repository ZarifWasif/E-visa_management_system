/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.visam;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class SigninSceneController implements Initializable {

    @FXML
    private Label RegLabel;
    @FXML
    private TextField userName;
    @FXML
    private TextField userPassword;
    @FXML
    private ComboBox allUserInCombox;
    @FXML
    private Label RegLabel1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 allUserInCombox.getItems().addAll("Admin","Supervisor","Operator Officer",
                 "Applicant","Analyst Officer","Manager","Agent","Support Officer");
        allUserInCombox.setValue("Select your Designation");     }    

    @FXML
    private void registerButtonOnClick(ActionEvent event) {
         File f = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        
        try {
            f = new File("login1.bin");
            if(f.exists()) fos = new FileOutputStream(f,true);
            else fos = new FileOutputStream(f);
            
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);
            
            
           
            dos.writeUTF(userName.getText());
           // dos.writeUTF(LastName.getText());
           // dos.writeUTF(UserName.getText());
           // dos.writeUTF(PhoneNo.getText().toString());
            dos.writeUTF(userPassword.getText().toString());
            dos.writeUTF(allUserInCombox.getValue().toString());
            
            
           userName.setText(null);  allUserInCombox.setValue(null);  userPassword.setText(null);  //PhoneNo.setText(null);
            //LastName.setText(null);  UserName.setText(null);
            
             RegLabel1.setText("Accont Create Successfully");

        } catch (Exception ex) {
    
        } finally {
            try {
                if(dos != null) dos.close();
            } catch (Exception ex) {
                
            }
        } 
    }

    @FXML
    private void BackToLoginPage(ActionEvent event) throws IOException {
             Parent scene2Parent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    
}

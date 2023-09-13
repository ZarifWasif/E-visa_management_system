/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.visam;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
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
public class LoginSceneController implements Initializable {

    @FXML
    private TextField UserName;
    @FXML
    private Label label;
    @FXML
    private TextField UserPassword;
    @FXML
    private ComboBox UserInComboBox;
    @FXML
    private Label loginLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          UserInComboBox.getItems().addAll("Admin","Supervisor","Operator Officer",
                 "Applicant","Analyst Officer","Manager","Agent","Support Officer");
        UserInComboBox.setValue("Select your Designation");
    }    

    @FXML
    private void UserLoginOnAction(ActionEvent event) 
    {   String name = UserName.getText().toString();
        String password = UserPassword.getText().toString();
        String users = UserInComboBox.getValue().toString();
        
        
        File logindata = null;
        FileInputStream loginInput = null;
        BufferedInputStream BufferInput = null;
        DataInputStream DataInput = null;
        String str="";
        try {
            logindata = new File("login1.bin");
            if(!logindata.exists()){
                label.setText("Account Does not Exits!!");
            }
            else{
                
                loginInput = new FileInputStream(logindata);
               
                DataInput = new DataInputStream(loginInput);
               
                while(true){
                    
                      String DataName=  DataInput.readUTF();
                       String DataPass= DataInput.readUTF();
                      String UserType=  DataInput.readUTF();
                      
                      if(DataName.equals(name) && DataPass.equals(password) && UserType.equals(users))
                      {
                        
                          
                         if(UserType.equals("Admin"))
                          {
                               Parent scene2Parent = FXMLLoader.load(getClass().getResource(".fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                           window.setScene(scene2);
                            window.show();
                              
                          }
                          
                          else if(UserType.equals("Supervisor"))
                          {
                                   Parent scene2Parent = FXMLLoader.load(getClass().getResource(".fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                            window.setScene(scene2);
                         window.show();
                              
                          }    
                          else if(UserType.equals("Operator Officer"))
                          {
                                   Parent scene2Parent = FXMLLoader.load(getClass().getResource("OperatorOfficerDashboardPage.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }
                          else if(UserType.equals("Applicant"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource("ApplicantDashBoard.fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                   window.setScene(scene2);
                      window.show();
                              
                          }
                          else if(UserType.equals("AnalystOfficer"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource(".fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                          window.setScene(scene2);
                          window.show();
                              
                          }
                          
                          
                            else if(UserType.equals("Manager"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource(".fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                          window.setScene(scene2);
                          window.show();
                              
                          }
                               else if(UserType.equals("Agent"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource(".fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                          window.setScene(scene2);
                          window.show();
                              
                          }
                          
                                  else if(UserType.equals("Support Officer"))
                          {
                           Parent scene2Parent = FXMLLoader.load(getClass().getResource(".fxml"));
                          Scene scene2 = new Scene(scene2Parent);
                          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                          window.setScene(scene2);
                          window.show();
                              
                          }
                                                 
                          break;
                      }
                    
                }
           
            }
        } catch (Exception ex) {
            loginLabel.setText("Login Failed!");

        } finally {
          
        }   

    }

    @FXML
    private void UserSigninOnAction(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("SigninScene.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    
}

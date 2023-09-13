/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.visam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class OperatorOfficerCommunicateWithOtherTeamMembersController implements Initializable {

    @FXML
    private TextArea OperatorOfficerMessage;
    @FXML
    private TextField OperatorOfficerName;
    @FXML
    private TextArea OtherTeamMemberReply;
    @FXML
    private TextField OtherTeamMemberName;
    @FXML
    private TextArea OtherTeamMemberMessage;
    @FXML
    private TextArea OperatorOfficerReply;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BackToOperatorOfficerDashBoardButtonOnClick(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("OperatorOfficerDashboardPage.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show(); 
    }


    @FXML
    private void ViewOtherTeamMemberReplyButtonOnClick(ActionEvent event) {
         OtherTeamMemberReply.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String showInformation="";
        try {
            f = new File("Otherteammembermessage.bin");
            if(!f.exists()){
                OtherTeamMemberReply.setText("No new Post");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               showInformation =   "Other Team Member Name: "+readData.readUTF()+"\n"+
                        "Other Team Member Message: "+readData.readUTF()+"\n"
                
                     ;
                
                    OtherTeamMemberReply.appendText(showInformation);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(OperatorOfficerCommunicateWithOtherTeamMembersController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(OperatorOfficerCommunicateWithOtherTeamMembersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void ViewOperatorOfficerReplyButtonOnClick(ActionEvent event) {
         OperatorOfficerReply.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String showInformation="";
        try {
            f = new File("OperatorOfficerMessage.bin");
            if(!f.exists()){
                OperatorOfficerReply.setText("No new Post");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               showInformation =   "Operator Officer Name: "+readData.readUTF()+"\n"+
                        "Operator Officer Message: "+readData.readUTF()+"\n"
                       
                     ;
                
                    OperatorOfficerReply.appendText(showInformation);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(OperatorOfficerCommunicateWithOtherTeamMembersController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(OperatorOfficerCommunicateWithOtherTeamMembersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void SubmitOtherTeamMemberMessageButtonOnClick(ActionEvent event) {
         File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("Otherteammembermessage.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            
            writeData = new DataOutputStream(wirteFile);
            
            writeData.writeUTF(OtherTeamMemberName.getText());
            writeData.writeUTF(OtherTeamMemberMessage.getText());
           
          
        } catch (IOException ex) {
            Logger.getLogger(OperatorOfficerCommunicateWithOtherTeamMembersController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(OperatorOfficerCommunicateWithOtherTeamMembersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
    }

    @FXML
    private void SubmitOperatorOfficerMessageButtonOnClick(ActionEvent event) {
         File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("OperatorOfficerMessage.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            
            writeData = new DataOutputStream(wirteFile);
            
            writeData.writeUTF(OperatorOfficerName.getText());
            writeData.writeUTF(OperatorOfficerMessage.getText());
            
         
          
            
          
        } catch (IOException ex) {
            Logger.getLogger(OperatorOfficerCommunicateWithOtherTeamMembersController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(OperatorOfficerCommunicateWithOtherTeamMembersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
}

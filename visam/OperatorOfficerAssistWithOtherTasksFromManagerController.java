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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class OperatorOfficerAssistWithOtherTasksFromManagerController implements Initializable {

    @FXML
    private TextArea OperatorOfficerAssistWork;
    @FXML
    private TextArea WorkDetails;

    @FXML
 private void BackToOperatorOfficerDashBoardButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("OperatorOfficerDashboardPage.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();    
    }    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ShowAssistWorkButtonOnClick(ActionEvent event) {
         OperatorOfficerAssistWork.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String showInformation="";
        try {
            f = new File("OperatorOfficerAssistWorkDetails.bin");
            if(!f.exists()){
                OperatorOfficerAssistWork.setText("No new Post");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               showInformation =   "Operator Officer Work Details: "+readData.readUTF()+"\n"
                        
                     ;
                
                    OperatorOfficerAssistWork.appendText(showInformation);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(OperatorOfficerAssistWithOtherTasksFromManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(OperatorOfficerAssistWithOtherTasksFromManagerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void SubmitWorkDetailsButtonOnClick(ActionEvent event) {
          File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("OperatorOfficerAssistWorkDetails.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            
            writeData = new DataOutputStream(wirteFile);
            
            writeData.writeUTF(WorkDetails.getText());
            
          
        } catch (IOException ex) {
            Logger.getLogger(OperatorOfficerAssistWithOtherTasksFromManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(OperatorOfficerAssistWithOtherTasksFromManagerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
    }
    
}

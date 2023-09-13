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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class OperatorOfficerSendReportToTheDirectorController implements Initializable {

    @FXML
    private TextField ApplicantName;
    @FXML
    private TextField VisaApprovedStatus;
    @FXML
    private TextField NidNumber;
    @FXML
    private TextField MobileNumber;
    @FXML
    private TextField Nationality;
    @FXML
    private TextArea OperatorOfficerReport;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
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
    private void SubmitButtonOnClick(ActionEvent event) {
         File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("OperatorOfficerReport.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            
            writeData = new DataOutputStream(wirteFile);
            
            writeData.writeUTF(ApplicantName.getText());
            writeData.writeUTF(VisaApprovedStatus.getText());
            writeData.writeUTF(NidNumber.getText());
                        writeData.writeUTF(MobileNumber.getText());
                        writeData.writeUTF(Nationality.getText());
                        

          
            
          
        } catch (IOException ex) {
            Logger.getLogger(ApplicantApplyForVisaController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writeData != null) writeData.close();
            } catch (IOException ex) {
                Logger.getLogger(ApplicantApplyForVisaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 

    
}

    @FXML
    private void ViewButtonOnClick(ActionEvent event) {
        OperatorOfficerReport.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String showInformation="";
        try {
            f = new File("OperatorOfficerReport.bin");
            if(!f.exists()){
                OperatorOfficerReport.setText("No new Post");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               showInformation =   
                        "Applicant Name: "+readData.readUTF()+"\n"
                        +
                        "Visa Approved Status: "+readData.readUTF()+"\n"
                       +
                        "Applicant Nid Number: "+readData.readUTF()+"\n"
                        +
                        "Applicant Mobile Number: "+readData.readUTF()+"\n"
                       +
                        "Applicant Nationality: "+readData.readUTF()+"\n"
                       
                       
                       
                     ;
                
                    OperatorOfficerReport.appendText(showInformation);
                }
            }
        } catch (IOException ex) {
           
            Logger.getLogger(ApplicantApplyForVisaController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(readData != null) readData.close();
            } catch (IOException ex) {
                Logger.getLogger(ApplicantApplyForVisaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
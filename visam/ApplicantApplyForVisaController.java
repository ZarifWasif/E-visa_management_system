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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ApplicantApplyForVisaController implements Initializable {

    @FXML
    private TextField FullName;
    @FXML
    private TextField PermanentAddress;
    @FXML
    private TextField AddressInBangladesh;
    @FXML
    private TextField PassportNo;
    @FXML
    private TextField PresentNationality;
    @FXML
    private TextField PlaceOfBirth;
    @FXML
    private DatePicker DateOfBirth;
    @FXML
    private ComboBox Gender;
    @FXML
    private ComboBox SelectCountry;
    @FXML
    private TextField BankDetails;
    @FXML
    private TextArea ApplicantInformation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Gender.getItems().addAll("Male","Female"
                );
        Gender.setValue("gender");
         SelectCountry.getItems().addAll("Australia","Bhutan","Canada","Denmark","Egypt","France","Greece","Hungary","India","Japan","Kazakhstan","Lebanon","Malaysia","Newziland","Pakistan","USA"	
                );
        SelectCountry.setValue("Select Country");
     
    }    

   

    
    @FXML
    private void BackToApplicantDashboardButtonOnClick(ActionEvent event) throws IOException { 
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("ApplicantDashBoard.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
   
    }

    @FXML
    private void SubmitVisaApplicantInformationButtonOnClick(ActionEvent event) {
         File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("Applyforvisa.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            
            writeData = new DataOutputStream(wirteFile);
            
            writeData.writeUTF(FullName.getText());
            writeData.writeUTF(PermanentAddress.getText());
            writeData.writeUTF(AddressInBangladesh.getText());
                        writeData.writeUTF(PassportNo.getText());
                        writeData.writeUTF(PresentNationality.getText());
                        writeData.writeUTF(PlaceOfBirth.getText());
            writeData.writeUTF(DateOfBirth.getValue().toString());

            writeData.writeUTF(Gender.getValue().toString());
            writeData.writeUTF(SelectCountry.getValue().toString());
                        writeData.writeUTF(BankDetails.getText());
         
          
            
          
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
    private void CheckInformationButtonOnClick(ActionEvent event) {
        ApplicantInformation.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String showInformation="";
        try {
            f = new File("Applyforvisa.bin");
            if(!f.exists()){
                ApplicantInformation.setText("No new Post");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               showInformation =   
                        "yout FullName: "+readData.readUTF()+"\n"
                        +
                        "Your PermanentAddress: "+readData.readUTF()+"\n"
                       +
                        "Your AddressInBangladesh: "+readData.readUTF()+"\n"
                        +
                        "Your PassportNo: "+readData.readUTF()+"\n"
                       +
                        "Your PresentNationality: "+readData.readUTF()+"\n"
                       +
                        "Your PlaceOfBirth: "+readData.readUTF()+"\n"
                       +
                        "Your DateOfBirth: "+readData.readUTF()+"\n"
                       +
                                               "Your Gender: "+readData.readUTF()+"\n"
                       +
                                               "Your SelectCountry: "+readData.readUTF()+"\n"
                       +
                                               "Your BankDetails: "+readData.readUTF()+"\n"

                       
                     ;
                
                    ApplicantInformation.appendText(showInformation);
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

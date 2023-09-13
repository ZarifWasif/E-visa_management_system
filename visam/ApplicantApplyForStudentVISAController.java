
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
import javafx.stage.Stage;


public class ApplicantApplyForStudentVISAController implements Initializable {

    @FXML
    private TextField StudentFullName;
    @FXML
    private TextField SPermanentAddress;
    @FXML
    private TextField SAddressInBangladesh;
    @FXML
    private TextField StudentPassportNo;
    @FXML
    private TextField SPresentNationality;
    @FXML
    private TextField SPlaceOfBirth;
    @FXML
    private DatePicker SDateOfBirth;
    @FXML
    private ComboBox SGender;
    @FXML
    private ComboBox StudentSelectCountry;
    @FXML
    private TextField SBankDetails;
    @FXML
    private TextArea WriteAboutYourself;
    @FXML
    private TextArea StudentApplicantInformation;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         SGender.getItems().addAll("Male","Female"
                );
        SGender.setValue("gender");
         StudentSelectCountry.getItems().addAll("Australia","Bhutan","Canada","Denmark","Egypt","France","Greece","Hungary","India","Japan","Kazakhstan","Lebanon","Malaysia","Newziland","Pakistan","USA"	
                );
        StudentSelectCountry.setValue("Select Country");
    }    

   

    @FXML
    private void StudentBackToApplicantDashboardButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("ApplicantDashBoard.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void StudentSubmitVisaApplicantInformationButtonOnClick(ActionEvent event) {
         File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("ApplyForStudentVISa.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            
            writeData = new DataOutputStream(wirteFile);
            
            writeData.writeUTF(StudentFullName.getText());
            writeData.writeUTF(SPermanentAddress.getText());
            writeData.writeUTF(SAddressInBangladesh.getText());
            writeData.writeUTF(StudentPassportNo.getText());
            writeData.writeUTF(SPresentNationality.getText());
            writeData.writeUTF(SPlaceOfBirth.getText());
            writeData.writeUTF(SDateOfBirth.getValue().toString());
            writeData.writeUTF(SGender.getValue().toString());
            writeData.writeUTF(StudentSelectCountry.getValue().toString());
            writeData.writeUTF(SBankDetails.getText());
            writeData.writeUTF(WriteAboutYourself.getText());

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
    private void StudentCheckInformationButtonOnClick(ActionEvent event) {
        StudentApplicantInformation.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String showInformation="";
        try {
            f = new File("ApplyForStudentVISa.bin");
            if(!f.exists()){
                StudentApplicantInformation.setText("No new Post");
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
                       +
                        "Your WriteAboutYourself: "+readData.readUTF()+"\n" 
                     ;
                
                    StudentApplicantInformation.appendText(showInformation);
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

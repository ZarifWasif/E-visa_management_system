/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.visam;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class OperatorOfficerProcessVisaApplicationsController implements Initializable {

    static void setSelectedFile(File selectedFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private TextArea VisaApplicationInformation;
    @FXML
    private TextArea StudentVisaApplicationInformation;

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
    private void CheckVisaApplicationInformation(ActionEvent event) 
    {
             VisaApplicationInformation.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String showInformation="";
        try {
            f = new File("Applyforvisa.bin");
            if(!f.exists()){
                VisaApplicationInformation.setText("No new Post");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               showInformation =  
                        "Applicant FullName: "+readData.readUTF()+"\n"
                        +
                        "Applicant PermanentAddress: "+readData.readUTF()+"\n"
                       +
                        "Applicant AddressInBangladesh: "+readData.readUTF()+"\n"
                        +
                        "Applicant PassportNo: "+readData.readUTF()+"\n"
                       +
                        "Applicant PresentNationality: "+readData.readUTF()+"\n"
                       +
                        "Applicant PlaceOfBirth: "+readData.readUTF()+"\n"
                       +
                        "Applicant DateOfBirth: "+readData.readUTF()+"\n"
                       +
                                               "Applicant Gender: "+readData.readUTF()+"\n"
                       +
                                               "Applicant SelectCountry: "+readData.readUTF()+"\n"
                       +
                                               "Applicant BankDetails: "+readData.readUTF()+"\n"

                       
                     ;
                
                    VisaApplicationInformation.appendText(showInformation);
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

    @FXML
    private void CheckStudentVisaApplicationInformation(ActionEvent event) {
         StudentVisaApplicationInformation.setText("");
        File f = null;
        FileInputStream readFile = null;
        DataInputStream readData = null;
        String showInformation="";
        try {
            f = new File("ApplyForStudentVISa.bin");
            if(!f.exists()){
                StudentVisaApplicationInformation.setText("No new Post");
            }
            else{
                
                readFile = new FileInputStream(f);

                readData = new DataInputStream(readFile);
             
                while(true){
               
               showInformation =   
                        "Applicant FullName: "+readData.readUTF()+"\n"
                        +
                        "Applicant PermanentAddress: "+readData.readUTF()+"\n"
                       +
                        "Applicant AddressInBangladesh: "+readData.readUTF()+"\n"
                        +
                        "Applicant PassportNo: "+readData.readUTF()+"\n"
                       +
                        "Applicant PresentNationality: "+readData.readUTF()+"\n"
                       +
                        "Applicant PlaceOfBirth: "+readData.readUTF()+"\n"
                       +
                        "Applicant DateOfBirth: "+readData.readUTF()+"\n"
                       +
                                               "Applicant Gender: "+readData.readUTF()+"\n"
                       +
                                               "Applicant SelectCountry: "+readData.readUTF()+"\n"
                       +
                                               "Applicant BankDetails: "+readData.readUTF()+"\n"
                       +
                                               "Applicant WriteAboutYourself: "+readData.readUTF()+"\n"


                       
                     ;
                
                    StudentVisaApplicationInformation.appendText(showInformation);
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

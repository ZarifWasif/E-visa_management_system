/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.visam;

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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ApplicantDashBoardController implements Initializable {

    @FXML
    private BorderPane ApplicantBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
    }  
    private void loadOperatorOfficerMultiPages(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            ApplicantBorderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(OperatorOfficerDashboardPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void ApplyforVisaButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("ApplicantApplyForVisa.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void ApplyforeVisaButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("ApplicantApplyForStudentVISA.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void SubmitALLDocumentsButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("ApplicantSubmitDocuments.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void ContactwithsupportOfficerButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("ApplicantContactWithSupportOfficer.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void SeeVISAupdateButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("ApplicantSeeVisaUpdate.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void SuggestionBoxButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("ApplicantSuggestionBox.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void SeeVisaRelatedInformationButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("ApplicantSeeVisaRelatedInformation.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void CollectVisaButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("ApplicantCollectVisa.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    private void ClearViewOfApplicantButton(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("ApplicantDashBoard.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void ApplicantLogOutBttonClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    
}

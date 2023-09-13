
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

 
public class OperatorOfficerDashboardPageController implements Initializable {

    @FXML
    private BorderPane OperatorOfficerBorderPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    private void loadOperatorOfficerMultiPages(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            OperatorOfficerBorderPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(OperatorOfficerDashboardPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void ProcessVisaApplicationButtonOnClick(ActionEvent event) throws IOException {
Parent GoBackParent = FXMLLoader.load(getClass().getResource("OperatorOfficerProcessVisaApplications.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
        
    }
    @FXML
    private void VerifyDocumentsButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("OperatorOfficerVerifydocuments.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    @FXML
    private void ProvideCustomerServiceButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("OperatorOfficerProvideCustomerService.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    @FXML
    private void CommunicateWithOtherTeamMembersButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("OperatorOfficerCommunicateWithOtherTeamMembers.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    @FXML
    private void ChangesRegulationsandPoliciesButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("OperatorOfficerChangesRegulationsandPolicies.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

    @FXML
    private void SendReporttotheDirectorButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("OperatorOfficerSendReportToTheDirector.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    @FXML
    private void ReviewAndSendButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("OperatorOfficerSendSuggestionToSupervisor.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    @FXML
    private void AssistwithothertasksButtonOnClick(ActionEvent event) throws IOException {
        Parent GoBackParent = FXMLLoader.load(getClass().getResource("OperatorOfficerAssistWithOtherTasksFromManager.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    private void ClearViewOfOperatorOfficerButton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("OperatorOfficerDashboardPage.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }
    @FXML
    private void OperatorOfficerLogOutBttonClick(ActionEvent event) throws IOException {
Parent GoBackParent = FXMLLoader.load(getClass().getResource("LoginScene.fxml"));
            Scene s = new Scene(GoBackParent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();
    }

   
    
}

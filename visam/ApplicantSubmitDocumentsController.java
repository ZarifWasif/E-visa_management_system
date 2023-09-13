/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.visam;

import com.sun.deploy.net.HttpResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.net.www.http.HttpClient;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ApplicantSubmitDocumentsController implements Initializable {

    @FXML
    private TextArea WriteandSubmitApplicantDocument;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BackToApplicantDashBoardButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ApplicantDashBoard.fxml"));
            Scene s = new Scene(scene2Parent);
          
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(s);
            window.show();    
    }

    @FXML
    private void ChooseFileButtonOnClick(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    File selectedFile = fileChooser.showOpenDialog(null);

    if (selectedFile != null) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OperatorOfficerProcessVisaApplications.fxml"));
            Parent root = loader.load();
            OperatorOfficerProcessVisaApplicationsController otherSceneController = loader.getController();
            OperatorOfficerProcessVisaApplicationsController.setSelectedFile(selectedFile);

            Scene otherScene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(otherScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    @FXML
    private void SubmitButtonOnClick(ActionEvent event) {
         File f = null;
        FileOutputStream wirteFile = null;
        DataOutputStream writeData = null;
        
        try {
            f = new File("ApplicantSubmitDocuments.bin");
            if(f.exists()) wirteFile = new FileOutputStream(f,true);
            else wirteFile = new FileOutputStream(f);
            
            writeData = new DataOutputStream(wirteFile);
            
            writeData.writeUTF(WriteandSubmitApplicantDocument.getText());
           
            
          
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

}

    
    

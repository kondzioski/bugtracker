/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bugtracker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author kalk
 */
public class newReportController implements Initializable {

    @FXML
    TextField heading;
    
    @FXML
    Button createReport;
    
    @FXML
     TextField status;
    
    @FXML
    TextField date;
    
    @FXML
    TextField submitter;
    
    @FXML
    TextField number;
    
    @FXML
    TextArea description;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
//    private static newReportController instance;
    
//    public newReportController(){
//        instance = this;
//    }
    
//    public static newReportController getInstance(){
//        return instance;
//    }
//    
    @FXML
    public void addReport() throws NoSuchMethodException{
        
        Report report = new Report();    
        report.heading.setValue(heading.getText());
        report.number.setValue(number.getText());
        report.status.setValue(status.getText());
        report.date.setValue(date.getText());
        report.submitter.setValue(submitter.getText());
        report.description.setValue(description.getText());
        FXMLDocumentController.addReportToTable(report);

    }
}

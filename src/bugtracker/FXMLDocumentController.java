/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bugtracker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.w3c.dom.Element;

/**
 *
 * @author kalk
 */
public class FXMLDocumentController implements Initializable {
    
    
    

   @FXML
   TableView<Report> reportsTable; 
   
   @FXML
   TableColumn headingCol;
   
   @FXML
   TableColumn numberCol;
   
   @FXML
   TableColumn statusCol;
   
   @FXML
   TableColumn submitterCol;
   
   @FXML
   TableColumn DateCol;
   
   @FXML
   MenuBar menuBar;
   
   @FXML
   Menu applicationMenuItem;
   
   @FXML
   Menu reportsMenuItem;
   
   @FXML
   MenuItem reportsCreateNew;
   
   @FXML
   MenuItem reportsDeleteReport;
   
   @FXML
   MenuItem saveReportsToXML;
   
   
   Scene scene;
   
   private XMLManagerImpl xml;
   
   static ObservableList<Report> data;
   

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        headingCol.setCellValueFactory(
                new PropertyValueFactory<Report,String>("heading"));
        
        numberCol.setCellValueFactory(
                new PropertyValueFactory<Report,String>("number"));
        
        statusCol.setCellValueFactory(
                new PropertyValueFactory<Report,String>("status"));
        
        DateCol.setCellValueFactory(
                new PropertyValueFactory<Report,String>("date"));
        
        submitterCol.setCellValueFactory(
                new PropertyValueFactory<Report,String>("submitter"));
        
        System.out.println("javafx.runtime.version: " + System.getProperties().get("javafx.runtime.version"));
        
        data = FXCollections.observableArrayList();
        reportsTable.setItems(data);
    }
    
    @FXML
    public static void addReportToTable (Report report){    
        data.add(report);
    }
    
    @FXML
    public void saveReportsToXMLFile(){
        
        xml = new XMLManagerImpl();
        xml.initialize();
        Element reports = xml.addElement("Reports", null, null);
        
        ObservableList<Report> items = reportsTable.getItems();
        
        Integer i = 1;
        for(Report item: items){
            
            Element report = xml.addElement("Report", reports,null);
            xml.setAttribute("id", i.toString(), report);
            xml.addElement("Heading", report,item.getHeading());
            xml.addElement("Status", report,item.getStatus());
            xml.addElement("Submitter", report,item.getSubmitter());
            xml.addElement("Number", report,item.getNumber());
            xml.addElement("Date", report,item.getDate());
            xml.addElement("Description", report,item.getDescription());
            i++;
        }
        
        xml.writeContentXMLfile(xml.getPath());  
    }
    
 
    @FXML
    public void createReport() throws IOException{
        
        Stage helpWindowStage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("newReport.fxml"));
    	scene = new Scene(root);
		helpWindowStage.setScene(scene);
		helpWindowStage.show();
    }
    
    
}

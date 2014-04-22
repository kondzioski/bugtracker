package bugtracker;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Report {
    
    public SimpleStringProperty heading = new SimpleStringProperty();
    public SimpleStringProperty description = new SimpleStringProperty();
    public SimpleStringProperty submitter = new SimpleStringProperty();
    public SimpleStringProperty number = new SimpleStringProperty();
    public SimpleStringProperty status = new SimpleStringProperty();
    public SimpleStringProperty date = new SimpleStringProperty();
    
    public void setHeading(String head){
	heading.set(head);
    }
    
    public String getHeading(){
	return heading.get();
    }
    
    public StringProperty headingProperty(){
	return heading;
    }
    
        public void setDescription(String head){
	description.set(head);
    }
    
    public String getDescription(){
	return description.get();
    }
    
    public StringProperty descriptionProperty(){
	return description;
    }
    
    
    public void setSubmitter(String head){
	submitter.set(head);
    }
    
    public String getSubmitter(){
	return submitter.get();
    }
    
    public StringProperty submitterProperty(){
	return submitter;
    }
    
    public void setNumber(String head){
	number.set(head);
    }
    
    public String getNumber(){
	return number.get();
    }
    
    public StringProperty numberProperty(){
	return number;
    }
    
    public void setStatus(String head){
	status.set(head);
    }
    
    public String getStatus(){
	return status.get();
    }
    
    public StringProperty statusProperty(){
	return status;
    }
    
    public void setDate(String head){
	date.set(head);
    }
    
    public String getDate(){
	return date.get();
    }
    
    public StringProperty dateProperty(){
	return date;
    }
    
}

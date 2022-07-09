package reservationMain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class ResTableRowDataModel {
		private StringProperty reservationDate;
	    private StringProperty Contents;
	    private StringProperty name;
	 
	    public ResTableRowDataModel(StringProperty reservationDate, StringProperty Contents, StringProperty name) {
	    	this.reservationDate = reservationDate;
	    	this.Contents = Contents;
	        this.name = name;
	    }
	    
	    public StringProperty resDayProperty() {
	        return reservationDate;
	    }
	 
	    public StringProperty resContProperty() {
	        return Contents;
	    }
	    public StringProperty nameProperty() {
	        return name;
	    }
	}


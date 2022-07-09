package check;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class TableRowCheckDTO {
		private StringProperty cNum;
	    private StringProperty name;
	    private StringProperty count;
	    private StringProperty cost;
	 
	    public TableRowCheckDTO(StringProperty cNum, StringProperty name, StringProperty count, StringProperty cost) {
	    	this.cNum = cNum;
	    	this.name = name;
	        this.count = count;
	        this.cost = cost;
	    }
	    
	    public StringProperty cNumProperty() {
	        return cNum;
	    }
	 
	    public StringProperty nameProperty() {
	        return name;
	    }
	    public StringProperty countProperty() {
	        return count;
	    }
	    public StringProperty costProperty() {
	        return cost;
	    }
	}


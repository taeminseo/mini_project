package shop.component;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableRowDataModel {
		private IntegerProperty cNum;
	    private StringProperty name;
	    private StringProperty count;
	    private StringProperty cost;
	    private IntegerProperty Num;
	 
	    public TableRowDataModel(IntegerProperty cNum, StringProperty name, StringProperty count, StringProperty cost, IntegerProperty Num) {
	    	this.cNum = cNum;
	    	this.name = name;
	        this.count = count;
	        this.cost = cost;
	        this.Num = Num;
	    }
	    

		public IntegerProperty cNumProperty() {
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
	    public IntegerProperty NumProperty() {
	        return Num;
	    }
	}


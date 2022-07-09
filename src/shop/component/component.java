package shop.component;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class component {
		int cNum;
	    String name;
	    String count;
	    String cost;
	    int sNum;
	    
		public component(int cNum, String name, String count, String cost, int sNum) {
			super();
			this.cNum = cNum;
			this.name = name;
			this.count = count;
			this.cost = cost;
			this.sNum = sNum;
		}


		public int getCNum() {
			return cNum;
		}


		public void setCNum(int cNum) {
			this.cNum = cNum;
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}

		public String getCost() {
			return cost;
		}

		public void setCost(String cost) {
			this.cost = cost;
		}

		public int getSNum() {
			return sNum;
		}

		public void setSNum(int sNum) {
			this.sNum = sNum;
		}
		
		
	    
	    
	    
		
	  
	 
	   
	}

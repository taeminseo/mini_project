package shop.res;

import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class shopRes {
		int resNum;
		String reservationDate;
	    String contents;
	    String carNum;
	    
	    
	    
		public shopRes(int resNum, String reservationDate, String contents, String carNum) {
			super();
			this.resNum = resNum;
			this.reservationDate = reservationDate;
			this.contents = contents;
			this.carNum = carNum;
		}
		public int getResNum() {
			return resNum;
		}
		public void setResNum(int resNum) {
			this.resNum = resNum;
		}
		public String getReservationDate() {
			return reservationDate;
		}
		public void setReservationDate(String reservationDate) {
			this.reservationDate = reservationDate;
		}
		public String getContents() {
			return contents;
		}
		public void setContents(String contents) {
			this.contents = contents;
		}
		public String getCarNum() {
			return carNum;
		}
		public void setCarNum(String carNum) {
			this.carNum = carNum;
		}
		
		
	  
	 
	   
	}

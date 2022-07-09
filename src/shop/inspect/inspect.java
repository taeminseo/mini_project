package shop.inspect;

import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class inspect {
	int mNum;
	int resNum;
	String reservationDate;
	String contents;
	String sit;
	int cost;
	String note;
	int sNum;
	String carNum;
	
	public inspect(int mNum, int resNum, String reservationDate, String contents, String sit, int cost, String note,
			int sNum, String carNum) {
		super();
		this.mNum = mNum;
		this.resNum = resNum;
		this.reservationDate = reservationDate;
		this.contents = contents;
		this.sit = sit;
		this.cost = cost;
		this.note = note;
		this.sNum = sNum;
		this.carNum = carNum;
	}

	public int getmNum() {
		return mNum;
	}

	public void setmNum(int mNum) {
		this.mNum = mNum;
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

	public String getSit() {
		return sit;
	}

	public void setSit(String sit) {
		this.sit = sit;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	
	
	
	
	
	   
	}

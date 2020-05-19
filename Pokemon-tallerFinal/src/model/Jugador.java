package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Jugador implements Serializable {

	private String username;
	private String fecha;
	//tipo de dato 
	private Calendar date;
	private int px;
	private int py;
	
	
	public Jugador(String username) {
		this.username = username;
		this.fecha = fecha;
		this.px = px;
		this.py = py;
		date= new GregorianCalendar();
	
	}
		
		
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	// posiciones 

	public int getPx() {
		return px;
	}
	public void setPx(int px) {
		this.px = px;
	}
	public int getPy() {
		return py;
	}
	public void setPy(int py) {
		this.py = py;
	}
	// registro usurios 
	
	public String getUsername(){
		return this.username;
	}
	public String getfecha(){
		return this.fecha;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	public void setfecha(String fecha) {
		this.fecha= fecha;
	}

	}// cierra 

	



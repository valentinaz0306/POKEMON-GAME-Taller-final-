package model;

public class Jugador {

	private String username;
	private String fecha;
	private int px;
	private int py;
	
	
	public Jugador(String username) {
		this.username = username;
		this.fecha = fecha;
		this.px = px;
		this.py = py;
	
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

	



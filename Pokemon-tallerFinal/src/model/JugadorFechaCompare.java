package model;

import java.util.Comparator;

public class JugadorFechaCompare implements Comparator<Jugador> {

	public JugadorFechaCompare() {

	}
	@Override
	public int compare(Jugador o1, Jugador o2) {
		// TODO Auto-generated method stub
		return o1.getDate().compareTo(o2.getDate());
	}
	
	
	

}

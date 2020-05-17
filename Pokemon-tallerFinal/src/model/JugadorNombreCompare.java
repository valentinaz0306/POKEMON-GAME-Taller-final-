package model;

import java.util.Comparator;

public class JugadorNombreCompare implements Comparator<Jugador> {

	public JugadorNombreCompare() {

	}

	@Override
	public int compare(Jugador o1, Jugador o2) {
		// TODO Auto-generated method stub
		return o1.getUsername().compareTo(o2.getUsername());
	}

}

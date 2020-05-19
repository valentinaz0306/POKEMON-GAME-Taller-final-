package model;

import java.io.File;
import processing.core.PApplet;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Logica {
	
	PApplet app;
	public int fila=7;
	public int col=12;
	public int mapa [][];
	
	
 
	// arralist para registar usuarios
	private ArrayList<Jugador> users;
	
	public Logica() {

		loadUsers();

	}

	public void addUsuario(String name) {
		users.add(new Jugador(name));
		saveUsers();
	}

	public void ordenarNombre() {

		users.sort(new JugadorNombreCompare());
	}

	public void ordenarFecha() {

		users.sort(new JugadorFechaCompare());
	}

	public void probar() {

		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getUsername() + " Fecha:" + users.get(i).getDate().getTime());
		}
		System.out.println(users.size());
		// System.out.println("despues de ordenar");
		// ordenarNombre();

		/*
		 * for (int i = 0; i < users.size(); i++) {
		 * System.out.println(users.get(i).getUsername() + " Fecha:" +
		 * users.get(i).getDate().getTime()); }
		 */
	}

	public String[] guardarTxt() {

		String[] temp = new String[users.size()];
		for (int i = 0; i < users.size(); i++) {
			temp[i] = users.get(i).getUsername() + " Fecha:" + users.get(i).getDate().getTime();

		}
		return temp;

	}

	@SuppressWarnings("unchecked")
	public void loadUsers() {
		// guarda archivo serializado
		File f = new File("data/Usuarios.dat");
		// comprobar si el archivo existe
		if (!f.exists()) {
			users = new ArrayList<Jugador>();
		} else {
			try {
				ObjectInputStream io = new ObjectInputStream(new FileInputStream(f));
				users = (ArrayList<Jugador>) io.readObject();
				io.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void saveUsers() {

		try {

			ObjectOutputStream io = new ObjectOutputStream(new FileOutputStream(new File("data/Usuarios.dat")));
			io.writeObject(users);
			io.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	////
	public ArrayList<Jugador> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Jugador> users) {
		this.users = users;
	}
	
	
	public void mapmatriz() {
		
		mapa[4][1]=1;
		mapa[9][1]=1;
		mapa[4][2]=1;
		mapa[5][2]=1;
		mapa[6][2]=1;
		mapa[7][2]=1;
		mapa[8][2]=1;
		mapa[9][2]=1;
		mapa[10][2]=1;
		mapa[11][2]=1;
		mapa[12][2]=1;
		mapa[3][3]=1;
		mapa[4][3]=1;
		mapa[5][3]=1;
		mapa[6][3]=1;
		mapa[7][3]=1;
		mapa[8][3]=1;
		mapa[9][3]=1;
		mapa[3][4]=1;
		mapa[4][4]=1;
		mapa[5][4]=1;
		mapa[6][4]=1;
		mapa[7][4]=1;
		mapa[8][4]=1;
		mapa[9][4]=1;
		
		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < fila; j++) {
				int x = col*j;
				int y = fila*i;
				
				if(mapa[i][j]==1) {
					app.rect(x,y,col,fila);
					
				}
				
				
			}
	}
		

		

}
}

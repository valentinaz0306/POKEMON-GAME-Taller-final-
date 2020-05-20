package model;

import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Logica {

	PApplet app;
	public int fila = 7;
	public int col = 12;
	public int mapa[][] = {

			{ 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 1, 2, 2, 2, 2, 1, 1, 0, 0 }, { 0, 0, 1, 1, 2, 2, 2, 2, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1 },

	};

	private Personaje persona;

	// arralist para registar usuarios
	private ArrayList<Jugador> users;

	public Logica(PApplet app) {
		this.app = app;
		loadUsers();
		generarPokemon();
		// System.out.println(mapa.length+ " "+ mapa[0].length);

	}

	// Method Paint the Character in map screen
	public void drawUser(PImage j) {
		persona.draw(j);
	}

	// Method to move that Character in map screen
	public void movePersonaje(char e) {
		switch (e) {
		case 'k':
			persona.movedown();
			System.out.println("down");
			break;

		case 'i':
			persona.moveup();
			System.out.println("up");
			break;

		case 'l':
			persona.moveright();
			System.out.println("right");
			break;

		case 'j':
			persona.moveleft();
			System.out.println("left");
			break;

		default:
			break;
		}
	}

    //Method to create the OBJECT Personaje
	public void loadPersonaje() {

		persona = new Personaje(300, 50, app);
	};

	public void generarPokemon() {

		boolean continuar = true;
		Set<Par> generados = new HashSet<>();

		while (continuar) {
			int i = (int) (Math.random() * (4 - 2)) + 2;
			int j = (int) (Math.random() * (8 - 4)) + 4;
			Par p = new Par(i, j);
			if (!generados.contains(p)) {
				generados.add(p);
				mapa[i][j] = 3;
			}
			if (generados.size() == 3) {
				continuar = false;
			}
		}

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

		/*
		 * for(int i = 0; i<mapa.length;i++){ System.out.println(" "); for(int j=0;
		 * j<mapa[0].length; j++){ System.out.print(mapa[i][j]+" "); } }
		 */
		for (int i = 0; i < users.size(); i++) {
		System.out.println(users.get(i).getUsername() + " Fecha:" +
		 users.get(i).getDate().getTime());
		}
		System.out.println(users.size());
		System.out.println("despues de ordenar");
		ordenarNombre();

		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getUsername() + " Fecha:" + users.get(i).getDate().getTime());
		}

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

	public void character(PApplet app) {
		this.app = app;

	}
}

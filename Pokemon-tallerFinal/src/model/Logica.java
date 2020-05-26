package model;

import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;
import threads.ChronometerThread;
import threads.RandomPokemonThread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import exceptions.NameException;

public class Logica {
	public final static int SIZE_MATRIX = 100;
	PApplet app;

	private int pantalla = 0;
	public int fila = 7;
	public int col = 12;
	public int mapa[][] = {

			{ 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 1, 2, 2, 2, 2, 1, 1, 0, 0 }, { 0, 0, 1, 1, 2, 2, 2, 2, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1 },

	};

	private Personaje persona;
	private Pokemon torchi;
	private Pokemon Plant;
	private Pokemon Water;
	private Chronometer crono;
	private Pokedex poke;
	private RandomPokemonThread rPt;

	// arralist para registar usuarios
	private ArrayList<Jugador> users;

	public Logica(PApplet app) {
		poke = new Pokedex(app);
		this.app = app;
		loadUsers();
		generarPokemon();
		crono = new Chronometer();
		loadPersonaje();
		loadPokemon();
		// loadPokedex();
		// System.out.println(mapa.length+ " "+ mapa[0].length);

		// hilo mov pokemones

		rPt = new RandomPokemonThread(this);
		rPt.setDaemon(true);
		rPt.start();
		
	}

	// Method Paint the Character in map screen
	public void character() {
		getPersona().move();

	}

	public void Starttimer() {
		ChronometerThread cT = new ChronometerThread(crono);
		cT.setDaemon(true);
		cT.start();
		System.out.println("a contar");
	}

	public void changemovstate(char dir) {
		getPersona().setDirection(dir);
	}

	// Method to create the OBJECT Personaje
	public void loadPersonaje() {

		setPersona(new Personaje(300, 50, mapa, app));
	}

	// Mothod to create the OBJECT Pokemon
	public void loadPokemon() {
		setTorchi(new Pokemon(persona.getFight(), "Torchi", 5, 200, 0, false));
		setPlant(new Pokemon(persona.getFight(), "Plant", 5, 200, 0, false));
		setWater(new Pokemon(persona.getFight(), "Water", 5, 200, 0, false));

	}

	public String reporteUsuarios() {

		String r = "";

		for (int i = 0; i < users.size(); i++) {

			Jugador cu = users.get(i);
			r += "" + cu.getUsername() + "  " + cu.getDate().getTime() + "\n";
		}

		return r;
	}

	public void generarPokemon() {
		boolean[] numeros = new boolean[3];

		boolean continuar = true;
		Set<Par> generados = new HashSet<>();
		Set<Integer> generados2 = new HashSet<>();

		while (continuar) {
			int i = (int) (Math.random() * (4 - 2)) + 2;
			int j = (int) (Math.random() * (8 - 4)) + 4;
			Par p = new Par(i, j);
			if (!generados.contains(p)) {
				generados.add(p);
				boolean next = true;
				while (next) {
					int x = (int) app.random(3, 6);
					if (!generados2.contains(x)) {
						mapa[i][j] = x;
						generados2.add(x);
						next = false;
					}
				}

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

		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getUsername() + " Fecha:" + users.get(i).getDate().getTime());
		}
		// System.out.println(users.size());
		// System.out.println("despues de ordenar");
		// ordenarNombre();

		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getUsername() + " Fecha:" + users.get(i).getDate().getTime());
		}

		// mapaa
		/*
		 * for (int i = 0; i < mapa.length; i++) { System.out.println(); for (int j = 0;
		 * j < mapa[0].length; j++) { System.out.print(""+mapa[i][j]+""); } }
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

	public void ppp() {
		for (int s = 0; s < mapa.length; s++) {
			System.out.println("");
			for (int k = 0; k < mapa[0].length; k++) {
				System.out.print(mapa[s][k] + " ");
			}
		}
		System.out.println("");
	}

	public void setDefaultMatrix() {
		int[][] defaultMatrix = {

				{ 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 2, 2, 2, 2, 1, 1, 0, 0 }, { 0, 0, 1, 1, 2, 2, 2, 2, 1, 1, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1 },

		};

		this.mapa = defaultMatrix;
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

	public void guardarPkmnTxt() {
		poke.escribirTxt();
	}

	public void guardarPokemon(int x) {

		if (x == 3) {
			poke.anadirPokemon(torchi);
		} else if (x == 4) {
			poke.anadirPokemon(Water);
		} else {
			poke.anadirPokemon(Plant);
		}

		// savePokemon();
	}

	public void ordenarPokemon() {
		Collections.sort(poke.getPokemones());
	}

	public String obtenerReport() {
		return poke.reportePokemones();
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

	public Personaje getPersona() {
		return persona;
	}

	public void setPersona(Personaje persona) {
		this.persona = persona;
	}

	public Pokemon getTorchi() {
		return torchi;
	}

	public void setTorchi(Pokemon torchi) {
		this.torchi = torchi;
	}

	public int getPantalla() {
		return pantalla;
	}

	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}

	public Pokemon getPlant() {
		return Plant;
	}

	public void setPlant(Pokemon plant) {
		Plant = plant;
	}

	public Pokemon getWater() {
		return Water;
	}

	public void setWater(Pokemon water) {
		Water = water;
	}

	public Chronometer getCrono() {
		return crono;
	}

	public void setCrono(Chronometer crono) {
		this.crono = crono;
	}

}

package model;
import processing.core.PApplet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pokedex implements Serializable {

	private List<Pokemon> pokemones;
	private List<String> info; 
	private PApplet app;

	public Pokedex(PApplet app) {
		this.app = app;
		pokemones = new ArrayList<Pokemon>();
		loadTxt();
	}

	public String reportePokemones() {

		String r = "";

		for (int i = 0; i < pokemones.size(); i++) {

			Pokemon po = pokemones.get(i);
			r += "" + po.getNombre() + "\n";
		}

		return r;
	}

	public List<Pokemon> getPokemones() {
		return pokemones;
	}

	public void setPokemones(List<Pokemon> pokemones) {
		this.pokemones = pokemones;
	}

	public void añadirPokemon(Pokemon p) {
		
		if(p==null) {
			System.out.println("El pokemon que me llega es nulo");
		}

		pokemones.add(p);
	}

	public void escribirTxt() {
		app.saveStrings("data/Pokedex.txt", getMsg());
	}
	
	public void loadTxt() {
		info = new ArrayList<String>();
		String[] lines = app.loadStrings("data/Pokedex.txt");
		for (int i = 0; i < lines.length; i++) {
			if(lines.length>0) {
				info.add(lines[i]);
			}
		}
	
	}

	public String [] getMsg() {

		String[] p = new String[pokemones.size()+info.size()];
		for (int i = 0; i < pokemones.size(); i++) {
			String t = "Fuego";
			if (pokemones.get(i).getTipo() == 4)
				t = "Agua";
			else if (pokemones.get(i).getTipo() == 5) {
				t = "Planta";
			}
			p[i] = pokemones.get(i).getNombre() + " " + t;
			System.out.println(""+ pokemones.get(i).getNombre() + " " + t+"    pokemones");
		}
		
		if(info.size()!=0) {
			for (int i = 0; i <+info.size(); i++) {
				p[i] = info.get(i+pokemones.size()-1);
				System.out.println(""+info.get(i+pokemones.size()-1)+"        info");
			}
		}
		
		
		return p;
	}

}// cierra clase

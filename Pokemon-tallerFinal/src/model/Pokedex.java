package model;
import processing.core.PApplet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pokedex  {

	private List<Pokemon> pokemones;
	private List<String> info; 
	private PApplet app;

	public Pokedex(PApplet app) {
		this.app = app;
		loadPokemonesFromTxt();
		

	}

	private void loadPokemonesFromTxt() {
		// TODO Auto-generated method stub
		pokemones = new ArrayList<Pokemon>();
		String[] lines = app.loadStrings("data/Pokedex.txt");
		if(0<lines.length) {
			for (int i = 0; i < lines.length; i++) {
				
				String[] parts = lines[i].split(" ");
				
				int tipo = Integer.parseInt(parts[0]);
				String nombre = parts[1];
				int nivel  = Integer.parseInt(parts[2]);
				int vida  = Integer.parseInt(parts[3]);
				int exp = Integer.parseInt(parts[4]);
				boolean estado = Boolean.parseBoolean(parts[5]);
			
				Pokemon p = new Pokemon(tipo, nombre, nivel, vida, exp, estado);
				pokemones.add(p);
			}
			
		}
	}

	public String reportePokemones() {

		String r = "";

		for (int i = 0; i < pokemones.size(); i++) {

			Pokemon po = pokemones.get(i);
			String tipo = "Fuego";
	
			if(po.getTipo()==4){
				tipo = "Agua";
			}else if(po.getTipo()==5){
				tipo = "Planta";
			}
			r += "" + po.getNombre() +" "+ tipo+"\n";
		}

		return r;
	}

	public List<Pokemon> getPokemones() {
		return pokemones;
	}

	public void setPokemones(List<Pokemon> pokemones) {
		this.pokemones = pokemones;
	}

	public void anadirPokemon(Pokemon p) {
		
		if(p==null){
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx p es null");
		}
		pokemones.add(p);
		
	}

	public void escribirTxt() {
		app.saveStrings("data/Pokedex.txt", getArrayToPrint());
	}
	
	public String[] getArrayToPrint(){
		
		String[] lines = new String[pokemones.size()];
		
		for(int i=0; i<pokemones.size();i++){
			Pokemon po = pokemones.get(i);
			lines[i] = ""+po.getTipo()+" "+po.getNombre()+" "+po.getNivel()+" "+po.getVida()+" "+po.getExp()+" "+po.isEstado();
		}
		
		return lines;
	}
	
	/*
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
	*/

}
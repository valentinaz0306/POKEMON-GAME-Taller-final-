package model;

import java.io.Serializable;

public class Pokemon implements Comparable <Pokemon> {

	private int tipo;
	private String nombre;
	private int nivel;
	private int vida;
	private int exp;
	private boolean estado;

	public Pokemon(int tipo, String nombre,int nivel, int vida, int exp,boolean estado) {
		
		this.tipo=tipo;
		this.nombre=nombre;
		this.nivel=nivel;
		this.vida=vida;
		this.exp=exp;
		this.estado=estado;
		
	}
	
	////
	

	/// gets and sets
	
	public int getTipo() {
		return tipo;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	// metodo comparar pokemones
	@Override
	public int compareTo(Pokemon o) {
		// TODO Auto-generated method stub
		return nombre.compareTo(o.getNombre());
	}

	/// 
	
	
	
}//cierra clase






package model;

public class Pokemon {

	private String tipo;
	private String nombre;
	private int nivel;
	private int vida;
	private int exp;
	private boolean estado;

	public Pokemon(String tipo, String nombre,int nivel, int vida, int exp,boolean estado) {
		
		this.tipo=tipo;
		this.nombre=nombre;
		this.nivel=nivel;
		this.vida=vida;
		this.exp=exp;
		this.estado=estado;
	}
	
	////
	
	
	
	/// gets and sets
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	/// 
	
	
	
}//cierra clase






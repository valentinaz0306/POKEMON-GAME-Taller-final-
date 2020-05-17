package view;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
import controlP5.*;
import model.Jugador;

import java.util.ArrayList;

public class Main extends PApplet {

	private ControlP5 cp5;

	// arralist para registar usuarios
	private ArrayList<Jugador> Users = new ArrayList<Jugador>();

	////
	String info = "";
	Textfield username, password;
	Textfield usernameR, emailR, passwordR, cPasswordR;

	// Image variables
	PImage start;
	PImage logo;

	// Int variables

	int pantalla;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
	}

	public void settings() {

		size(1200, 700);
	}

	public void setup() {
		// Load images
		start = loadImage("image/start.png");
		logo = loadImage("image/logo.png");

		// Load int variables
		pantalla = 0;

		/// usuarios

		// SE AÑADE UN NUEVO USUARIO AL ARRAYLIST
		Users.add(new Jugador("test"));
		PFont font = createFont("PT Sans", 20);
		cp5 = new ControlP5(this);

		// campo de texto para usuario
		username = cp5.addTextfield("Nombre")
				.setPosition(115, 343)
				.setSize(180, 38)
				.setFont(font)
				.setColor(color(255, 255, 255))
				.setColorBackground(0)
				.setColorActive(0).setColorLabel(0)
				.setColorCaptionLabel(0)
				.setColorForeground(0);

	}

	public void draw() {

		switch (pantalla) {

		case 0:
			background(0);
			image(start, 0, 0);
			image(logo, 0, 0);
			break;

		case 1:
			background(0);
			image(start, 0, 0);
			username.hide();


			break;

		}// cierre switch

	}
	
	public void mousePressed() {
		
		pantalla ++;

	}

}// cierra main

package view;

import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;
import processing.core.PFont;
import controlP5.*;
import exceptions.NameException;
import model.Jugador;
import model.Logica;
import model.Pokemon;
import model.Personaje;

import java.util.ArrayList;

public class Main extends PApplet {

	private ControlP5 cp5;
	private Logica logica;
	private Pokemon pokemon;
	// mensaje para excepción
	private static boolean mensaje;

	////
	String info = "";
	Textfield username, password;
	Textfield usernameR, emailR, passwordR, cPasswordR;
	
	
	//Sound variables
	SoundFile mapmusic;
	
	

	// Image variables
	PImage start;
	PImage logo;
	PImage map;
	PImage mapshadows;
	PImage mapobject;
	PImage bg1;
	PImage dim;
	PImage arrow;
	PImage box;
	PImage dialoguebox;
	PImage fightmenu;
	PImage fightbox;
	PImage pokeballs;
	PImage pokeselec;
	PImage tuto;
	PImage ch;
	PImage p1;
	PImage wpoke;
	PImage gpoke;
	PImage fpoke;

	int chnum = 4; // number of images
	PImage[] chdown = new PImage[chnum]; // ? just copied someone else's on a forum don't really get this line
	PImage[] chup = new PImage[chnum];
	PImage[] chur = new PImage[chnum];
	PImage[] chul = new PImage[chnum];
	
	// Int variables

	int pantalla;
	int T;
	int pv;

	// boolean
	boolean fpk;
	boolean gpk;
	boolean wpk;

	boolean up;
	boolean down;
	boolean right;
	boolean left;
	boolean still;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");

		probarExcepciones();
	}

	public void settings() {

		size(1200, 700);
	}

	public void setup() {

		logica = new Logica(this);
		pokemon = new Pokemon(info, info, T, T, T, fpk);
		// exception
		mensaje = false;
		
		
		//Load sound 
		mapmusic = new SoundFile(this,"music/map.mp3");
		mapmusic.play();
		if(mapmusic.isPlaying()) {
			mapmusic.play();
		}
		

		// Load images
		start = loadImage("image/start.png");
		logo = loadImage("image/logo.png");
		map = loadImage("image/map.png");
		mapshadows = loadImage("image/mapshadows.png");
		mapobject = loadImage("image/mapobject.png");
		dim = loadImage("image/dim.png");
		bg1 = loadImage("image/bg1.png");
		arrow = loadImage("image/arrow.png");
		box = loadImage("image/box.png");
		dialoguebox = loadImage("image/dialoguebox.png");
		fightmenu = loadImage("image/fightmenu.png");
		fightbox = loadImage("image/fightbox.png");
		pokeballs = loadImage("image/pokeballs.png");
		pokeselec = loadImage("image/pokeselec.png");
		tuto = loadImage("image/tuto.png");
		ch = loadImage("image/sprite/chd.png");
		p1 = loadImage("image/p1.png");
		fpoke = loadImage("image/fpoke.png");
		gpoke = loadImage("image/gpoke.png");
		wpoke = loadImage("image/wpoke.png");

		for (int i = 0; i < 3; i++) {
			chdown[i] = loadImage("image/sprite/chdown" + i + ".png");
		}
		for (int i = 0; i < 3; i++) {
			chup[i] = loadImage("image/sprite/chup" + i + ".png");
		}
		for (int i = 0; i < 3; i++) {
			chur[i] = loadImage("image/sprite/chright" + i + ".png");
		}
		for (int i = 0; i < 3; i++) {
			chul[i] = loadImage("image/sprite/chleft" + i + ".png");
		}

		// Load int variables
		pantalla = 0;
		pv = 0;

		// load boolean variables
		fpk = false;
		gpk = false;
		wpk = false;

		up = false;
		down = false;
		right = false;
		left = false;
		still=true;

		/// usuarios

		// SE AÑADE UN NUEVO USUARIO AL ARRAYLIST
		PFont font = createFont("PT Sans", 20);
		cp5 = new ControlP5(this);

		// campo de texto para usuario
		username = cp5.addTextfield("Nombre").setPosition(481, 287).setSize(180, 38).setFont(font)
				.setColor(color(255, 255, 255)).setColorBackground(0).setColorActive(0).setColorLabel(0)
				.setColorCaptionLabel(0).setColorForeground(0);

		logica.loadPersonaje();

	}

	public void draw() {

		switch (pantalla) {

		case 0:

			image(start, 0, 0);
			image(logo, 0, 0);
			username.hide();
			textSize(25);
			text("Press Enter to continue", 125, 470);

			break;

		case 1:

			image(start, 0, 0);
			image(dim, 0, 0);
			username.show();
			textSize(50);
			text("Set a nickname", 400, 150);
			textSize(25);
			text("Press Enter to continue", 440, 650);

			break;

		case 2:

			image(start, 0, 0);
			image(dim, 0, 0);
			username.hide();
			image(tuto, 0, 0);

			// condicional mensaje excepcion

			if (mensaje) {
				fill(255);
				text("Excedió el límite de caracteres", 400, 400);
			}

			/*
			 * textSize(50); text("Set a nickname", 400, 150); textSize(25);
			 * text("Press Enter to continue", 440, 650);
			 */
			break;

		case 3:

			image(bg1, 0, 0);
			image(dim, 0, 0);
			username.hide();
			if (wpk == false && gpk == false && fpk == false) {
				image(p1, 0, 0);
			}
			image(dialoguebox, 0, 50);
			image(box, 0, 0);
			hoverpokechoose();
			image(pokeballs, 0, 0);

			break;

		case 4:
			image(map, 0, 0);
			logica.character();
			PImage img = chdown[pv];
			PImage img1 = chup[pv];
			PImage img2 = chur[pv];
			PImage img3 = chul[pv];
			
			
			
			if (still == true) {
				image(ch, logica.getPersona().PosX, logica.getPersona().PosY, 50, 50);
			}
			
			if (up == true) {
				image(img1, logica.getPersona().PosX, logica.getPersona().PosY, 50, 50);
			}
			if (down == true) {
				image(img, logica.getPersona().PosX, logica.getPersona().PosY, 50, 50);
			}
			if (right == true) {
				image(img2, logica.getPersona().PosX, logica.getPersona().PosY, 50, 50);
			}
			if (left == true) {
				image(img3, logica.getPersona().PosX, logica.getPersona().PosY, 50, 50);
			}
			if (frameCount % 17 == 0) {
				pv++;
				if (pv == 3) {
					pv = 0;
				}
			}
			image(mapshadows, 0, 0);
			image(mapobject, 0, 0);
			username.hide();

			;

			break;

		}// cierre switch

		fill(255);
		text("X:" + mouseX + "Y:" + mouseY, mouseX, mouseY);

	}

	public void mousePressed() {
		if ((mouseX > 565 && mouseX < 648) && (mouseY > 237 && mouseY < 307)) {
			fpk = !fpk;
			gpk = false;
			wpk = false;
		}

		if ((mouseX > 720 && mouseX < 813) && (mouseY > 239 && mouseY < 293)) {
			gpk = !gpk;
			fpk = false;
			wpk = false;

		}

		if ((mouseX > 878 && mouseX < 965) && (mouseY > 235 && mouseY < 300)) {
			wpk = !wpk;
			gpk = false;
			fpk = false;

		}

	}

	public void keyPressed() {
		if (key == ENTER) {

			if (pantalla == 1) {

				logica.addUsuario(username.getText());

			}
			pantalla++;
		}

		if (key == 'a') {

			saveStrings("data/reporte.txt", logica.guardarTxt());
		}
		// con s aparecen los usuarios que se han registrado
		if (key == 's') {

			logica.probar();
		}
		// con d se ordena por fecha
		if (key == 'd') {

			logica.ordenarFecha();
		}
		// con f se ordena por nombre
		if (key == 'f') {

			logica.ordenarNombre();
		}
		// cada vez que se quiera guardar de forma serializada el usuario debe undir g
		if (key == 'g') {

			logica.saveUsers();

		}

		if (key == 'p') {

			logica.generarPokemon();

		}

		if (key == 'i') {
			logica.changemovstate(Personaje.UP);
			up = true;
			left = false;
			right = false;
			down = false;
			still=false;
		}
		if (key == 'j') {
			logica.changemovstate(Personaje.LEFT);
			up = false;
			left = true;
			right = false;
			down = false;
			still=false;
		}
		if (key == 'k') {
			logica.changemovstate(Personaje.DOWN);
			up = false;
			left = false;
			right = false;
			down = true;
			still=false;
		}
		if (key == 'l') {
			logica.changemovstate(Personaje.RIGHT);
			up = false;
			left = false;
			right = true;
			down = false;
			still=false;
		}

	}
	// cierra key

	public void keyReleased() {
		if (key == 'i') {
			logica.changemovstate(Personaje.STILL);
			up = false;
			left = false;
			right = false;
			down = false;
			still=true;
		}
		if (key == 'j') {
			logica.changemovstate(Personaje.STILL);
			up = false;
			left = false;
			right = false;
			down = false;
			still=true;
		}
		if (key == 'k') {
			logica.changemovstate(Personaje.STILL);
			up = false;
			left = false;
			right = false;
			down = false;
			still=true;
		}
		if (key == 'l') {
			logica.changemovstate(Personaje.STILL);
			up = false;
			left = false;
			right = false;
			down = false;
			still=true;
		}

	}

	public void keyCode() {

	}

	public void hoverpokechoose() {

		if ((mouseX > 565 && mouseX < 648) && (mouseY > 237 && mouseY < 307)) {
			image(pokeselec, 0, 0);
		}

		if ((mouseX > 720 && mouseX < 813) && (mouseY > 239 && mouseY < 293)) {
			image(pokeselec, 160, 0);
		}

		if ((mouseX > 878 && mouseX < 965) && (mouseY > 235 && mouseY < 300)) {
			image(pokeselec, 310, 0);
		}

		if (fpk == true) {
			image(fpoke, 0, 0);
		}

		if (gpk == true) {
			image(gpoke, 0, 0);
		}

		if (wpk == true) {
			image(wpoke, 0, 0);
		}

	}// cierra key

	public static void probarExcepciones() {
		// lanzar excepcion

		try {
			throw new NameException();

		} catch (NameException e) {

			System.out.println("Excedió el límite de caracteres");
			// JOptionPane.showMessageDialog(null, "Hello World");
			mensaje = true;
		}

	}

}// cierra main

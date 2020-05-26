package view;

import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;
import processing.core.PFont;
import controlP5.*;
import exceptions.LifeException;
import exceptions.NameException;
import model.Jugador;
import model.Logica;
import model.Pokemon;
import model.Personaje;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main extends PApplet {

	private ControlP5 cp5;
	private Logica logica;
	private Pokemon pokemon;
	// mensaje para excepeciÃ³n
	private static boolean mensaje;

	private String reporte;
	private String reportePoke;
	////

	Textfield username, password;
	Textfield usernameR, emailR, passwordR, cPasswordR;

	// Sound variables
	// SoundFile mapmusic;
	// SoundFile fightmusic;
	// SoundFile homemusic;

	// Image variables
	PImage start;
	PImage logo;
	PImage map;
	PImage mapshadows;
	PImage mapobject;
	PImage bg1;
	PImage dim;
	PImage dimwhite;
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
	PImage wpokeme;
	PImage gpokeme;
	PImage fpokeme;
	PImage wpokefight;
	PImage gpokefight;
	PImage fpokefight;
	PImage fboton1;
	PImage fboton2;
	PImage fboton3;
	PImage botons;
	PImage doc;
	PImage enemy;
	PImage intro;

	int chnum = 4; // number of images
	PImage[] chdown = new PImage[chnum]; // ? just copied someone else's on a forum don't really get this line
	PImage[] chup = new PImage[chnum];
	PImage[] chur = new PImage[chnum];
	PImage[] chul = new PImage[chnum];

	// Int variables

	int pantalla;
	int btnfight;
	int T;
	int pv;
	int vidaT;
	int vidaP;
	int vidaW;

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

		// pokemon = new Pokemon(info, info, T, T, T, fpk);
		// exception
		mensaje = false;

		// Load sound
		/*
		 * mapmusic = new SoundFile(this, "music/map.mp3"); fightmusic = new
		 * SoundFile(this, "music/fight.mp3"); homemusic = new SoundFile(this,
		 * "music/home.mp3"); mapmusic.amp((float) 0.1); mapmusic.play();
		 * mapmusic.loop();
		 */

		// Load images
		start = loadImage("image/start.png");
		logo = loadImage("image/logo.png");
		map = loadImage("image/map.png");
		mapshadows = loadImage("image/mapshadows.png");
		mapobject = loadImage("image/mapobject.png");
		dim = loadImage("image/dim.png");
		dimwhite = loadImage("image/dimwhite.png");
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
		fpokeme = loadImage("image/fpokeme.png");
		gpokeme = loadImage("image/gpokeme.png");
		wpokeme = loadImage("image/wpokeme.png");
		fpokefight = loadImage("image/fpokefight.png");
		gpokefight = loadImage("image/gpokefight.png");
		wpokefight = loadImage("image/wpokefight.png");
		fboton1 = loadImage("image/fboton1.png");
		fboton2 = loadImage("image/fboton2.png");
		fboton3 = loadImage("image/fboton3.png");
		botons = loadImage("image/botons.png");
		enemy = loadImage("image/enemy.png");
		doc = loadImage("image/doc.png");
		intro = loadImage("image/intro.png");

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
		btnfight = 0;
		pv = 0;
		vidaT = logica.getTorchi().getVida();
		vidaP = logica.getPlant().getVida();
		vidaW = logica.getWater().getVida();

		// load boolean variables
		fpk = false;
		gpk = false;
		wpk = false;

		up = false;
		down = false;
		right = false;
		left = false;
		still = true;

		/// usuarios

		// SE AÃ‘ADE UN NUEVO USUARIO AL ARRAYLIST
		PFont font = createFont("PT Sans", 20);
		cp5 = new ControlP5(this);

		// campo de texto para usuario
		username = cp5.addTextfield("Nombre").setPosition(481, 287).setSize(180, 38).setFont(font)
				.setColor(color(255, 255, 255)).setColorBackground(0).setColorActive(0).setColorLabel(0)
				.setColorCaptionLabel(0).setColorForeground(0);

	}

	boolean firsttime = false;

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

			// condicional excepcion

			if (mensaje) {
				fill(255);
				text("ExcediÃ³ el lÃ­mite de caracteres", 400, 400);
			}

			/*
			 * textSize(50); text("Set a nickname", 400, 150); textSize(25);
			 * text("Press Enter to continue", 440, 650);
			 */
			break;

		case 3:
			image(bg1, 0, 0);
			image(dim, 0, 0);
			image(intro, 0, 0);
			image(botons, 400, 0);
			String s = "Welcome to MEMORI, in this island we have a huge number of species, but most of them are unknow, can you hep us searching for this pokemons?";
			text(s, 553, 162, 430, 200);
			text("NO", 592, 555);
			text("YES", 833, 555);

			break;

		case 4:

			image(bg1, 0, 0);
			image(dim, 0, 0);

			username.hide();
			if (wpk == false && gpk == false && fpk == false) {
				image(doc, 0, 50);
			}
			image(dialoguebox, 0, 50);
			image(box, 0, 0);
			hoverpokechoose();
			image(pokeballs, 0, 0);
			text("Doc", 870, 530);
			String m = "Choose your Pokemon, your little buddy will help you in this adventure";
			text(m, 151, 595);

			break;

		case 5:
			image(map, 0, 0);
			logica.character();
			// System.out.println(logica.getPersona().getFight());
			if (logica.getPersona().getFight() >= 3) {
				// System.out.println("cambioooooooo scren");
				logica.guardarPokemon(logica.getPersona().getFight());
				pantalla = 6;

			}
			paintcharacter();
			image(mapshadows, 0, 0);
			image(mapobject, 0, 0);
			username.hide();
			// fightmusic.stop();
			;

			break;

		case 6:
			/*
			 * if (!firsttime) { homemusic.stop(); fightmusic.amp((float) 0.05);
			 * fightmusic.play(); fightmusic.loop(); firsttime = true; }
			 */

			image(map, 0, 0);
			image(mapshadows, 0, 0);
			image(mapobject, 0, 0);
			image(dimwhite, 0, 0);
			image(fightbox, 0, 0);

			// Character Torchi
			if (fpk == true) {
				image(fpokeme, 0, 0);
				fill(0);
				textSize(25);
				text("You", 1055, 389);
				text("Your pokemon", 785, 435);
				fill(0, 255, 0);
				noStroke();
				rect(781, 448, vidaT, 20, 20);
				fill(0);
				textSize(20);
				text("lvl" + logica.getTorchi().getNivel(), 1085, 468);
			}

			// Character Plant
			if (gpk == true) {
				image(gpokeme, 0, 0);
				fill(0);
				textSize(25);
				text("You", 1055, 389);
				text("Your pokemon", 785, 435);
				fill(0, 255, 0);
				noStroke();
				rect(781, 448, vidaP, 20, 20);
				fill(0);
				textSize(20);
				text("lvl" + logica.getPlant().getNivel(), 1085, 468);
			}

			// Character Water
			if (wpk == true) {
				image(wpokeme, 0, 0);
				fill(0);
				textSize(25);
				text("You", 1055, 389);
				text("Your pokemon", 785, 435);
				fill(0, 255, 0);
				noStroke();
				rect(781, 448, vidaW, 20, 20);
				fill(0);
				textSize(20);
				text("lvl" + logica.getWater().getNivel(), 1085, 468);
			}

			// Enemy Torchi
			if (logica.getPersona().getFight() == 3) {
				fill(0);
				textSize(25);
				text("Enemy", 74, 75);
				image(fpokefight, 0, 0);
				text(logica.getTorchi().getNombre(), 82, 122);
				if (vidaT > 50) {
					fill(0, 255, 0);
					noStroke();
					rect(80, 130, vidaT, 20, 20);
				} else {
					fill(255, 0, 0);
					noStroke();
					rect(80, 130, vidaT, 20, 20);
				}
				fill(0);
				textSize(20);
				text("lvl" + logica.getTorchi().getNivel(), 355, 143);
			}

			// Enemy Water
			if (logica.getPersona().getFight() == 4) {
				fill(0);
				textSize(25);
				text("Enemy", 74, 75);
				image(wpokefight, 0, 0);
				text(logica.getWater().getNombre(), 82, 122);
				if (vidaW > 50) {
					fill(0, 255, 0);
					noStroke();
					rect(80, 130, vidaW, 20, 20);
				} else {
					fill(255, 0, 0);
					noStroke();
					rect(80, 130, vidaW, 20, 20);
				}
				fill(0);
				textSize(20);
				text("lvl" + logica.getWater().getNivel(), 355, 143);
			}

			// Enemy Plant
			if (logica.getPersona().getFight() == 5) {
				fill(0);
				textSize(25);
				text("Enemy", 74, 75);
				image(gpokefight, 0, 0);
				text(logica.getPlant().getNombre(), 82, 122);
				if (vidaP > 50) {
					fill(0, 255, 0);
					noStroke();
					rect(80, 130, vidaP, 20, 20);
				} else {
					fill(255, 0, 0);
					noStroke();
					rect(80, 130, vidaP, 20, 20);
				}
				fill(0);
				textSize(20);
				text("lvl" + logica.getPlant().getNivel(), 355, 143);
			}

			// Fight menu
			image(fightmenu, 0, 0);
			switch (btnfight) {
			case 0:
				textSize(30);
				image(fboton1, 0, 0);
				image(fboton2, 0, 0);
				image(fboton3, 0, 0);
				text("Fight", 775, 578);
				text("Pokeball", 950, 578);
				text("Run", 775, 630);

				break;

			case 1:
				image(fboton1, 0, 0);
				image(fboton2, 0, 0);
				text("Punch", 775, 578);
				text("Super-Kick", 950, 578);
				image(fboton3, 0, 0);
				text("back", 775, 630);
				break;
			}

			textSize(20);
			text("What is your next move?", 103, 556, 598, 647);

			break;

		// pantalla de ordenar nombre usuario
		case 7:

			background(0);
			fill(255);
			textSize(25);
			text("para ordenar por nombre presionar la letra n", 100, 100);
			text(reporte, 100, 150);

			break;

		// pantalla de ordenar pokemones pokedex
		case 8:

			background(0);
			fill(255);
			textSize(25);
			text(reportePoke, 100, 150);

			break;

		}// cierre switch

		String t = logica.getCrono().getTime();
		fill(0);
		text(t, 1104, 30);

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
		if (pantalla == 3) {

			if ((mouseX > 555 && mouseX < 693) && (mouseY > 526 && mouseY < 567)) {
				exit();
			}

			if ((mouseX > 802 && mouseX < 928) && (mouseY > 528 && mouseY < 567)) {
				pantalla = 4;
			}

		}

		if (pantalla == 6) {

			if (btnfight == 0) {
				if ((mouseX > 754 && mouseX < 884) && (mouseY > 550 && mouseY < 583)) {
					btnfight = 1;
				}
				if ((mouseX > 945 && mouseX < 1080) && (mouseY > 553 && mouseY < 584)) {
					if(vidaT<55|vidaP<55|vidaW<55){
					logica.guardarPkmnTxt();
				} else {
					try {
						throw new LifeException();

					} catch (LifeException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						JOptionPane.showMessageDialog(null, e.getMessage());
					}

				}}
				
				if ((mouseX > 758 && mouseX < 876) && (mouseY > 608 && mouseY < 641)) {
					logica.loadPersonaje();
					vidaT = logica.getTorchi().getVida();
					vidaP = logica.getPlant().getVida();
					vidaW = logica.getWater().getVida();
					btnfight = 0;
					pantalla = 5;
				}

			}

			if (btnfight == 1) {
				if ((mouseX > 754 && mouseX < 884) && (mouseY > 550 && mouseY < 583)) {

					if (logica.getPersona().getFight() == 3 && vidaT >= 20) {
						vidaT -= 10;
					}

					if (logica.getPersona().getFight() == 4 && vidaW >= 20) {
						vidaW -= 10;
					}
					if (logica.getPersona().getFight() == 5 && vidaP >= 20) {
						vidaP -= 10;
					}
				}

				if ((mouseX > 758 && mouseX < 876) && (mouseY > 608 && mouseY < 641)) {
					btnfight = 0;
				}
				if ((mouseX > 945 && mouseX < 1080) && (mouseY > 553 && mouseY < 584)) {
					if (logica.getPersona().getFight() == 3 && vidaT >= 20) {
						vidaT -= 50;
					}

					if (logica.getPersona().getFight() == 4 && vidaW >= 20) {
						vidaW -= 50;
					}

					if (logica.getPersona().getFight() == 5 && vidaP >= 20) {
						vidaP -= 50;
					}
				}

			}

		}

	}

	public void keyPressed() {
		if (key == ENTER) {

			if (pantalla == 1) {

				String name = username.getText();

				if (name.length() <= 12 && name.length() >= 3 && name != null) {
					logica.addUsuario(username.getText());
					logica.Starttimer();
					pantalla++;
				} else {
					try {
						throw new NameException();
					} catch (NameException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}

			} else {
				pantalla++;
			}
			/*
			 * if (pantalla == 4) { mapmusic.stop(); homemusic.amp((float) 0.05);
			 * homemusic.play();
			 * 
			 * }
			 */

		}

		if (key == 'a') {

			saveStrings("data/reporte.txt", logica.guardarTxt());
		}
		// con s aparecen los usuarios que se han registrado
		if (key == 's') {

			logica.probar();
		}
		// con d se ordena por fecha
		if (key == 'f') {

			logica.ordenarFecha();
		}
		// con f se ordena por nombre
		if (key == 'n') {

			logica.ordenarNombre();
		}
		// cada vez que se quiera guardar de forma serializada el usuario debe undir g
		if (key == 'g') {

			logica.saveUsers();

		}

		if (key == 'p') {

			logica.generarPokemon();

		}

		if (key == 'h') {

			pantalla = 7;
			reporte = logica.reporteUsuarios();

		}

		if (key == 'o') {

			logica.ordenarPokemon();
			reportePoke = logica.obtenerReport();
			pantalla = 8;

		}

		if (key == 'i') {
			logica.changemovstate(Personaje.UP);
			up = true;
			left = false;
			right = false;
			down = false;
			still = false;
		}
		if (key == 'j') {
			logica.changemovstate(Personaje.LEFT);
			up = false;
			left = true;
			right = false;
			down = false;
			still = false;
		}
		if (key == 'k') {
			logica.changemovstate(Personaje.DOWN);
			up = false;
			left = false;
			right = false;
			down = true;
			still = false;
		}
		if (key == 'l') {
			logica.changemovstate(Personaje.RIGHT);
			up = false;
			left = false;
			right = true;
			down = false;
			still = false;
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
			still = true;
		}
		if (key == 'j') {
			logica.changemovstate(Personaje.STILL);
			up = false;
			left = false;
			right = false;
			down = false;
			still = true;
		}
		if (key == 'k') {
			logica.changemovstate(Personaje.STILL);
			up = false;
			left = false;
			right = false;
			down = false;
			still = true;
		}
		if (key == 'l') {
			logica.changemovstate(Personaje.STILL);
			up = false;
			left = false;
			right = false;
			down = false;
			still = true;
		}

	}

	public void hoverpokechoose() {

		/*
		 * if ((mouseX > 565 && mouseX < 648) && (mouseY > 237 && mouseY < 307)) {
		 * 
		 * }
		 * 
		 * if ((mouseX > 720 && mouseX < 813) && (mouseY > 239 && mouseY < 293)) {
		 * 
		 * }
		 * 
		 * if ((mouseX > 878 && mouseX < 965) && (mouseY > 235 && mouseY < 300)) {
		 * 
		 * }
		 */
		if (fpk == true) {
			image(fpoke, 0, 0);
			image(pokeselec, 0, 0);
		}

		if (gpk == true) {
			image(gpoke, 0, 0);
			image(pokeselec, 160, 0);
		}

		if (wpk == true) {
			image(wpoke, 0, 0);
			image(pokeselec, 310, 0);
		}

	}// cierra key

	public static void probarExcepciones() {
		// lanzar excepcion

		try {
			throw new NameException();

		} catch (NameException e) {

			System.out.println("Excedio el li­mite de caracteres");
			// JOptionPane.showMessageDialog(null, "Hello World");
			mensaje = true;
		}

	}

	public void paintcharacter() {
		PImage img = chdown[pv];
		PImage img1 = chup[pv];
		PImage img2 = chur[pv];
		PImage img3 = chul[pv];
		if (still == true) {
			image(ch, logica.getPersona().PosX, logica.getPersona().PosY, 70, 70);
		}

		if (up == true) {
			image(img1, logica.getPersona().PosX, logica.getPersona().PosY, 70, 70);
		}
		if (down == true) {
			image(img, logica.getPersona().PosX, logica.getPersona().PosY, 70, 70);
		}
		if (right == true) {
			image(img2, logica.getPersona().PosX, logica.getPersona().PosY, 70, 70);
		}
		if (left == true) {
			image(img3, logica.getPersona().PosX, logica.getPersona().PosY, 70, 70);
		}
		if (frameCount % 17 == 0) {
			pv++;
			if (pv == 3) {
				pv = 0;
			}
		}
	}
}// cierra main

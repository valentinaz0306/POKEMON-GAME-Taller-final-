package view;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
	
	
	//Image variables
	PImage start;
	PImage logo;
	
	
	//Int variables
	
	int pantalla;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("view.Main");
	}

	public void settings() {

		size(1200, 700);
	}

	public void setup() {
		//Load images
		start = loadImage("image/start.png");
		logo = loadImage("image/logo.png");
		
		
		//Load int variables
		pantalla = 0;
		

	}

	public void draw() {

		switch(pantalla) {
		
		case 0:
		background(0);
		image(start,0,0);
		image(logo,0,0);
		break;
		
		}
		
		
		
	}

}// cierra main

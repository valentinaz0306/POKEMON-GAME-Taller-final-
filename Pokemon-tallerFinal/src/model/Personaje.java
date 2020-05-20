package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Personaje {
	public int PosX;
	public int PosY;
	PApplet app;

	public Personaje(int PosX, int PosY, PApplet app) {
		this.PosX = PosX;
		this.PosY = PosY;
		this.app=app;
	}
	
	public void draw(PImage j) {
		app.image(j,PosX,PosY,50,50);
	}
	

	public void moveup() {
		if (this.PosY > 0) {
			this.PosY -= 100;
		}
	}

	public void movedown() {
		if (PosY < 700) {
			PosY += 100;
		}
	}

	public void moveright() {
		if (this.PosX < 1190) {
			this.PosX += 100;
		}
	}

	public void moveleft() {
		if (this.PosX > 0) {
			this.PosX -= 100;
		}

	}

}

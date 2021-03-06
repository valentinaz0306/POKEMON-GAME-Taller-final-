package model;

import processing.core.PApplet;
import processing.core.PImage;

public class Personaje {
	public final static char UP = 'w';
	public final static char LEFT = 'a';
	public final static char DOWN = 's';
	public final static char RIGHT = 'd';
	public final static char STILL = 'K';
	public int PosX;
	public int PosY;
	public int i;
	public int j;
	public int mapa[][];
	private char direction;
	private int fight;
	PApplet app;

	public Personaje(int PosX, int PosY, int mapa[][], PApplet app) {
		this.PosX = PosX;
		this.PosY = PosY;
		this.mapa = mapa;
		this.app = app;
		this.setFight(0);
	}

	public void move() {
		//System.out.println(direction);
		Par p;

		switch (direction) {
		case UP:
			p = converttoindex(this.PosX, this.PosY - 5);
			if (p.getI() > -1 && p.getI() < 7 && p.getJ() > -1 && p.getJ() < 12) {
				if (mapa[p.getI()][p.getJ()] != 0) {
					moveup();
					if(mapa[p.getI()][p.getJ()] >= 3) {
						setFight(mapa[p.getI()][p.getJ()]);
						System.out.println("lo que sea mani");
					}
					
				} else {
					direction = STILL;
				}
			} else {
				direction = STILL;
			}
			
			
			break;
		case DOWN:
			p = converttoindex(this.PosX, this.PosY + 5);
			if (p.getI() > -1 && p.getI() < 7 && p.getJ() > -1 && p.getJ() < 12) {
				if (mapa[p.getI()][p.getJ()] != 0) {
					movedown();
					if(mapa[p.getI()][p.getJ()] >= 3) {
						setFight(mapa[p.getI()][p.getJ()]);
						System.out.println("lo que sea mani");
					}
				} else {
					direction = STILL;
				}
			} else {
				direction = STILL;
			}
			
			break;
		case LEFT:
			p = converttoindex(this.PosX - 5, this.PosY);
			if (p.getI() > -1 && p.getI() < 7 && p.getJ() > -1 && p.getJ() < 12) {
				if (mapa[p.getI()][p.getJ()] != 0) {
					moveleft();
					if(mapa[p.getI()][p.getJ()] >= 3) {
						setFight(mapa[p.getI()][p.getJ()]);
						System.out.println("lo que sea mani");
					}
				} else {
					direction = STILL;
				}
			} else {
				direction = STILL;
			}
			
			break;
		case RIGHT:
			p = converttoindex(this.PosX + 5, this.PosY);
			if (p.getI() > -1 && p.getI() < 7 && p.getJ() > -1 && p.getJ() < 12) {
				if (mapa[p.getI()][p.getJ()] != 0) {
					moveright();
					if(mapa[p.getI()][p.getJ()] >= 3) {
						setFight(mapa[p.getI()][p.getJ()]);
						//System.out.println("lo que sea mani");
					}
				} else {
					direction = STILL;
				}
			} else {
				direction = STILL;
			}
		
			break;
		}

	}

	public void moveup() {
		if (this.PosY > 0) {
			this.PosY -= 3;
		}
	}

	public void movedown() {
		if (PosY < 700) {
			PosY += 3;
		}
	}

	public void moveright() {
		if (this.PosX < 1190) {
			this.PosX += 3;
		}
	}

	public void moveleft() {
		if (this.PosX > 0) {
			this.PosX -= 3;
		}

	}

	public Par converttoindex() {
		int currentI = this.PosY / Logica.SIZE_MATRIX;
		int currentJ = this.PosX / Logica.SIZE_MATRIX;

		Par p = new Par(currentI, currentJ);
		return p;

	}

	public Par converttoindex(int x, int y) {
		int currentI = y / Logica.SIZE_MATRIX;
		int currentJ = x / Logica.SIZE_MATRIX;

		Par p = new Par(currentI, currentJ);
		return p;

	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int getFight() {
		return fight;
	}

	public void setFight(int fight) {
		this.fight = fight;
	}

}

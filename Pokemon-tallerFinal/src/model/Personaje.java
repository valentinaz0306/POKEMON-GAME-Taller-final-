package model;

public class Personaje {
	public int PosX;
	public int PosY;

	public Personaje(int PosX, int PosY) {
		this.PosX = PosX;
		this.PosY = PosY;
	}

	public void moveup() {
		if (this.PosY > 0) {
			this.PosY -= 100;
		}
	}

	public void movedown() {
		if (this.PosY > 700) {
			this.PosY += 100;
		}
	}

	public void moveright() {
		if (this.PosX > 1190) {
			this.PosX += 100;
		}
	}

	public void moveleft() {
		if (this.PosX > 0) {
			this.PosX -= 100;
		}

	}

}

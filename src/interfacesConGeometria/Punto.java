package interfacesConGeometria;

import static java.lang.Math.pow;

public class Punto implements Desplazable {
	
	private double x;
	private double y;
	
	
	public double getX() {
		return x;
	}
	
	private void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	private void setY(double y) {
		this.y = y;
	}
	
	public Punto(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	public double distancia(Punto otro) {
		return Math.sqrt(pow(this.x - otro.x, 2) + pow(this.y - otro.y, 2));
	}
	
	@Override
	public void desplazar(double deltaX, double deltaY) {
		this.setX(this.getX() + deltaX);
		this.setY(this.getY() + deltaY);
	}
	
	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}
}
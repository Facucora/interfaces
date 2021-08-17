package interfacesConGeometria;

public abstract class Figura implements Desplazable, Comparable<Figura>{
	
	private Punto punto;
	
	public Figura(Punto punto) {
		this.punto = punto;
	}
	
	public abstract Double getArea();
	
	@Override
	public void desplazar(double deltaX, double deltaY) {
		this.punto.desplazar(deltaX, deltaY);
	}
	
	public int compareTo(Figura f) {
		return this.getArea().compareTo(f.getArea());
	}

}

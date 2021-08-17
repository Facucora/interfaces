package interfacesConGeometria;

import java.util.Objects;

public abstract class Figura implements Desplazable, Comparable<Figura>{
	
	@Override
	public int hashCode() {
		return Objects.hash(punto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figura other = (Figura) obj;
		return Objects.equals(punto, other.punto);
	}

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

package interfacesConGeometria;

import java.util.Objects;

public class Segmento implements Comparable<Segmento>, Desplazable, EsParalelo{
	


	private Punto puntoA;
	private Punto puntoB;
	
	public Segmento(Punto puntoA, Punto puntoB) throws InvalidSegmentoException{
		if(puntoA.equals(puntoB))
			throw new InvalidSegmentoException("Los extremos no puden ser el mismo punto");
		else {
		this.puntoA = puntoA;
		this.puntoB = puntoB;
		}
	}
	
	public Double getLargo() {
		return this.puntoA.distancia(puntoB);
	}
	
	@Override
	public void desplazar(double deltaX, double deltaY) {
		this.puntoA.desplazar(deltaX, deltaY);
		this.puntoB.desplazar(deltaX, deltaY);
	}
	
	@Override
	public int compareTo(Segmento o) {
		return this.getLargo().compareTo(o.getLargo());
	}
	
	@Override
	public boolean esParaleloAX() {
		return this.puntoA.getY() == this.puntoB.getY();
 	}
	
	@Override
	public boolean esParaleloAY() {
		return this.puntoA.getX() == this.puntoB.getX();
 	}
	
	@Override
	public boolean esParalelo(EsParalelo s) {
		if(s instanceof Segmento) {
			Segmento otro = (Segmento) s;
			
			double a = this.puntoA.getY() - this.puntoA.getY();
			double b = this.puntoA.getX() - this.puntoA.getX();
			double c = otro.puntoA.getY() - otro.puntoA.getY();
			double d = otro.puntoA.getX() - otro.puntoA.getX();
			return (a / b == c / d);
 		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(puntoA, puntoB);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segmento other = (Segmento) obj;
		return Objects.equals(puntoA, other.puntoA) && Objects.equals(puntoB, other.puntoB);
	}
}

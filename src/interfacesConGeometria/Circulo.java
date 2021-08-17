package interfacesConGeometria;

public class Circulo extends Figura{
	
	private double radio;
	
	public Circulo(Punto centro, double radio) throws InvalidRadioException{
		super(centro);
		setRadio(radio);
	}
	
	private void setRadio(double radio) {
		if(radio <= 0)
		this.radio = radio;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	public double getDiametro() {
		return this.radio*2;
	}
	
	public double getPerimetro() {
		return Math.PI * this.getDiametro();
	}
	
	@Override
	public Double getArea() {
		return Math.PI * Math.pow(this.radio, 2);
	}

}

package interfacestest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import interfacesConGeometria.Circulo;
import interfacesConGeometria.Cuadrado;
import interfacesConGeometria.Desplazable;
import interfacesConGeometria.Figura;
import interfacesConGeometria.InvalidSegmentoException;
import interfacesConGeometria.Punto;
import interfacesConGeometria.Segmento;

public class FigurasSegmentosTest {
	
	Segmento s1;
	Segmento s2;
	Circulo cic;
	Cuadrado cuc;
	Figura cif;
	Figura cuf;
	
	@Before
	public void setUp() throws Exception {
		cic = new Circulo(new Punto(-1, -1), 3);
		cuc = new Cuadrado(new Punto(-2, 2), 4);
		cif = new Circulo(new Punto(2, 2), 3.5);
		cuf = new Cuadrado(new Punto(2, -2), 3);
		s1 = new Segmento(new Punto(-5, 0), new Punto(-5, -10));
		s2 = new Segmento(new Punto(0, -5), new Punto(5, -5));

	}
	
	@Test
	public void segmentosParalelosTest() {
		Segmento s3 = new Segmento(new Punto(1, 2), new Punto(4, 5));
		Segmento s4 = new Segmento(new Punto(-1, 2), new Punto(2, 5));
		
		assertTrue(s1.esParaleloAY());
		assertTrue(s2.esParaleloAX());
		assertFalse(s1.esParalelo(s2));
		assertFalse(s2.esParalelo(s1));
		assertFalse(s3.esParalelo(s4));
		assertFalse(s4.esParalelo(s3));
	}
	
	@Test
	public void figurasOrdenadas() {
		Figura[] figuras = {cic, cuc, cif, cuf};
		Arrays.sort(figuras);
	}
	
	@Test
	public void desplazarTest() {
		Segmento s3 = new Segmento(new Punto(1, 2), new Punto(4, 5));
		@SuppressWarnings("unused")
		Segmento s4 = new Segmento(new Punto(-1, 2), new Punto(2, 5));
		Segmento s1Desplazado = new Segmento(new Punto(-4, 1), new Punto(-4, -9));
		Punto puntito = new Punto(0, 0);
		Figura cufDesplazado = new Cuadrado(new Punto(3, -1), 3);
		
		Desplazable[] desplazables = {cic, cif, cuc, cuf, s1, s2, s3, s3, puntito};
		
		for(Desplazable d : desplazables)
			d.desplazar(1, 1);
		
		assertEquals(new Punto(1, 1), puntito);
		assertEquals(cufDesplazado, cuf);
		assertEquals(s1, s1Desplazado);
	}
	
	@Test(expected=InvalidSegmentoException.class)
	public void segmentosInvalidos() {
		@SuppressWarnings("unused")
		Segmento s = new Segmento(new Punto(1, 2), new Punto(1, 2));
	}

}

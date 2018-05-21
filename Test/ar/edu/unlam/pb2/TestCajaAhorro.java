package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCajaAhorro {

	@Test
	public void testQueCreaCajaDeAhorro() {

		CajaAhorro miCajaAhorro = new CajaAhorro(1, 1500.0);
		
		assertEquals(1, miCajaAhorro.getCliente(),0.01);
		assertEquals(1500.0, miCajaAhorro.getSaldo(),0.01);
	}

	@Test
	public void testQueDepositaEnCajaDeAhorro() {
		
		CajaAhorro miCajaAhorro = new CajaAhorro(2,1560.0);
		
		Boolean  estado = miCajaAhorro.depositar(2000.0);
		assertTrue(estado);
		assertEquals(3560.0, miCajaAhorro.getSaldo(), 0.01);
		System.out.println("saldo "+miCajaAhorro.getSaldo());

	}
	
	@Test
	public void testQueExtraeUnaVezEnCajaDeAhorro() {
		CajaAhorro miCajaAhorro = new CajaAhorro(3,1500.0);
		
		Boolean estado = miCajaAhorro.extraer(100.0);
				
		assertTrue(estado);
		assertEquals(1400.0, miCajaAhorro.getSaldo(), 0.01);
		
		System.out.println("saldo "+miCajaAhorro.getSaldo());
	}
	
	@Test
	public void testQueExtraeConInteresEnCajaDeAhorro() {
		CajaAhorro miCajaAhorro = new CajaAhorro(3,1500.0);
		
		miCajaAhorro.depositar(10000.0); // $11500
		
		miCajaAhorro.extraer(100.0); 
		miCajaAhorro.extraer(200.0);
		miCajaAhorro.extraer(500.0);
		miCajaAhorro.extraer(1100.0);
		miCajaAhorro.extraer(700.0);
		miCajaAhorro.extraer(100.0); //tiene que cobrar por pasar la 5ta extraccion, quedan 8800-6

		Double esperado = 8794.0;
		
		assertEquals(esperado, miCajaAhorro.getSaldo(), 0.01);
		
		System.out.println("saldo "+miCajaAhorro.getSaldo());
	}

	
}

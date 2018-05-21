package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaSueldo {

	@Test
	public void testQueCreaCuentaSueldo() {

		CuentaSueldo miCuentaSueldo = new CuentaSueldo(1, 1500.0);
		
		assertEquals(1, miCuentaSueldo.getCliente(),0.01);
		assertEquals(1500.0, miCuentaSueldo.getSaldo(),0.01);
	}

	@Test
	public void testQueDepositaEnCuentaSueldo() {
		
		CuentaSueldo miCuentaSueldo = new CuentaSueldo(2,1560.0);
		
		Boolean  estado = miCuentaSueldo.depositar(2000.0);
		assertTrue(estado);
		assertEquals(3560.0, miCuentaSueldo.getSaldo(), 0.01);
		//System.out.println("saldo "+miCuentaSueldo.getSaldo());

	}
	
	@Test
	public void testQueExtraeEnCuentaSueldo() {
		CuentaSueldo miCuentaSueldo = new CuentaSueldo(3,1500.0);
		
		Boolean estado = miCuentaSueldo.extraer(100.0);
				
		assertTrue(estado);
		assertEquals(1400.0, miCuentaSueldo.getSaldo(), 0.01);
		
		//System.out.println("saldo "+miCuentaSueldo.getSaldo());
	}
	
	@Test
	public void testQueDepositayExtraeEnCuentaSueldo() {
		CuentaSueldo miCuentaSueldo = new CuentaSueldo(3, 2000.0);
		
		miCuentaSueldo.depositar(3000.0);
		Boolean estado = miCuentaSueldo.extraer(4000.0);
		
		Double esperado = 1000.0; 
		
		assertTrue(estado);
		assertEquals(esperado, miCuentaSueldo.getSaldo(), 0.01);
		
	}
	
}

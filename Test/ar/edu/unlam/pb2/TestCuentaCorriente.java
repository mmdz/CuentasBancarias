package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaCorriente {

	@Test
	public void testQueCreaCuentaCorriente() {

		CuentaCorriente miCuentaCorriente = new CuentaCorriente(1, 10000.0);
		
		Double saldo = miCuentaCorriente.getSaldo();
		Double esperado = 10000.0;
		assertEquals(esperado, saldo, 0.01);
		
//		CuentaBancaria miBancaria= new CuentaBancaria();
//		System.out.println("cta banc "+miBancaria.getSaldo());
	}
	
	@Test
	public void testQueDepositaEnCuentaCorriente() {
		
		CuentaCorriente miCuentaCorriente = new CuentaCorriente(2, 0.0);
		Boolean estado = miCuentaCorriente.depositar(2000.0);
		
		assertTrue(estado);	//si deposito devuelve true	
	}
	
	@Test
	public void testQueExtraeEnCuentaCorriente() {
		
		CuentaCorriente miCuentaCorriente = new CuentaCorriente(3, 2000.0);
		Boolean  estado = miCuentaCorriente.extraer(1500.0);
		
		assertTrue(estado); //si extrajo devuelve true
	//	System.out.println("dinero en cuenta"+ miCuentaCorriente.getSaldo()); //$500.0
	}
	
	@Test 
	public void TestQueExtraeEnDescubiertoEnCuentaCorriente() {
		
		CuentaCorriente miCuentaCorriente = new CuentaCorriente(4, 1400.0);
		Boolean estado = miCuentaCorriente.extraer(2000.0);	//600=2000-1400 -> 630=600+(600*0.05)
		
		//System.out.println("dinero en cuenta "+ miCuentaCorriente.getSaldo());
		//System.out.println("descubierto "+ miCuentaCorriente.getDescubierto()); //370
		
		 assertTrue(estado);
	}
	
	@Test
	public void testQueAgotoDescubiertoEnCuentaCorriente() {
		
		CuentaCorriente miCuentaCorriente = new CuentaCorriente(5, 3000.0);
		
		miCuentaCorriente.extraer(3500.0);
		Boolean estado = miCuentaCorriente.extraer(2000.0);
		
		//System.out.println("dinero en cuenta "+ miCuentaCorriente.getSaldo());
		//System.out.println("descubierto "+ miCuentaCorriente.getDescubierto()); //370
		
		assertFalse(estado); //saldo insuficiente
	}
	

}

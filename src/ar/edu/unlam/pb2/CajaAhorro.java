package ar.edu.unlam.pb2;

public class CajaAhorro extends CuentaBancaria{

	//atributos propios
	private Integer cantidadExtracciones;
	private final Double adicional=6.0; /*luego de la 5ta extraccion se cobrara 6 pesos extra*/
	
	//constructor
	public CajaAhorro() {
		// vacio por defecto
	}
	
	public CajaAhorro(Integer cliente, Double saldo) {
		super(cliente,saldo); //guardo en los atributos del padre
		this.cantidadExtracciones = 0; //inicializo en cero
	}
	
	//metodos
	public Boolean depositar(Double deposito) {
		
		Boolean estado = super.depositar(deposito);
		
		System.out.println("Deposito en Caja  de Ahorro");
		return estado;
	}
	

	public Boolean extraer(Double extraccion) {
		
		Boolean estado = super.extraer(extraccion);
		
		System.out.println("Extraccion en Caja de Ahorro");
		if(estado.equals(true)) {
			cantidadExtracciones++;
			
			if(cantidadExtracciones>5) {
			
			Double saldo=super.getSaldo()-adicional;
			setSaldo(saldo);
			}
		}
		
		return estado;
	}
	
	
	//set saldo para guardar un nuevo valor sobre el q tenia el padre
	public void setSaldo(Double saldo){
			super.setSaldo(saldo);
	}	
	
}

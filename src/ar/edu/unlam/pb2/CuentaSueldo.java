package ar.edu.unlam.pb2;

public class CuentaSueldo extends CuentaBancaria {  //extiende de cta bancaria

//no tiene atributos propios
	

	//constructor vacio
	public CuentaSueldo() {		
	
	}
	
	//constructor con parametros
	public CuentaSueldo(Integer cliente,Double saldo) {
		super(cliente,saldo);	//hereda el constructor del padre
	}
	
	
	//metodos
	public Boolean depositar(Double deposito) {
		
		Boolean estado = super.depositar(deposito);
		System.out.println("Deposito en Cuenta Sueldo");

		return estado;
	}
	
	public Boolean extraer(Double extraccion) {
		
		Boolean estado = super.extraer(extraccion);		//uso el metodo del padre
		System.out.println("Extraccion en Cuenta Sueldo");
		
		return estado;
	}
	
	//set saldo para guardar un nuevo valor sobre el q tenia el padre
	public void setSaldo(Double saldo){
		
			super.setSaldo(saldo);
		
	}	
	
	
	
	

}

package ar.edu.unlam.pb2;

public class CuentaBancaria { //clase padre 
	//atributos padre
		private Double saldo;
		private Integer cliente;
		
		//constructor
		public CuentaBancaria() {
			//vacio por defecto
		}
		
		public CuentaBancaria(Integer cliente,Double saldo) { //recibe parametros
			
			this.saldo=saldo;
			this.cliente=cliente;
		}
		
		//metodos
		
		public Boolean depositar(Double deposito) {
			
			Boolean estado=true;		//true deposito bien  false no 
			if(deposito>0) {	
				saldo += deposito;
				setSaldo(saldo);
				estado = true;
			}
			else {
				estado = false;
			}
			return estado;
		}
		
		public Boolean extraer(Double extraccion) {
			Boolean estado=false; 
			
			if(extraccion<=saldo) {
				
				saldo -= extraccion;
				setSaldo(saldo);
				estado = true;
			}
			else {
				estado = false;
			}
			return estado;
		}
		
		
		
		//getter y setter
		public void setSaldo(Double saldo) {
			this.saldo=saldo;
		}
		
		public Double getSaldo() {
			return saldo;
		}
		
		public void setCliente(Integer cliente) {
			this.cliente=cliente;
		}
		
		public Integer getCliente() {
			return cliente;
		}

}

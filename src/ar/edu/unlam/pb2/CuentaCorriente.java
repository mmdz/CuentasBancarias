package ar.edu.unlam.pb2;

public class CuentaCorriente extends CuentaBancaria{

	//atributos propios
	private final Double comision=0.05;
	private  Double descubierto;
	
	public CuentaCorriente() {
		//vacio por defecto
	}
	
	public CuentaCorriente(Integer cliente,Double saldo) {
		super(cliente,saldo);	
		this.descubierto = 1000.0; //max permitido
	}
	
	//metodos
	public Boolean depositar(Double deposito) {
		
		Boolean estado = super.depositar(deposito);
		System.out.println("Deposito en Cta Corriente");
		return estado;
	}
	
	public Boolean extraer(Double extraccion) {
		
		Boolean estado = super.extraer(extraccion);  //si hay saldo, extrae 
		
			if(estado.equals(false)) { //si saldo insuficiente, pide giro descubierto
				
				Double dineroPosible = extraccion - super.getSaldo(); //500=1500-1000 -> 525=500+(500*0.05)
				
				dineroPosible += (dineroPosible*comision); //calculo el descubierto
					
				if(descubierto > dineroPosible)
				{
					descubierto -= dineroPosible; //extraigo lo pedido, calculo lo que me queda para pedir descubierto
					estado=true; 				//entrego dinero
					
					setSaldo(-dineroPosible); 	//dejo en negativo el saldo que se debe
				}
				
				else {
					System.out.println("Agotó el giro descubierto");
					estado=false;				//no entrego
				}
					
			}
			System.out.println("Movimiento en Cta corriente");

		return estado;
	}

	
	
	//set saldo para guardar un nuevo valor sobre el q tenia el padre
	public void setSaldo(Double saldo){
			super.setSaldo(saldo);
	}

	public Double getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(Double descubierto) {
		this.descubierto = descubierto;
	}
	
	
}

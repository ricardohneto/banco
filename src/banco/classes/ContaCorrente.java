package banco.classes;

public class ContaCorrente extends Conta {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected double limite;
	protected double juros;
	protected double tarifa;
	
	public ContaCorrente(double saldo, Cliente cliente, Agencia agencia, double limite, double juros,
			double tarifa) {
		super(saldo, cliente, agencia);
		this.limite = limite;
		this.juros = juros;
		this.tarifa = tarifa;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	@Override
	public String imprimirTipoConta() {
    	return "Conta Corrente";
    }
	
	@Override
	public String toString() {
		return this.imprimirTipoConta()+" : "+this.getCodConta()+" [ R$"+this.getSaldo()+" / R$"+this.limite+" / "+this.juros+"% / "+this.tarifa+"% ]\nTitular:"+this.getCliente();
	}

	public boolean sacar(double valor) {
    	if(valor <= this.saldo + this.limite) {
    		this.saldo -= valor;
    		return true;
    	}
    	return false;
    }
	
	public double viraMes(){
		double saldoAnterior = this.saldo;

		if(this.saldo < 0){
			this.saldo -= (-this.saldo * this.juros);
		}

		this.saldo -= this.tarifa;

		return this.saldo - saldoAnterior;
	}
	
}

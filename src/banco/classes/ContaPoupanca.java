package banco.classes;

public class ContaPoupanca extends Conta {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected double rendimento;
	
	public ContaPoupanca(double saldo, Cliente cliente, Agencia agencia, double rendimento) {
		super(saldo, cliente, agencia);
		this.rendimento = rendimento;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
	
	@Override
	public String imprimirTipoConta() {
    	return "Poupanca";
    }

	@Override
	public String toString() {
		return this.imprimirTipoConta()+" : "+this.getCodConta()+
		"\n     SALDO: R$"+this.getSaldo()+
		"\n     RENDIMENTO: "+this.rendimento+
		"%\nTITULAR:\n     "+this.getCliente();
	}

	public double viraMes(){
		double saldoAnterior = this.saldo;
		this.saldo += this.saldo * this.rendimento;
		return this.saldo - saldoAnterior;
	}
	
}

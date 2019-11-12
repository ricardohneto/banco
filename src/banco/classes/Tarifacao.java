package banco.classes;

public class Tarifacao implements Operacao{
    private ContaCorrente conta;

    public Tarifacao(ContaCorrente conta) {
        this.conta = conta;
    }
    
    public boolean efetuar(){
		double saldoAnterior = this.conta.saldo;

		if(this.conta.saldo < 0){
			this.conta.saldo -= (-this.conta.saldo * this.conta.juros);
		}

		this.conta.saldo -= this.conta.tarifa;

        this.conta.saldo -= saldoAnterior;
        return true;
	}

}
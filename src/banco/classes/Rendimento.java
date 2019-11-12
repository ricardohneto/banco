package banco.classes;

public class Rendimento implements Operacao{
    private ContaPoupanca conta;

    public Rendimento(ContaPoupanca conta) {
        this.conta = conta;
    }
    
    public boolean efetuar(){
		double saldoAnterior = this.conta.saldo;
		this.conta.saldo += this.conta.saldo * this.conta.rendimento;
        this.conta.saldo -= saldoAnterior;
        return true;
	}

}
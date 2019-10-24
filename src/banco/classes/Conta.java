package banco.classes;

import java.io.*;

public abstract class Conta implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static int cont = 0;
    private int codConta;
    protected double saldo;
    private Cliente cliente;
    private Agencia agencia;

    public Conta(double saldo, Cliente cliente, Agencia agencia) {
        this.saldo = saldo;
        this.codConta = cont++;
        this.cliente = cliente;
        this.agencia = agencia;
    }

    public int getCodConta() {
        return codConta;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

    @Override
    public abstract String toString();
    
    public String imprimirTipoConta() {
    	return "Conta";
    }

    @Override
    public boolean equals(Object contaAux) {
        return (this.codConta == (((Conta)contaAux).codConta));
    }
    
    public void depositar(double valor) {
    	if(valor > 0) {
    		this.saldo += valor;
    	}
    }
    
    public boolean sacar(double valor) {
    	if(valor <= this.saldo) {
    		this.saldo -= valor;
    		return true;
    	}
    	return false;
    }
    
    public boolean transferir(double valor, Conta conta) {
    	if(this.sacar(valor)) {
    		conta.depositar(valor);
    		return true;
    	}
    	return false;
    }

    public abstract double viraMes();

}
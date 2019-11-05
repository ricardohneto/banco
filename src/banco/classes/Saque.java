package banco.classes;

import java.util.Date;

public class Saque implements Operacao{
    private Conta conta;
    private double valor;
    private Date data;

    public Saque(Conta conta, double valor) {
        this.conta = conta;
        this.valor = valor;
    }

    @Override
    public boolean efetuar() {
        if(this.conta.sacar(this.valor)){
            this.conta.operacoes.add(this);
            this.data = new Date(System.currentTimeMillis());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Saque de:\n" + conta.toString() + "\nRealizado no dia: " + data + "\nNo valor de: R$" + valor;
    }
}
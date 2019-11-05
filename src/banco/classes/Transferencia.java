package banco.classes;

import java.util.Date;

public class Transferencia implements Operacao {
    private Conta contaOrigem;
    private Conta contaDestino;
    private double valor;
    private Date data;

    public Transferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
    }

    @Override
    public boolean efetuar() {
        if(this.contaOrigem.transferir(this.valor, this.contaDestino)){
            this.contaOrigem.operacoes.add(this);
            this.contaDestino.operacoes.add(this);
            this.data = new Date(System.currentTimeMillis());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Saque de:\n" + contaOrigem.toString() + "Para:\n" + contaDestino.toString() + "\nRealizado no dia: " + data + "\nNo valor de: R$" + valor;
    }
    
}
package banco.classes;

import java.io.Serializable;
import java.util.Date;

public class Transferencia implements Operacao, Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
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
        return "Transferência de:\n" + contaOrigem.toString() + "Para:\n" + contaDestino.toString() + "\nRealizado no dia: " + data + "\nNo valor de: R$" + valor;
    }
    
}
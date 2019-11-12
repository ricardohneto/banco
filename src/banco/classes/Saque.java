package banco.classes;

import java.io.Serializable;
import java.util.Date;

public class Saque implements Operacao, Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
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
        return "SAQUE DE: "+ conta.imprimirTipoConta()+" : "+conta.getCodConta()+"\nREALIZADO NO DIA: " + data + "\nNO VALOR DE: R$" + valor;
    }
}
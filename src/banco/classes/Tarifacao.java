package banco.classes;

import java.io.Serializable;
import java.util.Date;

public class Tarifacao implements Operacao, Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Conta conta;
    private double valor;
    private Date data;

    public Tarifacao(Conta conta) {
        this.conta = conta;
    }
    
    public boolean efetuar(){
        this.valor = this.conta.viraMes();
        this.conta.operacoes.add(this);
        this.data = new Date(System.currentTimeMillis());
        return true;
    }
    
    @Override
    public String toString() {
        return "TARIFACAO DE: "+ conta.imprimirTipoConta()+" : "+conta.getCodConta()+"\nREALIZADO NO DIA: " + data + "\nNO VALOR DE: R$" + valor;
    }

}
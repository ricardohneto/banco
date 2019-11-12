package banco.classes;

public class Gerente extends Funcionario {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Gerente(String nome, String cpf, String telefone, double salario) {
		super(nome, cpf, telefone, salario);
	}

	@Override
	public String toString() {
		return "GERENTE: "+this.getNome()+
		"\nCPF: "+this.getCpf()+
		"\nTELEFONE: (27)"+this.getTelefone()+
		"\nSALARIO: R$"+this.getSalario();
	}
    
    
    
}
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
		return this.getNome()+" / "+this.getCpf()+" / (27)"+this.getTelefone()+" / R$"+this.getSalario()+"\n";
	}
    
    
    
}
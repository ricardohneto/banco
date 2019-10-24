package banco.classes;

public abstract class Funcionario extends Pessoa {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private double salario;
	
	public Funcionario(String nome, String cpf, String telefone, double salario) {
		super(nome, cpf, telefone);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public abstract String toString();
	
}

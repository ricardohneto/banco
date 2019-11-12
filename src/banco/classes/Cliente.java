package banco.classes;

public class Cliente extends Pessoa{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Cliente(String nome, String cpf, String telefone) {
		super(nome, cpf, telefone);
	}

	@Override
	public String toString() {
		return "CLIENTE: "+this.getNome()+
		"\nCPF: "+this.getCpf()+
		"\nTELEFONE: (27)"+this.getTelefone();
	}

}
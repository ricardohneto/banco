package banco.classes;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String telefone;
	
	public Pessoa(String nome, String cpf, String telefone) {	
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public abstract String toString();
	
	@Override
    public boolean equals(Object pessoaAux) {
        return (this.cpf.equalsIgnoreCase(((Pessoa)pessoaAux).cpf));
    }
	
}

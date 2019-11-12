package banco.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Agencia implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static int cont = 0;
	private int codAgencia;
	private String nome;
	private Gerente gerente;
	private ArrayList<Conta> contas;

	public Agencia(String nome, Gerente gerente) {
		this.codAgencia = cont++;
		this.nome = nome;
		this.gerente = gerente;
		this.contas = new ArrayList<>();
	}

	public int getCodAgencia() {
		return codAgencia;
	}

	public String getNome() {
		return nome;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public String toString() {
		return "AGENCIA: "+this.nome+" : "+this.codAgencia+
		"\nFUNCIONARIO: \n     "+this.getGerente().toString();
	}

	@Override
	public boolean equals(Object agenciaAux) {
		return (this.codAgencia == (((Agencia)agenciaAux).codAgencia));
	}

}
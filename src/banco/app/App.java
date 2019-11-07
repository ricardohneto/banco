package banco.app;

import java.util.ArrayList;
import java.util.Iterator;

import banco.classes.*;
import banco.metodos.*;

public class App {

	public static ArrayList<Agencia> agencias = new ArrayList<>();
	public static Iterator<Agencia> itAgencias = agencias.iterator();

	public static ArrayList<Cliente> clientes = new ArrayList<>();
	public static Iterator<Cliente> itClientes = clientes.iterator();

	public static ArrayList<Gerente> gerentes = new ArrayList<>();
	public static Iterator<Gerente> itGerentes = gerentes.iterator();

	public static ArrayList<Conta> contas = new ArrayList<>();
	public static Iterator<Conta> itContas = contas.iterator();

	public static void main(String[] args) {

		RelatoriosController.carregarDados();
		MenuController.principal();
		//RelatoriosController.gravarDados();
		Util.input.close();

	}
}

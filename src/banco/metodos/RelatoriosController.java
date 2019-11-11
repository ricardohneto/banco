package banco.metodos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import banco.app.App;
import banco.classes.Agencia;
import banco.classes.Cliente;
import banco.classes.Conta;
import banco.classes.Gerente;
import banco.classes.Util;

import java.util.ArrayList;

public class RelatoriosController {

	public static void menu(){
		int op = 0;
		boolean sair = false;

		do{

			System.out.println("\n\nMENU DE RELATORIOS\n" + 
					"(1) - EXIBIR RELATORIO COMPLETO\n" + 
					"(2) - GRAVAR DADOS\n" + 
					"(3) - CARREGAR DADOS\n" + 
					"(0) - VOLTAR");
			op = Util.input.nextInt();
			switch(op){
			case 0:
				sair = true;
				break;
			case 1:
				exibeRelatorio();
				break;
			case 2:
				gravarDados();
				break;
			case 3:
				carregarDados();
				break;
			}

		}while(!sair);

	}

	//  [1.3.1] - exibir relatorio completo

	public static void exibeRelatorio(){
		System.out.println("\n");
		exibeRelatorioAgencia();
		exibeRelatorioCliente();
		exibeRelatorioContas();
		exibeRelatorioGerente();
	}

	public static void exibeRelatorioAgencia(){
		Agencia agenciaAux = null;

		System.out.println("[!] Lista de Ag�ncias:\n------------------------------\nNome & Código   / Gerente\n------------------------------\n");

		App.itAgencias = App.agencias.iterator();

		while (App.itAgencias.hasNext()) { 
			agenciaAux = (Agencia) App.itAgencias.next(); 
			System.out.println(agenciaAux.toString()); 
		}
		System.out.println("------------------------------\n");
	}

	public static void exibeRelatorioCliente(){
		Cliente clienteAux = null;

		System.out.println("[!] Lista de Clientes:\n------------------------------\nNome     / CPF / Telefone\n------------------------------");

		App.itClientes = App.clientes.iterator();


		while (App.itClientes.hasNext()) { 
			clienteAux = (Cliente) App.itClientes.next(); 
			System.out.println(clienteAux.toString()); 
		}
		System.out.println("------------------------------\n");
	}

	public static void exibeRelatorioContas(){
		Conta contaAux = null;

		System.out.println("[!] Lista de Contas:\n------------------------------");

		App.itContas = App.contas.iterator();

		while (App.itContas.hasNext()) { 
			contaAux = (Conta) App.itContas.next(); 
			System.out.println(contaAux.toString()); 
		}
		System.out.println("------------------------------\n");
	}

	public static void exibeRelatorioGerente(){
		Gerente gerenteAux = null;

		System.out.println("[!] Lista de Gerentes:\n------------------------------");

		App.itGerentes = App.gerentes.iterator(); 

		while (App.itGerentes.hasNext()) { 
			gerenteAux = (Gerente) App.itGerentes.next(); 
			System.out.println(gerenteAux.toString()); 
		}
		System.out.println("------------------------------\n");
	}

	//  [1.3.2] - gravar dados

	public static void gravarDados(){
		gravarDadosAgencia();
		gravarDadosCliente();
		gravarDadosConta();
		gravarDadosGerente();
	}

	public static void gravarDadosAgencia(){
		try{
			FileOutputStream arq = new FileOutputStream("C:/Users/ricar/Documents/Ricardo/Programação/Workspace/banco/src/banco/relatorios/agencias.arq");
			ObjectOutputStream obj = new ObjectOutputStream(arq);
				
			obj.writeObject(App.agencias);
			obj.flush();

			System.out.println("[+] arquivo de AGENCIAS gravado com sucesso!!!");

		} catch (Exception e) {

			System.err.println("[+] erro ao gravar arquivos!!!");

		}
	}

	public static void gravarDadosCliente(){
		try{

			FileOutputStream arq = new FileOutputStream("C:/Users/ricar/Documents/Ricardo/Programação/Workspace/banco/src/banco/relatorios/clientes.arq");
			ObjectOutputStream obj = new ObjectOutputStream(arq);
			
			obj.writeObject(App.clientes);
			obj.flush();
			
			System.out.println("[+] arquivo de CLIENTES gravado com sucesso!!!");

		} catch (Exception e) {

			System.err.println("[+] erro ao gravar arquivos!!!");

		}
	}

	public static void gravarDadosConta(){
		try{

			FileOutputStream arq = new FileOutputStream("C:/Users/ricar/Documents/Ricardo/Programação/Workspace/banco/src/banco/relatorios/contas.arq");
			ObjectOutputStream obj = new ObjectOutputStream(arq);
				
			obj.writeObject(App.contas);
			obj.flush();
			
			System.out.println("[+] arquivo de CONTAS gravado com sucesso!!!");

		} catch (Exception e) {

			System.err.println("[+] erro ao gravar arquivos!!!");

		}

	}

	public static void gravarDadosGerente(){
		try{

			
			FileOutputStream arq = new FileOutputStream("C:/Users/ricar/Documents/Ricardo/Programação/Workspace/banco/src/banco/relatorios/gerentes.arq");
			ObjectOutputStream obj = new ObjectOutputStream(arq);
				
			obj.writeObject(App.gerentes);
			obj.flush();
			
			System.out.println("[+] arquivo de GERENTES gravado com sucesso!!!");

		} catch (Exception e) {

			System.err.println("[+] erro ao gravar arquivos!!!");

		}

	}

	//  [1.3.3] - carregar dados

	public static void carregarDados(){
		carregarDadosAgencia();
		carregarDadosCliente();
		carregarDadosConta();
		carregarDadosGerente();
	}

	public static void carregarDadosAgencia(){
		
		try {

			FileInputStream arq = new FileInputStream("C:/Users/ricar/Documents/Ricardo/Programação/Workspace/banco/src/banco/relatorios/agencias.arq");
			ObjectInputStream obj = new ObjectInputStream(arq);
			App.agencias = (ArrayList<Agencia>) obj.readObject();

		} catch (Exception e) {
			System.err.println("[+] erro ao carregar arquivos de AGENCIAS!!!");
		}
	}

	public static void carregarDadosCliente(){

		try {

			FileInputStream arq = new FileInputStream("C:\\Users\\ricar\\Documents\\Ricardo\\Programação\\Workspace\\banco\\src\\banco\\relatorios\\clientes.arq");
			ObjectInputStream obj = new ObjectInputStream(arq);
			App.clientes = (ArrayList<Cliente>)obj.readObject();
			

		} catch (Exception e) {
			System.err.println("[+] erro ao carregar arquivos de CLIENTES!!!");
		}
	}

	public static void carregarDadosConta(){
		try {

			FileInputStream arq = new FileInputStream("C:/Users/ricar/Documents/Ricardo/Programação/Workspace/banco/src/banco/relatorios/contas.arq");
			ObjectInputStream obj = new ObjectInputStream(arq);
			App.contas = (ArrayList<Conta>)obj.readObject();
			

		} catch (Exception e) {
			System.err.println("[+] erro ao carregar arquivos de CONTAS!!!");
		}
	}

	public static void carregarDadosGerente(){
		try {

			FileInputStream arq = new FileInputStream("C:/Users/ricar/Documents/Ricardo/Programação/Workspace/banco/src/banco/relatorios/gerentes.arq");
			ObjectInputStream obj = new ObjectInputStream(arq);
			App.gerentes = (ArrayList<Gerente>)obj.readObject();

		} catch (Exception e) {
			System.err.println("[+] erro ao carregar arquivos de GERENTES!!!");
		}
	}

}
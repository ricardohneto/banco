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
		menuPrincipal();
		Util.input.close();

	}

	public static void menuPrincipal(){
		int op = 0;
		boolean sair = false;

		do{

			System.out.print("\n\nMENU PRINCIPAL\n" + 
					"(1) - GERENCIAMENTO DE DADOS\n" + 
					"(2) - OPERA��ES BANCARIAS\n" + 
					"(3) - RELATORIOS\n" +
					"(0) - SAIR DO PROGRAMA\n" + 
					"=>");
			op = Util.input.nextInt();
			switch(op){
			case 0:
				System.out.println("\n[+] programa finalizado!!!");
				sair = true;
				break;
			case 1:
				gerenciarDados();
				break;
			case 2:
				OperacoesBancariasController.menu();
				break;
			case 3:
				RelatoriosController.menu();
				break;
			default:
				System.out.println("op��o invalida!!!");
				break;

			}

		}while(!sair);

	}

	//  [1.1] - gerenciarDados

	public static void gerenciarDados(){
		int op = 0;
		boolean sair = false;

		do {

			System.out.print("\n\nMENU DE GERENCIAMENTO DE DADOS\n" + 
					"(1) - Agencias\n" + 
					"(2) - Clientes\n" + 
					"(3) - Contas\n" + 
					"(4) - Gerentes\n" +
					"(0) - Voltar para o MENU PRINCIPAL\n" +
					"=>");
			op = Util.input.nextInt();
			switch(op){
			case 0:
				sair = true;
				break;
			case 1:
				AgenciaController.menu();
				break;
			case 2:
				ClienteController.menu();
				break;
			case 3:
				ContaController.menu();
				break;
			case 4:
				GerenteController.menu();
				break;
			default:
				System.out.println("op��o invalida");
				break;
			}

		}while(!sair);
	}
}

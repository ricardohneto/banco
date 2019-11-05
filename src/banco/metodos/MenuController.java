package banco.metodos;

import banco.classes.Util;

public class MenuController{

    public static void principal(){
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
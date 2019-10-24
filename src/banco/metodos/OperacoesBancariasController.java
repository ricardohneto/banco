package banco.metodos;

import banco.classes.Util;	

public class OperacoesBancariasController {

	public static void menu(){
		int op = 0;
		boolean sair = false;

		do{

			System.out.print("\n\nMENU DE OPERA��ES BANCARIAS\n" + 
					"(1) - VER SALDO\n" + 
					"(2) - DEPOSITAR\n" + 
					"(3) - SACAR\n" + 
					"(4) - TRANSFERIR\n" + 
					"(0) - VOLTAR\n=>");
			op = Util.input.nextInt();
			switch(op){
			case 0:
				sair = true;
				break;
			case 1:
				formVerSaldo();
				break;
			case 2:
				formDepositar();
				break;
			case 3:
				formSacar();
				break;
			case 4:
				formTransferir();
				break;
			default:
				System.out.println("[+] op��o invalida!!!");
				break;
			}

		}while(!sair);
	}    

	//  [1.2.1] - ver saldo

	public static void formVerSaldo(){
		int codConta = 0;

		System.out.println("[?] informe o CODIGO da sua CONTA");
		codConta = Util.input.nextInt();

		if(ContaController.existe(codConta)){
			double saldo = ContaController.getConta(codConta).getSaldo();
			System.out.println(saldo);
		}else{
			System.out.println("[+] conta n�o existe!!!");
		}
	}

	//  [1.2.2] - depositar

	public static void formDepositar(){
		double valor = 0;
		int codConta = 0;

		System.out.println("[?] informe o CODIGO da CONTA:");
		codConta = Util.input.nextInt();
		System.out.println("[?] informe o VALOR para DEPOSITAR:");
		valor = Util.input.nextDouble();

		if(ContaController.existe(codConta)){
			ContaController.getConta(codConta).depositar(valor);
			System.out.println("[+] dep�sito realizado com sucesso!!!");
		}else{
			System.out.println("[+] conta n�o existe!!!");
		}
	}

	//  [1.2.3] - sacar

	public static void formSacar(){
		double valor = 0; 
		int codConta = 0;

		System.out.println("[?] informe o CODIGO da CONTA:");
		codConta = Util.input.nextInt();
		System.out.println("[?] informe o VALOR para SACAR:");
		valor = Util.input.nextDouble();

		if(ContaController.existe(codConta)){
			if(ContaController.getConta(codConta).sacar(valor)) {
				System.out.println("[+] saque realizado !!!");
			}else {
				System.out.println("[+] erro ao sacar !!!");
			}
		}else{
			System.out.println("[+] conta n�o existe!!!");
		}
	}

	//  [1.2.4] - transferir

	public static void formTransferir(){
		double valor = 0;
		int codConta = 0;
		int codConta2 = 0;

		System.out.println("[?] informe o CODIGO de SUA CONTA:");
		codConta = Util.input.nextInt();
		System.out.println("[?] informe o CODIGO da CONTA para TRANSFERIR:");
		codConta2 = Util.input.nextInt();
		System.out.println("[?] informe o VALOR para TRANSFERIR:");
		valor = Util.input.nextDouble();

		if(ContaController.existe(codConta)){
			if(ContaController.existe(codConta2)){ 
				if(ContaController.getConta(codConta).transferir(valor, ContaController.getConta(codConta2))){
					System.out.println("[+] transferencia realizada com sucesso !!!");
				}else {
					System.out.println("[+] erro ao transferir !!!");
				}
			}
		}else{
			System.out.println("[+] conta n�o existe!!!");
		}
	}
}

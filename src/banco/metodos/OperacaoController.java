package banco.metodos;

import banco.app.App;
import banco.classes.Conta;
import banco.classes.ContaCorrente;
import banco.classes.ContaPoupanca;
import banco.classes.Saque;
import banco.classes.Tarifacao;
import banco.classes.Deposito;
import banco.classes.Operacao;
import banco.classes.Rendimento;
import banco.classes.Transferencia;
import banco.classes.Util;

public class OperacaoController {

	public static void menu() {
		int op = 0;
		boolean sair = false;

		do {

			System.out.print("\n\nMENU DE OPERA��ES BANCARIAS\n" + "(1) - VER SALDO\n" + "(2) - DEPOSITAR\n"
					+ "(3) - SACAR\n" + "(4) - TRANSFERIR\n" + "(5) - VER EXTRATO\n" + "(0) - VOLTAR\n=>");
			op = Util.input.nextInt();
			switch (op) {
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
			case 5:
				formVerExtrato();
			case 6:
				formViraMes();
			default:
				System.out.println("[+] op��o invalida!!!");
				break;
			}

		} while (!sair);
	}

	// [1.2.1] - ver saldo

	public static void formVerSaldo() {
		int codConta = 0;

		System.out.println("[?] informe o CODIGO da sua CONTA");
		codConta = Util.input.nextInt();

		if (ContaController.existe(codConta)) {
			double saldo = ContaController.getConta(codConta).getSaldo();
			System.out.println(saldo);
		} else {
			System.out.println("[+] conta n�o existe!!!");
		}
	}

	// [1.2.2] - depositar

	public static void formDepositar() {

		System.out.println("[?] informe o CODIGO da CONTA:");
		int codConta = Util.input.nextInt();
		System.out.println("[?] informe o VALOR para DEPOSITAR:");
		double valor = Util.input.nextDouble();

		if (ContaController.existe(codConta)) {
			Conta contaAux = ContaController.getConta(codConta);
			Operacao deposito = new Deposito(contaAux, valor);

			if (deposito.efetuar()) {
				System.out.println("[+] DEPOSITO realizado com SUCESSO!");
			} else {
				System.out.println("[+] falha ao DEPOSITAR!!!");
			}
		} else {
			System.out.println("[+] conta n�o existe!!!");
		}
	}

	// [1.2.3] - sacar

	public static void formSacar() {
		double valor = 0;
		int codConta = 0;
		Conta contaAux = null;

		System.out.println("[?] informe o CODIGO da CONTA:");
		codConta = Util.input.nextInt();
		System.out.println("[?] informe o VALOR para SACAR:");
		valor = Util.input.nextDouble();

		if (ContaController.existe(codConta)) {
			contaAux = ContaController.getConta(codConta);
			Operacao saque = new Saque(contaAux, valor);

			if (saque.efetuar()) {
				System.out.println("[+] SAQUE realizado com SUCESSO!");
			} else {
				System.out.println("[+] falha ao SACAR!!!");
			}
		} else {
			System.out.println("[+] conta n�o existe!!!");
		}
	}

	// [1.2.4] - transferir

	public static void formTransferir() {
		double valor = 0;
		int codConta = 0;
		Conta contaOrigem = null;
		int codConta2 = 0;
		Conta contaDestino = null;

		System.out.println("[?] informe o CODIGO de SUA CONTA:");
		codConta = Util.input.nextInt();
		System.out.println("[?] informe o CODIGO da CONTA para TRANSFERIR:");
		codConta2 = Util.input.nextInt();
		System.out.println("[?] informe o VALOR para TRANSFERIR:");
		valor = Util.input.nextDouble();

		if (ContaController.existe(codConta)) {
			if (ContaController.existe(codConta2)) {
				contaOrigem = ContaController.getConta(codConta);
				contaDestino = ContaController.getConta(codConta2);
				Operacao transferencia = new Transferencia(contaOrigem, contaDestino, valor);

				if (transferencia.efetuar()) {
					System.out.println("[+] TRANSFERENCIA realizada com SUCESSO!");
				} else {
					System.out.println("[+] falha ao SACAR!!!");
				}
			}
		} else {
			System.out.println("[+] conta n�o existe!!!");
		}
	}

	public static void formVerExtrato() {
		int codConta = 0;

		System.out.println("[?] informe o CODIGO da sua CONTA");
		codConta = Util.input.nextInt();

		if (ContaController.existe(codConta)) {
			String extrato = ContaController.getConta(codConta).extrato();
			System.out.println(extrato);
		} else {
			System.out.println("[+] conta n�o existe!!!");
		}
	}

	public static void formViraMes(){
		Operacao viraMes = null;

		ContaCorrente contaCorrente = null;
		ContaPoupanca contaPoupanca = null;

		App.itContas = App.contas.iterator();

		while(App.itContas.hasNext()){
			if(App.itContas.next() instanceof ContaCorrente){
				contaCorrente = (ContaCorrente) App.itContas.next();
				viraMes = new Tarifacao(contaCorrente);
				viraMes.efetuar();
			}else{
				if(App.itContas.next() instanceof ContaPoupanca){
					contaPoupanca = (ContaPoupanca) App.itContas.next();
					viraMes = new Rendimento(contaPoupanca);
					viraMes.efetuar();
				}
			}	
		}
	}
}



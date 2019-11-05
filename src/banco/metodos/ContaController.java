package banco.metodos;

import banco.app.App;
import banco.classes.Agencia;
import banco.classes.Cliente;
import banco.classes.Conta;
import banco.classes.ContaCorrente;
import banco.classes.ContaPoupanca;
import banco.classes.Util;

public class ContaController {

	public static void menu(){
		int op = 0;
		boolean sair = false;

		do{

			System.out.println("\n\nMENU DE CONTA");
			Util.exibeCRUD();
			op = Util.input.nextInt();
			switch(op){
			case 0:
				sair = true;
				break;
			case 1:
				formCadastrar();
				break;
			case 2:
				formExcluir();
				break;
			case 3:
				formConsultar();         
				break;
			case 4:
				formAlterar();
				break;
			default:
				System.out.println("\n[+] informe uma op��o valida!!!");
				break;
			}
		}while(!sair);
	}

	public static void formCadastrar(){
		boolean control = false;
		double saldo = 0;
		String cpfCliente = "";
		int codAgencia = 0;
		int tipo = 0;

		double limite = 0;
		double juros = 0;
		double tarifa = 0;

		double rendimento = 0;

		System.out.print("[?] informe o CPF do seu CLIENTE:\n=>");
		cpfCliente = Util.input.next();
		System.out.print("[?] informe o CODIGO da AGENCIA:\n=>");
		codAgencia = Util.input.nextInt();
		System.out.print("[?] informe o SALDO INICIAL da CONTA:\n=>");
		saldo = Util.input.nextDouble();
		System.out.print("[?] informe o TIPO da CONTA:\n(1) - Conta Corrente\n(2) - Conta Poupan�a\n=>");
		tipo = Util.input.nextInt();

		if(tipo == 1) {

			System.out.print("[?] informe o LIMITE INICIAL da CONTA:\n=>");
			limite = Util.input.nextDouble();
			System.out.print("[?] informe o JUROS INICIAL da CONTA:\n=>");
			juros = Util.input.nextDouble();
			System.out.print("[?] informe a TARIFA INICIAL da CONTA:\n=>");
			tarifa = Util.input.nextDouble();

			control = cadastrarContaCorrente(saldo, limite, juros, tarifa, cpfCliente, codAgencia);
		}else {
			if(tipo == 2) {

				System.out.print("[?] informe o RENDIMENTO INICIAL da CONTA:\n=>");
				rendimento = Util.input.nextDouble();

				control = cadastrarContaPoupanca(saldo, rendimento, cpfCliente, codAgencia);
			}else {
				System.out.println("tipo de conta incorreta! vacilou...");
			}
		}

		if(control){
			System.out.println("\n[+] conta cadastrada com sucesso!!!");
		}else{
			System.out.println("\n[+] erro ao cadastrar!!!");
		}
	}

	public static boolean cadastrarContaCorrente(double saldo, double limite, double juros, double tarifa, String cpfCliente, int codAgencia){
		boolean cadastrado = false;

		if(ClienteController.existe(cpfCliente)){
			if(AgenciaController.existe(codAgencia)){  
				Agencia agenciaAux = AgenciaController.getAgencia(codAgencia);
				Conta contaAux = new ContaCorrente(saldo, ClienteController.getCliente(cpfCliente), agenciaAux, limite, juros, tarifa);
				App.contas.add(contaAux);
				agenciaAux.getContas().add(contaAux);
				cadastrado = true;
			}            
		}          

		return cadastrado;
	}

	public static boolean cadastrarContaPoupanca(double saldo, double rendimento, String cpfCliente, int codAgencia){
		boolean cadastrado = false;

		if(ClienteController.existe(cpfCliente)){
			if(AgenciaController.existe(codAgencia)){
				Agencia agenciaAux = AgenciaController.getAgencia(codAgencia);  
				Conta contaAux = new ContaPoupanca(saldo, ClienteController.getCliente(cpfCliente), agenciaAux, rendimento);
				App.contas.add(contaAux);
				agenciaAux.getContas().add(contaAux);
				cadastrado = true;
			}            
		}          

		return cadastrado;
	}

	public static void formExcluir(){
		int codConta = 0;
		Conta contaAux = null; 
		Cliente clienteAux = null;
		Agencia agenciaAux = null;

		contaAux = formConsultar();
		contaAux = excluir(codConta, contaAux, clienteAux, agenciaAux);
		if(contaAux == null){
			System.out.println("\n[+] conta n�o existe ou cliente/agencia vinculado,\nDICA: consulte antes de excluir");
		}else{
			System.out.println("\n[+] EXCLUIDA COM SUCESSO:\n" + contaAux.toString());
		}
	}

	public static Conta excluir(int codConta, Conta contaAux, Cliente clienteAux, Agencia agenciaAux){
		if(contaAux != null){
			if(contaAux.getAgencia() == null && contaAux.getCliente() == null){
				App.contas.remove(contaAux);
				agenciaAux.getContas().remove(contaAux);
			}else{
				contaAux = null;
			}
		}else{
			contaAux = null;
		}
		return contaAux;
	}

	public static Conta formConsultar(){
		int codConta = 0; 
		Conta contaAux = null;

		System.out.print("[?] informe o IDENTIFICADOR da CONTA:\n=>");
		codConta = Util.input.nextInt();

		contaAux = consultar(codConta);
		if(contaAux == null){
			System.out.println("\n[+] conta n�o existe!!!");
		}else{
			System.out.println(contaAux.toString());
		}
		return contaAux;
	}

	public static Conta consultar(int codConta){

		if(existe(codConta)){
			return getConta(codConta);
		}

		return null;
	}

	public static void formAlterar(){
		boolean control = false;
		double saldo = 0;
		double limite = 0;
		String cpfCliente = "";
		int codAgencia = 0;
		Cliente clienteAux = null; 
		Agencia agenciaAux = null;
		Conta contaAux = null;


		contaAux = formConsultar();
		if(contaAux != null) {
			System.out.print("[?] informe o NOVO SALDO:\n=>");
			saldo = Util.input.nextDouble();
			System.out.print("[?] informe o NOVO LIMITE:\n=>");
			limite = Util.input.nextDouble();
			System.out.print("[?] informe o CPF do NOVO CLIENTE:\n=>");
			cpfCliente = Util.input.next();
			System.out.print("[?] informe o CODIGO da NOVA AGENCIA:\n=>");
			codAgencia = Util.input.nextInt();

			control = alterar(saldo, limite, cpfCliente, codAgencia, clienteAux, agenciaAux, contaAux);
			if(control){
				System.out.println("\n[+] agencia alterada com sucesso!!!");
			}else{
				System.out.println("\n[+] erro ao alterar!!!");
			}
		}else {
			System.out.println("\n[+] conta n�o existe!!!");
		}
	}
	
	public static boolean alterar(double saldo, double limite, String cpfCliente, int codAgencia, Cliente clienteAux, Agencia agenciaAux, Conta contaAux){
		boolean alterado = false;

		if(contaAux != null){
			if(ClienteController.existe(cpfCliente)){
				if(AgenciaController.existe(codAgencia)){  
					contaAux.setSaldo(saldo);
					contaAux.setCliente(ClienteController.getCliente(cpfCliente));
					contaAux.setAgencia(AgenciaController.getAgencia(codAgencia));
					alterado = true;

				}            
			}           
		}

		return alterado;
	}

	public static boolean existe(int codConta) {
		Conta contaAux = null;
		boolean existe = false;

		App.itContas = App.contas.iterator();

		while(App.itContas.hasNext() && !existe){
			contaAux = (Conta) App.itContas.next();
			existe = contaAux.getCodConta() == codConta;
		}

		return existe;
	}

	public static Conta getConta(int codConta) {
		Conta contaAux = null;
		boolean existe = false;

		App.itContas = App.contas.iterator();

		while(App.itContas.hasNext() && !existe){
			contaAux = (Conta) App.itContas.next();
			existe = contaAux.getCodConta() == codConta;
		}

		if(existe) {
			return contaAux;
		}

		return null;
	}

}

package banco.metodos;

import banco.app.App;
import banco.classes.Cliente;
import banco.classes.Util;

public class ClienteController {

	public static void menu(){
		int op = 0;
		boolean sair = false;

		do {

			System.out.println("\n\nMENU DO CLIENTE");
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
			}

		}while(!sair);
	}

	public static void formCadastrar(){

		System.out.print("[?] informe o NOME do CLIENTE:\n=>");
		String nome = Util.input.next();
		System.out.print("[?] informe o TELEFONE:\n=>");
		String telefone = Util.input.next();
		System.out.print("[?] informe o CPF:\n=>");
		String cpf = Util.input.next();

		if(cadastrar(nome, cpf, telefone)) {
			System.out.println("\n[+] cliente cadastrado com sucesso!!!");
		}else{
			System.out.println("[+] erro ao cadastrar!!!");
		}
	}

	public static boolean cadastrar(String nome, String cpf, String telefone){
		boolean cadastrado = false;

		if(existe(cpf)){
			System.out.println("\n[+] cpf ja existe!!!");
		}else{
			App.clientes.add(new Cliente(nome, cpf, telefone));
			cadastrado = true;
		}

		return cadastrado;
	}

	public static void formExcluir(){
		Cliente clienteAux = null;

		clienteAux = formConsultar();
		if(clienteAux != null) {
			clienteAux = excluir(clienteAux);
			System.out.println("\n[+] EXCLUIDO COM SUCESSO:\n" + clienteAux.toString());
		}else {
			System.out.println("\n[+] cliente n�o existe");
		}
	}

	public static Cliente excluir(Cliente clienteAux){		
		if(App.clientes.remove(clienteAux)){
			return clienteAux;
		}
		return null;
	}

	public static Cliente formConsultar(){

		Cliente clienteAux = null;

		System.out.print("[?] informe o CPF do CLIENTE:\n=>");
		String cpf = Util.input.next();

		clienteAux = consultar(cpf);

		if(clienteAux == null){
			System.out.println("\n[+] cliente n�o existe!!!");
		}else{
			System.out.println(clienteAux.toString());
		}
		return clienteAux;
	}

	public static Cliente consultar(String cpf){

		if(existe(cpf)){
			return getCliente(cpf);
		}

		return null;
	}

	public static void formAlterar(){
		Cliente clienteAux = null;

		clienteAux = formConsultar();
		if(clienteAux != null) {

			System.out.print("[?] informe o NOVO NOME:\n=>");
			String nome = Util.input.next();
			System.out.print("[?] informe o NOVO TELEFONE:\n=>");
			String telefone = Util.input.next();
			System.out.print("[?] informe o NOVO CPF:\n=>");
			String cpf = Util.input.next();

			if(alterar(nome, telefone, cpf, clienteAux)) {
				System.out.println("\n[+] cliente alterado com sucesso!!!");
			}else {
				System.out.println("\n[+] erro ao alterar!!!");
			}
		}else {
			System.out.println("\n[+]cliente n�o existe!!!");
		}
	}

	public static boolean alterar(String nome, String telefone, String cpf, Cliente clienteAux){
		boolean alterado = false;

		if(existe(cpf)){
			System.out.println("\n[+] cpf ja existe!!!");
		}else {
			clienteAux.setNome(nome);
			clienteAux.setCpf(cpf);
			clienteAux.setTelefone(telefone);
			alterado = true;

		}

		return alterado;
	}

	public static boolean existe(String cpf) {
		Cliente clienteAux = null;
		boolean existe = false;

		App.itClientes = App.clientes.iterator();

		while(App.itClientes.hasNext() && !existe){
			clienteAux = (Cliente) App.itClientes.next();
			existe = clienteAux.getCpf().equals(cpf);
		}

		return existe;
	}

	public static Cliente getCliente(String cpf) {
		Cliente clienteAux = null;
		boolean existe = false;

		App.itClientes = App.clientes.iterator();

		while(App.itClientes.hasNext() && !existe){
			clienteAux = (Cliente) App.itClientes.next();
			existe = clienteAux.getCpf().equals(cpf);
		}

		if(existe) {
			return clienteAux;
		}

		return null;
	}

}

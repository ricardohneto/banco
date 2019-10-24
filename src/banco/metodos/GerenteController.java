package banco.metodos;

import banco.app.App;
import banco.classes.Gerente;
import banco.classes.Util;

public class GerenteController {

	public static void menu(){
		int op = 0;
		boolean sair = false;

		do {

			System.out.println("\n\nMENU DO GERENTE");
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

		System.out.print("[?] informe o NOME do GERENTE:\n=>");
		String nome = Util.input.next();
		System.out.print("[?] informe o TELEFONE:\n=>");
		String telefone = Util.input.next();
		System.out.print("[?] informe o CPF:\n=>");
		String cpf = Util.input.next();
		System.out.print("[?] informe o SALARIO:\n=>");
		double salario = Util.input.nextDouble();

		if(cadastrar(nome, cpf, telefone, salario)){
			System.out.println("\n[+] gerente cadastrado com sucesso!!!");
		}else{
			System.out.println("\n[+] erro ao cadastrar!!!");
		}
	}

	public static boolean cadastrar(String nome, String telefone, String cpf, double salario){
		boolean cadastrado = false;

		if(existe(cpf)){
			System.out.println("\n[+] cpf ja existe!!!");
		}else{
			App.gerentes.add(new Gerente(nome, telefone, cpf, salario));
			cadastrado = true;
		}

		return cadastrado;
	}

	public static void formExcluir(){
		Gerente gerenteAux = null;

		gerenteAux = formConsultar();
		if(gerenteAux != null) {
			gerenteAux = excluir(gerenteAux);
			System.out.println("\n[+] EXCLUIDO COM SUCESSO:\n" + gerenteAux.toString());
		}else {
			System.out.println("\n[+] gerente n�o existe");
		}
	}

	public static Gerente excluir(Gerente gerenteAux){
		if(App.gerentes.remove(gerenteAux)){
			return gerenteAux;
		}
		return null;
	}

	public static Gerente formConsultar(){

		Gerente gerenteAux = null;

		System.out.print("[?] informe o CPF do GERENTE:\n=>");
		String cpf = Util.input.next();

		gerenteAux = consultar(cpf);

		if(gerenteAux == null){
			System.out.println("\n[+] gerente n�o existe!!!");
		}else{
			System.out.println(gerenteAux.toString());
		}
		return gerenteAux;
	}

	public static Gerente consultar(String cpf){

		if(existe(cpf)){
			return getGerente(cpf);
		}

		return null;
	}

	public static void formAlterar(){
		Gerente gerenteAux = null;

		gerenteAux = formConsultar();
		if(gerenteAux != null) {

			System.out.print("[?] informe o NOVO NOME:\n=>");
			String nome = Util.input.next();
			System.out.print("[?] informe o NOVO TELEFONE:\n=>");
			String telefone = Util.input.next();
			System.out.print("[?] informe o NOVO CPF:\n=>");
			String cpf = Util.input.next();
			System.out.print("[?] informe o NOVO SALARIO:\n=>");
			double salario = Util.input.nextDouble();

			if(alterar(nome, telefone, cpf, salario, gerenteAux)) {
				System.out.println("\n[+] gerente alterado com sucesso!!!");
			}else {
				System.out.println("\n[+] erro ao alterar!!!");
			}
		}else {
			System.out.println("\n[+] gerente n�o existe!!!");
		}
	}

	public static boolean alterar(String nome, String telefone, String cpf, double salario, Gerente gerenteAux){
		boolean alterado = false;

		if(existe(cpf)){
			System.out.println("\n[+] cpf ja existe!!!");
		}else {
			gerenteAux.setNome(nome);
			gerenteAux.setCpf(cpf);
			gerenteAux.setTelefone(telefone);
			gerenteAux.setSalario(salario);
			alterado = true;
		}
		return alterado;
	}

	public static boolean existe(String cpf) {
		Gerente gerenteAux = null;
		boolean existe = false;

		App.itGerentes = App.gerentes.iterator();

		while(App.itGerentes.hasNext() && !existe){
			gerenteAux = (Gerente) App.itGerentes.next();
			existe = gerenteAux.getCpf().equals(cpf);
		}

		return existe;
	}

	public static Gerente getGerente(String cpf) {
		Gerente gerenteAux = null;
		boolean existe = false;

		App.itGerentes = App.gerentes.iterator();

		while(App.itGerentes.hasNext() && !existe){
			gerenteAux = (Gerente) App.itGerentes.next();
			existe = gerenteAux.getCpf().equals(cpf);
		}

		if(existe) {
			return gerenteAux;
		}

		return null;
	}

}

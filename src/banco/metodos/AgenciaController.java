package banco.metodos;

import banco.app.App;
import banco.classes.Agencia;
import banco.classes.Gerente;
import banco.classes.Util;

public class AgenciaController {

	public static void menu(){
		int op = 0;
		boolean sair = false;

		do{

			System.out.println("\n\nMENU DE AGENCIA");
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

		System.out.print("[?] informe o NOME da AGENCIA:\n=>");
		String nome = Util.input.next();
		System.out.print("[?] informe o CPF de seu GERENTE:\n=>");
		String cpfGerente = Util.input.next();

		if(cadastrar(nome, cpfGerente)){
			System.out.println("\n[+] agencia cadastrada com sucesso!!!");
		}else{
			System.out.println("\n[+] erro ao cadastrar!!!");
		}
	}

	public static boolean cadastrar(String nome, String cpfGerente){
		boolean cadastrado = false;

		if(GerenteController.existe(cpfGerente)) {
			App.agencias.add(new Agencia(nome, GerenteController.getGerente(cpfGerente)));
			cadastrado = true;
		}

		return cadastrado;
	}

	public static void formExcluir(){
		Agencia agenciaAux = null;
		Gerente gerenteAux = null;

		agenciaAux = formConsultar();
		agenciaAux = excluir(agenciaAux, gerenteAux);
		if(agenciaAux == null){
			System.out.println("\n[+] agencia n�o existe ou gerente ou contas vinculado,\nDICA: consulte antes de excluir");
		}else{
			System.out.println("\n[+] EXCLUIDA COM SUCESSO:\n" + agenciaAux.toString());
		}
	}

	public static Agencia excluir(Agencia agenciaAux, Gerente gerenteAux){
		if(agenciaAux != null){
			if(agenciaAux.getGerente() == null){
				if(agenciaAux.getContas().isEmpty()) {
					App.agencias.remove(agenciaAux);
				}
			}else{
				agenciaAux = null;
			}
		}else{
			agenciaAux = null;
		}
		return agenciaAux;
	}

	public static Agencia formConsultar(){

		Agencia agenciaAux = null;

		System.out.print("[?] informe o CODIGO da AGENCIA:\n=>");
		int codAgencia = Util.input.nextInt();

		agenciaAux = consultar(codAgencia);

		if(agenciaAux == null){
			System.out.println("\n[+] agencia n�o existe!!!");
		}else{
			System.out.println(agenciaAux.toString());
		}
		return agenciaAux;
	}

	public static Agencia consultar(int codAgencia){

		if(existe(codAgencia)){
			return getAgencia(codAgencia);
		}

		return null;
	}

	public static void formAlterar(){
		Agencia agenciaAux = null;
		Gerente gerenteAux = null;

		agenciaAux = formConsultar();
		if(agenciaAux != null) {

			System.out.print("[?] informe o NOVO NOME:\n=>");
			String nome = Util.input.next();
			System.out.print("[?] informe a MATRICULA do NOVO GERENTE:\n=>");
			String cpfGerente = Util.input.next();

			if(alterar(nome, cpfGerente, agenciaAux, gerenteAux)){
				System.out.println("\n[+] agencia alterada com sucesso!!!");
			}else{
				System.out.println("\n[+] erro ao alterar!!!");
			}
		}else {
			System.out.println("\n[+] agencia n�o existe!!!");
		}
	}

	public static boolean alterar(String nome, String cpfGerente, Agencia agenciaAux, Gerente gerenteAux){
		boolean alterado = false;

		if(GerenteController.existe(cpfGerente)){
			GerenteController.getGerente(cpfGerente);
			agenciaAux.setNome(nome);
			agenciaAux.setGerente(gerenteAux);
			alterado = true;
		}

		return alterado;
	}

	public static boolean existe(int codAgencia) {
		Agencia agenciaAux = null;
		boolean existe = false;

		App.itAgencias = App.agencias.iterator();

		while(App.itAgencias.hasNext() && !existe){
			agenciaAux = (Agencia) App.itAgencias.next();
			existe = agenciaAux.getCodAgencia() == codAgencia;
		}

		return existe;
	}

	public static Agencia getAgencia(int codAgencia) {
		Agencia agenciaAux = null;
		boolean existe = false;

		App.itAgencias = App.agencias.iterator();

		while(App.itAgencias.hasNext() && !existe){
			agenciaAux = (Agencia) App.itAgencias.next();
			existe = agenciaAux.getCodAgencia() == codAgencia;
		}

		if(existe) {
			return agenciaAux;
		}

		return null;
	}	

}

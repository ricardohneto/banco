package banco.classes;

import java.util.Scanner;

public class Util {
	
	public static Scanner input = new Scanner(System.in);

	public static void exibeCRUD(){
        System.out.print("(1) - Cadastrar\n" +
        "(2) - Excluir\n" +
        "(3) - Consultar\n" +
        "(4) - Alterar\n" +
        "(0) - Voltar para o GERENCIAR DADOS\n" +
        "=>");
    }
	
}

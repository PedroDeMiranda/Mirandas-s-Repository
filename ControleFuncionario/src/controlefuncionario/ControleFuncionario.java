package controlefuncionario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleFuncionario {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Instanciando classes
		Departamento dep1 = new Departamento();
		
		//Loop do Menu de ações
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		while (opcao != 6) {
            System.out.println("\nMenu de Gerenciamento de Departamentos:");
            System.out.println("1 - Inserir um Departamento");
            System.out.println("2 - Listar Departamentos");
            System.out.println("3 - Consultar um Departamento");
            System.out.println("4 - Alterar um Departamento");
            System.out.println("5 - Deletar um Departamento");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            System.out.println("\n");
			
			switch (opcao) {
			case 1: {
				//Inserir um Departamento				
				System.out.println("Informe o departamento");
				dep1.setDescDepto(sc.next());
				if (dep1.incluirDepartamento()) {
					System.out.println("Inclusão de departamento efetuada com sucesso");
				} else {
					System.out.println("Ocorreram erros na inclusão do departamento");
				}
				break;
			}
			case 2: {
				//Listar departamentos
				List<Departamento> lista = new ArrayList<>();
				lista = dep1.listarDeptos();
				for (Departamento d : lista) {
					System.out.println("Departamento: "+ d.getIdDepto() + " - " + d.getDescDepto());
				}				
				break;
			}
			case 3: {
				//Consultar um departamento
				break;
			}
			case 4: {
				//Alterar um departamento
				break;
			}
			case 5: {
				//Deletar um departamento
				
				break;
			}
			case 6: {
				//Sair
				System.out.println("Saindo ... ");
				System.exit(0);
				break;
			}
			default:
				System.out.println("Valor inesperdo: " + opcao);
			}
			
			
			}
				
		}
	}
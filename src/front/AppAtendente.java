package front;

import entidades.Atendente;
import persistencia.AtendentePersistencia;

public class AppAtendente {
	public AppAtendente() {
		int opc;
		do {
			System.out.println("\n\n");
			System.out.println("*** Atendente ***");
			System.out.println("1 - Cadastrar atendente");
			System.out.println("2 - Listar atendentes");
			System.out.println("3 - Consultar atendentes");
			System.out.println("4 - Alterar atendente");
			System.out.println("5 - Excluir atendente");
			System.out.println("6 - Voltar");
			opc = Console.readInt("Opção: ");
			switch (opc) {
				case 1:
					incluirAtendente();
					break;
				case 2:
					listarAtendente();
					break;
				case 3:
					consultarAtendente();
					break;
				case 4:
					alterarAtendente();
					break;
				case 5:
					excluirAtendente();
					break;
			}
		} while (opc != 6);
	}

	private static void incluirAtendente() {
		System.out.println("\n\n*** INCLUSÃO DE FUNCIONARIOS ***");
		Atendente objAtendente = new Atendente();
		if (AtendentePersistencia.procurarPorNome(objAtendente) == null) {
			objAtendente.setNome(Console.readString("Informe o nome do atendente: "));
			AtendentePersistencia.incluir(objAtendente);
			System.out.println("\n\nAtendente cadastrado...");
		} else {
			System.out.println("\n\nEsse atendente já foi cadastrado...");
		}
	}

	private static void listarAtendente() {
		System.out.println("\n\n*** LISTAGEM DE FUNCIONARIOS ***");
		Atendente objAtendente = new Atendente();
		objAtendente.setNome(Console.readString("Informe uma parte do nome que deseja listar: "));
		for (Atendente item : AtendentePersistencia.getAtendentes(objAtendente)) {
			System.out.println("ID: " + item.getId());
			System.out.println("Nome: " + item.getNome());
			System.out.println("-------------------------------");
		}

	}

	private static void consultarAtendente() {
		System.out.println("\n\n*** CONSULTA DE ATENDENTE ***");
		Atendente objAtendente = new Atendente();
		objAtendente.setNome(Console.readString("Informe o nome a ser consultado: "));
		objAtendente = AtendentePersistencia.procurarPorNome(objAtendente);
		if (objAtendente != null) {
			System.out.println("-------------------------------");
			System.out.println("ID: " + objAtendente.getId());
			System.out.println("Nome: " + objAtendente.getNome());
			System.out.println("-----------------------");
		} else {
			System.out.println("\n\nAtendente não encontrado...");
		}
	}

	private static void alterarAtendente() {
		System.out.println("\n\n*** ALTERAÇÃO DE ATENDENTE ***");
		Atendente objAtendente = new Atendente();
		objAtendente.setNome(Console.readString("Informe o nome a ser consultado: "));
		objAtendente = AtendentePersistencia.procurarPorNome(objAtendente);
		if (objAtendente != null) {
			System.out.println("\n\n-----------------------");
			System.out.println("ID: " + objAtendente.getId());
			System.out.println("Nome: " + objAtendente.getNome());
			System.out.println("-----------------------");
			String resp = Console.readString("\n\nQuer alterar os dados desse atendente? ");
			if (resp.equals("S")) {
				objAtendente.setNome(Console.readString("Informe um novo nome para o atendente: "));
				if (AtendentePersistencia.alterar(objAtendente) == true) {
					System.out.println("\n\nA alteração foi realizada...");
				} else {
					System.out.println("\n\nA alteração não pôde ser realizada no momento...");
				}
			}
		} else {
			System.out.println("\n\nAtendente não encontrado...");
		}
	}

	private static void excluirAtendente() {
		System.out.println("\n\n*** EXCLUSÃO DE ATENDENTE ***");
		Atendente objAtendente = new Atendente();
		objAtendente.setNome(Console.readString("Informe o nome a ser consultado: "));
		objAtendente = AtendentePersistencia.procurarPorNome(objAtendente);
		if (objAtendente != null) {
			System.out.println("\n\n-----------------------");
			System.out.println("ID: " + objAtendente.getId());
			System.out.println("Nome: " + objAtendente.getNome());
			System.out.println("-----------------------");
			String resp = Console.readString("\n\nQuer excluir esse atendente? ");
			if (resp.equals("S")) {
				if (AtendentePersistencia.excluir(objAtendente) == true) {
					System.out.println("\n\nA exclusão foi realizada...");
				} else {
					System.out.println("\n\nA exclusão não pôde ser realizada no momento...");
				}
			}
		} else {
			System.out.println("\n\nAtendente não encontrado...");
		}
	}
}

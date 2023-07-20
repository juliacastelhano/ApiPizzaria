package front;

import entidades.Cliente;
import persistencia.ClientePersistencia;

public class AppCliente {
	public AppCliente() {
		int opc;
		do {
			System.out.println("\n\n");
			System.out.println("*** CLIENTES ***");
			System.out.println("1 - Novo cliente");
			System.out.println("2 - Listar clientes");
			System.out.println("3 - Consultar cliente");
			System.out.println("4 - Alterar cliente");
			System.out.println("5 - Excluir cliente");
			System.out.println("6 - Voltar");
			opc = Console.readInt("Opção: ");
			switch (opc) {
				case 1:
					incluirCliente();
					break;
				case 2:
					listarClientes();
					break;
				case 3:
					consultarClientes();
					break;
				case 4:
					alterarClientes();
					break;
				case 5:
					excluirClientes();
					break;
			}
		} while (opc != 6);
	}

	private static void incluirCliente() {
		System.out.println("\n\n*** INCLUSÃO DE CLIENTES ***");
		Cliente objCliente = new Cliente();
		objCliente.setNome(Console.readString("\n\nInforme o nome do cliente: "));
		if (ClientePersistencia.procurarPorNome(objCliente) == null) {
			objCliente.setTelefone(Console.readString("Informe o telefone do cliente: "));
			objCliente.setEndereco(Console.readString("Informe o endereço do cliente: "));
			ClientePersistencia.incluir(objCliente);
			System.out.println("\n\nCliente cadastrado...");
		} else {
			System.out.println("\n\nEsse cliente já foi cadastrado...");
		}
	}

	private static void listarClientes() {
		System.out.println("\n\n*** LISTAGEM DE CLIENTES ***");
		Cliente objCliente = new Cliente();
		objCliente.setNome(Console.readString("Informe uma parte do nome que deseja listar: "));
		for (Cliente item : ClientePersistencia.getClientes(objCliente)) {
			System.out.println("ID: " + item.getId());
			System.out.println("Nome: " + item.getNome());
			System.out.println("Telefone:  " + item.getTelefone());
			System.out.println("Endereço: " + item.getEndereco());
			System.out.println("-------------------------------");
		}

	}

	private static void consultarClientes() {
		System.out.println("\n\n*** CONSULTA DE CLIENTES ***");
		Cliente objCliente = new Cliente();
		objCliente.setNome(Console.readString("Informe o nome a ser consultado: "));
		objCliente = ClientePersistencia.procurarPorNome(objCliente);
		if (objCliente != null) {
			System.out.println("-------------------------------");
			System.out.println("ID: " + objCliente.getId());
			System.out.println("Nome: " + objCliente.getNome());
			System.out.println("Telefone:  " + objCliente.getTelefone());
			System.out.println("Endereço: " + objCliente.getEndereco());
			System.out.println("-----------------------");
		} else {
			System.out.println("\n\nCliente não encontrado...");
		}
	}

	private static void alterarClientes() {
		System.out.println("\n\n*** ALTERAÇÃO DE CLIENTES ***");
		Cliente objCliente = new Cliente();
		objCliente.setNome(Console.readString("Informe o nome a ser consultado: "));
		objCliente = ClientePersistencia.procurarPorNome(objCliente);
		if (objCliente != null) {
			System.out.println("\n\n-----------------------");
			System.out.println("ID: " + objCliente.getId());
			System.out.println("Nome: " + objCliente.getNome());
			System.out.println("Telefone:  " + objCliente.getTelefone());
			System.out.println("-----------------------");
			String resp = Console.readString("\n\nQuer alterar os dados desse cliente? ");
			if (resp.equals("S")) {
				objCliente.setNome(Console.readString("Informe um novo nome para o cliente: "));
				if (ClientePersistencia.alterar(objCliente) == true) {
					System.out.println("\n\nA alteração foi realizada...");
				} else {
					System.out.println("\n\nA alteração não pôde ser realizada no momento...");
				}
			}
		} else {
			System.out.println("\n\nCliente não encontrado...");
		}
	}

	private static void excluirClientes() {
		System.out.println("\n\n*** EXCLUSÃO DE CLIENTES ***");
		Cliente objCliente = new Cliente();
		objCliente.setNome(Console.readString("Informe o nome a ser consultado: "));
		objCliente = ClientePersistencia.procurarPorNome(objCliente);
		if (objCliente != null) {
			System.out.println("\n\n-----------------------");
			System.out.println("ID: " + objCliente.getId());
			System.out.println("Nome: " + objCliente.getNome());
			System.out.println("Telefone:  " + objCliente.getTelefone());
			System.out.println("Endereço: " + objCliente.getEndereco());
			System.out.println("-----------------------");
			String resp = Console.readString("\n\nQuer excluir esse cliente? ");
			if (resp.equals("S")) {
				if (ClientePersistencia.excluir(objCliente) == true) {
					System.out.println("\n\nA exclusão foi realizada...");
				} else {
					System.out.println("\n\nA exclusão não pôde ser realizada no momento...");
				}
			}
		} else {
			System.out.println("\n\nCliente não encontrado...");
		}
	}
}

package front;

import entidades.Pizza;
import persistencia.PizzaPersistencia;

public class AppPizza {
	public AppPizza() {
		int opc;
		do {
			System.out.println("\n\n");
			System.out.println("*** CLIENTES ***");
			System.out.println("1 - Nova pizza");
			System.out.println("2 - Listar pizzas");
			System.out.println("3 - Consultar pizzas");
			System.out.println("4 - Alterar pizza");
			System.out.println("5 - Excluir pizza");
			System.out.println("6 - Voltar");
			opc = Console.readInt("Opção: ");
			switch (opc) {
				case 1:
					incluirPizza();
					break;
				case 2:
					listarPizzas();
					break;
				case 3:
					consultarPizzas();
					break;
				case 4:
					alterarPizzas();
					break;
				case 5:
					excluirPizzas();
					break;
			}
		} while (opc != 6);
	}

	private static void incluirPizza() {
		System.out.println("\n\n*** INCLUSÃO DE PIZZAS ***");
		Pizza objPizza = new Pizza();
		if (PizzaPersistencia.procurarPorSabor(objPizza) == null) {
			objPizza.setSabor(Console.readString("Informe o sabor da pizza: "));
			objPizza.setPrecoUnitario(Console.readFloat("Informe o preço unitário da pizza:"));
			PizzaPersistencia.incluir(objPizza);
			System.out.println("\n\nPizza adicionada...");
		} else {
			System.out.println("\n\nEssa pizza já foi cadastrada...");
		}
	}

	private static void listarPizzas() {
		System.out.println("\n\n*** LISTAGEM DE PIZZAS ***");
		Pizza objPizza = new Pizza();
		objPizza.setSabor(Console.readString("Informe uma parte do nome que deseja listar: "));
		for (Pizza item : PizzaPersistencia.getPizza(objPizza)) {
			System.out.println("ID: " + item.getId());
			System.out.println("Nome: " + item.getSabor());
			System.out.println("Preço unitário: " + item.getPrecoUnitario());
			System.out.println("-------------------------------");
		}

	}

	private static void consultarPizzas() {
		System.out.println("\n\n*** CONSULTA DE PIZZAS ***");
		Pizza objPizza = new Pizza();
		objPizza.setSabor(Console.readString("Informe o sabor de pizza a ser consultado: "));
		objPizza = PizzaPersistencia.procurarPorSabor(objPizza);
		if (objPizza != null) {
			System.out.println("-------------------------------");
			System.out.println("ID: " + objPizza.getId());
			System.out.println("Sabor: " + objPizza.getSabor());
			System.out.println("Preço unitário: " + objPizza.getPrecoUnitario());
			System.out.println("-----------------------");
		} else {
			System.out.println("\n\nPizza não encontrada...");
		}
	}

	private static void alterarPizzas() {
		System.out.println("\n\n*** ALTERAÇÃO DE PIZZA ***");
		Pizza objPizza = new Pizza();
		objPizza.setSabor(Console.readString("Informe o sabor de pizza a ser consultado: "));
		objPizza = PizzaPersistencia.procurarPorSabor(objPizza);
		if (objPizza != null) {
			System.out.println("-------------------------------");
			System.out.println("ID: " + objPizza.getId());
			System.out.println("Sabor: " + objPizza.getSabor());
			System.out.println("-----------------------");
			String resp = Console.readString("\n\nQuer alterar as informações dessa pizza? ");
			if (resp.equals("S")) {
				objPizza.setSabor(Console.readString("Informe as novas informações para essa pizza: "));
				if (PizzaPersistencia.alterar(objPizza) == true) {
					System.out.println("\n\nA alteração foi realizada...");
				} else {
					System.out.println("\n\nA alteração não pôde ser realizada no momento...");
				}
			}
		} else {
			System.out.println("\n\nPizza não encontrado...");
		}
	}

	private static void excluirPizzas() {
		System.out.println("\n\n*** EXCLUSÃO DE PIZZA ***");
		Pizza objPizza = new Pizza();
		objPizza.setSabor(Console.readString("Informe o sabor a ser consultado: "));
		objPizza = PizzaPersistencia.procurarPorSabor(objPizza);
		if (objPizza != null) {
			System.out.println("-------------------------------");
			System.out.println("ID: " + objPizza.getId());
			System.out.println("Sabor: " + objPizza.getSabor());
			System.out.println("-----------------------");
			String resp = Console.readString("\n\nQuer excluir essa pizza? ");
			if (resp.equals("S")) {
				if (PizzaPersistencia.excluir(objPizza) == true) {
					System.out.println("\n\nA exclusão foi realizada...");
				} else {
					System.out.println("\n\nA exclusão não pôde ser realizada no momento...");
				}
			}
		} else {
			System.out.println("\n\nPizza não encontrado...");
		}
	}
}

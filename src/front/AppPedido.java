package front;

import entidades.Cliente;
import entidades.ItemVenda;
import entidades.Pedido;
import entidades.Pizza;
import negocio.PedidoNegocio;
import negocio.PizzaNegocio;
import entidades.Atendente;
import persistencia.ClientePersistencia;
import persistencia.PedidoPersistencia;
import persistencia.PizzaPersistencia;
import persistencia.AtendentePersistencia;

public class AppPedido {
	public AppPedido() {
		int opc;
		do {
			System.out.println("\n\n*** PIZZARIA ***");
			System.out.println("1 - Fazer pedido");
			System.out.println("2 - Consultar pedidos");
			System.out.println("3 - Sair");
			opc = Console.readInt("Opção: ");
			switch (opc) {
				case 1:
					fazerPedido();
					break;

				case 2:
					consultarPedidos();
					break;

			}
		} while (opc != 3);
	}

	private static void fazerPedido() {
		System.out.println("\n\n*** FAZER PEDIDO ***");
		String resposta;
		Pedido objPedido = new Pedido();
		Cliente objCliente = new Cliente();
		objCliente.setTelefone(Console.readString("Informe o telefone do cliente: "));
		objCliente = ClientePersistencia.procurarPorTelefone(objCliente);
		if (objCliente != null) {
			objPedido.setCliente(objCliente);
			Atendente objAtendente = new Atendente();
			objAtendente.setNome(Console.readString("Informe o nome do atendente: "));
			objAtendente = AtendentePersistencia.procurarPorNome(objAtendente);
			if (objAtendente != null) {
				objPedido.setAtendente(objAtendente);
				do {
					ItemVenda objItemVenda = new ItemVenda();
					Pizza objPizza = new Pizza();
					objPizza.setSabor(Console.readString("Informe o sabor da pizza: "));
					objPizza = PizzaPersistencia.procurarPorSabor(objPizza);
					if (objPizza != null) {
						objItemVenda.setPizza(objPizza);
						objItemVenda.setQuantidade(Console.readInt("Informe a quantidade de pizza: "));
						objItemVenda.setTotalPedido(PedidoNegocio.subtotalPedido(objItemVenda));
						objItemVenda.setPrecoUnitarioVenda(PizzaNegocio.calcularPrecoVenda(objPizza));
						System.out.println("Preço unitário: " + objItemVenda.getPrecoUnitarioVenda());
						System.out.println("Subtotal: " + PedidoNegocio.subtotalPedido(objItemVenda));
						// adicionando no array de itemVendas
						objPedido.getPedidos().add(objItemVenda);
					} else {
						System.out.println("\n\nProduto não cadastrado...");
					}
					resposta = Console.readString("Adicionar mais pizza(s) ao pedido? ");
				} while (resposta.equals("S")); 
			if(PedidoPersistencia.incluir(objPedido) == true) {
						System.out.println("\n\nPedido foi incluído...");
					}
					else {
						System.out.println("\n\nNão foi possível cadastrar o pedido...");
					}
				}
			else {
				System.out.println("\n\nCliente não cadastrado...");
			}
		}
		else {
			System.out.println("\n\nPedido já cadastrado...");
		}
	}
	private static void consultarPedidos() {
		System.out.println("\n\n*** CONSULTA DE PEDIDOS ***");
		Pedido objPedido = new Pedido();
		objPedido.setId(Console.readInt("Informe o id do pedido a ser consultado: "));
		objPedido = PedidoPersistencia.procurarPorId(objPedido);
		if (objPedido != null) {
			System.out.println("-------------------------------");
			System.out.println("ID: " + objPedido.getId());
			System.out.println("Cliente:  " + objPedido.getCliente().getNome());
			System.out.println("Atendente: " + objPedido.getAtendente().getNome());
			System.out.println("---------------------------");
			System.out.println("***PEDIDO***");
			System.out.println("---------------------------");
			for(ItemVenda pedido: objPedido.getPedidos()){
			System.out.println("Pizza: " + pedido.getPizza().getSabor());
			System.out.println("Quantidade: " + pedido.getQuantidade());
			System.out.println("Preço unitario: " + pedido.getPrecoUnitarioVenda());
			System.out.println("Subtotal: " + PedidoNegocio.subtotalPedido(pedido));
			System.out.println("----------------------------");
			}
			
		} else {
			System.out.println("\n\nPedido não encontrado...");
		}
	}

}
			

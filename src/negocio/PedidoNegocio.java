package negocio;

import entidades.ItemVenda;


public class PedidoNegocio {
	public static float subtotalPedido(ItemVenda itemVenda) {
		// return itemVenda.getQuantidade() * itemVenda.getPrecoUnitario();
		return itemVenda.getQuantidade() * itemVenda.getPizza().getPrecoUnitario();
		
	}
}



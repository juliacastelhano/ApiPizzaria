package negocio;

// import entidades.ItemVenda;
import entidades.Pizza;

public class PizzaNegocio {

    	public static float calcularPrecoVenda(Pizza pizza) {

		return pizza.getPrecoUnitario();
			
		// return itemVenda.getQuantidade() * pizza.getPrecoUnitario();
		// return itemVenda.getQuantidade() * itemVenda.getPrecoUnitario();

	}

    
    
}

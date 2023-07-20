package entidades;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemVenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	@OneToOne
	private Pizza pizza;
	private int quantidade;
	private float precoUnitarioVenda;

    
    private float totalPedido;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Pizza getPizza() {
        return pizza;
    }
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

     public float getTotalPedido() {
        return totalPedido;
    }
    public void setTotalPedido(float totalPedido) {
        this.totalPedido = totalPedido;
    }
    public float getPrecoUnitarioVenda() {
        return precoUnitarioVenda;
    }
    public void setPrecoUnitarioVenda(float precoUnitarioVenda) {
        this.precoUnitarioVenda = precoUnitarioVenda;
    }
    public ItemVenda(float precoUnitarioVenda) {
        this.precoUnitarioVenda = precoUnitarioVenda;
    }
    public ItemVenda() {
    }
}

package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@OneToOne
	private Cliente cliente;

	@OneToOne
	private Atendente atendente;

	
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemVenda> pedidos = new ArrayList<ItemVenda>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<ItemVenda> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<ItemVenda> pedidos) {
		this.pedidos = pedidos;
	}
}

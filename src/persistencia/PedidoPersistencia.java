package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Pedido;

public class PedidoPersistencia {
	public static boolean incluir(Pedido pedido) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(pedido);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Pedido procurarPorId(Pedido pedido) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Pedido where id = :param");
		consulta.setParameter("param", pedido.getId());
		List<Pedido> pedidos = consulta.getResultList();
		if (!pedidos.isEmpty()) {
			return pedidos.get(0);
		}
		return null;
	}

	public static List<Pedido> getPedidos(Pedido pedido) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Pedido where id like :param");
		consulta.setParameter("param", +pedido.getId());
		List<Pedido> pedidos = consulta.getResultList();
		return pedidos;
	}

	// public static Pedido consultarPedidos(Pedido pedido) {
	// EntityManager manager = EntityManagerFactory.getInstance();
	// Query consulta = manager.createQuery("from Pedido where cliente =
	// :paramCliente and atendente = :paramAtendente");
	// consulta.setParameter("paramCliente", pedido.getCliente());
	// consulta.setParameter("paramAtendente", pedido.getAtendente());
	// List<Pedido> pedidos = consulta.getResultList();
	// if(!pedidos.isEmpty()){
	// return pedidos.get(0);
	// }
	// return null;
	// }
}

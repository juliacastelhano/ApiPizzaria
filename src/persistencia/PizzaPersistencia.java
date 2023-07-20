package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidades.Pizza;

public class PizzaPersistencia {
	public static boolean incluir(Pizza pizza) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(pizza);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean alterar(Pizza pizza) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(pizza);
			manager.getTransaction().commit();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean excluir(Pizza pizza) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(pizza);
			manager.getTransaction().commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Pizza procurarPorSabor(Pizza pizza) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Pizza where sabor = :param");
		consulta.setParameter("param", pizza.getSabor());
		List<Pizza> pizzas = consulta.getResultList();
		if (!pizzas.isEmpty()) {
			return pizzas.get(0);
		}
		return null;
	}

	public static Pizza procurarPorId(Pizza pizza) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Pizza where id = :param");
		consulta.setParameter("param", pizza.getId());
		List<Pizza> pizzas = consulta.getResultList();
		if (!pizzas.isEmpty()) {
			return pizzas.get(0);
		}
		return null;
	}

	public static List<Pizza> getPizza(Pizza pizza) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Pizza where sabor like :param");
		consulta.setParameter("param", "%" + pizza.getSabor() + "%");
		List<Pizza> pizzas = consulta.getResultList();
		return pizzas;
	}
}

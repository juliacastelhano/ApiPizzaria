package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import entidades.Atendente;

public class AtendentePersistencia {
	public static boolean incluir(Atendente atendente) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(atendente);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean alterar(Atendente atendente) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(atendente);
			manager.getTransaction().commit();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean excluir(Atendente atendente) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(atendente);
			manager.getTransaction().commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// public static Atendente procurarPorNome(Atendente atendente){
	// EntityManager manager = EntityManagerFactory.getInstance();
	// Query consulta = manager.createQuery("from Cliente where nome = :param");
	// consulta.setParameter("param", atendente.getNome());
	// List<Atendente> atendentes = consulta.getResultList();
	// if(!atendentes.isEmpty()){
	// return atendentes.get(0);
	// }
	// return null;
	// }

	public static Atendente procurarPorNome(Atendente atendente) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Atendente where nome = :param");
		consulta.setParameter("param", atendente.getNome());
		List<Atendente> atendentes = consulta.getResultList();
		if (!atendentes.isEmpty()) {
			return atendentes.get(0);
		}
		return null;
	}

	public static Atendente procurarPorId(Atendente atendente) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Atendente where id = :param");
		consulta.setParameter("param", atendente.getId());
		List<Atendente> atendentes = consulta.getResultList();
		if (!atendentes.isEmpty()) {
			return atendentes.get(0);
		}
		return null;
	}

	public static List<Atendente> getAtendentes(Atendente atendente) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Atendente where nome like :param");
		consulta.setParameter("param", "%" + atendente.getNome() + "%");
		List<Atendente> atendentes = consulta.getResultList();
		return atendentes;
	}
}

package ma.ensa.Dao.Impl;

import ma.ensa.Dao.ClientDAO;
import ma.ensa.Models.Client;
import ma.ensa.Utils.HibernateUtil;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClientDAOImpl implements ClientDAO {
	EntityManager em = HibernateUtil.getEm();

	@Override
	public Client get(int id) {
		Query q = em.createQuery("Select c from Client c where c.id= :clientID");
		q.setParameter("clientID", id);

		Client client = (Client) q.getResultList().stream().findFirst().orElse(null);
		return client;
	}

	@Override
	public Client get(String email, String password) {
		Query q = em.createQuery("Select c from Client c where c.email= :clientEmail and c.motPasse= :clientMDP");
		q.setParameter("clientEmail", email);
		q.setParameter("clientMDP", password);

		Client client = (Client) q.getResultList().stream().findFirst().orElse(null);
		return client;
	}

	@Override
	public Client create(Client client) {
		try {
			em.getTransaction().begin();
			em.persist(client);
			em.getTransaction().commit();
			return client;
		} catch (ConstraintViolationException e) {
			// Email déja utilisé
			return null;
		}
	}

	@Override
	public Client findByEmail(String email) {
		Query q = em.createQuery("Select c from Client c where lower(c.email)= lower(:clientEmail)");
		q.setParameter("clientEmail", email);

		Client client = (Client) q.getResultList().stream().findFirst().orElse(null);
		return client;
	}
}

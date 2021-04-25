package ma.ensa.Dao.Impl;

import ma.ensa.Dao.CommandeDAO;
import ma.ensa.Models.Client;
import ma.ensa.Models.Commande;
import ma.ensa.Models.LigneCommande;
import ma.ensa.Utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CommandeDAOImpl implements CommandeDAO {
	@Override
	public List<Commande> getAll(Client client) {
		EntityManager em = HibernateUtil.getEm();
		Query q = em.createQuery("Select c from Commande c where c.client= :client");
		q.setParameter("client", client);

		List<Commande> commandes = (List<Commande>) q.getResultList();
		return commandes.size()==0? null: commandes;
	}

	@Override
	public int create(Commande commande) {
		EntityManager em = HibernateUtil.getEm();
		em.getTransaction().begin();
		em.persist(commande);
		em.getTransaction().commit();
		return commande.getNumCommande();
	}

	@Override
	public List<LigneCommande> getCommande(Commande commande) {
		EntityManager em = HibernateUtil.getEm();
		Query q = em.createQuery("Select lc from LigneCommande lc where lc.commande= :commande");
		q.setParameter("commande", commande);

		List<LigneCommande> panier = (List<LigneCommande>) q.getResultList();
		return panier.size()==0? null: panier;
	}
}

package ma.ensa.Dao.Impl;

import ma.ensa.Dao.LigneCommandeDAO;
import ma.ensa.Models.Commande;
import ma.ensa.Models.LigneCommande;
import ma.ensa.Utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class LigneCommandeDAOImpl implements LigneCommandeDAO {
	EntityManager em = HibernateUtil.getEm();
	@Override
	public List<LigneCommande> getAll(Commande commande) {
		Query q = em.createQuery("Select lc from LigneCommande lc where lc.commande= :commande");
		q.setParameter("commande", commande);

		List<LigneCommande> panier = (List<LigneCommande>) q.getResultList();
		return panier.size()==0? null:panier;
	}

	@Override
	public void create(LigneCommande lc) {
		em.getTransaction().begin();
		em.persist(lc);
		em.getTransaction().commit();
	}
}

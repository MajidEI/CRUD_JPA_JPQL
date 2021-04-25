package ma.ensa.Dao;

import ma.ensa.Models.Client;
import ma.ensa.Models.Commande;
import ma.ensa.Models.LigneCommande;

import java.util.List;

public interface LigneCommandeDAO {
	public List<LigneCommande> getAll(Commande commande);
	public void create(LigneCommande lc);
}

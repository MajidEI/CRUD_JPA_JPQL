package ma.ensa.Dao;

import ma.ensa.Models.Article;
import ma.ensa.Models.Client;
import ma.ensa.Models.Commande;
import ma.ensa.Models.LigneCommande;

import java.util.List;

public interface CommandeDAO {
	public List<Commande> getAll(Client client);
	public int create(Commande commande);
	public List<LigneCommande> getCommande(Commande commande);
}

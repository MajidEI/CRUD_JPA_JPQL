package ma.ensa.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="commandes")
public class Commande {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	int numCommande;
	Date dateCommande = new java.util.Date();
	@ManyToOne
	@JoinColumn(name = "codeClient")
	Client client;

	public Commande() {
	}

	public int getNumCommande() {
		return numCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Commande{" +
				"numCommande=" + numCommande +
				", dateCommande=" + dateCommande +
				", client=" + client.getPrenom() + client.getNom() +
				'}';
	}

	/*
	public static int passerCommande(List<Article> panier, Client client) {
		DBConfig dbConfig = new DBConfig();
		try {
			String query = "INSERT INTO `commandes` (codeClient) VALUES (?) ";

			PreparedStatement ps = dbConfig.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, client.getCode());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int codeCommande = rs.getInt(1);

			for (Article article : panier) {

				query = "INSERT INTO `lignecommande` (numCommande, codeArticle, qteCde) VALUES (?,?,?) ";
				ps = dbConfig.getConnection().prepareStatement(query);

				ps.setInt(1, codeCommande);
				ps.setInt(2, article.getCode());
				// To be changed
				ps.setInt(3, 1);

				ps.executeUpdate();

			}
			return codeCommande;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			dbConfig.close();
		}
	}

	public static List<Commande> getCommandes(Client client) {
		DBConfig dbConfig = new DBConfig();
		try {
			String query = "SELECT DISTINCT commandes.numCommande, dateCommande FROM commandes JOIN lignecommande on commandes.numCommande=lignecommande.numCommande WHERE codeClient=?";

			PreparedStatement ps = dbConfig.getConnection().prepareStatement(query);
			ps.setInt(1, client.getCode());
			ResultSet rs = ps.executeQuery();
			List<Commande> commandes = new ArrayList<>();
			// Loop over commands
			while (rs.next()) {
				int codeCommande = rs.getInt("NumCommande");
				Commande commande = new Commande();
				commande.setCode(codeCommande);
				commande.setClient(client);
				commande.setDate(rs.getDate("DateCommande"));
				try {
					query = "SELECT Designation, Prix FROM commandes JOIN lignecommande on commandes.numCommande=lignecommande.numCommande JOIN articles on lignecommande.codeArticle=articles.CodeArticle WHERE commandes.numCommande=?";

					ps = dbConfig.getConnection().prepareStatement(query);
					ps.setInt(1, codeCommande);
					ResultSet rset = ps.executeQuery();
					List<Article> articles = new ArrayList<>();
					// Loop over single command
					while (rset.next()) {
						Article article = new Article();
						article.setDesignation(rset.getString("Designation"));
						article.setPrix(rset.getInt("Prix"));
						articles.add(article);
					}
					commande.setArticles(articles);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
				commandes.add(commande);
			}
			return commandes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbConfig.close();
		}
	}
 */

}

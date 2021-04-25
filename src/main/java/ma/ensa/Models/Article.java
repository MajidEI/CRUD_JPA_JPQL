package ma.ensa.Models;


import javax.persistence.*;

@Entity
@Table(name="articles")
public class Article {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	int codeArticle;
	String designation;
	String photo;
	int prix;
	int stock;
	@ManyToOne
	@JoinColumn(name = "categorie")
	Categorie categorie;

	public Article() {
	}

	public int getCodeArticle() {
		return codeArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Article{" +
				"codeArticle=" + codeArticle +
				", designation='" + designation + '\'' +
				", photo='" + photo + '\'' +
				", prix=" + prix +
				", stock=" + stock +
				", categorie=" + categorie.getCat() +
				'}';
	}

	/*
	public static List<Article> getAll() {
		DBConfig dbConfig = new DBConfig();
		try {
			String query = "SELECT CodeArticle, Designation, Prix, Stock, Cat, Photo FROM articles JOIN categories ON articles.Categorie=categories.RefCat";

			PreparedStatement ps = dbConfig.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Article> articles = new ArrayList<Article>();
			while (rs.next()) {
				Article article = new Article();
				article.setCode(rs.getInt("CodeArticle"));
				article.setDesignation(rs.getString("Designation"));
				article.setPrix(rs.getInt("Prix"));
				article.setStock(rs.getInt("Stock"));
				article.setCategorie(rs.getString("Cat"));
				article.setPhoto(rs.getString("Photo"));
				articles.add(article);
			}
			return articles;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbConfig.close();
		}
	}

	public static Article getArticle(String code) {
		DBConfig dbConfig = new DBConfig();
		try {
			String query = "SELECT CodeArticle, Designation, Prix, Stock, Cat, Photo FROM articles JOIN categories ON articles.Categorie=categories.RefCat where CodeArticle = ?";

			PreparedStatement ps = dbConfig.getConnection().prepareStatement(query);
			ps.setString(1, code);

			ResultSet rs = ps.executeQuery();
			rs.next();
			Article article = new Article();
			article.setCode(rs.getInt("CodeArticle"));
			article.setDesignation(rs.getString("Designation"));
			article.setPrix(rs.getInt("Prix"));
			article.setStock(rs.getInt("Stock"));
			article.setCategorie(rs.getString("Cat"));
			article.setPhoto(rs.getString("Photo"));
			return article;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbConfig.close();
		}
	}

 */
}

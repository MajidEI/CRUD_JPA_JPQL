package ma.ensa.Models;

import javax.persistence.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Entity
@Table(name="clients")
public class Client {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(unique = true)
	String email;
	String nom;
	String prenom;
	String adresse;
	String codePostal;
	String ville;
	String tel;
	String motPasse;

	public Client() {

	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMotPasse() {
		return motPasse;
	}

	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}

	@Override
	public String toString() {
		return "Client{" +
				"id=" + id +
				", email='" + email + '\'' +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", adresse='" + adresse + '\'' +
				", codePostal=" + codePostal +
				", ville='" + ville + '\'' +
				", tel='" + tel + '\'' +
				", motPasse='" + motPasse + '\'' +
				'}';
	}

	/*
	public void saveClient() throws Exception {
		DBConfig dbConfig = new DBConfig();
		try {
			String query = "INSERT INTO `clients` (`Email`, `Nom`, `Prenom`, `Adresse`, codePostal, ville, tel, motPasse) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";

			PreparedStatement ps = dbConfig.getConnection().prepareStatement(query);
			ps.setString(1, this.getEmail());
			ps.setString(2, this.getNom());
			ps.setString(3, this.getPrenom());
			ps.setString(4, this.getAdresse());
			ps.setInt(5, this.getZip());
			ps.setString(6, this.getVille());
			ps.setString(7, this.getTelephone());
			ps.setString(8, this.getMdp());

			ps.executeUpdate();
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new Exception("duplicate");
		} finally {
			dbConfig.close();
		}
	}

	public static Client getClient(String email, String mdp) {
		DBConfig dbConfig = new DBConfig();
		try {
			String query = "SELECT * FROM clients WHERE email = ? and motPasse = ?";

			PreparedStatement ps = dbConfig.getConnection().prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, mdp);
			ResultSet rs = ps.executeQuery();
			Client client = new Client();
			while (rs.next()) {
				client.setCode(rs.getInt("Id"));
				client.setNom(rs.getString("Nom"));
				client.setPrenom(rs.getString("Prenom"));
				client.setEmail(rs.getString("Email"));
				client.setMdp(rs.getString("MotPasse"));
				client.setAdresse(rs.getString("Adresse"));
				client.setVille(rs.getString("Ville"));
				client.setZip(rs.getInt("CodePostal"));
				client.setTelephone(rs.getString("Tel"));
				return client;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			dbConfig.close();
		}
		return null;
	}
*/
}

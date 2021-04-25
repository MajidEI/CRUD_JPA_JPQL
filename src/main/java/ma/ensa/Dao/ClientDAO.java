package ma.ensa.Dao;

import ma.ensa.Models.Client;

public interface ClientDAO {
	public Client get(int id);
	public Client get(String email, String password);
	public Client create(Client client);
	public Client findByEmail(String email);
}

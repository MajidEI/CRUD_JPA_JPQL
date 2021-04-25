package ma.ensa.Service;

import ma.ensa.Models.Client;

public interface AuthService {
	public Client login(String email, String password);
	public Client signup(Client client);
}

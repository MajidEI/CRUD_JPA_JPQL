package ma.ensa.Service.Impl;

import ma.ensa.Dao.ClientDAO;
import ma.ensa.Dao.Impl.ClientDAOImpl;
import ma.ensa.Models.Client;
import ma.ensa.Service.AuthService;

public class AuthServiceImpl implements AuthService {
	ClientDAO dao = new ClientDAOImpl();

	@Override
	public Client login(String email, String password) {
		return dao.get(email, password);
	}

	@Override
	public Client signup(Client client) {
		return dao.create(client);
	}
}

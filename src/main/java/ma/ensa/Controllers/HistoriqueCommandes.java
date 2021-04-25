package ma.ensa.Controllers;

import ma.ensa.Dao.CommandeDAO;
import ma.ensa.Dao.Impl.CommandeDAOImpl;
import ma.ensa.Dao.Impl.LigneCommandeDAOImpl;
import ma.ensa.Dao.LigneCommandeDAO;
import ma.ensa.Models.Client;
import ma.ensa.Models.Commande;
import ma.ensa.Models.LigneCommande;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "Historique", value = "/historique")
public class HistoriqueCommandes extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Client client = (Client) session.getAttribute("client");

		CommandeDAO svc = new CommandeDAOImpl();
		HashMap<Commande, List<LigneCommande>> historique = new HashMap<>();

		List<Commande> commandes = svc.getAll(client);

		LigneCommandeDAO lcsvc = new LigneCommandeDAOImpl();
		for (Commande commande : commandes) {
			List<LigneCommande> articles = lcsvc.getAll(commande);
			historique.put(commande, articles);
		}
		request.setAttribute("historique", historique);
		request.getRequestDispatcher("historique.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

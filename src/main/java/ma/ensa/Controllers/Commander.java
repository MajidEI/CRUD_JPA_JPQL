package ma.ensa.Controllers;

import ma.ensa.Dao.CommandeDAO;
import ma.ensa.Dao.Impl.CommandeDAOImpl;
import ma.ensa.Dao.Impl.LigneCommandeDAOImpl;
import ma.ensa.Dao.LigneCommandeDAO;
import ma.ensa.Models.Article;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "Commander", value = "/commander")
public class Commander extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Enumeration<String> names = session.getAttributeNames();
		List<String> attributes = Collections.list(names);

		Client client = (Client) session.getAttribute("client");
		Commande commande = new Commande();
		commande.setClient(client);
		CommandeDAO svc = new CommandeDAOImpl();
		int numCommande = svc.create(commande);

		List<LigneCommande> panier = new ArrayList<>();
		for (String attribute : attributes) {
			if (attribute.startsWith("article")) {
				Article article = (Article) request.getSession().getAttribute(attribute);
				LigneCommande lc = new LigneCommande();
				lc.setCommande(commande);
				lc.setArticle(article);
				// Add search for duplicate
				lc.setQteCde(1);
				panier.add(lc);
			}
		}
		int nbArticles = panier.size();
		if (nbArticles == 0) {
			// Pas d articles dans le panier
			// Panier vide
			response.sendRedirect(request.getContextPath() + "/catalogue");
			return;
		} else {
			LigneCommandeDAO lcsvc = new LigneCommandeDAOImpl();
			for (LigneCommande lc : panier)
				lcsvc.create(lc);
			request.getSession().invalidate();
			request.setAttribute("numCommande", numCommande);
			request.getRequestDispatcher("resume.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

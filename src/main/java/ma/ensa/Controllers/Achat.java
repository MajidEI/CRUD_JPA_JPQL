package ma.ensa.Controllers;

import ma.ensa.Models.Article;
import ma.ensa.Service.ArticleService;
import ma.ensa.Service.Impl.ArticleServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "Achat", value = "/achat")
public class Achat extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Enumeration<String> names = session.getAttributeNames();
		List<String> attributes = Collections.list(names);
		if (request.getParameter("code") != null) {
			try {
				// code de l article a ajouter au panier
				int code = Integer.parseInt(request.getParameter("code"));
				// Recherche de l article
				ArticleService svc = new ArticleServiceImpl();
				Article article = svc.getById(code);
				if (article == null) {
					throw new Exception();
				}
				// Nombre d articles dans la session
				int nbArticles = attributes.size();
				nbArticles++;
				// Ajout de l article a la session
				session.setAttribute("article" + nbArticles, article);
				response.sendRedirect(request.getContextPath() + "/panier");
			} catch (Exception e) {
				request.setAttribute("erreur", "notFound");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/catalogue");
				dispatcher.forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

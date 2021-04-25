package ma.ensa.Controllers;

import ma.ensa.Models.Article;

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

@WebServlet(name = "Panier", value = "/panier")
public class Panier extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Enumeration<String> names = session.getAttributeNames();
		List<String> attributes = Collections.list(names);
		boolean vide = true;
		List<Article> panier = new ArrayList<>();
		// Creation du panier et verification s'il est vide
		for (String attribute : attributes) {
			if (attribute.startsWith("article")) {
				if (vide) vide = false;
				Article ar = (Article) request.getSession().getAttribute(attribute);
				panier.add(ar);
			}
		}
		if (vide) {
			request.setAttribute("vide", "vide");
		} else {
			request.setAttribute("panier", panier);
		}
		request.getRequestDispatcher("panier.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

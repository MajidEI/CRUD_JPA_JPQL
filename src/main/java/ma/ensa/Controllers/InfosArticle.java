package ma.ensa.Controllers;

import ma.ensa.Models.Article;
import ma.ensa.Service.ArticleService;
import ma.ensa.Service.Impl.ArticleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InfosArticle", value = "/infos")
public class InfosArticle extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperer le code de l article
		int code = Integer.parseInt(request.getParameter("code"));
		ArticleService svc = new ArticleServiceImpl();
		Article article = svc.getById(code);
		if (article == null) {
			request.setAttribute("erreur", "articleNotFound");
			response.sendRedirect(request.getContextPath() + "/catalogue");
			return;
		}
		request.setAttribute("article", article);
		request.getRequestDispatcher("infos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

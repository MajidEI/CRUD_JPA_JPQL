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
import java.util.List;

@WebServlet(name = "Catalogue", value = "/catalogue")
public class Catalogue extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleService svc = new ArticleServiceImpl();
		List<Article> catalogue = svc.getAll();
		request.setAttribute("catalogue", catalogue);
		request.getRequestDispatcher("catalogue.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

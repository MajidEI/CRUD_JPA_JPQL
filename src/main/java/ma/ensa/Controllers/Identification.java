package ma.ensa.Controllers;

import ma.ensa.Models.Client;
import ma.ensa.Service.AuthService;
import ma.ensa.Service.Impl.AuthServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Identification", value = "/identification")
public class Identification extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Client client = (Client) session.getAttribute("client");
		if (client != null) {
			request.setAttribute("loggedIn", "yes");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/acceuil");
			dispatcher.forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String mdp = request.getParameter("password");
			AuthService svc = new AuthServiceImpl();
			Client client = svc.login(email, mdp);
			if (client == null) {
				throw new Exception("nonExistant");
			}
			Cookie emailCK = new Cookie("email", email);
			response.addCookie(emailCK);
			Cookie pwCK = new Cookie("password", mdp);
			response.addCookie(pwCK);
			HttpSession session = request.getSession();
			session.setAttribute("client", client);
			response.sendRedirect(request.getContextPath() + "/acceuil");

		} catch (Exception e) {
			HttpSession session = request.getSession();
			String msg = e.getMessage().equals("nonExistant") ? "nonExistant" : "other";
			session.setAttribute("msgErreur", msg);
			doGet(request, response);
		}
	}
}

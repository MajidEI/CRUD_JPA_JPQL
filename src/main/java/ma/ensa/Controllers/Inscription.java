package ma.ensa.Controllers;

import ma.ensa.Dao.Impl.ClientDAOImpl;
import ma.ensa.Models.Client;
import ma.ensa.Service.AuthService;
import ma.ensa.Service.Impl.AuthServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet(name = "Inscription", value = "/inscription")
public class Inscription extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = new Client();
		String email = request.getParameter("email"), password = request.getParameter("password");
		String fname = request.getParameter("fname"), lname = request.getParameter("lname");
		String adresse = request.getParameter("address"), ville = request.getParameter("city");
		String telephone = request.getParameter("phone");
		String zip = request.getParameter("zip");

		client.setEmail(email);
		client.setMotPasse(password);
		client.setNom(lname);
		client.setPrenom(fname);
		client.setAdresse(adresse);
		client.setVille(ville);
		client.setCodePostal(zip);
		client.setTel(telephone);

		List<String> errors = new ArrayList<String>();
		if (fname == null || fname.trim().isEmpty()) {
			errors.add("fnameRequired");
		}

		if (lname == null || lname.trim().isEmpty()) {
			errors.add("lnameRequired");
		}

		if (adresse == null || adresse.trim().isEmpty()) {
			errors.add("addressRequired");
		}

		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		Matcher matcher = pattern.matcher(email);
		if (email == null || email.trim().isEmpty()) {
			errors.add("emailRequired");
		} else if (!matcher.matches()) {
			errors.add("emailBadFormat");
		} else {
			if (new ClientDAOImpl().findByEmail(email) != null) {
				errors.add("duplicateEmail");
			}
		}

		if (password == null || password.trim().isEmpty()) {
			errors.add("passwordRequired");
		}

		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			request.setAttribute("client", client);
			doGet(request, response);
			return;
		}

		/*
		 * Persister le client dans la DB
		 * Si l email est deja utilise on leve un exception pour
		 * renvoyer l utilisateur vers la page d inscription
		 */
		AuthService svc = new AuthServiceImpl();

		client = svc.signup(client);
		Cookie emailCK = new Cookie("email", email);
		response.addCookie(emailCK);
		Cookie pwCK = new Cookie("motdepasse", password);
		response.addCookie(pwCK);

		request.setAttribute("client", client);
		request.getSession().setAttribute("client", client);
		request.getRequestDispatcher("acceuil.jsp").forward(request, response);

	}

}

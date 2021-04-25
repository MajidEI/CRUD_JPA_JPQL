package ma.ensa.Utils;

import ma.ensa.Models.Client;
import ma.ensa.Service.AuthService;
import ma.ensa.Service.Impl.AuthServiceImpl;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Optional;

public class CookiesHelper {

	public CookiesHelper() {
	}

	public static Client chercheClient(Cookie[] cookies) {
		String email = getCookie("email", cookies);
		String mdp = getCookie("password", cookies);
		AuthService svc = new AuthServiceImpl();
		Client client = svc.login(email, mdp);
		return client;
	}
	
	public static String getCookie(String name, Cookie[] cookies) {
		return Optional.ofNullable(cookies).flatMap(cookiesF -> Arrays.stream(cookiesF)
				.filter(cookie -> name.equals(cookie.getName())).findAny())
				// If we have a matching cookie, return its value.
				.map(e -> e.getValue())
				// otherwise return null to retain original behaviour
				.orElse(null);
	}

}

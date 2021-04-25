package ma.ensa.Filters;

import ma.ensa.Models.Client;
import ma.ensa.Utils.CookiesHelper;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AutorisationFiltre")
public class AutorisationFiltre implements Filter {
	public void init(FilterConfig config) throws ServletException {
	}

	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		Client client = null;
		if(session.getAttribute("client")!=null){
			chain.doFilter(httpRequest, response);
			return;
		}
		Cookie[] cookies = httpRequest.getCookies();
		client = CookiesHelper.chercheClient(cookies);
		if (client == null) {
			// Appel servlet identification
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/identification");
			return;
		}
		session.setAttribute("client", client);
		chain.doFilter(httpRequest, response);
	}
}

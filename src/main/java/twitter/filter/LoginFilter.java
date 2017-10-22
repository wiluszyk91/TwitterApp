package twitter.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/all", "/create","/favourite_tweets"})
public class LoginFilter implements Filter {
	
    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		boolean logged = false;

		HttpSession session = ((HttpServletRequest) request).getSession();

		if (session.getAttribute("login") != null) {
			logged = true;
		}

		if (!logged) {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			httpServletResponse.sendRedirect("/login?backUrl="+httpServletRequest.getServletPath());
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

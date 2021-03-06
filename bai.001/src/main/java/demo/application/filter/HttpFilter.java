package demo.application.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@WebFilter(filterName = "httpFilter", urlPatterns = {"/*"})
public class HttpFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		System.out.printf("#INFO: %s: %s \n", req.getMethod(), req.getRequestURI());

		boolean need = needJDBC(req);

		if (need) {

			try {

				chain.doFilter(request, response);

			} catch (Exception ex) {

			} finally {

			}
		} else {
			chain.doFilter(request, response);
		}
	}

	private boolean needJDBC(HttpServletRequest req) {

		return true;
	}
}

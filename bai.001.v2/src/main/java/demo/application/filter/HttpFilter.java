package demo.application.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class HttpFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		System.out.printf("#INFO: %s: %s \n", req.getMethod(), req.getRequestURI());
		
		boolean need = needJDBC(req);
		
		if(need) {
			
			try {
				
				chain.doFilter(request, response);
				
				
			}
			catch(Exception ex) {
				
				
			}
			finally {
				
			}
		}
		else {
			chain.doFilter(request, response);
		}
	}
	
	private boolean needJDBC(HttpServletRequest req) {
		
		String servletPath = req.getServletPath();
		
		String pathInfo = req.getPathInfo();
		
		String url = servletPath;
		
		if(pathInfo != null) url += "/*";
		
		Map<String, ? extends ServletRegistration> map = req.getServletContext().getServletRegistrations();
		
		Collection<? extends ServletRegistration> servletRegistrations = map.values();
		
		for(ServletRegistration sr : servletRegistrations) {
			
			Collection<String> servlets = sr.getMappings();
			
			if(servlets.contains(url)) return true;
		}
		
		return false;
	}
}

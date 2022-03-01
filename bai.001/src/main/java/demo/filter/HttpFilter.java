package demo.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import demo.utils.AttributesUtils;

@WebFilter(filterName = "httpFilter", urlPatterns = {"/*"})
public class HttpFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		System.out.printf("#INFO: %s: %s \n", req.getMethod(), req.getRequestURI());
		
		boolean need = needJDBC(req);
		
		if(need) {
			
			EntityManagerFactory emf = null;
			
			EntityManager em = null;
			
			try {
				
				emf = Persistence.createEntityManagerFactory("ctvftech_demo");
				
				em = emf.createEntityManager();
				
				em.getTransaction().begin();
				
				AttributesUtils.storeEntityManager(request, em);
				
				chain.doFilter(request, response);
				
				em.getTransaction().commit();
			}
			catch(Exception ex) {
				
				if(em.getTransaction().isActive()) em.getTransaction().rollback();
			}
			finally {
				em.close();
				emf.close();
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
		
		if(!pathInfo.isEmpty()) url += "/*";
		
		Map<String, ? extends ServletRegistration> map = req.getServletContext().getServletRegistrations();
		
		Collection<? extends ServletRegistration> servletRegistrations = map.values();
		
		for(ServletRegistration sr : servletRegistrations) {
			
			Collection<String> servlets = sr.getMappings();
			
			if(servlets.contains(url)) return true;
		}
		
		return false;
	}
}

package demo.utils;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;

public class AttributesUtils {

	private static final String ATT_ENTITY_MANAGER = "ATT_ENTITY_MANAGER";
	
	public static void storeEntityManager(ServletRequest request, EntityManager em) {
		
		request.setAttribute(ATT_ENTITY_MANAGER, em);
	}
	
	public static EntityManager getEntityManager(ServletRequest request) {
		
		EntityManager em = (EntityManager) request.getAttribute(ATT_ENTITY_MANAGER);
		
		return em;
	}
}

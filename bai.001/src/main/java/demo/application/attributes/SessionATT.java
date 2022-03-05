package demo.application.attributes;

import javax.servlet.http.HttpSession;

import demo.application.dto.User;

public class SessionATT {

	private static final String DEMO_USER_SESSION_ATT = "DEMO_USER_SESSION_ATT";
	
	private static final String CHECKED = null;
	
	public static void storeUserInSession(HttpSession session, User user) {
		
		session.setAttribute(DEMO_USER_SESSION_ATT, user);
	}
	
	public static User getUserInSession(HttpSession session) {
		
		return (User) session.getAttribute(DEMO_USER_SESSION_ATT);
	}
	
	public static void doChecked(HttpSession session, String checked) {
		
		session.setAttribute(CHECKED, checked);
	}
	
	public static String getChecked(HttpSession session) {
		
		return (String) session.getAttribute(CHECKED);
	}
}

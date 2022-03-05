package demo.application.attributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.application.dto.User;

public class CookieATT {

	private static final String DEMO_USER_ATT = "DEMO_USER_ATT";

	// lưu thông tin đăng nhập vào Cookie.
	public static void storeUserInCookie(HttpServletResponse response, User user) {

		String att = String.format("%s+%s+%s", user.getUsername(), user.getPassword(), user.getId());

		Cookie cookie = new Cookie(DEMO_USER_ATT, att);

		cookie.setMaxAge(24 * 60 * 60);

		response.addCookie(cookie);
	}

	// duyệt Cookie để tìm thông tin đăng nhập.
	public static User getUserInCookie(HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {

			if (cookie.getName().equals("DEMO_USER_ATT")) {

				String[] atts = cookie.getValue().split("+");

				if (atts.length == 3) {

					User user = new User(atts[0], atts[1], atts[2]);

					return user;
				}
			}
		}

		return null;
	}

	// xóa thông tin đăng nhập.
	public static void deleteUserInCookie(HttpServletResponse response) {

		Cookie cookie = new Cookie(DEMO_USER_ATT, null);

		cookie.setMaxAge(0);

		response.addCookie(cookie);
	}
}

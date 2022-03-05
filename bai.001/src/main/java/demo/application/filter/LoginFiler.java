package demo.application.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import demo.application.attributes.CookieATT;
import demo.application.attributes.SessionATT;
import demo.application.dto.User;
import demo.application.services.EmployeesService;

@Component
@Order(1)
@WebFilter(filterName = "loginFilter", urlPatterns = {"/work/*", "/employee/*", "/office/*"})
public class LoginFiler implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

	
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		
		//1. Kiểm tra thuộc tính CHECKED của session.
		
		String checked = SessionATT.getChecked(session);
		
		//1.1 CHECKED bằng CHECKED => đã đăng nhập
		if(checked != null && checked.equals("CHECKED")) {
			
			chain.doFilter(request, response);
			return;
		}
		
		/*1.2 CHECKED == NULL => chưa đăng nhập, phiên làm việc đã hết hoặc chưa lưu cookie.
		* => cần đăng nhập lại
		* => Duyệt cookie.
		* => 1.2.1.Thông tin đăng nhập khớp thì cho đi tiếp
		* => 1.2.2.Thông tin đăng nhập không khớp thì xóa Cookie và chuyển đến trang đăng nhập.
		*/
		User user = CookieATT.getUserInCookie(req);
		
		EmployeesService service = new EmployeesService();
		
		try {
			String password = service.findUser(user.getUsername());
			
			String reversePassword = service.encodingPassword(user.getPassword());
			
			if(!password.equals(reversePassword)) {
				
				//chuyển đến trang đăng nhập.
				
				return;
			}
			
			SessionATT.doChecked(session, "CHECKED");
			SessionATT.storeUserInSession(session, user);
			
			chain.doFilter(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

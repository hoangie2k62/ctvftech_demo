package demo.application.api;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.application.attributes.CookieATT;
import demo.application.attributes.SessionATT;
import demo.application.dto.User;
import demo.application.services.EmployeesService;

@RestController
@RequestMapping("/user")
public class UserAPI {

	@Autowired
	private EmployeesService service;

	@Autowired
	private HttpSession session;

	@Autowired
	private HttpServletResponse response;
	
	private String avatarDefault;

	// chức năng đăng nhập.
	@PostMapping("/login/")
	public String login(@RequestBody User user, @RequestParam(value = "rememberPassword") String rememberPassword)
			throws Exception {

		String password = service.findUser(user.getUsername());

		String reversePassword = service.encodingPassword(user.getPassword());

		if (!password.equals(reversePassword))
			return "thông tin tài khoản hoặc mật khẩu không chính xác";

		if (rememberPassword.equals("REMEMBER"))
			CookieATT.storeUserInCookie(response, user);

		return "successful";
	}

	@PutMapping("/changePassword/")
	public String changePassword(@RequestParam(value = "username") String username,
			@RequestParam(value = "oldPass") String oldPass, @RequestParam(value = "newPass") String newPass)
			throws Exception {

		String password = service.findUser(username);

		String reversePassword = service.encodingPassword(oldPass);

		if (!password.equals(reversePassword))
			return "mật khẩu cũ không chính xác";

		service.saveUser(username, reversePassword);

		return "successful";
	}

	// chức năng quên mật khẩu.
	@PutMapping("/forgerpassword/{username}")
	public String forgetpassword(@PathVariable(value = "username") String username) {

		return "successful";
	}

	// chức năng đăng xuất.
	@PostMapping("/logout/")
	public void logout() {

		SessionATT.getChecked(session);

		SessionATT.storeUserInSession(session, null);
	}

	// chức năng đăng ký tài khoản mới dành riêng cho quản trị viên.
	@PostMapping("/admin/register/")
	public String registerUser(@RequestBody User user) throws Exception {

		if(!service.checkId("EmployeesEntity", user.getId())) return "nhân viên chưa đăng ký";
		
		if(service.findUser(user.getUsername()) != null)  return "tên tài khoản đã tồn tại";
		
		if(user.getAvatarUrl() == null) user.setAvatarUrl(avatarDefault);
		
		if(!service.saveUser(session, user)) return "failed"; 
		
		return "successful";
	}
}

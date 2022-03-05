package demo.application.dto;

//để xử lý Session và xem thông tin đăng nhập hiện tại của người dùng.
public class User {

	private String username;
	private String password;
	private String id;
	private String avatarUrl;

	public User() {
	}

	public User(String username, String password, String id) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
	}

	public User(String username, String password, String id, String avatarUrl) {
		super();
		this.username = username;
		this.password = password;
		this.id = id;
		this.avatarUrl = avatarUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

}

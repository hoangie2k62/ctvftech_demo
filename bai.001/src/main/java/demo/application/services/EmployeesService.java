package demo.application.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.application.attributes.SessionATT;
import demo.application.dto.User;
import demo.application.entity.EmployeesEntity;
import demo.application.entity.LogsEntity;
import demo.application.repository.DefaultIDFactory;

@Service
public class EmployeesService extends CrudService<EmployeesEntity, String> {

	@Autowired
	private DefaultIDFactory idFactory;
	

	@Override
	public DefaultIDFactory getIDFactory() {
		// TODO Auto-generated method stub
		return idFactory;
	}

	// tìm kiếm thông tin user
	public String findUser(String username) throws Exception {

		String hql = String.format("SELECT e.password FROM EmployeesEntity e WHERE e.username IN ('%s')", username);

		Query query = this.getRepository().get().createQuery(hql);

		return (String) query.getResultList().get(0);
	}

	// mã hóa mật khẩu theo SHA-256
	public String encodingPassword(String password) throws NoSuchAlgorithmException {

		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		sha.update(password.getBytes());

		byte[] bytes = sha.digest();

		StringBuilder str = new StringBuilder();

		for (int i = 0; i < bytes.length; i++)
			str.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));

		return str.toString();
	}

	// lưu thông tin user sau khi thay đổi.
	public boolean saveUser(String username, String password) {

		try {

			this.getRepository().begin();

			String hql = String.format("UPDATE employees" + "SET password = %s" + "WHERE username = %s", password,
					username);

			Query query = this.getRepository().get().createQuery(hql);

			query.executeUpdate();

			/*
			 * Quyết định không lưu việc thay đổi thông tin thay đổi mật khẩu của người
			 * dùng. Vì: việc lưu lại vào bảng logs cốt để biết ai đã làm gì với CSDL. Mà
			 * việc thay đổi mật khẩu ta không có cách nào để biết nhân viên nào đã thay đổi
			 * cả vì 1. là đăng nhập vào tài khoản chính chủ để đổi mật khẩu 2. là có 1
			 * trang đổi mật khẩu riêng. => không cần lưu lại hành động thay đổi mật khẩu.
			 */

			this.getRepository().commit();

			return true;
		} catch (Exception ex) {

			this.getRepository().rollback();
		} finally {

			this.getRepository().close();
		}

		return false;
	}

	// thêm tài khoản đăng nhập cho nhân viên.
	public boolean saveUser(HttpSession session, User user) {
		
		try {
			this.getRepository().begin();
			
			String hql = String.format("INSERT INTO employees(id, username, password, avatar_url) VALUES ('%s', '%s', '%s')", 
					user.getUsername(), user.getPassword(), user.getAvatarUrl());
			
			Query query = this.getRepository().get().createQuery(hql);
			
			query.executeUpdate();
			
			//lưu việc thêm thông tin tài khoản vào logs
			
			LogsEntity log = new LogsEntity();
			
			log.setTableName("employees");
			log.setEntityId(user.getId());
			log.setType("UPDATE");
			log.setContents(user.toString());
			
			// lấy id người thực hiện them.
			String employeeId = SessionATT.getUserInSession(session).getId();
			log.setEntityId(employeeId);
			
			this.getRepository().commit();
			
			return true;
		}
		catch(Exception ex) {
			
			this.getRepository().rollback();
		}
		finally {
			
			this.getRepository().close();
		}
		
		return false;
	}
}

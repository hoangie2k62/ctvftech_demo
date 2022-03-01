package demo.application.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login_infos")
public class LoginInfosEntity {

	@Id
	@Column(columnDefinition="CHAR(20)")
	private String username;

	@Column(columnDefinition="CHAR(16)")
	private String password;

	@Column
	private Timestamp updatedDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id", nullable=false)
	private EmployeesEntity employee;

	public LoginInfosEntity() {
	}

	public LoginInfosEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	public EmployeesEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeesEntity employee) {
		this.employee = employee;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

}

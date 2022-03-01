package demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import demo.entity.relationship.WorkAssginEntity;

@Entity
@Table(name = "employees")
public class EmployeesEntity {

	@Id
	@Column(columnDefinition="CHAR(9)")
	private String id;

	@Column(columnDefinition="CHAR(30)")
	private String firstName;
	@Column(columnDefinition="CHAR(30)")
	private String lastName;
	@Column
	private Date birthDay;
	@Column(columnDefinition="CHAR(20)")
	private String gioiTinh;
	@Column(columnDefinition="CHAR(50)")
	private String country;
	@Column(columnDefinition="CHAR(30)")
	private String city;
	@Column(columnDefinition="CHAR(30)")
	private String district;
	@Column(columnDefinition="CHAR(20)")
	private String village;
	@Column
	private String addressExtra;
	@Column(columnDefinition="CHAR(10)")
	private String phone;
	@Column(length=100)
	private String email;

	@Column
	private int salary;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "report_to", referencedColumnName = "id")
	private EmployeesEntity manager;

	@OneToMany(mappedBy = "manager")
	private Set<EmployeesEntity> employees;

	@OneToMany(mappedBy = "employeeId")
	private Set<WorkAssginEntity> assgins;

	@OneToOne(mappedBy = "employee")
	private LoginInfosEntity loginInfo;

	@OneToMany(mappedBy = "employeeId")
	private Set<WorksEntity> worksSchema;

	@Column
	private Timestamp updateDate;

	public EmployeesEntity() {
		super();
	}

	public EmployeesEntity(String id) {
		this.id = id;
	}

	public EmployeesEntity(String firstName, String lastName, Date birthDay, String gioiTinh, String country,
			String city, String district, String village, String addressExtra, String phone, String email, int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.gioiTinh = gioiTinh;
		this.country = country;
		this.city = city;
		this.district = district;
		this.village = village;
		this.addressExtra = addressExtra;
		this.phone = phone;
		this.email = email;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getAddressExtra() {
		return addressExtra;
	}

	public void setAddressExtra(String addressExtra) {
		this.addressExtra = addressExtra;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public EmployeesEntity getManager() {
		return manager;
	}

	public void setManager(EmployeesEntity manager) {
		this.manager = manager;
	}

	public Set<EmployeesEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeesEntity> employees) {
		this.employees = employees;
	}

	public Set<WorkAssginEntity> getAssgins() {
		return assgins;
	}

	public void setAssgins(Set<WorkAssginEntity> assgins) {
		this.assgins = assgins;
	}

	public LoginInfosEntity getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(LoginInfosEntity loginInfo) {
		this.loginInfo = loginInfo;
	}

	public Set<WorksEntity> getWorksSchema() {
		return worksSchema;
	}

	public void setWorksSchema(Set<WorksEntity> worksSchema) {
		this.worksSchema = worksSchema;
	}
}

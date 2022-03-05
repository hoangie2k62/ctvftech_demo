package demo.application.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import demo.application.entity.relationship.WorkAssginEntity;

@Entity
@Table(name = "employees")
public class EmployeesEntity {

	/*
	 * thông tin bản thân.
	 */

	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short stt;

	@Id
	@Column(columnDefinition = "CHAR(9)")
	private String id;

	@Column(name = "first_name", columnDefinition = "CHAR(30)")
	private String firstName;
	@Column(name = "last_name", columnDefinition = "CHAR(30)")
	private String lastName;
	@Column
	private Date birthday;
	@Column(name = "gioi_tinh", columnDefinition = "CHAR(20)")
	private String gioiTinh;
	@Column(columnDefinition = "CHAR(50)")
	private String country;
	@Column(columnDefinition = "CHAR(30)")
	private String city;
	@Column(columnDefinition = "CHAR(30)")
	private String district;
	@Column(columnDefinition = "CHAR(20)")
	private String village;
	@Column(name = "address_extra")
	private String addressExtra;
	@Column(columnDefinition = "CHAR(10)")
	private String phone;
	@Column(length = 100)
	private String email;

	// thông tin bản thân.

	/*
	 * thông tin công việc.
	 */

	@OneToMany(mappedBy = "manager")
	private Set<EmployeesEntity> employees;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "report_to", referencedColumnName = "id")
	private EmployeesEntity manager;

	@Column(name = "job_title", columnDefinition = "CHAR(50)")
	private String jobTitle;

	@Column
	private int salary;

	// thông tin công việc.

	/*
	 * Thông tin đăng nhập.
	 */

	@Column(columnDefinition = "CHAR(20) CHARACTER SET latin1 COLLATE latin1_general_cs", unique = true)
	private String username;

	@Column(columnDefinition = "CHAR(12) CHARACTER SET latin1 COLLATE latin1_general_cs")
	private String password;

	@Column(name = "avatar_url", columnDefinition = "CHAR(12) CHARACTER SET latin1 COLLATE latin1_general_cs")
	private String avatarUrl;

	// thông tin đăng nhập

	@OneToMany(mappedBy = "employeeId")
	private Set<WorkAssginEntity> assgins;

	@OneToMany(mappedBy = "createdEmployee")
	private Set<WorksEntity> worksSchema;

	@OneToOne(mappedBy = "managerId")
	private OfficesEntity office;

	@OneToMany(mappedBy = "editedEmployee")
	private Set<LogsEntity> editLog;

	public EmployeesEntity() {
	}

	public EmployeesEntity(String id) {
		this.id = id;
	}

	@Override
	public String toString() {

		String values = String.format(
				"id:%s,first_name:%s,last_name:%s,birthday:%s, gioi_tinh:%s"
						+ "country:%s,city:%s,district:%s,village:%s,address_extra:%s,"
						+ "phone:%s,email:%s,report_to:%s,job_title:%s,salary:%d,username:%s,password:%s, avatar_url:%s",
				id, firstName, lastName, birthday.toString(), gioiTinh, country, city, district, village, addressExtra,
				phone, email, (this.manager == null) ? "NULL" : this.manager.getId(), jobTitle, salary, username,
				password, avatarUrl);

		return values;
	}

	public OfficesEntity getOffice() {
		return office;
	}

	public void setOffice(OfficesEntity office) {
		this.office = office;
	}

	public Set<LogsEntity> getEditLog() {
		return editLog;
	}

	public void setEditLog(Set<LogsEntity> editLog) {
		this.editLog = editLog;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public Set<WorksEntity> getWorksSchema() {
		return worksSchema;
	}

	public void setWorksSchema(Set<WorksEntity> worksSchema) {
		this.worksSchema = worksSchema;
	}

	public short getStt() {
		return stt;
	}

	public void setStt(short stt) {
		this.stt = stt;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
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

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
}

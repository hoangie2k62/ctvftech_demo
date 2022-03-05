package demo.application.dto;

import java.sql.Date;

import demo.application.entity.EmployeesEntity;

public class Employee extends GenericDTO<EmployeesEntity> {

	private String id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String gioiTinh;
	private String country;
	private String city;
	private String district;
	private String village;
	private String addressExtra;
	private String phone;
	private String email;
	private String reportTo;
	private String reportName;
	private String jobTitle;
	private int salary;

	public Employee() {

		super(null);
	}

	public Employee(EmployeesEntity entity) {

		super(entity);
	}

	@Override
	public void init(EmployeesEntity entity) {
		
		if(entity != null) {
			
			this.id = entity.getId();
			this.firstName = entity.getFirstName();
			this.lastName = entity.getLastName();
			this.birthday = entity.getBirthday();
			this.gioiTinh = entity.getGioiTinh();
			this.country = entity.getCountry();
			this.city = entity.getCity();
			this.district = entity.getDistrict();
			this.village = entity.getVillage();
			this.addressExtra = entity.getAddressExtra();
			this.phone = entity.getPhone();
			this.email = entity.getEmail();
			this.reportTo = entity.getManager().getId();
			this.reportName = entity.getManager().getFirstName() + " " + entity.getManager().getLastName();
			this.jobTitle = entity.getJobTitle();
			this.salary = entity.getSalary();
		}

	}

	@Override
	public EmployeesEntity toEntity() {

		EmployeesEntity entity = new EmployeesEntity();
		
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		entity.setBirthday(birthday);
		entity.setGioiTinh(gioiTinh);
		entity.setCountry(country);
		entity.setCity(city);
		entity.setDistrict(district);
		entity.setVillage(village);
		entity.setAddressExtra(addressExtra);
		entity.setPhone(phone);
		entity.setEmail(email);
		entity.setJobTitle(jobTitle);
		entity.setSalary(salary);

		return entity;
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

	public void setGioi_tinh(String gioiTinh) {
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

	public String getReportTo() {
		return reportTo;
	}

	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}

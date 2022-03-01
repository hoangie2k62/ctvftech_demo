package demo.beans;

import java.sql.Timestamp;

import demo.entity.EmployeesEntity;
import demo.entity.WorksEntity;
import demo.enums.WorkStatus;

public class Work {

	private String heading;
	private String content;
	private Timestamp beginedDate;
	private Timestamp deadline;
	private String createdEmp;

	public Work() {
	}

	public Work(String heading, String content, String beginedDate, String deadline, String createdEmp) {
		super();
		this.heading = heading;
		this.content = content;
		this.beginedDate = Timestamp.valueOf(beginedDate);
		this.deadline = Timestamp.valueOf(deadline);
		this.createdEmp = createdEmp;
	}

	// chuyển đổi bảng sang dạng Entity để lưu vào database;
	public WorksEntity toEntity(){

		WorksEntity entity = new WorksEntity();
		
		entity.setHeading(this.heading);
		entity.setContent(this.content);
		entity.setBeginedDate(this.beginedDate);
		entity.setDeadline(this.deadline);
		entity.setStatus(WorkStatus._1.toString());

		entity.setEmployeeId(new EmployeesEntity(this.createdEmp));

		return entity;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getBeginedDate() {
		return beginedDate;
	}

	public void setBeginedDate(Timestamp beginedDate) {
		this.beginedDate = beginedDate;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public String getCreatedEmp() {
		return createdEmp;
	}

	public void setCreatedEmp(String createdEmp) {
		this.createdEmp = createdEmp;
	}

}

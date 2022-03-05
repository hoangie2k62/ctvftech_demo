package demo.application.dto;

import java.sql.Timestamp;

import demo.application.entity.WorksEntity;

public class Work extends GenericDTO<WorksEntity> {

	private String id;
	private String heading;
	private String content;
	private String status;
	private Timestamp createdDate;
	private Timestamp beginedDate;
	private String endedDate;
	private Timestamp deadline;

	private String createdId;
	private String createdName;
	private String jobTitle;

	private String updatedDate;

	public Work() {

		super(null);
	}

	public Work(WorksEntity entity) {

		super(entity);
	}

	// Lấy 1 số thông tin từ entity chuyển sang dto để hiển thị thông tin.
	@Override
	public void init(WorksEntity entity) {

		if (entity != null) {
			this.id = entity.getId();
			this.heading = entity.getHeading();
			this.content = entity.getContent();
			this.createdDate = entity.getCreatedDate();
			this.beginedDate = entity.getBeginedDate();

			if (entity.getEndedDate() == null)
				this.endedDate = "không xác định";
			else
				this.endedDate = entity.getEndedDate().toString();

			this.deadline = entity.getDeadline();

			this.createdId = entity.getCreatedEmployee().getId();

			// lấy tên người lập kế hoạch.

			String firstName = entity.getCreatedEmployee().getFirstName();
			String lastName = entity.getCreatedEmployee().getLastName();
			String fullName = firstName + " " + lastName;
			this.createdName = fullName;

			this.jobTitle = entity.getCreatedEmployee().getJobTitle();
		}

	}

	// chuyển đổi 1 số giá trị sang entity.
	@Override
	public WorksEntity toEntity() {

		WorksEntity entity = new WorksEntity();

		entity.setHeading(heading);
		entity.setContent(content);
		entity.setBeginedDate(beginedDate);
		entity.setDeadline(deadline);
		entity.setStatus(status);

		return entity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getBeginedDate() {
		return beginedDate;
	}

	public void setBeginedDate(Timestamp beginedDate) {
		this.beginedDate = beginedDate;
	}

	public String getEndedDate() {
		return endedDate;
	}

	public void setEndedDate(String endedDate) {
		this.endedDate = endedDate;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	public String getCreatedName() {
		return createdName;
	}

	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

}

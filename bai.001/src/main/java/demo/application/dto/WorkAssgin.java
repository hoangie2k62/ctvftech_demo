package demo.application.dto;

import java.sql.Date;

import demo.application.entity.relationship.WorkAssginEntity;
import demo.application.entity.relationship.WorkAssginKey;

public class WorkAssgin extends GenericDTO<WorkAssginEntity> {

	private String employeeId;
	private String officeId;
	private String workId;
	private Date beginedDate;
	private Date endedDate;

	public WorkAssgin() {

		super(null);
	}

	public WorkAssgin(WorkAssginEntity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(WorkAssginEntity entity) {

		if (entity != null) {

			this.employeeId = entity.getId().getEmployeeId();
			this.officeId = entity.getId().getOfficeId();
			this.workId = entity.getId().getWorkId();
			this.beginedDate = entity.getBeginedDate();
			this.endedDate = entity.getEndedDate();
		}
	}

	@Override
	public WorkAssginEntity toEntity() {

		WorkAssginEntity entity = new WorkAssginEntity();

		WorkAssginKey key = new WorkAssginKey(employeeId, officeId, workId);

		entity.setId(key);

		entity.setBeginedDate(beginedDate);

		return entity;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	public Date getBeginedDate() {
		return beginedDate;
	}

	public void setBeginedDate(Date beginedDate) {
		this.beginedDate = beginedDate;
	}

	public Date getEndedDate() {
		return endedDate;
	}

	public void setEndedDate(Date endedDate) {
		this.endedDate = endedDate;
	}

}

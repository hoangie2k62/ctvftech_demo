package demo.application.entity.relationship;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import demo.application.entity.EmployeesEntity;
import demo.application.entity.OfficesEntity;
import demo.application.entity.WorksEntity;

@Entity
@Table(name = "work_assgin")
public class WorkAssginEntity {

	@EmbeddedId
	private WorkAssginKey id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private EmployeesEntity employeeId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "office_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private OfficesEntity officeId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "work_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private WorksEntity workId;

	/*
	 * ngày bắt đầu là ngày quy định từ khi đấy bắt đầu làm công việc.
	 * Còn ngày được chèn vào hay khởi tạo thì được lưu trong edited_date trong bảng Logs
	 * theo type = "INSERT"
	 */
	@Column
	private Date beginedDate;

	@Column
	private Date endedDate;

	@Override
	public String toString() {

		String values = String.format("%s,begined_date:%s,ended_date:%s", id.toString(), this.beginedDate.toString(),
				null);

		return values;
	}

	public WorkAssginKey getId() {
		return id;
	}

	public void setId(WorkAssginKey id) {
		this.id = id;
	}

	public EmployeesEntity getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeesEntity employeeId) {
		this.employeeId = employeeId;
	}

	public OfficesEntity getOfficeId() {
		return officeId;
	}

	public void setOfficeId(OfficesEntity officeId) {
		this.officeId = officeId;
	}

	public WorksEntity getWorkId() {
		return workId;
	}

	public void setWorkId(WorksEntity workId) {
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

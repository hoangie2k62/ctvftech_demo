package demo.entity.relationship;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import demo.entity.EmployeesEntity;
import demo.entity.OfficesEntity;
import demo.entity.WorksEntity;

@Entity
@Table(name = "work_assgin")
public class WorkAssginEntity {

	@EmbeddedId
	private WorkAssginKey key;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id", nullable=false)
	private EmployeesEntity employeeId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "office_id", referencedColumnName = "id", nullable=false)
	private OfficesEntity officeId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "work_id", referencedColumnName = "id", nullable=false)
	private WorksEntity workId;

	@Column(columnDefinition="CHAR(30)")
	private String jobTitle;

	@Column
	private Timestamp beginedDate;

	@Column
	private Timestamp endedDate;

	@Column
	private Timestamp updatedDate;

	public WorkAssginKey getKey() {
		return key;
	}

	public void setKey(WorkAssginKey key) {
		this.key = key;
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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Timestamp getBeginedDate() {
		return beginedDate;
	}

	public void setBeginedDate(Timestamp beginedDate) {
		this.beginedDate = beginedDate;
	}

	public Timestamp getEndedDate() {
		return endedDate;
	}

	public void setEndedDate(Timestamp endedDate) {
		this.endedDate = endedDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

}

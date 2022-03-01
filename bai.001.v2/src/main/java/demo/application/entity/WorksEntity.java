package demo.application.entity;

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
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import demo.application.entity.relationship.WorkAssginEntity;

@Entity
@Table(name = "works")
public class WorksEntity {
	
	@Id
	@Column(columnDefinition="CHAR(14)")
	private String id;

	@Column(columnDefinition="CHAR(100)")
	private String heading;
	@Column
	private String content;
	
	@CreationTimestamp
	@Column
	private Timestamp createdDate;
	
	@Column
	private Timestamp beginedDate;
	
	@Column
	private Timestamp endedDate;
	
	@Column
	private Timestamp deadline;
	
	@Column(columnDefinition="CHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci")
	private String status;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_employee", referencedColumnName = "id", nullable=false)
	private EmployeesEntity employeeId;

	@UpdateTimestamp
	@Column
	private Timestamp updatedDate;

	@OneToMany(mappedBy = "workId")
	private Set<WorkAssginEntity> assgins;

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

	public Timestamp getEndedDate() {
		return endedDate;
	}

	public void setEndedDate(Timestamp endedDate) {
		this.endedDate = endedDate;
	}

	public Timestamp getDeadline() {
		return deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EmployeesEntity getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeesEntity employeeId) {
		this.employeeId = employeeId;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Set<WorkAssginEntity> getAssgins() {
		return assgins;
	}

	public void setAssgins(Set<WorkAssginEntity> assgins) {
		this.assgins = assgins;
	}

}

package demo.application.entity;

import java.sql.Timestamp;
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
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import demo.application.entity.relationship.WorkAssginEntity;

@Entity
@Table(name = "works")
public class WorksEntity {

	@Column(length=8)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stt;

	@Id
	@Column(columnDefinition = "CHAR(14) ")
	private String id;

	@Column(columnDefinition = "CHAR(100)")
	private String heading;
	@Column
	private String content;

	@CreationTimestamp
	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "begined_date")
	private Timestamp beginedDate;

	@Column(name = "ended_date")
	private Timestamp endedDate;

	@Column
	private Timestamp deadline;

	@Column(columnDefinition = "CHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci")
	private String status;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "created_employee", referencedColumnName = "id", nullable = false)
	private EmployeesEntity createdEmployee;

	@OneToMany(mappedBy = "workId")
	private Set<WorkAssginEntity> assgins;

	@Override
	public String toString() {

		String values = String.format(
				"id:%s,heading:%s,content:%s,created_date:%s,"
						+ "begined_date:%s,ended:%s,deadline:%s,status:%s,created_id:%s",
				id, heading, this.content, new Timestamp(System.currentTimeMillis()).toString(), beginedDate.toString(), null,
				deadline.toString(), status, createdEmployee.getId());

		return values;
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

	public EmployeesEntity getCreatedEmployee() {
		return createdEmployee;
	}

	public void setCreatedEmployee(EmployeesEntity createdEmployee) {
		this.createdEmployee = createdEmployee;
	}

	public Set<WorkAssginEntity> getAssgins() {
		return assgins;
	}

	public void setAssgins(Set<WorkAssginEntity> assgins) {
		this.assgins = assgins;
	}

}

package demo.application.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "logs")
public class LogsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stt;

	@Column(name = "table_name", columnDefinition = "CHAR(30)")
	private String tableName;

	@Column(name = "entity_id", columnDefinition = "CHAR(125)")
	private String entityId;

	@Column(columnDefinition = "CHAR(30)")
	private String type;

	// form data: tên trường 1:giá trị trường 1,tên trường 2:giá trị trường 2:...
	@Column
	private String contents;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "edited_employee", referencedColumnName = "id")
	private EmployeesEntity editedEmployee;

	@CreationTimestamp
	@Column
	private Timestamp editedDate;

	public Timestamp getEditedDate() {
		return editedDate;
	}

	public void setEditedDate(Timestamp editedDate) {
		this.editedDate = editedDate;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public EmployeesEntity getEditedEmployee() {
		return editedEmployee;
	}

	public void setEditedEmployee(EmployeesEntity editedEmployee) {
		this.editedEmployee = editedEmployee;
	}

}

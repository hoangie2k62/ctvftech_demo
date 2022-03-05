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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import demo.application.entity.relationship.WorkAssginEntity;

@Entity
@Table(name = "offices")
public class OfficesEntity {

	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private short stt;

	@Id
	@Column(columnDefinition = "CHAR(9) ")
	private String id;

	@Column(columnDefinition = "CHAR(50)")
	private String officeName;

	@Column
	private String description;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id", referencedColumnName = "id")
	private EmployeesEntity managerId;

	@Column(name = "date_of_talking_office")
	private Date dateOfTalkingOffice;

	@OneToMany(mappedBy = "officeId")
	private Set<WorkAssginEntity> assgins;

	public short getStt() {
		return stt;
	}

	public void setStt(short stt) {
		this.stt = stt;
	}

	public Date getDateOfTalkingOffice() {
		return dateOfTalkingOffice;
	}

	public void setDateOfTalkingOffice(Date dateOfTalkingOffice) {
		this.dateOfTalkingOffice = dateOfTalkingOffice;
	}

	@Override
	public String toString() {

		String values = String.format("id:%s,office_name:%s,description:%s, manager_id:%s,date_of_talking_office:%s",
				id, officeName, description, managerId.getId(), dateOfTalkingOffice.toString());
		return values;
	}

	public EmployeesEntity getManagerId() {
		return managerId;
	}

	public void setManagerId(EmployeesEntity managerId) {
		this.managerId = managerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<WorkAssginEntity> getAssgins() {
		return assgins;
	}

	public void setAssgins(Set<WorkAssginEntity> assgins) {
		this.assgins = assgins;
	}
}

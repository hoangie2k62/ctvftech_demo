package demo.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import demo.entity.relationship.WorkAssginEntity;

@Entity
@Table(name = "offices")
public class OfficesEntity {

	@Id
	@Column(columnDefinition="CHAR(9)")
	private String id;
	
	@Column(columnDefinition="CHAR(50)")
	private String officeName;
	@Column
	private String description;
	@Column
	private Timestamp updatedDate;
	
	@OneToMany(mappedBy = "officeId")
	private Set<WorkAssginEntity> assgins;

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

package demo.application.dto;

import java.sql.Date;

import demo.application.entity.OfficesEntity;

public class Office extends GenericDTO<OfficesEntity> {

	private String id;
	private String officeName;
	private String description;
	private String managerId;
	private String managerName;
	private Date dateOfTalkingOffice;

	public Office() {

		super(null);
	}

	public Office(OfficesEntity entity) {

		super(entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(OfficesEntity entity) {

		if (entity != null) {

			this.id = entity.getId();
			this.officeName = entity.getOfficeName();
			this.description = entity.getDescription();
			this.managerId = entity.getManagerId().getId();
			this.managerName = entity.getManagerId().getFirstName() + " " + entity.getManagerId().getLastName();
			this.dateOfTalkingOffice = entity.getDateOfTalkingOffice();
		}

	}

	@Override
	public OfficesEntity toEntity() {

		OfficesEntity entity = new OfficesEntity();

		entity.setId(id);
		entity.setOfficeName(officeName);
		entity.setDescription(description);

		return entity;
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

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Date getDateOfTalkingOffice() {
		return dateOfTalkingOffice;
	}

	public void setDateOfTalkingOffice(Date dateOfTalkingOffice) {
		this.dateOfTalkingOffice = dateOfTalkingOffice;
	}

}

package demo.application.dto;

import java.sql.Timestamp;

import demo.application.entity.LogsEntity;

public class Log extends GenericDTO<LogsEntity> {

	private int stt;
	private String tableName;
	private String entityId;
	private String contents;
	private String editedEmployeeId;
	private String editedEmployeeName;
	private Timestamp editedDate;

	public Log() {

		super(null);
	}

	public Log(LogsEntity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(LogsEntity entity) {

		if (entity != null) {

			this.stt = entity.getStt();
			this.tableName = entity.getTableName();
			this.entityId = entity.getEntityId();
			this.contents = entity.getContents();
			this.editedEmployeeId = entity.getEditedEmployee().getId();
			this.editedEmployeeName = entity.getEditedEmployee().getFirstName() + " "
					+ entity.getEditedEmployee().getLastName();
			this.editedDate = entity.getEditedDate();
		}

	}

	/*
	 * LogsEntity có dữ liêu hiển thị ra View, nhưng không có dữ liệu nhận từ View.
	 * Do table logs đóng vai trò ghi chép sự thay đổi trên những bảng khác.
	 */
	@Override
	public LogsEntity toEntity() {

		return new LogsEntity();
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getEditedEmployeeId() {
		return editedEmployeeId;
	}

	public void setEditedEmployeeId(String editedEmployeeId) {
		this.editedEmployeeId = editedEmployeeId;
	}

	public String getEditedEmployeeName() {
		return editedEmployeeName;
	}

	public void setEditedEmployeeName(String editedEmployeeName) {
		this.editedEmployeeName = editedEmployeeName;
	}

	public Timestamp getEditedDate() {
		return editedDate;
	}

	public void setEditedDate(Timestamp editedDate) {
		this.editedDate = editedDate;
	}

}

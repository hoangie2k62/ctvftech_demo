package demo.enums;

public enum WorkStatus {

	_1("đang chờ"), _2("đang thực hiện"), _3("hoàn thành"), _4("tạm ngưng"), _5("bị hủy");
	
	private String value;
	private WorkStatus(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}

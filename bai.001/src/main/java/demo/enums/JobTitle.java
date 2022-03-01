package demo.enums;

public enum JobTitle {

	_1("HR"), _2("Thực tập sinh"), _3("Cộng tác viên"), _4("Developer"),  _5("Kế toán"), _6("Trưởng phòng");
	
	private String value;
	private JobTitle(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}


package demo.enums;

public enum GioiTinh {

	_1("Nam"), _2("Nữ"), _3("Không xác định");
	
	private String value;
	
	private GioiTinh(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}

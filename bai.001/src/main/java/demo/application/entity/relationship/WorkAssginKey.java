package demo.application.entity.relationship;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WorkAssginKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Column(name = "employee_id", columnDefinition="CHAR(9)")
	String employeeId;
	
	@Column(name = "office_id", columnDefinition="CHAR(9)")
	String officeId;
	
	@Column(name = "work_id", columnDefinition="CHAR(14)")
	String workId;
	
	public WorkAssginKey() {}

	public WorkAssginKey(String employeeId, String officeId, String workId) {
		super();
		this.employeeId = employeeId;
		this.officeId = officeId;
		this.workId = workId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}
	
	@Override
	public String toString() {
		
		String values = String.format("employee_id:%s+office_id:%s+work_id:%s", employeeId, officeId, workId);
		
		return values;
	}
	
	@Override
	public boolean equals(Object work) {
		
		if(work instanceof WorkAssginKey) {
			
			WorkAssginKey key = (WorkAssginKey) work;
			
			if( this.employeeId.equals(key.employeeId) ) {
				
				if( this.officeId.equals(key.officeId) ) {
					
					if(this.workId.equals(key.workId)) return true;
				}
			}
		}
			
		return false;
	}
	
	@Override
	public int hashCode() {
		int hashCode = super.hashCode();
		
		return hashCode;
	}
}

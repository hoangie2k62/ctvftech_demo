package demo.entity.relationship;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WorkAssginKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Column
	String employeeId;
	
	@Column
	String officeId;
	
	@Column
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

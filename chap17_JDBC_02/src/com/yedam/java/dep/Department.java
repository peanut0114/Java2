package com.yedam.java.dep;

public class Department {

	private int depatmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	
	@Override
	public String toString() {
		return "dapartemnt [depatementId=" + depatmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", locationId=" + locationId + "]";
	}
	
	public int getDepatementId() {
		return depatmentId;
	}
	public void setDepatementId(int depatementId) {
		this.depatmentId = depatementId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	
	
	
}

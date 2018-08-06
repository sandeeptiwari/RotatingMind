package com.sandi.ocp;

public class Employee {
	
	public int employeeId;
	public String firstName, lastName;
	public int yearStarte;
	
	@Override public int hashCode() {
		return employeeId;
	}
	//public boolean equals(Object employee)
	public boolean equals(Employee employee) {
		//return this.employeeId == ((Employee)employee).employeeId;
		return this.employeeId == employee.employeeId;
	}

	public static void main(String[] args) {
		Employee one = new Employee();
		one.employeeId = 101;
		
		Employee two = new Employee();
		two.employeeId = 101;
		
		if(one.equals(two)) {
			System.out.println("Success");
		}else System.out.println("Failure");
	}

}

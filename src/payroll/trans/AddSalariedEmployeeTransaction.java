package payroll.trans;

import payroll.Transaction;

public class AddSalariedEmployeeTransaction implements Transaction {

	private int empId;
	private String name;
	private String address;
	private double salary;

	public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}

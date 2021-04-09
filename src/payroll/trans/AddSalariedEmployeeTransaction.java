package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;
import payroll.classifcation.HourlyClassification;
import payroll.classifcation.SalariedClassification;

public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction implements Transaction {

	private double salary;

	public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
		// TODO Auto-generated constructor stub
	}

	protected PaymentClassification getPaymentClassifcation() {
		return new SalariedClassification(salary);
	}

	@Override
	protected PaymentClassification getPaymentClassifcaction() {
		// TODO Auto-generated method stub
		return null;
	}

}

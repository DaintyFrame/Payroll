package payroll.trans;

import payroll.PaymentClassification;
import payroll.Transaction;
import payroll.classification.SalariedClassification;

public class AddSalariedEmployeeTransaction extends AddEmployeeTransaction implements Transaction {

	private double salary;

	public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
		super(empId,name,address);
		this.salary = salary;
	}
	

	@Override
	protected PaymentClassification getPaymentClassificaction() {
		// TODO Auto-generated method stub
		return new SalariedClassification(salary);
	}
}

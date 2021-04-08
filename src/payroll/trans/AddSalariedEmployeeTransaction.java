package payroll.trans;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classifcation.HourlyClassification;
import payroll.classifcation.SalariedClassification;
import payroll.method.HoldMethod;

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
		//�½���Ա
		Employee employee = new Employee(empId,name,address);
		//���ù��ʼ��㷽ʽ
		employee.setPaymentClassification(getPaymentClassifcation());
		//���ù���֧������
		employee.setPaymentMethod(new HoldMethod());
		//���浽���ݿ�
		PayrollDatabase.save(employee);
	}

	protected SalariedClassification getPaymentClassifcation() {
		return new SalariedClassification(salary);
	}

}

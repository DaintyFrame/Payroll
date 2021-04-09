package payroll.trans;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.method.HoldMethod;

public abstract class AddEmployeeTransaction implements Transaction{

	protected int empId;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	protected abstract PaymentClassification getPaymentClassifcaction();

	protected String name;
	protected String address;

	public AddEmployeeTransaction() {
		super();
	}

	public void execute() {
		// TODO Auto-generated method stub
		//新建雇员
		Employee employee = new Employee(empId,name,address);
		//设置工资计算方式
		employee.setPaymentClassification(getPaymentClassifcaction());
		//设置工资支付方法
		employee.setPaymentMethod(new HoldMethod());
		//保存到数据库
		PayrollDatabase.save(employee);
	}

}
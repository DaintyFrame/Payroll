package payroll.trans;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.method.HoldMethod;

public abstract class AddEmployeeTransaction {

	protected int empId;

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
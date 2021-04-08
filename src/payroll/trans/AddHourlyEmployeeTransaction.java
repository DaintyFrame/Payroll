package payroll.trans;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classifcation.HourlyClassification;
import payroll.method.HoldMethod;

public class AddHourlyEmployeeTransaction implements Transaction {

	private int empId;
	private String name;
	private String address;
	private double hourlyRate;

	public AddHourlyEmployeeTransaction(int empId, String name, String address, double hourlyRate) {
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.hourlyRate = hourlyRate;
	}

	@Override
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

	protected HourlyClassification getPaymentClassifcaction() {
		return new HourlyClassification(hourlyRate);
	}

}

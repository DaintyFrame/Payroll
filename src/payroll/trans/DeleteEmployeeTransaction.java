package payroll.trans;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.exception.NoSuchEmployeeException;

public class DeleteEmployeeTransaction implements Transaction {

	private int empId;

	public DeleteEmployeeTransaction(int empId) {
		this.empId = empId;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		//找到雇员
		Employee e = PayrollDatabase.getEmployee(empId);
		//存在- 删除
		if (e != null) {
			PayrollDatabase.deleteEmployee(empId);
		}
		//else 抛出异常
		else {
			throw new NoSuchEmployeeException();
		}
	}

}

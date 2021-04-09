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
		//�ҵ���Ա
		Employee e = PayrollDatabase.getEmployee(empId);
		//����- ɾ��
		if (e != null) {
			PayrollDatabase.deleteEmployee(empId);
		}
		//else �׳��쳣
		else {
			throw new NoSuchEmployeeException();
		}
	}

}

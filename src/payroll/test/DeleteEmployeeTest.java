package payroll.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.exception.NoSuchEmployeeException;
import payroll.trans.AddHourlyEmployeeTransaction;
import payroll.trans.DeleteEmployeeTransaction;

class DeleteEmployeeTest {

	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	public void testDeleteEmployeeExists() {
		//插入雇员
		int empId = 1623111006;
		new AddHourlyEmployeeTransaction(empId, "zxb-006", "BZUSOFT", 2048.0).execute();

		Transaction t = new DeleteEmployeeTransaction(empId);
		t.execute();//删除
//检验删除成功
		Employee e = PayrollDatabase.getEmployee(empId);
		assertNull(e);
	}
	@Test
	public void deleteEmployeeNotExists() {
		int empId = 1623111006;
		Employee e = PayrollDatabase.getEmployee(empId);
		assertNull(e);
		
		Transaction t = new DeleteEmployeeTransaction(empId);
		try {
		t.execute();
		fail("No such employee.");
		}catch(Exception e1) {
			assertTrue(e1 instanceof NoSuchEmployeeException);
			
		}
	}
}

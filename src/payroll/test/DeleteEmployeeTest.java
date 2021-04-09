package payroll.test;


import org.junit.jupiter.api.Test;

import payroll.Transaction;
import payroll.trans.AddHourlyEmployeeTransaction;
import payroll.trans.DeleteEmployeeTransaction;

class DeleteEmployeeTest {

	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	public void testDeleteEmployeeExists() {
		//≤Â»ÎπÕ‘±
		int empId = 1623111006;
		new AddHourlyEmployeeTransaction(empId, "zxb-006", "BZUSOFT", 2048.0).execute();

		Transaction t = new DeleteEmployeeTransaction(empId);
		t.execute();

		Employee e = PayrollDatabase.getEmployee(empId);
		assertNull(e);
	}
}

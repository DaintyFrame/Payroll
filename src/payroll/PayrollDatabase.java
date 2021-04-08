package payroll;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
	private static Map<Integer,Employee> employees = new HashMap<Integer,Employee>();
	public static Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		return employees.get(empId);
	}

}

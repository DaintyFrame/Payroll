package payroll.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payroll.Employee;
import payroll.PaymentClassification;
import payroll.PaymentMethod;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.HourlyClassification;
import payroll.method.HoldMethod;
import payroll.trans.AddHourlyEmployeeTransaction;


/*
      用例1：增加雇员。
使用AddEmp操作(transaction)增加新雇员。该操作包含有分配的雇员号、雇员的名字及其
地址。该操作有3种形式：
AddEmp EmpId “name” “address” H hourly-rate
AddEmp EmpId “name" “address” S monthly-salary
AddEmp EmpId “name” “address” C monthly-salary commission-rate
雇员记录是根据对应字段的值来创建的。
异常情况1：描述操作的结构有错误。
如果描述操作的结构不正确，会打印一条错误消息，不进行任何处理。
 */
public class AddEmployeeTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
	@Test
	public void testAddHourlyEmployeeTransaction() {
		//添加小时工基本信息
		int empId = 1623111006;
		String name = "zxb";
		String address = "BZU";
		double hourlyRate = 88.8;
		
		//--新建添加钟点工操作，并执行--
		Transaction t = new AddHourlyEmployeeTransaction(empId,name,address,hourlyRate);
		t.execute();
		
		// 验证执行结果
		Employee e = PayrollDatabase.getEmployee(empId);	// 根据雇员编号读取雇员记录
		assertNotNull(e); // 雇员记录存在
		assertEquals(empId, e.getEmpId()); 	//编号正确
		assertEquals(name, e.getName()); 	//名字正确
		assertEquals(address, e.getAddress());	 //地址正确
		PaymentClassification pc = e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);	//钟点工
		HourlyClassification hc = (HourlyClassification) pc;
		assertEquals(hourlyRate, hc.getHourlyRate(), 0.01);	//小时工资正确
		PaymentMethod pm = e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);	//支付方式默认为保存支票
		
	}
	

}

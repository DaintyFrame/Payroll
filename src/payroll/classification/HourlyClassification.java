package payroll.classification;

import payroll.PaymentClassification;

public class HourlyClassification extends PaymentClassification{

	private double hourlyRate;

	public HourlyClassification(double hourlyRate) {
		this.hourlyRate = hourlyRate;
		// TODO Auto-generated constructor stub
	}

	public double getHourlyRate() {
		// TODO Auto-generated method stub
		return hourlyRate;
	}

}

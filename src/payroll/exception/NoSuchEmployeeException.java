package payroll.exception;

public class NoSuchEmployeeException extends RuntimeException {

	private String string;

	public NoSuchEmployeeException(String string) {
		this.string = string;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

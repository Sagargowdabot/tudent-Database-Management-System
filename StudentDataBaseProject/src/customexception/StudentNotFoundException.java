package customexception;

public class StudentNotFoundException extends Exception {
	private String message;
	public StudentNotFoundException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}

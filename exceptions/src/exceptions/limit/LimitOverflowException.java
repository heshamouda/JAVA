package ch.fhnw.oop2.exceptions.limit;

public class LimitOverflowException extends Exception {
	
	private double limit;

	public LimitOverflowException() {
		super();
	}

	public LimitOverflowException(String message, Throwable cause, double limit) {
		super(message, cause);
		this.limit = limit;
	}

	public LimitOverflowException(String message, double limit) {
		this(message, null, limit);
	}

	public LimitOverflowException(Throwable cause, double limit) {
		this(null, cause, limit);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + ": " + getLimit();
	}

	public double getLimit() {
		return limit;
	}	
}

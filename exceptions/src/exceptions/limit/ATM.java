package exceptions.limit;

public class ATM {

	private double limit = 3000;
	
	public static void main(String[] args) {
		
		try {
			new ATM().withdraw(5000);
			System.out.println("Success!");
		}
		catch(LimitOverflowException exception) {
			System.err.println("LimitOverflowException");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		catch(Exception exception) {
			System.err.println("Exception");
			System.err.println(exception.getMessage());
		}
		finally {
			 System.out.println("Finally");
		}
		
	}
	
	
	public void withdraw(double amount) throws LimitOverflowException {
		
		if(amount > limit) {
			throw new LimitOverflowException("Limit too small", limit);
		}
		else {
			// ...
		}
		
	}
	
}

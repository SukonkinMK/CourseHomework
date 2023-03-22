
public class MyCounter implements AutoCloseable  {
	private int _counter;
	
    public MyCounter() {
		_counter = 0;
	}

	public void add() {
		_counter++;
	}

	@Override
	public void close() {
		
	}
}

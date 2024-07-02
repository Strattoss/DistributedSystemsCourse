package sr.thrift.server;

import org.apache.thrift.TException;
import sr.rpc.thrift.Calculator;
import sr.rpc.thrift.InvalidArguments;

public class CalculatorHandler implements Calculator.Iface {

	int id;

	public CalculatorHandler(int id) {
		this.id = id;
	}

	@Override
	public int add(int n1, int n2) {
		System.out.println("CalcHandler#" + id + " add(" + n1 + "," + n2 + ")");
		if(n1 > 1000 || n2 > 1000) { 
			try { Thread.sleep(6000); } catch(java.lang.InterruptedException ex) { }
			System.out.println("DONE");
		}
		return n1 + n2;
	}

	@Override
	public int subtract(int num1, int num2) throws TException {
		return num1 - num2;
	}

	@Override
	public double funFibonacci(int startNum1, int startNum2, int n) throws InvalidArguments, TException {
		if (n < 0) {
			throw new InvalidArguments(0, "cannot be negative");
		}

		if (n == 0) return startNum1;
		if (n == 1) return startNum2;

		int a = startNum1, b = startNum2;
		for (int i = 0; i < n - 1; i++) {
			b += a;
			a = b - a;
		}

		return b;
	}
}


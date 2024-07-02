package sr.thrift.server;

import org.apache.thrift.TException;

import sr.rpc.thrift.OperationType;
import sr.rpc.thrift.InvalidArguments;
import sr.rpc.thrift.AdvancedCalculator;

// Generated code

import java.util.Set;

public class AdvancedCalculatorHandler implements AdvancedCalculator.Iface {

	int id;

	public AdvancedCalculatorHandler(int id) {
		this.id = id;
	}

	public int add(int n1, int n2) {
		System.out.println("AdvCalcHandler#" + id + " add(" + n1 + "," + n2 + ")");
		//try { Thread.sleep(9000); } catch(java.lang.InterruptedException ex) { }
		System.out.println("DONE");
		return n1 + n2;
	}


	@Override
	public double op(OperationType type, Set<Double> val) throws TException 
	{
		System.out.println("AdvCalcHandler#" + id + " op() with " + val.size() + " arguments");
		
		if(val.isEmpty()) {
			throw new InvalidArguments(0, "no data");
		}

		double res = 0;
		switch (type) {
		case SUM:
			for (Double d : val) res += d;
			return res;
		case AVG:
			for (Double d : val) res += d;
			return res/val.size();
		case MIN:
			return val.stream()
					.min(Double::compareTo)
					.get();
		case MAX:
			return val.stream()
					.max(Double::compareTo)
					.get();
		}

		return 0;
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


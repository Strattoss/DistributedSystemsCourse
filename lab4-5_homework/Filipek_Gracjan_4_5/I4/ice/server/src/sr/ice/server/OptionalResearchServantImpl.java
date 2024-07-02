package sr.ice.server;

import Demo.C;
import Demo.MyException;
import com.zeroc.Ice.Current;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class OptionalResearchServantImpl implements Demo.OptionalResearchServant {
	private static final long serialVersionUID = -2448962912780867770L;

	@Override
	public C sendC(C c, Current current) {
		return c;
	}

	@Override
	public void throwException(boolean withOptional, Current current) throws MyException {
		if (withOptional) {
			throw new MyException(123);
		}
		throw new MyException();
	}

	@Override
	public int[] sequenceMethod(int[] intArray, Current current) {
		return intArray;
	}

	@Override
	public void voidMethod(Current current) {
		return;
	}

	@Override
	public OptionalInt optionalParameters(OptionalInt integer, Current current) {
		return integer;
	}
}
package circuits;

public class FalseGate extends Gate {
	private static FalseGate f=null;
	private FalseGate(Gate[] inGates) {//private constructor
		super(inGates);
	}
	public static Gate instance() {//singelton method
		if(f==null)
			f=new FalseGate(null);
		return f;
	}
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return false;
	}

	@Override
	public String getName() {
		return "F";
	}

	@Override
	public Gate simplify() {
		return FalseGate.instance();
	}

}

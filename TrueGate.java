package circuits;

public class TrueGate extends Gate {
	private static TrueGate t=null;
	
	private TrueGate(Gate[] inGates) {//private constructor
		super(inGates);
	}
	public static Gate instance() {//singelton method
		if(t==null)
			t=new TrueGate(null);
		return t;
	}
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return true;
	}

	@Override
	public String getName() {
		return "T";
	}

	@Override
	public Gate simplify() {
		return TrueGate.instance();
	}

}
